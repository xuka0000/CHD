package npc;

import DataMask.Img;
import DataMask.NPCMask;
import ui.GameFrame;

/**崔悦
 * @author shkstart
 * @create 2020-05-30-14:40
 * 调用地图的X,Y gf.map.Map.getImg()[4]
 */
public class Npc extends Thread{
    public NPCMask npc;
    public GameFrame gf;
    public Img[] image = {
            new Img("", "", 0, 0, 0, 0)
    };
    public Npc(GameFrame gf) {
        this.gf = gf;
    }

    public Npc() {}

    @Override
    public void run() {
        while (true){
            if(gf.hero.hero.getMove().getX()< npc.getX()+gf.map.Map.getImg()[4].getX()){
                this.image = npc.getAction()[0].getImg();
            }else {
                this.image = npc.getAction()[1].getImg();
            }
            System.out.println(gf.hero.hero.getMove().getX());
            System.out.println(npc.getX()+gf.map.Map.getImg()[4].getX());
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
