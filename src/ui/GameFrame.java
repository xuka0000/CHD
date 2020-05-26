package ui;

import java.awt.*;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import Hero.Hero;
import Map.Monster;
import Map.NPC;
import Map.Portal;
import SQL.MapSQL;
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
	public Portal[] portal;

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

		// 确定地图优先
		for (int i = 0; i <MapSQL.MapSQL.length; i++) {
			if (hero.hero.getMapId() == i) {
				for (int j = 0; j <MapSQL.MapSQL.length; j++) {
					if (SQL.MapSQL.MapSQL[j].getId() == i) {
						//给Map
						map.Map = SQL.MapSQL.MapSQL[j];
					}
				}
			}
		}

		// 创建怪兽(线程）
		for (int i = 0; i < map.Map.getMonster().length - 1; i++) {
			monster[i] = new Monster(this);
		}
		// 创建NPC(线程）
		for (int i = 0; i < map.Map.getNPC().length - 1; i++) {
			NPC[i] = new NPC(this);
		}
		// 创建传送门
		for (int i = 0; i < map.Map.getPortal().length - 1; i++) {
			portal[i] = new Portal(this);
		}

		// 线程任务开始
		// 冒险家
		hero.start();
		// 怪物
		for (int i = 0; i < map.Map.getMonster().length - 1; i++) {
			monster[i].start();
		}
		// NPC
		for (int i = 0; i < map.Map.getNPC().length - 1; i++) {
			NPC[i].start();
		}
		// 传送门
		for (int i = 0; i < map.Map.getPortal().length - 1; i++) {
			portal[i].start();
		}

		// 开启音乐播放器
		new Thread() {
			public void run() {
				while (true) {
					AudioPlayer StartSound = new AudioPlayer(map.Map.getSound().getSoundPath());
					StartSound.run();
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
						// TODO Auto-generated catch block
						e.printStackTrace();
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
		for (int i = map.Map.getImg().length - 1; i >= 0; i--) {
			big.drawImage(map.Map.getImg()[i].getPicturePath(), map.Map.getImg()[i].getX(), map.Map.getImg()[i].getY(),
					map.Map.getImg()[i].getWidth(), map.Map.getImg()[i].getHeight(), null);
		}
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

		// 绘画上色
		g.drawImage(bi, 0, 0, null);
	}

}
