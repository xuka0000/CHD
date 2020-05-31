package util;

import ui.GameFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListenerPortal  extends KeyAdapter {
    public GameFrame gf ;

    public KeyListenerPortal(GameFrame gf) {
        this.gf = gf;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {

    }
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
