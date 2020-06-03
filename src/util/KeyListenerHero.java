package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ui.GameFrame;

/**
 * 英雄监听器控制
 */
public class KeyListenerHero extends KeyAdapter{

	public GameFrame gf ;

	public KeyListenerHero(GameFrame gf) {
		this.gf = gf;
	}

	/**
	 * 按键触发一次
	 * 仅对字母键位有效
	 * @param e
	 */
	@Override
	public void keyTyped(KeyEvent e){
		int code = e.getKeyCode();

	}
	/**
	 * 键盘点击每一个键时
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		//测试ASCLL码
//		System.out.print(code);
		switch (code) {
			//左键
			case 37:
				/**
				 * 左移动控制
				 */
				gf.hero.faceTo = true;
				gf.hero.hero.getAction()[2].setDirection(true);
				break;
			//右键
			case 39:
				/**
				 * 右移动控制
				 */
				gf.hero.faceTo = false;
				gf.hero.hero.getAction()[3].setDirection(true);
				break;
			//C键
			case 67:
				/**
				 * 跳跃启动后，重力线程关闭的控制 哈哈哈哈哈  看不懂吧！
				 */
				if (!gf.hero.hero.getIsGravity()) {
					gf.hero.hero.getAction()[4].setDirection(true);
				}
				/**
				 * 扒住绳索后脱离绳索的方式
				 * 首先判断玩家是否左键或右键是否保持开启 + 是否可以进行绳索状态的改变（每次判断间隔1S） + 是否是扒住绳子的状态
				 */
				if(gf.hero.hero.getAction()[2].isDirection()||gf.hero.hero.getAction()[3].isDirection()){
					if(gf.hero.isRopeContraling){
						if(gf.hero.ropeContral){
							gf.hero.ropeContral = false;
						}

					}

				}
				break;
			//上键
			case 38:
				/**
				 * 更换地图
				 */

				for (int i = 0; i < gf.portal.length ; i++) {


					if (gf.hero.hit(gf.hero.DIR_PORTAL)) {
						gf.hero.changeMap = true;

						//切换地图切换音乐
						if (!gf.StartSound.isAlive()) {
							gf.StartSound.stopMusic();
						}
					}
				}
				/**
				 * 绳索判断  (绳索状态是否是true + 冒险家是否与绳索接触 )
				 * 判断成功后 按下上键 去改变冒险家与绳索的深入关系 （扒上去就掉不下来了)
				 * 扒住绳子后！ 控制键变成false ！ 让两次控制之间间隔1S 。
				 */
				if(gf.hero.isRopeContraling){
					if(gf.hero.hit(gf.hero.DIR_ROPE)){
						gf.hero.ropeContral = true;
						gf.hero.isRopeContraling = false;
					}
				}
				/**
				 * 我扒住了绳子   +  我想要往上扒 嘿嘿
				 * 我是否是扒住绳子的状态呢？
				 */
               if(gf.hero.ropeContral){
               	gf.hero.ropeUp = true ;
			   }

				break;
			case 40:
				/**
				 * 我扒住了绳子  + 我想往下面钻
				 * 我是否是扒住绳子的状态呢？
				 */
				if(gf.hero.ropeContral){
					gf.hero.ropeDown = true ;
				}
				break;

		}
	}

	/**
	 * 当抬起键盘摸一个键时
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		/**
		 * 左移动释放按键---关闭行为
		 */
		if (code == 37) {
			gf.hero.hero.getAction()[2].setDirection(false);

		}
		/**
		 * 右移动释放按键 -- 贤者模式
		 */
		if (code == 39) {
			gf.hero.hero.getAction()[3].setDirection(false);
		}
		/**
		 * 扒住绳索后向上面扒  --- 释放
		 */
		if( code == 38){
			gf.hero.ropeUp = false ;
		}
		/**
		 * 扒住绳索后向下面扒  --- 释放
		 */
		if( code == 40){
			gf.hero.ropeDown = false ;
		}


	}
	/**************************************************************************************/
	public static void sleepTest(int sleep) {//时间延迟装置
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
