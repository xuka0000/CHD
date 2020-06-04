package Hero;

import javax.sound.sampled.Line;
import javax.swing.*;
import javax.xml.crypto.Data;

import DataMask.*;
import Map.BG;
import gameProgress.Loading;
import ui.GameFrame;
import SQL.HeroSQL;

import java.awt.*;
import java.util.ArrayList;

/**
 * 英雄线程
 * 冒险家移动：绳索上下、左右移动、重力、跳跃
 * 地图移动：X：左右移动
 *         Y：重力、跳跃、绳索
 * 地图中元素：X：依据地图判断，自己参数不改变
 *          Y:重力、跳跃、绳索
 * 注意碰撞检测.
 * @author OUT
 */
public class Hero extends Thread implements HeroControl{

	public HeroMask hero;
	public GameFrame gf;
	public Img[] image = {
			new Img("", "", 0, 0, 0, 0)
	};
	//斜坡判断 高度
	public int count = 0;
	public int high = 50;
	public int width = 50;
	public int HillHigh = 0;
	public String dir_Left = "left";
	public String dir_Right = "right";
	public String dir_Down = "down";
	public  String DIR_ROPE = "rope";
	public String dir_Ladder = "Ladder";
	public String dir_leftHill = "leftHill";
	public  String DIR_rightHill = "rightHill";
	public String DIR_PORTAL = "portal";

	public PortalMask portal;
	//改变地图的判断  ture需要改变
	public boolean changeMap = false;
	//绳索控制判断  英雄的爬绳子向上移动判断  英雄的爬绳子向下移动判断  判断绳索是否需要被监听
	public boolean ropeContral = false , ropeUp = false ,ropeDown = false , isRopeContraling = true;
	//判断英雄朝向 ，true-左 false -右
	public boolean faceTo = false;
	//是否在扒绳索的时候跳跃
	public boolean ropeToJump = false;
	//切换地图感受器
	public boolean isChangeMap = false;

	//是否重置英雄的位置
	public boolean isChangeHero = false;

	public Hero(GameFrame gf) {


		hero = SQL.HeroSQL.soldier[0];
		this.gf = gf;
//		this.hero.getIsGravity();
//		hero.getAbilityValue().getCurrHp();
		this.Gravity();

	}

	/**
	 * 移动方法(线程)
	 */
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

			//重置坐标
			try {
				resetHero();
			} catch (Exception e) {
				e.printStackTrace();
			}

			//判断绳索是否可以进行判断（我预判你的预判 哈哈哈哈 ）
			ropeHero.isRopeContraling(gf);
            //System.out.println(ropeContral);
			//休眠
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


	public void resetHero() {
		if (isChangeHero) {


			hero.getMove().setX(20);
			hero.getMove().setY(20);

//			hero.getMove().setY(205);
//			hero.getMove().setX(205);

			for (int i = 0; i < gf.map.Map.getImg().length; i++) {
				gf.map.Map.getImg()[i].setX(0);
				gf.map.Map.getImg()[i].setY(0);
			}

			isChangeHero = false;

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

			  Img[] rope = {
					new Img("上", "Image\\技能1下右.gif", 108, 156, 50, 50),
			};
			this.image = rope;
			/**
			 * Hero:570 ~ 400
			 * Map:-750 ~ -650
			 */
			if (hero.getMove().getY() >= 400 && gf.map.Map.getImg()[4].getY()<=-650) {
				hero.getMove().setY(hero.getMove().getY()-hero.getMove().getUpSpeed()*2);
			}
			/**
			 * Hero:2000 ~ 120
			 * Map:-1000 ~ -100
			 */
			if ((hero.getMove().getY() < 2000 && hero.getMove().getY() >= 120) &&
					(gf.map.Map.getImg()[4].getY()>=-1000 && gf.map.Map.getImg()[4].getY()<=-100)) {
				UnHeroControl.arraySetY_Up(gf.map.Map.getImg(),gf.hero.hero.getMove().getUpSpeed()*2);
//				//地面碰撞改变
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getUpSpeed()*2);
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getRope(),gf.hero.hero.getMove().getUpSpeed()*2);
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getUpSpeed()*2);
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getUpSpeed()*2);
//				UnHeroControl.arrayHillSetY_Up(gf.map.Map.getLeftHill(),gf.hero.hero.getMove().getUpSpeed()*2);
//				UnHeroControl.arrayHillSetY_Up(gf.map.Map.getRightHill(),gf.hero.hero.getMove().getUpSpeed()*2);
//				//传送门改变
//				UnHeroControl.arrayPortalSetY_Up(gf.map.Map.getPortal(),gf.hero.hero.getMove().getUpSpeed()*2);
//				//怪物坐标改变
//                UnHeroControl.arrayMonsterSetY_Up(gf.monsters,gf.hero.hero.getMove().getUpSpeed()*2);
//                //NPC坐标改变
//                UnHeroControl.arrayNpcSetY_Up(gf.npcs,gf.hero.hero.getMove().getUpSpeed()*2);
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
//			System.out.println(gf.hero.hero.getMove().getY()+"英雄");
//			System.out.println(gf.map.Map.getImg()[4].getY()+"地图");
//			System.out.println(gf.hero.hit(gf.hero.DIR_ROPE));
			if(gf.hero.hit(gf.hero.dir_Down)){
				gf.hero.hero.getMove().setDownSoeed(0);
			}
			Img[] rope = {
					new Img("上", "Image\\技能1下右.gif", 108, 156, 50, 50),
			};
			this.image = rope;
			/**
			 * Hero:570 ~ 400
			 * Map:-100 ~ 0
			 */
			if (hero.getMove().getY() >= 400 &&
					(gf.map.Map.getImg()[4].getY()>-100 && gf.map.Map.getImg()[4].getY() <0)) {
				hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed()*3);
			}
			/**
			 * Hero: 2000 ~ 160
			 * Map:-1000 ~ -100
			 */
			if (hero.getMove().getY() <= 2000 && hero.getMove().getY() > 160&&
					(gf.map.Map.getImg()[4].getY()>-1000&& gf.map.Map.getImg()[4].getY()<=-100)) {
				UnHeroControl.arraySetY_Down(gf.map.Map.getImg(),gf.hero.hero.getMove().getDownSoeed()*3);

//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getDownSoeed()*3);
//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getRope(),gf.hero.hero.getMove().getDownSoeed()*3);
//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getDownSoeed()*3);
//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getDownSoeed()*3);
//				UnHeroControl.arrayHillSetY_Down(gf.map.Map.getLeftHill(),gf.hero.hero.getMove().getDownSoeed()*3);
//				UnHeroControl.arrayHillSetY_Down(gf.map.Map.getRightHill(),gf.hero.hero.getMove().getDownSoeed()*3);
//				//传送门
//				UnHeroControl.arrayPortalSetY_Down(gf.map.Map.getPortal(),gf.hero.hero.getMove().getDownSoeed()*3);
//				//怪物坐标改变
//                UnHeroControl.arrayMonsterSetY_Down(gf.monsters,gf.hero.hero.getMove().getDownSoeed()*3);
//				//npc坐标改变
//                UnHeroControl.arrayNpcSetY_Down(gf.npcs,gf.hero.hero.getMove().getDownSoeed()*3);
			}
			/**
			 * Hero:285 ~ 0
			 * Map:-750 ~ -600
			 */
			if (hero.getMove().getY() > 285 && gf.map.Map.getImg()[4].getY()<=-650) {
				hero.getMove().setY(hero.getMove().getY()+hero.getMove().getDownSoeed()*3);
			}
			gf.hero.hero.getMove().setDownSoeed(1);
		}
		/**
		 * 爬出绳索
		 */
		if(!gf.hero.hit(gf.hero.DIR_ROPE)){
			gf.hero.ropeContral = false;
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

			for (int i = 0; i < gf.portals.length; i++) {
				portal = gf.portals[i].portal;

				if (hit(DIR_PORTAL)) {
					hero.setMapId(portal.getChangeMapId());
					Loading.loadingMap(gf);
					gf.map.startMap = gf.map;
					//感受器感知切换地图
					isChangeMap = true;
                    //改变地图后根据传送门改变hero的初始坐标
					hero.getMove().setX(portal.getChangeHeroX());
					hero.getMove().setY(portal.getChangeHeroY());
					//使用传送门后加载地图的坐标
					UnHeroControl.arraySetY_Up(gf.map.Map.getImg(), portal.getAddMapY());
					UnHeroControl.arraySetX_Up(gf.map.Map.getImg(), portal.getAddMapX());


//                    //使用传送门后加载下方障碍物的坐标
//					UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsBottom(), portal.getAddMapY());
//					UnHeroControl.arrayObsSetX_Up(gf.map.Map.getObsBottom(), portal.getAddMapX());
//                    //使用传送门后加载左方障碍物的坐标
//					UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsLeft(), portal.getAddMapY());
//					UnHeroControl.arrayObsSetX_Up(gf.map.Map.getObsLeft(), portal.getAddMapX());
//                    //使用传送门后加载右方障碍物的坐标
//					UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsRight(), portal.getAddMapY());
//					UnHeroControl.arrayObsSetX_Up(gf.map.Map.getObsRight(), portal.getAddMapX());
//                    //使用传送门后加载绳子障碍物的坐标
//					UnHeroControl.arrayObsSetY_Up(gf.map.Map.getRope(), portal.getAddMapY());
//					UnHeroControl.arrayObsSetX_Up(gf.map.Map.getRope(), portal.getAddMapX());
//                    //使用传送门后加载梯子障碍物的坐标
//					UnHeroControl.arrayObsSetY_Up(gf.map.Map.getLadder(), portal.getAddMapY());
//					UnHeroControl.arrayObsSetX_Up(gf.map.Map.getLadder(), portal.getAddMapX());
//                    //使用传送门后加载左倾斜坡障碍物的坐标
//					UnHeroControl.arrayHillSetY_Up(gf.map.Map.getLeftHill(), portal.getAddMapY());
//					UnHeroControl.arrayHillSetX_Up(gf.map.Map.getLeftHill(), portal.getAddMapX());
//                    //使用传送门后加载右倾斜坡障碍物的坐标
//					UnHeroControl.arrayHillSetY_Up(gf.map.Map.getRightHill(),portal.getAddMapY());
//					UnHeroControl.arrayHillSetX_Up(gf.map.Map.getRightHill(),portal.getAddMapX());
//                    //使用传送门后加载传送门碍物的坐标
//					UnHeroControl.arrayPortalSetY_Up(gf.map.Map.getPortal(),portal.getAddMapY());
//					UnHeroControl.arrayPortalSetX_Up(gf.map.Map.getPortal(),portal.getAddMapX());
//
//                    //使用传送门后加载怪物的坐标
//                    UnHeroControl.arrayMonsterSetY_Up(gf.monsters,portal.getAddMapY());
//
//                    //使用传送门后加载NPC的坐标
//                    UnHeroControl.arrayNpcSetY_Up(gf.npcs,portal.getAddMapY());

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
//			System.out.println("1");
			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		}
		if (hero.getMove().getX() >510 && hero.getMove().getX()<520) {
//			System.out.println("2");
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
//			System.out.println("3");
			hero.getMove().setX(hero.getMove().getX() + hero.getMove().getRightSpeed());
		}

		if(hit(dir_Down)){
			gf.hero.hero.getMove().setDownSoeed(0);
		}

        if(hit(dir_leftHill)){
			System.out.println("1111");
			System.out.println(hero.getMove().getUpSpeed()*2);
			System.out.println("11HillHigh"+HillHigh);
			hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed() * 2);
			System.out.println("**************************");
			HillHigh++;
			HillHigh++;
			HillHigh++;

		}


		if(hit(DIR_rightHill)){
			System.out.println("2222");

        	hero.getMove().setY(hero.getMove().getY()-hero.getMove().getUpSpeed()*2);
			HillHigh--;
			HillHigh--;
			HillHigh--;

		}
		gf.hero.hero.getMove().setDownSoeed(1);

	}

	/**
	 * 向左跑的判断
	 */
	@Override
	public void heroLeftRun() {

		if (hero.getMove().getX() > 0 && hero.getMove().getX() <= 515 && gf.map.Map.getImg()[0].getX() == 0) {
//			System.out.println("1");
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		}
		if (hero.getMove().getX() >510 && hero.getMove().getX()<520) {
//			System.out.println("2");
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
//			System.out.println("3");
			hero.getMove().setX(hero.getMove().getX() - hero.getMove().getLeftSpeed());
		}
        if(hit(dir_Down)){
        	gf.hero.hero.getMove().setDownSoeed(0);
		}
		if(hit(dir_leftHill)){
			System.out.println("333");
			System.out.println(hero.getMove().getUpSpeed()*2);
			System.out.println("33HillHigh"+HillHigh);
			System.out.println("**************************");
			hero.getMove().setY(hero.getMove().getY() - hero.getMove().getUpSpeed() * 2);
			HillHigh--;
			HillHigh--;
			HillHigh--;

		}

		if(hit(DIR_rightHill)){
			System.out.println(4444);
			hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed() * 2);
			HillHigh++;
			HillHigh++;
			HillHigh++;

		}
		gf.hero.hero.getMove().setDownSoeed(1);
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

			if ( gf.hero.ropeContral) {
				hero.getMove().setUpSpeed(0);
			}

			//true往上跳
			hero.getAction()[6].setDirection(true);
			if(gf.hero.ropeToJump){
				UnHeroControl.arraySetY_Up(gf.map.Map.getImg(),gf.hero.hero.getMove().getUpSpeed());
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getUpSpeed());
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getUpSpeed());
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getUpSpeed());
//				UnHeroControl.arrayObsSetY_Up(gf.map.Map.getRope(),gf.hero.hero.getMove().getUpSpeed());
//				UnHeroControl.arrayHillSetY_Up(gf.map.Map.getLeftHill(),gf.hero.hero.getMove().getUpSpeed());
//				UnHeroControl.arrayHillSetY_Up(gf.map.Map.getRightHill(),gf.hero.hero.getMove().getUpSpeed());
//				//传送门
//				UnHeroControl.arrayPortalSetY_Up(gf.map.Map.getPortal(),gf.hero.hero.getMove().getUpSpeed());
//				//npc
//                UnHeroControl.arrayNpcSetY_Up(gf.npcs,gf.hero.hero.getMove().getUpSpeed());
//                //怪物
//                UnHeroControl.arrayMonsterSetY_Up(gf.monsters,gf.hero.hero.getMove().getUpSpeed());
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


			if (hit(dir_Down) || gf.hero.ropeContral) {
				hero.getMove().setDownSoeed(0);
			}

			hero.getAction()[6].setDirection(false);
			if(gf.hero.ropeToJump  &&  gf.map.Map.getImg()[4].getY()>-745){

				UnHeroControl.arraySetY_Down(gf.map.Map.getImg(),gf.hero.hero.getMove().getDownSoeed());
//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getDownSoeed());
//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getDownSoeed());
//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getDownSoeed());
//				UnHeroControl.arrayObsSetY_Down(gf.map.Map.getRope(),gf.hero.hero.getMove().getDownSoeed());
//				UnHeroControl.arrayHillSetY_Down(gf.map.Map.getLeftHill(),gf.hero.hero.getMove().getDownSoeed());
//				UnHeroControl.arrayHillSetY_Down(gf.map.Map.getRightHill(),gf.hero.hero.getMove().getDownSoeed());
//				//传送门
//				UnHeroControl.arrayPortalSetY_Down(gf.map.Map.getPortal(),gf.hero.hero.getMove().getDownSoeed());
//				//npc
//                UnHeroControl.arrayNpcSetY_Up(gf.npcs,gf.hero.hero.getMove().getDownSoeed());
//                //怪物
//                UnHeroControl.arrayMonsterSetY_Up(gf.monsters,gf.hero.hero.getMove().getDownSoeed());
			}else{
				hero.getMove().setY(hero.getMove().getY() + hero.getMove().getDownSoeed());
				if (i % 5 == 0 && i > 30) {
					gf.map.Map.getImg()[2].setY(gf.map.Map.getImg()[2].getY() + 2 * i * i / 8000);
					gf.map.Map.getImg()[1].setY(gf.map.Map.getImg()[1].getY() + 1 * i * i / 8000);
				}
			}


			try {
				sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//恢复出厂设置
		hero.getMove().setDownSoeed(1);
		hero.getMove().setUpSpeed(1);
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
		ArrayList<hill> leftHill = new ArrayList<>();
		ArrayList<hill> rightHill = new ArrayList<>();
		//传送门
		ArrayList<Rectangle> obsPortal = new ArrayList<>();


		try {
			for (int i = 0; i < gf.map.Map.getObsLeft().length; i++) {
				obsLeft.add(new Rectangle(gf.map.Map.getObsLeft()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getObsLeft()[i].getImg().getY()+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getObsLeft()[i].getImg().getWidth(), gf.map.Map.getObsLeft()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getObsRight().length; i++) {
				obsRight.add(new Rectangle(gf.map.Map.getObsRight()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getObsRight()[i].getImg().getY()+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getObsRight()[i].getImg().getWidth(), gf.map.Map.getObsRight()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getObsBottom().length; i++) {
				obsBottom.add(new Rectangle(gf.map.Map.getObsBottom()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getObsBottom()[i].getImg().getY()+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getObsBottom()[i].getImg().getWidth(), gf.map.Map.getObsBottom()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getLadder().length; i++) {
				ladder.add(new Rectangle(gf.map.Map.getLadder()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getLadder()[i].getImg().getY()+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getLadder()[i].getImg().getWidth(), gf.map.Map.getLadder()[i].getImg().getHeight()));
			}

			for (int i = 0; i < gf.map.Map.getRope().length; i++) {
				rope.add(new Rectangle(gf.map.Map.getRope()[i].getImg().getX()+gf.map.Map.getImg()[4].getX(), gf.map.Map.getRope()[i].getImg().getY()+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getRope()[i].getImg().getWidth(), gf.map.Map.getRope()[i].getImg().getHeight()));
			}
			for (int i = 0; i < gf.map.Map.getLeftHill().length; i++) {
				leftHill.add(new hill(gf.map.Map.getLeftHill()[i].getX1()+gf.map.Map.getImg()[4].getX(),
						gf.map.Map.getLeftHill()[i].getY1()+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getLeftHill()[i].getX2()+gf.map.Map.getImg()[4].getX(),
						gf.map.Map.getLeftHill()[i].getY2()+(750+gf.map.Map.getImg()[4].getY())));
			}

			for (int i = 0; i < gf.map.Map.getRightHill().length; i++) {
				rightHill.add(new hill(gf.map.Map.getRightHill()[i].getX1()+gf.map.Map.getImg()[4].getX(),
						gf.map.Map.getRightHill()[i].getY1()+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getRightHill()[i].getX2()+gf.map.Map.getImg()[4].getX(),
						gf.map.Map.getRightHill()[i].getY2()+(750+gf.map.Map.getImg()[4].getY())));
			}

			for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
				obsPortal.add(new Rectangle(gf.map.Map.getPortal()[i].getImg()[0].getX() + gf.map.Map.getImg()[4].getX(),
						gf.map.Map.getPortal()[i].getImg()[0].getY() + gf.map.Map.getPortal()[i].getImg()[0].getHeight() - 20+(750+gf.map.Map.getImg()[4].getY()),
						gf.map.Map.getPortal()[i].getImg()[0].getWidth(),
						20));
			}


		} catch (NullPointerException e) {
			System.err.println("");
		}
		if (dir.equals(DIR_PORTAL)) {
			for (int i = 0; i < obsHeroDown.size(); i++) {
				for (int j = 0; j < obsPortal.size(); j++) {
					if (obsHeroDown.get(i).intersects(obsPortal.get(j))) {
						return true;
					}
				}
			}
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
		if (dir.equals(dir_Right)) {
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
		if (dir.equals(dir_Ladder)) {
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
		//左斜坡碰撞判断
		if (dir.equals(dir_leftHill)) {
			for (int i = 0; i < obsHeroDown.size(); i++) {
				for (int j = 0; j < leftHill.size(); j++) {
					if(LineToRect.isLineIntersectRectangle(leftHill.get(j).getX1(),leftHill.get(j).getY1(),
							leftHill.get(j).getX2(),leftHill.get(j).getY2(),obsHeroDown.get(i).x,obsHeroDown.get(i).y,
							obsHeroDown.get(i).x+obsHeroDown.get(i).width,
							obsHeroDown.get(i).y+obsHeroDown.get(i).height)){
						return true;
					}
				}
			}
		}


		//右斜坡碰撞判断

		if (dir.equals(DIR_rightHill)) {

			for (int i = 0; i < obsHeroDown.size(); i++) {

				for (int j = 0; j < rightHill.size(); j++) {

					if(LineToRect.isLineIntersectRectangle(rightHill.get(j).getX1(),rightHill.get(j).getY1(),
							rightHill.get(j).getX2(),rightHill.get(j).getY2(),obsHeroDown.get(i).x,obsHeroDown.get(i).y,
							obsHeroDown.get(i).x+obsHeroDown.get(i).width,
							obsHeroDown.get(i).y+obsHeroDown.get(i).height)){

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




						if (hit(dir_Down)) {
							//System.out.println("3");
							hero.setIsGravity(false);
							break;
						}

						if(hit(DIR_rightHill)){
							//System.out.println("5");
							hero.setIsGravity(false);
							break;
						}
						try{
							if (hero.getMove().getY() >= 570  && gf.map.Map.getImg()[4].getY()<=-750) {
								//System.out.println("4");
								hero.setIsGravity(false);
							} else {

								if (!hero.getAction()[4].isDirection()) {
									if(hero.getMove().getY()< (570  ) ){
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


//                                        UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsBottom(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsLeft(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        UnHeroControl.arrayObsSetY_Down(gf.map.Map.getObsRight(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        UnHeroControl.arrayObsSetY_Down(gf.map.Map.getRope(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        UnHeroControl.arrayObsSetY_Down(gf.map.Map.getLadder(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        UnHeroControl.arrayHillSetY_Down(gf.map.Map.getLeftHill(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        UnHeroControl.arrayHillSetY_Down(gf.map.Map.getRightHill(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        /**
//                                         * 传送门下坠
//                                         */
//                                        UnHeroControl.arrayPortalSetY_Down(gf.map.Map.getPortal(),gf.hero.hero.getMove().getDownSoeed()*5);
//                                        /**
//                                         * 怪物下坠
//                                         */
//                                        UnHeroControl.arrayMonsterSetY_Down(gf.monsters,gf.hero.hero.getMove().getDownSoeed()*5);
//                                        /**
//                                         * NPC们下坠
//                                         */
//                                        UnHeroControl.arrayNpcSetY_Down(gf.npcs,gf.hero.hero.getMove().getDownSoeed()*5);
                                    }
								}
							}
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
