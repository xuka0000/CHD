package Map;

import DataMask.PortalMask;
import ui.GameFrame;

public class Portal extends Thread{

	public GameFrame gf ;
	
	public PortalMask portal ;

	public Portal() { }
	public Portal(GameFrame gf ) {
		this.gf = gf ;
	}
	
	//传送门移动的地方
	public void run() {
		while (true) {
			//缺Y的判断
			if (gf.hero.hero.getMove().getX() > portal.getImg()[0].getX() + gf.map.Map.getImg()[0].getX() - 50 &&
					 gf.hero.hero.getMove().getX() < portal.getImg()[0].getX() + gf.map.Map.getImg()[0].getX() +100 &&
					gf.hero.hero.getMove().getY() > portal.getImg()[0].getY()- 50&&
					gf.hero.hero.getMove().getY() < portal.getImg()[0].getY()+ 50

			) {

				portal.setIsGravity(true);
			}else {
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
