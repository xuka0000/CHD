package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ui.GameFrame;

public class KeyListener extends KeyAdapter{

	public GameFrame gf ;
	
	public KeyListener(GameFrame gf) {
		this.gf = gf;
		}

	/**
	 * 键盘点击每一个键时
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//测试ASCLL码
		//System.out.print(code);
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
		if (code == 37) {

			gf.hero.hero.getAction()[2].setDirection(false);

		} else if (code == 39) {

			gf.hero.hero.getAction()[3].setDirection(false);

		}
	}
}
