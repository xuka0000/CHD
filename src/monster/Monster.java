package monster;

import DataMask.MonsterMask;
import ui.GameFrame;

/**
 * 王家平
 * @author shkstart
 * @create 2020-05-30-14:37
 */
public class Monster extends Thread {
    public MonsterMask monster;
    public GameFrame gf;


    public Monster(){}

    public Monster(GameFrame gf) {
        this.gf = gf;
    }


    @Override
    public void run() {
        super.run();
    }
}
