package util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ui.GameFrame;

public class KeyListener extends KeyAdapter{

	public GameFrame gf ;
	
	public KeyListener(GameFrame gf) {
		this.gf = gf;
		}
	
	//¼üÅÌ¼àÌı
	//¼üÅÌ°´ÏÂ
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//²âÊÔASCLLÂë
		//System.out.print(code);
		switch (code) {
			case 37:
				gf.hero.faceTo = true;
				gf.hero.hero.getAction()[2].setDirection(true);
				break;
			case 39:
				gf.hero.faceTo = false;
				gf.hero.hero.getAction()[3].setDirection(true);
				break;
			case 67:
				if (!gf.hero.hero.getIsGravity()) {
					gf.hero.hero.getAction()[4].setDirection(true);
				}
				break;
		}
	}
	//¼üÅÌÊÍ·Å
	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 37) {

			gf.hero.hero.getAction()[2].setDirection(false);

		} else if (code == 39) {

			gf.hero.hero.getAction()[3].setDirection(false);

		}
	}
}
