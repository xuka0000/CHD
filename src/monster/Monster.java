package monster;

import DataMask.MonsterMask;
import ui.GameFrame;

/**
 * @author shkstart
 * @create 2020-05-30-14:37
 */
public class Monster extends Thread {
    private MonsterMask monster;
    private GameFrame gf;

    public Monster(GameFrame gf) {
        this.gf = gf;
    }


    @Override
    public void run() {

        super.run();
    }
}
