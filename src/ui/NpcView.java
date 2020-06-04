package ui;

import DataMask.Img;

import java.awt.*;

/**崔悦
 * 画NPC
 * */
public class NpcView {
    public static void NpcImg(Graphics graphics,GameFrame gameFrame){
        for (int i=0;i<gameFrame.npcs.length;i++){
            for (int j = 0; j < gameFrame.npcs[i].image.length; j++) {
                graphics.drawImage(gameFrame.npcs[i].image[j].getPicturePath(),gameFrame.npcs[i].npc.getX()+gameFrame.map.Map.getImg()[4].getX(),
                        gameFrame.npcs[i].npc.getY()+(750+gameFrame.map.Map.getImg()[4].getY()),
                        gameFrame.npcs[i].image[j].getWidth(),
                        gameFrame.npcs[i].image[j].getHeight(),null);
            }
        }
    }
}
