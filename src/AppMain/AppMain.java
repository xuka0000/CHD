package AppMain;

import ui.GameFrame;
import util.KeyListener;
import util.MouseListen;


public class AppMain {
public static void main(String[] args) {
    //����˭
	GameFrame gf = new GameFrame();
	// ��������������
	KeyListener kl = new KeyListener(gf);
	// ��������Ӽ��̼�����
	gf.addKeyListener(kl);
	//����һ������������
	//����������
	MouseListen m1 = new MouseListen(gf);
	MouseListen m2 = new MouseListen(gf);
	gf.addMouseMotionListener(m1);
	gf.addMouseListener(m2);
}
}
