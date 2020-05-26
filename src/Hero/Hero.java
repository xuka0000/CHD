package Hero;

import javax.swing.*;
import javax.xml.crypto.Data;

import DataMask.HeroMask;
import DataMask.Img;
import DataMask.Obstruction;
import ui.GameFrame;
import SQL.HeroSQL;

import java.awt.*;
import java.util.ArrayList;

/**
 * ð�ռ�
 *
 * @author ����
 */
public class Hero extends Thread implements HeroControl{

	public HeroMask hero;
	public GameFrame gf;
	public Img[] image = {
			new Img("", "", 0, 0, 0, 0)
	};
	public int high = 50;
	public int width = 50;
	public String dir_Left = "left";
	public String dir_Right = "right";
	public String dir_Down = "down";

	//���ﳯ��,ture �� false ��
	public boolean faceTo = false;

	public Hero(GameFrame gf) {


		hero = SQL.HeroSQL.soldier[0];
		this.gf = gf;
//		this.hero.getIsGravity();
//		hero.getAbilityValue().getCurrHp();
		this.Gravity();

	}

	//Ӣ���ƶ�
	public void run() {
		int i = 1;
		while (true) {
			//��д�Ͷ�����
			if (i == 2) {
				System.out.println("hh");
			}
			i++;
			//Ӣ��վ��
			heroStand();
			//�Ƿ�����߲�
			if (hero.getAction()[2].isDirection() || hero.getAction()[3].isDirection()) {
				if (hit("right")) {
					hero.getMove().setRightSpeed(0);
				}
				if (hit("left")) {
					hero.getMove().setLeftSpeed(0);
				}

				heroRun();

				hero.getMove().setRightSpeed(5);
				hero.getMove().setLeftSpeed(5);
			}
			//��Ծ
			if (hero.getAction()[4].isDirection()) {
				heroJump();
				jumpImg();
			}

			if (hero.getIsGravity()) {
				isGravity();
			}

			//���ӳ�
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * �½�ͼƬ
	 */
	private void isGravity() {
		if (faceTo) {
			this.image = hero.getAction()[5].getImg();
		} else {
			this.image = hero.getAction()[7].getImg();
		}
	}
	/**
	 * վ��
	 */
	public void heroStand() {
		if (faceTo) {
			this.image = hero.getAction()[0].getImg();

		} else {
			this.image = hero.getAction()[1].getImg();
		}
	}

	/**
	 * �ܲ�
	 */
	public void heroRun() {
		//�����ܲ�
		if (hero.getAction()[2].isDirection()) {
			this.image = hero.getAction()[2].getImg();
			heroLeftRun();
		}
		//�����ܲ�
		if (hero.getAction()[3].isDirection()) {
			this.image = hero.getAction()[3].getImg();
			heroRightRun();
		}

	}
	/**
	 * �����ܵ��ж�
	 */
	@Override
	public void heroRightRun() {
		//hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		//4900  1024  512
		if (hero.getMove().getX() >= 0 && hero.getMove().getX() <= 510) {
			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		}
		if (hero.getMove().getX() == 515) {
			//ѭ����ӡ��ͼ
			for (int i = 0; i < gf.map.Map.getImg().length; i++) {
				//��ͼ�����ƶ�
				if (i == 2) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - (hero.getMove().getRightSpeed() * 6 / 10));
				}
				if (i == 3) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - (hero.getMove().getRightSpeed() * 4 / 10));
				}
				if (i == 4) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - (hero.getMove().getRightSpeed() * 2 / 10));
				} else if (i != 2 && i != 3) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - hero.getMove().getRightSpeed());
				}
			}
		}
		//
		if ((hero.getMove().getX() >= 515 &&
				//��ͼ���ұߣ�1024-Ӣ�����Ͻ�����
				hero.getMove().getX() < (1024 - hero.getAction()[0].getImg()[0].getWidth())) &&
				//��ͼ��xһ��С��1024-��ͼ��x
				gf.map.Map.getImg()[0].getX() < (1024 - gf.map.Map.getImg()[0].getWidth())) {

			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());

		}


	}

	/**
	 * �����ܵ��ж�
	 */
	@Override
	public void heroLeftRun() {
		//hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		//������
		if (hero.getMove().getX() > 0 && hero.getMove().getX() <= 515 && gf.map.Map.getImg()[0].getX() == 0) {
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		}
		if (hero.getMove().getX() == 515) {
			//ѭ����ӡ��ͼ
			for (int i = 0; i < gf.map.Map.getImg().length; i++) {
				//��ͼ�����ƶ�
				//��ͼ�����ƶ�
				if (i == 2) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getRightSpeed() * 6 / 10));
				}
				if (i == 3) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getRightSpeed() * 4 / 10));
				}
				if (i == 4) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getRightSpeed() * 2 / 10));
				} else if (i != 2 && i != 3) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + hero.getMove().getRightSpeed());
				}
			}
		}
		//
		if (hero.getMove().getX() >= 510 && hero.getMove().getX() <= 1024
				&& gf.map.Map.getImg()[0].getX() < 1024 - gf.map.Map.getImg()[0].getWidth()) {
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getRightSpeed());
		}
	}

	/**
	 * Ӣ����Ծ
	 */
	@Override
	public void heroJump() {
		System.out.println("�����"+!hero.getIsGravity());
		if (!hero.getAction()[5].isDirection() && !hero.getIsGravity()) {
			hero.getAction()[5].setDirection(true);
			new Thread() {
				@Override
				public void run() {
					jumpLogic();
					hero.getAction()[5].setDirection(false);
					hero.getAction()[4].setDirection(false);
				}
			}.start();
		}
	}

	/**
	 * ��Ծ���亯��
	 */
	@Override
	public void jumpLogic() {
		//��Ծ�߶�
		int jumpHeigh = 0;
		for (int i = 0; i < 150; i++) {
			//true������
			hero.getAction()[6].setDirection(true);
			hero.getMove().setY(hero.getMove().getY() - hero.getMove().getUpSpeed());
			if (i % 5 == 0 && i > 30) {
				gf.map.Map.getImg()[2].setY(gf.map.Map.getImg()[2].getY() - 2 * i * i / 8000);
				gf.map.Map.getImg()[3].setY(gf.map.Map.getImg()[3].getY() - 1 * i * i / 8000);
			}
			jumpHeigh++;

			try {
				sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//��Ծ��ߴ�ͣ��
		try {
			sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//����
		for (int i = 0; i < jumpHeigh; i++) {

			hero.getAction()[6].setDirection(false);
			hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed());
			if (i % 5 == 0 && i > 30) {
				gf.map.Map.getImg()[2].setY(gf.map.Map.getImg()[2].getY() + 2 * i * i / 8000);
				gf.map.Map.getImg()[3].setY(gf.map.Map.getImg()[3].getY() + 1 * i * i / 8000);
			}

			if (hit(dir_Down)) {
				hero.getMove().setDownSoeed(0);
			} else {
				hero.getMove().setDownSoeed(1);
			}

			try {
				sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		hero.getMove().setDownSoeed(1);
	}

	/**
	 * ��ԾͼƬ�ı�
	 */
	@Override
	public void jumpImg() {
		//�жϳ���
		if (faceTo) {
			//�ж����ϻ�����
			if (hero.getAction()[6].isDirection()) {
				this.image = hero.getAction()[4].getImg();
			} else {

				this.image = hero.getAction()[5].getImg();
			}
		} else {
			if (hero.getAction()[6].isDirection()) {
				this.image = hero.getAction()[6].getImg();
			} else {

				this.image = hero.getAction()[7].getImg();
			}
		}
	}

	/**
	 * �����ײ
	 */
	@Override
	public boolean hit(String dir) {
		//Ӣ�۵���ײ�б�
		ArrayList<Rectangle> obsHreo = new ArrayList<>();
		//Swing ������

		for (int i = 0; i < image.length; i++) {
			obsHreo.add(new Rectangle(hero.getMove().getX(), hero.getMove().getY(), image[i].getWidth(), image[i].getHeight()));
		}
		ArrayList<Rectangle> obsLeft = new ArrayList<>();
		ArrayList<Rectangle> obsRight = new ArrayList<>();
		ArrayList<Rectangle> obsBottom = new ArrayList<>();
		ArrayList<Rectangle> ladder = new ArrayList<>();
		ArrayList<Rectangle> rope = new ArrayList<>();

		try {
			for (int i = 0; i < gf.map.Map.getObsLeft().length; i++) {
				obsLeft.add(new Rectangle(gf.map.Map.getObsLeft()[i].getImg().getX()+gf.map.Map.getImg()[0].getX(), gf.map.Map.getObsLeft()[i].getImg().getY(),
						gf.map.Map.getObsLeft()[i].getImg().getWidth(), gf.map.Map.getObsLeft()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getObsRight().length; i++) {
				obsRight.add(new Rectangle(gf.map.Map.getObsRight()[i].getImg().getX()+gf.map.Map.getImg()[0].getX(), gf.map.Map.getObsRight()[i].getImg().getY(),
						gf.map.Map.getObsRight()[i].getImg().getWidth(), gf.map.Map.getObsRight()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getObsBottom().length; i++) {
				obsBottom.add(new Rectangle(gf.map.Map.getObsBottom()[i].getImg().getX()+gf.map.Map.getImg()[0].getX(), gf.map.Map.getObsBottom()[i].getImg().getY(),
						gf.map.Map.getObsBottom()[i].getImg().getWidth(), gf.map.Map.getObsBottom()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getLadder().length; i++) {
				ladder.add(new Rectangle(gf.map.Map.getLadder()[i].getImg().getX()+gf.map.Map.getImg()[0].getX(), gf.map.Map.getLadder()[i].getImg().getY(),
						gf.map.Map.getLadder()[i].getImg().getWidth(), gf.map.Map.getLadder()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getRope().length; i++) {
				rope.add(new Rectangle(gf.map.Map.getRope()[i].getImg().getX()+gf.map.Map.getImg()[0].getX(), gf.map.Map.getRope()[i].getImg().getY(),
						gf.map.Map.getRope()[i].getImg().getWidth(), gf.map.Map.getRope()[i].getImg().getHeight()));
			}
		} catch (NullPointerException e) {
			System.err.println("");
		}

		//��ײ������
		if (dir.equals(dir_Down)) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsBottom.size(); j++) {
					if (obsHreo.get(i).intersects(obsBottom.get(j))) {
						//System.out.println("down");
						return true;
					}
				}
			}
		}

		//���ϰ����ж�
		if (dir.equals("right")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsRight.size(); j++) {
					if (obsHreo.get(i).intersects(obsRight.get(j))) {
						return true;
					}
				}
			}
		}
		//���ϰ����ж�
		if (dir.equals("left")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsLeft.size(); j++) {
					if (obsHreo.get(i).intersects(obsLeft.get(j))) {
						return true;
					}
				}
			}
		}
		//������ײ�ж�
		if (dir.equals("ladder")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < ladder.size(); j++) {
					if (obsHreo.get(i).intersects(ladder.get(j))) {
						return true;
					}
				}
			}
		}
		//������ײ�ж�
		if (dir.equals("rope")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < rope.size(); j++) {
					if (obsHreo.get(i).intersects(rope.get(j))) {
						return true;
					}
				}
			}
		}
		return false;
	}
	/**
	 * �����߳�
	 */
	@Override
	public void Gravity() {
		new Thread(){
			@Override
			public void run() {
				while (true) {

					try {
						sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					while (true) {
						//�������涨���Ӣ��ͼƬ6���ж���Ծ

						if (hero.getAction()[6].isDirection()&&!hero.getIsGravity()) {

							break;
						}

						if (hit(dir_Down)) {

							break;
						}
						if (hero.getMove().getY() >= 570) {
							System.out.println(!hero.getIsGravity());
							hero.setIsGravity(false);
						} else {
							if (!hero.getAction()[4].isDirection()) {
								hero.setIsGravity(true);
								hero.getMove().setY(hero.getMove().getY() + (hero.getMove().getDownSoeed() * 1));
							}
						}
						try {
							sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}.start();
	}
}
