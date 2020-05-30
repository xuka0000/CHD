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
 * 英雄线程
 *
 * @author OUT
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
	public boolean changeMap = false;

	//判断英雄朝向 ，true-左 false -右
	public boolean faceTo = false;

	public Hero(GameFrame gf) {


		hero = SQL.HeroSQL.soldier[0];
		this.gf = gf;
//		this.hero.getIsGravity();
//		hero.getAbilityValue().getCurrHp();
		this.Gravity();

	}

	//移动方法
	public void run() {
		int i = 1;
		while (true) {

			//英雄的地图改变
			changeMap();
			//不写就动不了


			if (i == 2) {
				System.out.println("hh");
			}
			i++;
			//站立方法
			heroStand();
			//左右跑步方法
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
			//跳跃方法
			if (hero.getAction()[4].isDirection()) {
				heroJump();
				jumpImg();
			}

			if (hero.getIsGravity()) {
				isGravity();
			}

			//休眠
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
<<<<<<< HEAD
	 * 更换地图，更换英雄坐标
	 */
	public void changeMap() {
		if (changeMap) {
			for (int i = 0; i < gf.portal.length; i++) {
				if (gf.portal[i].portal.getIsGravity()) {
					hero.setMapId(gf.portal[i].portal.getChangeMapId());
					hero.getMove().setX(gf.portal[i].portal.getChangeHeroX());
					hero.getMove().setY(gf.portal[i].portal.getChangeHeroY());
				}
			}
			changeMap = false;
		}
	}

	/**
	 * 下降图片
=======
	 * 涓嬮檷鍥剧墖
>>>>>>> 6ea51db78ee0f9c87ab8400125c8e1523c62c56b
	 */
	private void isGravity() {
		if (faceTo) {
			this.image = hero.getAction()[5].getImg();
		} else {
			this.image = hero.getAction()[7].getImg();
		}
	}
	/**
	 * 站立
	 */
	public void heroStand() {
		if (faceTo) {
			this.image = hero.getAction()[0].getImg();

		} else {
			this.image = hero.getAction()[1].getImg();
		}
	}

	/**
	 * 跑步
	 */
	public void heroRun() {
		//鍚戝乏璺戞
		if (hero.getAction()[2].isDirection()) {
			this.image = hero.getAction()[2].getImg();
			heroLeftRun();
		}
		//鍚戝彸璺戞
		if (hero.getAction()[3].isDirection()) {
			this.image = hero.getAction()[3].getImg();
			heroRightRun();
		}

	}
	/**
	 * 右跑
	 */
	@Override
	public void heroRightRun() {
		//hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		//4900  1024  512
		if (hero.getMove().getX() >= 0 && hero.getMove().getX() <= 510) {
			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		}
		if (hero.getMove().getX() == 515) {
			//寰幆鎵撳嵃鍦板浘
			for (int i = 0; i < gf.map.Map.getImg().length; i++) {
				//鍦板浘鍚戝乏绉诲姩
				if (i == 2) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - (hero.getMove().getRightSpeed() * 6 / 10));
				}
				if (i == 1) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - (hero.getMove().getRightSpeed() * 4 / 10));
				}
				if (i == 0) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - (hero.getMove().getRightSpeed() * 2 / 10));
				} else if (i != 2 && i != 1) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() - hero.getMove().getRightSpeed());
				}
			}
		}
		//
		if ((hero.getMove().getX() >= 515 &&
				//鍦ㄥ浘鐨勫彸杈癸紝1024-鑻遍泟宸︿笂瑙掑潗鏍?
				hero.getMove().getX() < (1024 - hero.getAction()[0].getImg()[0].getWidth())) &&

				//地图的x一定小于1024-地图的x
				gf.map.Map.getImg()[4].getX() < (1024 - gf.map.Map.getImg()[4].getWidth())) {


			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());

		}

	}

	/**
	 * 左跑
	 */
	@Override
	public void heroLeftRun() {
		//hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		//鍚戝乏璧?
		if (hero.getMove().getX() > 0 && hero.getMove().getX() <= 515 && gf.map.Map.getImg()[0].getX() == 0) {
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		}
		if (hero.getMove().getX() == 515) {
			//寰幆鎵撳嵃鍦板浘
			for (int i = 0; i < gf.map.Map.getImg().length; i++) {
				//鍦板浘鍚戝乏绉诲姩
				//鍦板浘鍚戝乏绉诲姩
				if (i == 2) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getRightSpeed() * 6 / 10));
				}
				if (i == 1) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getRightSpeed() * 4 / 10));
				}
				if (i == 0) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getRightSpeed() * 2 / 10));
				} else if (i != 2 && i != 1) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + hero.getMove().getRightSpeed());
				}
			}
		}
		//
		if (hero.getMove().getX() >= 510 && hero.getMove().getX() <= 1024
				&& gf.map.Map.getImg()[4].getX() < 1024 - gf.map.Map.getImg()[4].getWidth()) {
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getRightSpeed());
		}
	}

	/**
	 * 跳跃
	 */
	@Override
	public void heroJump() {
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
	 * 璺宠穬闄嶈惤鍑芥暟
	 */
	@Override
	public void jumpLogic() {
		//璺宠穬楂樺害
		int jumpHeigh = 0;
		for (int i = 0; i < 150; i++) {
			//true寰?涓婅烦
			hero.getAction()[6].setDirection(true);
			hero.getMove().setY(hero.getMove().getY() - hero.getMove().getUpSpeed());
			if (i % 5 == 0 && i > 30) {
				gf.map.Map.getImg()[2].setY(gf.map.Map.getImg()[2].getY() - 2 * i * i / 8000);
				gf.map.Map.getImg()[1].setY(gf.map.Map.getImg()[1].getY() - 1 * i * i / 8000);
			}
			jumpHeigh++;

			try {
				sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//璺宠穬鏈?楂樺鍋滈】
		try {
			sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//闄嶈惤
		for (int i = 0; i < jumpHeigh; i++) {

			hero.getAction()[6].setDirection(false);
			hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed());
			if (i % 5 == 0 && i > 30) {
				gf.map.Map.getImg()[2].setY(gf.map.Map.getImg()[2].getY() + 2 * i * i / 8000);
				gf.map.Map.getImg()[1].setY(gf.map.Map.getImg()[1].getY() + 1 * i * i / 8000);
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
	 * 璺宠穬鍥剧墖鏀瑰彉
	 */
	@Override
	public void jumpImg() {
		//鍒ゆ柇鏈濆悜
		if (faceTo) {
			//鍒ゆ柇鏄笂杩樻槸涓?
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
	 * 妫?娴嬬鎾?
	 */
	@Override
	public boolean hit(String dir) {
		//鑻遍泟鐨勭鎾炲垪琛?
		ArrayList<Rectangle> obsHreo = new ArrayList<>();
		//Swing 鎶?鏈腑

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

		//纰版挒搴曢潰妫?鏌?
		if (dir.equals(dir_Down)) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsBottom.size(); j++) {
					if (obsHreo.get(i).intersects(obsBottom.get(j))) {

						return true;
					}
				}
			}
		}

		//鍙抽殰纰嶇墿鍒ゆ柇
		if (dir.equals("right")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsRight.size(); j++) {
					if (obsHreo.get(i).intersects(obsRight.get(j))) {
						return true;
					}
				}
			}
		}
		//宸﹂殰纰嶇墿鍒ゆ柇
		if (dir.equals("left")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsLeft.size(); j++) {
					if (obsHreo.get(i).intersects(obsLeft.get(j))) {
						return true;
					}
				}
			}
		}
		//姊瓙纰版挒鍒ゆ柇
		if (dir.equals("ladder")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < ladder.size(); j++) {
					if (obsHreo.get(i).intersects(ladder.get(j))) {
						return true;
					}
				}
			}
		}
		//缁冲瓙纰版挒鍒ゆ柇
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
	 * 閲嶅姏绾跨▼
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
						//鍒╃敤涓婇潰瀹氫箟鐨勮嫳闆勫浘鐗?6鐨勫垽鏂烦璺?

						if (hero.getAction()[6].isDirection()&&!hero.getIsGravity()) {

							break;
						}

						if (hit(dir_Down)) {

							break;
						}
						if (hero.getMove().getY() >= 570) {

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
