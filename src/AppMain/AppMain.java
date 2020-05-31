package AppMain;

import ui.GameFrame;
import util.KeyListenerHero;
import util.MouseListenHero;




public class AppMain {

	public static void main(String[] args) {

		GameFrame gf = new GameFrame();
		// 创建监听器对象

		/***英雄监听器**/
		KeyListenerHero klHero = new KeyListenerHero(gf);
		// 给窗体添加键盘监听器
		gf.addKeyListener(klHero);
		//创建一个监听鼠标对象
		//创建鼠标监听
		MouseListenHero m1Hero = new MouseListenHero(gf);
		MouseListenHero m2Hero = new MouseListenHero(gf);
		gf.addMouseMotionListener(m1Hero);
		gf.addMouseListener(m2Hero);

		/***NPC监听器**/
		KeyListenerHero klNpc = new KeyListenerHero(gf);
		// 给窗体添加键盘监听器
		gf.addKeyListener(klHero);
		//创建一个监听鼠标对象
		//创建鼠标监听
		MouseListenHero m1Npc = new MouseListenHero(gf);
		MouseListenHero m2Npc = new MouseListenHero(gf);
		gf.addMouseMotionListener(m1Npc);
		gf.addMouseListener(m2Npc);

		/***怪物监听器**/
		KeyListenerHero klMonster = new KeyListenerHero(gf);
		// 给窗体添加键盘监听器
		gf.addKeyListener(klHero);
		//创建一个监听鼠标对象
		//创建鼠标监听
		MouseListenHero m1Monster = new MouseListenHero(gf);
		MouseListenHero m2Monster = new MouseListenHero(gf);
		gf.addMouseMotionListener(m1Monster);
		gf.addMouseListener(m2Monster);

		/***传送门监听器**/
		KeyListenerHero klPortal = new KeyListenerHero(gf);
		// 给窗体添加键盘监听器
		gf.addKeyListener(klHero);
		//创建一个监听鼠标对象
		//创建鼠标监听
		MouseListenHero m1Portal = new MouseListenHero(gf);
		MouseListenHero m2Portal = new MouseListenHero(gf);
		gf.addMouseMotionListener(m1Portal);
		gf.addMouseListener(m2Portal);
	}
}
