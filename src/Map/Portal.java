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
	
	//�������ƶ��ĵط�
	public void run() {
		while (true) {
			//ȱY���ж�
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
