package npc;

import DataMask.NPCMask;
import ui.GameFrame;

/**
 * @author shkstart
 * @create 2020-05-30-14:40
 */
public class Npc extends Thread{
    private NPCMask npc;
    private GameFrame gf;

    public Npc(GameFrame gf) {
        this.gf = gf;
    }

    @Override
    public void run() {

        super.run();
    }
}
