package AppMain;

import ui.GameFrame;
import util.KeyListenerHero;
import util.MouseListenHero;




public class AppMain {

	public static void main(String[] args) {

		GameFrame gf = new GameFrame();
		// 创建监听器对象
		KeyListenerHero kl1 = new KeyListenerHero(gf);
		// 给窗体添加键盘监听器
		gf.addKeyListener(kl1);
		//创建一个监听鼠标对象
		//创建鼠标监听
		MouseListenHero m1 = new MouseListenHero(gf);
		MouseListenHero m2 = new MouseListenHero(gf);
		gf.addMouseMotionListener(m1);
		gf.addMouseListener(m2);
	}
}
