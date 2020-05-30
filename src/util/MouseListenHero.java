package util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ui.GameFrame;

public class MouseListenHero implements MouseListener,MouseMotionListener {

	public GameFrame gf;

	public int mousex,mousey;
	public int x,y;

	//构造监听类型
	public MouseListenHero(int a) {
	}


	public MouseListenHero(GameFrame gf) {
		this.gf = gf;
	}

	//获取鼠标位置

	//鼠标按键监听
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//鼠标移动进入区域监听
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//鼠标离开区域监听
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	//鼠标点击
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub


	}

	//鼠标释放
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//鼠标进入
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	//鼠标离开
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
