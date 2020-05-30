package ui;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import DataMask.MapMask;
import DataMask.Sound;
import Hero.Hero;
import Map.Monster;
import Map.NPC;
import Map.Portal;
import SQL.MapSQL;
import SQL.TradableSQL;
import gameProgress.Loading;
import util.AudioPlayer;
import Map.BG;
import Map.LeftBg;
import Map.TopBg;
import Map.RightBG;

public class GameFrame extends JFrame {
	// 得到一个英雄
	public Hero hero;
	// 得到一张地图
	public BG map;
	//等到左上属性
	public LeftBg leftBg;
	//上面技能栏
	public TopBg topBg;
	//右上角小地图
	public RightBG rightBG;
	// 得到很多怪兽
	public Monster[] monster;
	// 得到很多NPC
	public NPC[] NPC;
	// 得到很多传送门
	public Portal[] portal = {new Portal()};
	//创建加载类
	public Loading loading;
	//音乐播放
	public AudioPlayer StartSound;

	public GameFrame() {

		// 制作界面~~~~~~~~~~~~~~~~~~~~~~~~~~
		String title = "彩虹岛";
		JFrame jf = new JFrame(title);
		Container container = jf.getContentPane();
		jf.setSize(600, 400);
		jf.setLayout(new BorderLayout());

		// 初始化窗口
		this.setSize(1024, 807);
		this.setTitle("彩虹岛");
		this.setResizable(false);
		// 居中展示窗口
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		// 创建地图
		map = new BG();

		// 创建冒险家(线程）
		hero = new Hero(this);


		//创建左上属性
		leftBg = new LeftBg();
		//创建上面技能栏
		topBg = new TopBg();
		//创建加载类的对象
		loading = new Loading(this);

		// 确定地图优先

		loading.start();
		// 开启音乐播放器
		new Thread() {
			@Override
			public void run() {
				setName("音乐线程");
				while (true) {
					try {
						while (true) {
							StartSound = new AudioPlayer(map.Map.getSound().getSoundPath());
							StartSound.runBg();
						}
					} catch (Exception e) {
						//不打印异常
					}
				}

			}
		}.start();

		// 开启一个线程负责界面的窗体重绘线程
		new Thread() {
			public void run() {

				while (true) {
					// 绘制窗体
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						//不打印了
					}
				}
			}
		}.start();
	}

	// 利用双缓冲画背景图片和冒险家
	@Override
	public void paint(Graphics g) {
		// 绘画板
		BufferedImage bi = (BufferedImage) this.createImage(this.getSize().width, this.getSize().height);
		// 画笔
		Graphics big = bi.getGraphics();

		//背景图
		for (int i = 0; i < 5; i++) {
			big.drawImage(map.Map.getImg()[i].getPicturePath(), map.Map.getImg()[i].getX(), map.Map.getImg()[i].getY(),
					map.Map.getImg()[i].getWidth(), map.Map.getImg()[i].getHeight(), null);
		}
		//传送门
		PortalView.portalUse(big,portal,map);

		//调用方法打印英雄
		GraphicsView.heroActionImg(big, hero.image, hero.hero);

		//左上角属性
		//drawleftBg(big);
		LeftBgView.drawleftBg(big, leftBg, hero);

		//顶部技能栏
		TopBgView.topBgView(big, topBg);

		//右上角小地图
		RightBgView.rightBgView(big, map, hero);

		//打印障碍物
		ObsView.obsView(big, map, hero);
		//打印前面图层的地图
		for (int i = 5; i < map.Map.getImg().length; i++) {
			big.drawImage(map.Map.getImg()[i].getPicturePath(), map.Map.getImg()[i].getX(), map.Map.getImg()[i].getY(),
					map.Map.getImg()[i].getWidth(), map.Map.getImg()[i].getHeight(), null);
		}
		// 绘画上色
		g.drawImage(bi, 0, 0, null);
	}

}
