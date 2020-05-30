package AppMain;

import ui.GameFrame;
import util.KeyListenerHero;
import util.MouseListenHero;




public class AppMain {

public static void main(String[] args) {

	GameFrame gf = new GameFrame();

	// ��������������


	KeyListenerHero kl = new KeyListenerHero(gf);
    // ��������Ӽ��̼�����
	gf.addKeyListener(kl);

	MouseListenHero m1 = new MouseListenHero(gf);
	MouseListenHero m2 = new MouseListenHero(gf);
    //����һ������������
	//����������
	gf.addMouseMotionListener(m1);
	gf.addMouseListener(m2);
}
}
