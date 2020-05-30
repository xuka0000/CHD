package ui;

import Hero.Hero;
import Map.BG;

import java.awt.*;

/**
 * @author shkstart
 * @create 2020-05-26-1:05
 */
public class ObsView {
    public static void obsView(Graphics big, BG map, Hero hero) {
        /**
         * ²âÊÔ´úÂë
         */
            for (int i = 0; i < map.Map.getObsBottom().length ; i++) {
                big.drawImage(map.Map.getObsBottom()[i].getImg().getPicturePath(),
                        map.Map.getObsBottom()[i].getImg().getX() + map.Map.getImg()[0].getX(), map.Map.getObsBottom()[i].getImg().getY(),
                        map.Map.getObsBottom()[i].getImg().getWidth(), map.Map.getObsBottom()[i].getImg().getHeight(), null);
            }

            big.drawRect(hero.hero.getMove().getX(),hero.hero.getMove().getY(),
                    hero.hero.getAction()[0].getImg()[0].getWidth(),
                    hero.hero.getAction()[0].getImg()[0].getHeight());
            big.drawRect(300+map.Map.getImg()[0].getX(),650,80,10);


    }
}
