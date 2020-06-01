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
	//绳索控制判断  英雄的爬绳子向上移动判断  英雄的爬绳子向下移动判断  判断绳索是否需要被监听
	public boolean ropeContral = false , ropeUp = false ,ropeDown = false , isRopeContraling = true;
	//判断英雄朝向 ，true-左 false -右
	public boolean faceTo = false;
	//是否在扒绳索的时候跳跃
	public boolean ropeToJump = false;


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

			if (ropeContral) {
				heroRope();
			}else {
				//英雄基础移动
				baseMoveHero();
			}


			//判断绳索是否可以进行判断（我预判你的预判 哈哈哈哈 ）
			ropeHero.isRopeContraling(gf);
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
		/**
		 * 上扒
		 */
		if (ropeUp) {
            //System.out.println(gf.hero.hero.getMove().getY()+"英雄");
            // System.out.println(gf.map.Map.getImg()[4].getY()+"地图");
            //System.out.println(gf.hero.hit(gf.hero.DIR_ROPE));
			this.image[0] = new Img("上", "Image\\技能1下右.gif", 168, 192, 50, 50);
			/**
			 * Hero:570 ~ 400
			 * Map:-750 ~ -650
			 */
			if (hero.getMove().getY() >= 400 && gf.map.Map.getImg()[4].getY()<=-650) {
				hero.getMove().setY(hero.getMove().getY()-hero.getMove().getUpSpeed()*2);
			}
			/**
			 * Hero:400 ~ 120
			 * Map:-1000 ~ -100
			 */
			if ((hero.getMove().getY() < 400 && hero.getMove().getY() >= 120) &&
					(gf.map.Map.getImg()[4].getY()>=-1000 && gf.map.Map.getImg()[4].getY()<=-100)) {
				UnHeroControl.arraySetY_Up(gf.map.Map.getImg(),gf.hero.hero.getMove().getUpSpeed()*2);
				//地面碰撞改变
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getUpSpeed()*2);
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getRope(),gf.hero.hero.getMove().getUpSpeed()*2);
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getUpSpeed()*2);
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getUpSpeed()*2);

			}
			/**
			 * Hero:285 ~ 0
			 * Map:-100 ~ 0
			 */
			if (hero.getMove().getY() < 285 &&
					(gf.map.Map.getImg()[4].getY()>-100 && gf.map.Map.getImg()[4].getY() <0)) {
				hero.getMove().setY(hero.getMove().getY()-hero.getMove().getUpSpeed()*2);
			}
		}
		/**
		 * 下扒
		 */
		if (ropeDown) {
			System.out.println(gf.hero.hero.getMove().getY()+"英雄");
			System.out.println(gf.map.Map.getImg()[4].getY()+"地图");
			System.out.println(gf.hero.hit(gf.hero.DIR_ROPE));
			if(gf.hero.hit(gf.hero.dir_Down)){
				gf.hero.hero.getMove().setDownSoeed(0);
			}
			this.image[0] = new Img("下", "Image\\技能1下右.gif", 168, 192, 50, 50);
			/**
			 * Hero:570 ~ 400
			 * Map:-100 ~ 0
			 */
			if (hero.getMove().getY() >= 400 &&
					(gf.map.Map.getImg()[4].getY()>-100 && gf.map.Map.getImg()[4].getY() <0)) {
				hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed()*3);
			}
			/**
			 * Hero:400 ~ 285
			 * Map:-750 ~ -100
			 */
			if (hero.getMove().getY() <= 400 && hero.getMove().getY() > 160&&
					(gf.map.Map.getImg()[4].getY()>-800 && gf.map.Map.getImg()[4].getY()<=-100)) {
				UnHeroControl.arraySetY_Down(gf.map.Map.getImg(),gf.hero.hero.getMove().getDownSoeed()*3);

				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getDownSoeed()*3);
				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getRope(),gf.hero.hero.getMove().getDownSoeed()*3);
				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getDownSoeed()*3);
				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getDownSoeed()*3);

			}
			/**
			 * Hero:285 ~ 0
			 * Map:-750 ~ -600
			 */
			if (hero.getMove().getY() > 285 && gf.map.Map.getImg()[4].getY()<=-650) {
				hero.getMove().setY(hero.getMove().getY()+hero.getMove().getUpSpeed()*3);
			}
			gf.hero.hero.getMove().setDownSoeed(1);
		}
		/**
		 * 爬出绳索
		 */
		if(!gf.hero.hit(gf.hero.DIR_ROPE)){
			gf.hero.ropeContral = false;
		}

		gf.hero.ropeToJump = true;

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
		if (hero.getMove().getX() >510 && hero.getMove().getX()<520) {
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
		if (hero.getMove().getX() >510 && hero.getMove().getX()<520) {
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
			if(gf.hero.ropeToJump){
				UnHeroControl.arraySetY_Up(gf.map.Map.getImg(),gf.hero.hero.getMove().getUpSpeed());
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getUpSpeed());
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getUpSpeed());
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getUpSpeed());
				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getRope(),gf.hero.hero.getMove().getUpSpeed());
			}else{
				hero.getMove().setY(hero.getMove().getY() - hero.getMove().getUpSpeed());
				if (i % 5 == 0 && i > 30) {
					gf.map.Map.getImg()[2].setY(gf.map.Map.getImg()[2].getY() - 2 * i * i / 8000);
					gf.map.Map.getImg()[1].setY(gf.map.Map.getImg()[1].getY() - 1 * i * i / 8000);
				}
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
			if(gf.hero.ropeToJump){
				UnHeroControl.arraySetY_Down(gf.map.Map.getImg(),gf.hero.hero.getMove().getDownSoeed());
				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getDownSoeed());
				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getDownSoeed());
				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getDownSoeed());
				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getRope(),gf.hero.hero.getMove().getDownSoeed());
			}else{
				hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed());
				if (i % 5 == 0 && i > 30) {
					gf.map.Map.getImg()[2].setY(gf.map.Map.getImg()[2].getY() + 2 * i * i / 8000);
					gf.map.Map.getImg()[1].setY(gf.map.Map.getImg()[1].getY() + 1 * i * i / 8000);
				}
			}


			if (hit(dir_Down) || gf.hero.ropeContral) {
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
		//恢复出厂设置
		hero.getMove().setDownSoeed(1);
		gf.hero.ropeToJump = false;
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
		ArrayList<Rectangle> obsHeroDown = new ArrayList<>();
		ArrayList<Rectangle> obsHeroTop = new ArrayList<>();
		ArrayList<Rectangle> obsHeroRight = new ArrayList<>();
		ArrayList<Rectangle> obsHeroLeft = new ArrayList<>();
		ArrayList<Rectangle> obsHeroRope = new ArrayList<>();
		ArrayList<Rectangle> obsHeroLadder = new ArrayList<>();
		//Swing 技术中

		for (int i = 0; i < image.length; i++) {
			obsHeroDown.add(new Rectangle(hero.getMove().getX(), hero.getMove().getY()+image[i].getHeight(), image[i].getWidth(), 20));
		}
		for (int i = 0; i < image.length; i++) {
			obsHeroTop.add(new Rectangle(hero.getMove().getX(), hero.getMove().getY(), image[i].getWidth(), 20));
		}
		for (int i = 0; i < image.length; i++) {
			obsHeroRight.add(new Rectangle(hero.getMove().getX()+image[i].getWidth(), hero.getMove().getY(), 20, image[i].getHeight()));
		}
		for (int i = 0; i < image.length; i++) {
			obsHeroLeft.add(new Rectangle(hero.getMove().getX(), hero.getMove().getY(), 20, image[i].getHeight()));
		}
		for (int i = 0; i < image.length; i++) {
			obsHeroRope.add(new Rectangle(hero.getMove().getX()+image[i].getWidth()/2-25, hero.getMove().getY(), 50, image[i].getHeight()));
		}
		for (int i = 0; i < image.length; i++) {
			obsHeroLadder.add(new Rectangle(hero.getMove().getX()+image[i].getWidth()/2-25, hero.getMove().getY(), 50, image[i].getHeight()));
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
			for (int i = 0; i < obsHeroDown.size(); i++) {
				for (int j = 0; j < obsBottom.size(); j++) {
					if (obsHeroDown.get(i).intersects(obsBottom.get(j))) {
						return true;
					}
				}
			}
		}

		//右障碍物判断
		if (dir.equals("right")) {
			for (int i = 0; i < obsHeroRight.size(); i++) {
				for (int j = 0; j < obsRight.size(); j++) {
					if (obsHeroRight.get(i).intersects(obsRight.get(j))) {
						return true;
					}
				}
			}
		}
		//左障碍物判断
		if (dir.equals(dir_Left)) {
			for (int i = 0; i < obsHeroLeft.size(); i++) {
				for (int j = 0; j < obsLeft.size(); j++) {
					if (obsHeroLeft.get(i).intersects(obsLeft.get(j))) {
						return true;
					}
				}
			}
		}
		//梯子碰撞判断
		if (dir.equals("ladder")) {
			for (int i = 0; i < obsHeroLadder.size(); i++) {
				for (int j = 0; j < ladder.size(); j++) {
					if (obsHeroLadder.get(i).intersects(ladder.get(j))) {
						return true;
					}
				}
			}
		}
		//绳子碰撞判断
		if (dir.equals(DIR_ROPE)) {
			for (int i = 0; i < obsHeroRope.size(); i++) {
				for (int j = 0; j < rope.size(); j++) {
					if (obsHeroRope.get(i).intersects(rope.get(j))) {
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
						try{
							//System.out.println(gf.map.Map.getImg()[4].getY()+"这里这里");
							//System.out.println(hero.getMove().getY()+"障碍物的Y");

						}catch (Exception e){

						}
						if (ropeContral) {
							//System.out.println("1");
							break;
						}
						//利用上面定义的英雄运动的6的判断跳跃?
						if (hero.getAction()[6].isDirection()&&!hero.getIsGravity()) {
							//System.out.println("2");
							break;
						}
//


						if (hit(dir_Down)) {
							//System.out.println("3");
							hero.setIsGravity(false);
							break;
						}

						try{
							if (hero.getMove().getY() >= 570 && gf.map.Map.getImg()[4].getY()<=-750) {
								//System.out.println("4");
								hero.setIsGravity(false);
							} else {

								if (!hero.getAction()[4].isDirection()) {
									if(hero.getMove().getY()<570){
										hero.setIsGravity(true);
										hero.getMove().setY(hero.getMove().getY() + (hero.getMove().getDownSoeed()*3));

									}


										if(gf.map.Map.getImg()[4].getY()>-750){

											hero.setIsGravity(true);
											/**
											 * 背景图片下坠
											 */
											UnHeroControl.arraySetY_Down(gf.map.Map.getImg(),gf.hero.hero.getMove().getDownSoeed()*5);
											/**
											 * 障碍物下坠
											 */
											UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getDownSoeed()*5);
											UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getDownSoeed()*5);
											UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getDownSoeed()*5);
											UnHeroControl.arrayObsSetY_Down(gf.map.Map.getRope(),gf.hero.hero.getMove().getDownSoeed()*5);
											UnHeroControl.arrayObsSetY_Down(gf.map.Map.getLadder(),gf.hero.hero.getMove().getDownSoeed()*5);
											/**
											 * 传送门下坠
											 */
											/**
											 * 怪物下坠
											 */
											/**
											 * NPC门下坠
											 */
										}




								}

							}
//
						}catch (Exception e){

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
