package ui;

import java.awt.*;
import Hero.Hero;
import Map.BG;

/**
 * @author shkstart
 * @create 2020-05-26-0:55
 */
public class RightBgView {
    public static void rightBgView(Graphics big, BG map, Hero hero) {

        big.setFont(new Font("",Font.BOLD,15));

        //打印地图,不打印右上角小人,和绿点
        for (int i = 0; i < map.Map.getSmallMapMask().length - 2; i++) {
            big.drawImage(map.Map.getSmallMapMask()[i].getPicturePath(), map.Map.getSmallMapMask()[i].getX(), map.Map.getSmallMapMask()[i].getY(), map.Map.getSmallMapMask()[i].getWidth(), map.Map.getSmallMapMask()[i].getHeight(), null);
        }
        //小地图坐标
        big.drawString("坐标"+(hero.hero.getMove().getX()-map.Map.getImg()[4].getX())+":"+hero.hero.getMove().getY(),890,70);
        //小人的位置
        big.drawImage(map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 1].getPicturePath(),
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 1].getX() + hero.hero.getMove().getX() / 23 - map.Map.getImg()[4].getX()/23,
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 1].getY() + hero.hero.getMove().getY() / 20,
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 1].getWidth(),
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 1].getHeight(), null);
        //小人对应上吊点

        big.drawImage(map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 2].getPicturePath(),
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 2].getX() + hero.hero.getMove().getX() / 23 - map.Map.getImg()[4].getX()/23,
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 2].getY(),
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 2].getWidth(),
                map.Map.getSmallMapMask()[map.Map.getSmallMapMask().length - 2].getHeight(), null);

    }
}
