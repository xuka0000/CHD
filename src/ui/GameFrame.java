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
	public Portal[] portal;

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

		// ȷ����ͼ����
		for (int i = 0; i <MapSQL.MapSQL.length; i++) {
			if (hero.hero.getMapId() == i) {
				for (int j = 0; j <MapSQL.MapSQL.length; j++) {
					if (SQL.MapSQL.MapSQL[j].getId() == i) {
						//��Map
						map.Map = SQL.MapSQL.MapSQL[j];
					}
				}
			}
		}

		// ��������(�̣߳�
		for (int i = 0; i < map.Map.getMonster().length - 1; i++) {
			monster[i] = new Monster(this);
		}
		// ����NPC(�̣߳�
		for (int i = 0; i < map.Map.getNPC().length - 1; i++) {
			NPC[i] = new NPC(this);
		}
		// ����������
		for (int i = 0; i < map.Map.getPortal().length - 1; i++) {
			portal[i] = new Portal(this);
		}

		// �߳�����ʼ
		// ð�ռ�
		hero.start();
		// ����
		for (int i = 0; i < map.Map.getMonster().length - 1; i++) {
			monster[i].start();
		}
		// NPC
		for (int i = 0; i < map.Map.getNPC().length - 1; i++) {
			NPC[i].start();
		}
		// ������
		for (int i = 0; i < map.Map.getPortal().length - 1; i++) {
			portal[i].start();
		}

		// �������ֲ�����
		new Thread() {
			public void run() {
				while (true) {
					AudioPlayer StartSound = new AudioPlayer(map.Map.getSound().getSoundPath());
					StartSound.run();
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
						// TODO Auto-generated catch block
						e.printStackTrace();
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
		for (int i = map.Map.getImg().length - 1; i >= 0; i--) {
			big.drawImage(map.Map.getImg()[i].getPicturePath(), map.Map.getImg()[i].getX(), map.Map.getImg()[i].getY(),
					map.Map.getImg()[i].getWidth(), map.Map.getImg()[i].getHeight(), null);
		}
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

		// �滭��ɫ
		g.drawImage(bi, 0, 0, null);
	}

}
