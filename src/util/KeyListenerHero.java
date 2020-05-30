package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ui.GameFrame;

/**
 * Ó¢ĞÛ¼àÌıÆ÷¿ØÖÆ
 */
public class KeyListenerHero extends KeyAdapter{

	public GameFrame gf ;
	
	public KeyListenerHero(GameFrame gf) {
		this.gf = gf;
		}

	/**
	 * ¼üÅÌµã»÷Ã¿Ò»¸ö¼üÊ±
	 * @param e
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//²âÊÔASCLLÂë
		//System.out.print(code);
		switch (code) {
			//×ó¼ü
			case 37:
				gf.hero.faceTo = true;
				gf.hero.hero.getAction()[2].setDirection(true);
				break;
			//ÓÒ¼ü
			case 39:
				gf.hero.faceTo = false;
				gf.hero.hero.getAction()[3].setDirection(true);
				break;
			//C¼ü
			case 67:
				if (!gf.hero.hero.getIsGravity()) {
					gf.hero.hero.getAction()[4].setDirection(true);
				}
				break;
			//ÉÏ¼ü
			case 38:
				/**
				 * ¸ü»»µØÍ¼
				 */
				for (int i = 0; i < gf.portal.length ; i++) {
					if (gf.portal[i].portal.getIsGravity()) {
						gf.hero.changeMap = true;
						//ÇĞ»»µØÍ¼ÇĞ»»ÒôÀÖ
						if (!gf.StartSound.isAlive()) {
							gf.StartSound.stopMusic();
						}
					}
				}
				break;
		}
	}

	/**
	 * µ±Ì§Æğ¼üÅÌÃşÒ»¸ö¼üÊ±
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
