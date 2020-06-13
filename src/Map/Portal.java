package Map;

import DataMask.PortalMask;
import ui.GameFrame;

public class Portal extends Thread{
	public GameFrame gf ;
	
	public PortalMask portal ;

	public Portal() {
	}
	public Portal(GameFrame gf ) {
		this.gf = gf ;
	}
	
	//传送门移动的地方
	public void run() {
		while (true) {
			if (gf.hero.hit(gf.hero.DIR_PORTAL)
			) {

				portal.setIsGravity(true);
			} else {
				portal.setIsGravity(false);
			}
			try {
				sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
