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
	public final String DIR_ROPE = "rope";

	//改变地图的判断  ture需要改变
	public boolean changeMap = false;
	//绳索控制判断
	public boolean ropeContral = false;
	//判断英雄朝向 ，true-左 false -右
	public boolean faceTo = false;
	//英雄的向上移动判断
	public boolean ropeUp = false;
	//英雄的向下移动判断
	public boolean ropeDown = false;

	public Hero(GameFrame gf) {


		hero = SQL.HeroSQL.soldier[0];
		this.gf = gf;
//		this.hero.getIsGravity();
//		hero.getAbilityValue().getCurrHp();
		this.Gravity();

	}

	//移动方法
	public void run() {

		while (true) {
			//英雄的地图改变
			changeMap();
//			if (ropeContral) {
//				//heroRope();
//			}else {
				//英雄基础移动
				baseMoveHero();
//			}
			//休眠
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 英雄绳索逻辑
	 */
	private void heroRope() {
		//测试
		if (ropeUp) {
			this.image[0] = new Img("上", "Image\\技能1下右.gif", 168, 192, 50, 50);
			if (hero.getMove().getY() >= 400) {
				hero.getMove().setY(hero.getMove().getY()-hero.getMove().getUpSpeed());
			}
			if (hero.getMove().getY() < 400 && hero.getMove().getY() >= 300) {
				for (int i = 3; i < gf.map.Map.getImg().length ; i++) {
					gf.map.Map.getImg()[i].setY(gf.map.Map.getImg()[i].getY()+hero.getMove().getUpSpeed());
				}
				for (int i = 0; i < 3 ; i++) {
					gf.map.Map.getImg()[i].setY(gf.map.Map.getImg()[i].getY()+hero.getMove().getUpSpeed()*2*(i+1)/10);
				}
				//地面碰撞改变
				for (int i = 0; i < gf.map.Map.getObsBottom().length ; i++) {
					gf.map.Map.getObsBottom()[i].getImg().setY(gf.map.Map.getObsBottom()[i].getImg().getY()+hero.getMove().getUpSpeed());
				}
				for (int i = 0; i < gf.map.Map.getRope().length ; i++) {
					gf.map.Map.getRope()[i].getImg().setY(gf.map.Map.getRope()[i].getImg().getY()+hero.getMove().getUpSpeed());
				}
				for (int i = 0; i < gf.map.Map.getObsLeft().length ; i++) {
					gf.map.Map.getObsLeft()[i].getImg().setY(gf.map.Map.getObsLeft()[i].getImg().getY()+ hero.getMove().getUpSpeed());
				}

				for (int i = 0; i < gf.map.Map.getObsRight().length ; i++) {
					gf.map.Map.getObsRight()[i].getImg().setY(gf.map.Map.getObsRight()[i].getImg().getY()+ hero.getMove().getUpSpeed());
				}
			}
			if (hero.getMove().getY() < 300) {
				hero.getMove().setY(hero.getMove().getY()-hero.getMove().getUpSpeed());
			}
		}
		if (ropeDown) {
			this.image[0] = new Img("下", "Image\\技能1下右.gif", 168, 192, 50, 50);
			if (hero.getMove().getY() <= 300) {
				hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed());
			}
			if (hero.getMove().getY() <= 400 && hero.getMove().getY() > 300) {
				for (int i = 3; i < gf.map.Map.getImg().length ; i++) {
					gf.map.Map.getImg()[i].setY(gf.map.Map.getImg()[i].getY()-hero.getMove().getUpSpeed());
				}
				for (int i = 0; i < 3 ; i++) {
					gf.map.Map.getImg()[i].setY(gf.map.Map.getImg()[i].getY()-hero.getMove().getUpSpeed()*2*(i+1)/10);
				}

				for (int i = 0; i < gf.map.Map.getObsBottom().length ; i++) {
					gf.map.Map.getObsBottom()[i].getImg().setY(gf.map.Map.getObsBottom()[i].getImg().getY()-hero.getMove().getUpSpeed());
				}

				for (int i = 0; i < gf.map.Map.getRope().length ; i++) {
					gf.map.Map.getRope()[i].getImg().setY(gf.map.Map.getRope()[i].getImg().getY()- hero.getMove().getUpSpeed());
				}

				for (int i = 0; i < gf.map.Map.getObsLeft().length ; i++) {
					gf.map.Map.getObsLeft()[i].getImg().setY(gf.map.Map.getObsLeft()[i].getImg().getY()- hero.getMove().getUpSpeed());
				}

				for (int i = 0; i < gf.map.Map.getObsRight().length ; i++) {
					gf.map.Map.getObsRight()[i].getImg().setY(gf.map.Map.getObsRight()[i].getImg().getY()- hero.getMove().getUpSpeed());
				}

			}
			if (hero.getMove().getY() > 400) {
				hero.getMove().setY(hero.getMove().getY()+hero.getMove().getUpSpeed());
			}
		}
	}

	/**
	 * 英雄基础移动，左右站立,跳跃,移动,重力线程
	 */
	public void baseMoveHero() {
		//英雄站立
		heroStand();
		//是否进入走步
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
		//跳跃
		if (hero.getAction()[4].isDirection()) {
			heroJump();
			jumpImg();
		}

		if (hero.getIsGravity()) {
			isGravity();
		}
	}

	/**
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
		//向左跑步
		if (hero.getAction()[2].isDirection()) {
			this.image = hero.getAction()[2].getImg();
			if (hit(dir_Left)) {
				hero.getMove().setLeftSpeed(0);
			}
			heroLeftRun();
			hero.getMove().setLeftSpeed(5);
		}
		//向右跑步
		if (hero.getAction()[3].isDirection()) {
			this.image = hero.getAction()[3].getImg();
			if (hit(dir_Right)){
				hero.getMove().setRightSpeed(0);
			}
			heroRightRun();
			hero.getMove().setRightSpeed(5);
		}

	}
	/**
	 * 向右跑的判断
	 */
	@Override
	public void heroRightRun() {
		//hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		//4900  1024  512
		if (hero.getMove().getX() >= 0 && hero.getMove().getX() <= 510) {
			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		}
		if (hero.getMove().getX() == 515) {
			//循环打印地图
			for (int i = 0; i < gf.map.Map.getImg().length; i++) {
				//地图向左移动
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
                hero.getMove().getX() < (1024 - hero.getAction()[0].getImg()[0].getWidth())) &&
                gf.map.Map.getImg()[4].getX() < (1024 - gf.map.Map.getImg()[4].getWidth())) {
			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		}


	}

	/**
	 * 向左跑的判断
	 */
	@Override
	public void heroLeftRun() {

		if (hero.getMove().getX() > 0 && hero.getMove().getX() <= 515 && gf.map.Map.getImg()[0].getX() == 0) {
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		}
		if (hero.getMove().getX() == 515) {
			//循环打印地图
			for (int i = 0; i < gf.map.Map.getImg().length; i++) {
				//地图向左移动
				//地图向左移动
				if (i == 2) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getLeftSpeed() * 6 / 10));
				}
				if (i == 1) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getLeftSpeed() * 4 / 10));
				}
				if (i == 0) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + (hero.getMove().getLeftSpeed() * 2 / 10));
				} else if (i != 2 && i != 1) {
					gf.map.Map.getImg()[i].setX(gf.map.Map.getImg()[i].getX() + hero.getMove().getLeftSpeed());
				}
			}
		}
		//
		if (hero.getMove().getX() >= 510 && hero.getMove().getX() <= 1024
				&& gf.map.Map.getImg()[4].getX() < 1024 - gf.map.Map.getImg()[4].getWidth()) {
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		}
	}

	/**
	 * 英雄跳跃
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
	 * 跳跃降落函数
	 */
	@Override
	public void jumpLogic() {
		//跳跃高度
		int jumpHeigh = 0;
		for (int i = 0; i < 160; i++) {
			//true往上跳
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
		//跳跃最高处停顿
		try {
			sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//降落
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
	 * 跳跃图片改变
	 */
	@Override
	public void jumpImg() {
		//判断朝向
		if (faceTo) {
			//判断是上还是下
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
	 * 检测碰撞
	 */
	@Override
	public boolean hit(String dir) {
		//英雄的碰撞列表
		ArrayList<Rectangle> obsHreo = new ArrayList<>();
		//Swing 技术中

		for (int i = 0; i < image.length; i++) {
			obsHreo.add(new Rectangle(hero.getMove().getX(), hero.getMove().getY(), image[i].getWidth(), image[i].getHeight()));
		}
		//障碍物集合
		ArrayList<Rectangle> obsLeft = new ArrayList<>();
		ArrayList<Rectangle> obsRight = new ArrayList<>();
		ArrayList<Rectangle> obsBottom = new ArrayList<>();
		ArrayList<Rectangle> ladder = new ArrayList<>();
		ArrayList<Rectangle> rope = new ArrayList<>();

		try {
			for (int i = 0; i < gf.map.Map.getObsLeft().length; i++) {
				obsLeft.add(new Rectangle(gf.map.Map.getObsLeft()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getObsLeft()[i].getImg().getY(),
						gf.map.Map.getObsLeft()[i].getImg().getWidth(), gf.map.Map.getObsLeft()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getObsRight().length; i++) {
				obsRight.add(new Rectangle(gf.map.Map.getObsRight()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getObsRight()[i].getImg().getY(),
						gf.map.Map.getObsRight()[i].getImg().getWidth(), gf.map.Map.getObsRight()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getObsBottom().length; i++) {
				obsBottom.add(new Rectangle(gf.map.Map.getObsBottom()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getObsBottom()[i].getImg().getY(),
						gf.map.Map.getObsBottom()[i].getImg().getWidth(), gf.map.Map.getObsBottom()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getLadder().length; i++) {
				ladder.add(new Rectangle(gf.map.Map.getLadder()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getLadder()[i].getImg().getY(),
						gf.map.Map.getLadder()[i].getImg().getWidth(), gf.map.Map.getLadder()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getRope().length; i++) {
				rope.add(new Rectangle(gf.map.Map.getRope()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getRope()[i].getImg().getY(),
						gf.map.Map.getRope()[i].getImg().getWidth(), gf.map.Map.getRope()[i].getImg().getHeight()));
			}
		} catch (NullPointerException e) {
			System.err.println("");
		}

		//碰撞底面检查
		if (dir.equals(dir_Down)) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsBottom.size(); j++) {
					if (obsHreo.get(i).intersects(obsBottom.get(j))) {
						return true;
					}
				}
			}
		}

		//右障碍物判断
		if (dir.equals("right")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsRight.size(); j++) {
					if (obsHreo.get(i).intersects(obsRight.get(j))) {
						return true;
					}
				}
			}
		}
		//左障碍物判断
		if (dir.equals(dir_Left)) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < obsLeft.size(); j++) {
					if (obsHreo.get(i).intersects(obsLeft.get(j))) {
						return true;
					}
				}
			}
		}
		//梯子碰撞判断
		if (dir.equals("ladder")) {
			for (int i = 0; i < obsHreo.size(); i++) {
				for (int j = 0; j < ladder.size(); j++) {
					if (obsHreo.get(i).intersects(ladder.get(j))) {
						return true;
					}
				}
			}
		}
		//绳子碰撞判断
		if (dir.equals(DIR_ROPE)) {
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
	 * 重力线程
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

						if (ropeContral) {
							break;
						}
						//利用上面定义的英雄运动的6的判断跳跃?
						if (hero.getAction()[6].isDirection()&&!hero.getIsGravity()) {
							break;
						}
						if (hit(dir_Down)) {
							hero.setIsGravity(false);
							break;
						}
						if (hero.getMove().getY() >= 570) {
							hero.setIsGravity(false);
						} else {
							if (!hero.getAction()[4].isDirection()) {
								hero.setIsGravity(true);
								hero.getMove().setY(hero.getMove().getY() + (hero.getMove().getDownSoeed() * 3));
							}
//							try {
//								if (gf.map.Map.getImg()[4].getY() > -750) {
//									hero.setIsGravity(true);
//									for (int i = 0; i < gf.map.Map.getImg().length ; i++) {
//										gf.map.Map.getImg()[i].setY(gf.map.Map.getImg()[i].getY() -(hero.getMove().getDownSoeed() * 3) );
//									}
//								}
//							} catch (Exception e) {
//								e.printStackTrace();
//							}
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
