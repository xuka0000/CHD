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
	// �õ�һ��Ӣ��
	public Hero hero;
	// �õ�һ�ŵ�ͼ
	public BG map;
	//�ȵ���������
	public LeftBg leftBg;
	//���漼����
	public TopBg topBg;
	//���Ͻ�С��ͼ
	public RightBG rightBG;
	// �õ��ܶ����
	public Monster[] monster;
	// �õ��ܶ�NPC
	public NPC[] NPC;
	// �õ��ܶഫ����
	public Portal[] portal = {new Portal()};
	//����������
	public Loading loading;
	//���ֲ���
	public AudioPlayer StartSound;

	public GameFrame() {

		// ��������~~~~~~~~~~~~~~~~~~~~~~~~~~
		String title = "�ʺ絺";
		JFrame jf = new JFrame(title);
		Container container = jf.getContentPane();
		jf.setSize(600, 400);
		jf.setLayout(new BorderLayout());

		// ��ʼ������
		this.setSize(1024, 807);
		this.setTitle("�ʺ絺");
		this.setResizable(false);
		// ����չʾ����
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		// ������ͼ
		map = new BG();

		// ����ð�ռ�(�̣߳�
		hero = new Hero(this);


		//������������
		leftBg = new LeftBg();
		//�������漼����
		topBg = new TopBg();
		//����������Ķ���
		loading = new Loading(this);

		// ȷ����ͼ����

		loading.start();
		// �������ֲ�����
		new Thread() {
			@Override
			public void run() {
				setName("�����߳�");
				while (true) {
					try {
						while (true) {
							StartSound = new AudioPlayer(map.Map.getSound().getSoundPath());
							StartSound.runBg();
						}
					} catch (Exception e) {
						//����ӡ�쳣
					}
				}

			}
		}.start();

		// ����һ���̸߳������Ĵ����ػ��߳�
		new Thread() {
			public void run() {

				while (true) {
					// ���ƴ���
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						//����ӡ��
					}
				}
			}
		}.start();
	}

	// ����˫���廭����ͼƬ��ð�ռ�
	@Override
	public void paint(Graphics g) {
		// �滭��
		BufferedImage bi = (BufferedImage) this.createImage(this.getSize().width, this.getSize().height);
		// ����
		Graphics big = bi.getGraphics();

		//����ͼ
		for (int i = 0; i < 5; i++) {
			big.drawImage(map.Map.getImg()[i].getPicturePath(), map.Map.getImg()[i].getX(), map.Map.getImg()[i].getY(),
					map.Map.getImg()[i].getWidth(), map.Map.getImg()[i].getHeight(), null);
		}
		//������
		PortalView.portalUse(big,portal,map);

		//���÷�����ӡӢ��
		GraphicsView.heroActionImg(big, hero.image, hero.hero);

		//���Ͻ�����
		//drawleftBg(big);
		LeftBgView.drawleftBg(big, leftBg, hero);

		//����������
		TopBgView.topBgView(big, topBg);

		//���Ͻ�С��ͼ
		RightBgView.rightBgView(big, map, hero);

		//��ӡ�ϰ���
		ObsView.obsView(big, map, hero);
		//��ӡǰ��ͼ��ĵ�ͼ
		for (int i = 5; i < map.Map.getImg().length; i++) {
			big.drawImage(map.Map.getImg()[i].getPicturePath(), map.Map.getImg()[i].getX(), map.Map.getImg()[i].getY(),
					map.Map.getImg()[i].getWidth(), map.Map.getImg()[i].getHeight(), null);
		}
		// �滭��ɫ
		g.drawImage(bi, 0, 0, null);
	}

}
