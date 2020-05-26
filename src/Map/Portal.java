package Map;

import DataMask.PortalMask;
import ui.GameFrame;

public class Portal extends Thread{

	public GameFrame gf ;
	
	public PortalMask portal ;
	
	public Portal(GameFrame gf ) {
		this.gf = gf ;
	}
	
	//传送门移动的地方
	public void run() {
		
	}
}
