package util;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import ui.GameFrame;

public class MouseListenHero implements MouseListener,MouseMotionListener {

public GameFrame gf;
	
	public int mousex,mousey;
	public int x,y;
	
	//�����������
	public MouseListenHero(int a) {
	}
	
	
	public MouseListenHero(GameFrame gf) {
		this.gf = gf;
	}
	
	//��ȡ���λ��
	
	//��갴������
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//����ƶ������������
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//����뿪�������
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	//�����
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		
	}

	//����ͷ�
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//������
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//����뿪
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
