package util;

import ui.GameFrame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListenerMonster extends KeyAdapter {
    public GameFrame gf ;

    public KeyListenerMonster(GameFrame gf) {
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
