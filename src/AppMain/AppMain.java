package AppMain;

import ui.GameFrame;
import util.KeyListener;
import util.MouseListen;

/**
 *
 */
public class AppMain {
<<<<<<< HEAD
	public static void main(String[] args) {

		GameFrame gf = new GameFrame();
		// 创建监听器对象
		KeyListener kl = new KeyListener(gf);
		// 给窗体添加键盘监听器
		gf.addKeyListener(kl);
		//创建一个监听鼠标对象
		//创建鼠标监听
		MouseListen m1 = new MouseListen(gf);
		MouseListen m2 = new MouseListen(gf);
		gf.addMouseMotionListener(m1);
		gf.addMouseListener(m2);
	}
=======
public static void main(String[] args) {
    //我是谁
	GameFrame gf = new GameFrame();
	// 创建监听器对象
	KeyListener kl = new KeyListener(gf);
	// 给窗体添加键盘监听器
	gf.addKeyListener(kl);
	//创建一个监听鼠标对象
	//创建鼠标监听
	MouseListen m1 = new MouseListen(gf);
	MouseListen m2 = new MouseListen(gf);
	gf.addMouseMotionListener(m1);
	gf.addMouseListener(m2);
}
>>>>>>> be063d5b093d76a8f081c562eab166234cde1d75
}
