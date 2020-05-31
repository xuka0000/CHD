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

	@Override
	public void keyTyped(KeyEvent e) {
		//判断是否接触绳子，改变绳子Boolean的状态，如果触碰就为当前的反状态
		int code = e.getKeyCode();
		switch (code) {
			case 38:


				break;
		}
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
				gf.hero.faceTo = true;
				gf.hero.hero.getAction()[2].setDirection(true);
				break;
			//右键
			case 39:
				gf.hero.faceTo = false;
				gf.hero.hero.getAction()[3].setDirection(true);
				break;
			//C键
			case 67:
				if (!gf.hero.hero.getIsGravity()) {
					gf.hero.hero.getAction()[4].setDirection(true);
				}
//				//绳索关系,判断绳子和人接触
//				if (gf.hero.ropeContral) {
//					//是否按了左还是右
//					if (gf.hero.hero.getAction()[3].isDirection() || gf.hero.hero.getAction()[3].isDirection()) {
//						//释放
//						gf.hero.ropeContral = false;
//					}
//				}
				break;
			//上键
			case 38:
				/**
				 * 更换地图
				 */
				for (int i = 0; i < gf.portal.length ; i++) {
					if (gf.portal[i].portal.getIsGravity()) {
						gf.hero.changeMap = true;
						//切换地图切换音乐
						if (!gf.StartSound.isAlive()) {
							gf.StartSound.stopMusic();
						}
					}
				}
//				//判断是否接触绳子，改变绳子Boolean的状态，如果触碰就为当前的反状态
//				gf.hero.ropeUp = true;
//				break;
//			case 40:
//				//如果按下英雄的向下变量为ture
//				gf.hero.ropeDown = true;
//
//				break;
		}
	}

	/**
	 * 当抬起键盘摸一个键时
	 * @param e
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 37) {
			gf.hero.hero.getAction()[2].setDirection(false);

		} else if (code == 39) {
			gf.hero.hero.getAction()[3].setDirection(false);
		}

//		if (code == 38) {
//			System.out.println(gf.hero.hit(gf.hero.DIR_ROPE));
//			if (gf.hero.hit(gf.hero.DIR_ROPE)) {
//
//				gf.hero.ropeContral = !gf.hero.ropeContral;
//				sleepTest(100);
//			}
//			gf.hero.ropeUp = false;
//		}
//		if (code == 40) {
//			gf.hero.ropeDown = false;
//		}
	}
	public static void sleepTest(int sleep) {//时间延迟装置
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
