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
         * 测试
         */
//        big.drawImage(map.Map.getObsBottom()[0].getImg().getPicturePath(), 0, 600, 750, 90, null);
        //打印地下碰撞判断图片
        for (int i = 0; i < map.Map.getObsBottom().length ; i++) {
            big.drawImage(map.Map.getObsBottom()[i].getImg().getPicturePath(),
                    map.Map.getObsBottom()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getObsBottom()[i].getImg().getY(),
                    map.Map.getObsBottom()[i].getImg().getWidth(), map.Map.getObsBottom()[i].getImg().getHeight(), null);
        }
        //打印左碰撞图片
        for (int i = 0; i < map.Map.getObsRight().length ; i++) {
            big.drawImage(map.Map.getObsRight()[i].getImg().getPicturePath(),
                    map.Map.getObsRight()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getObsRight()[i].getImg().getY(),
                    map.Map.getObsRight()[i].getImg().getWidth(), map.Map.getObsRight()[i].getImg().getHeight(), null);
        }
        //打印左碰撞图片
        for (int i = 0; i < map.Map.getObsLeft().length ; i++) {
            big.drawImage(map.Map.getObsLeft()[i].getImg().getPicturePath(),
                    map.Map.getObsLeft()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getObsLeft()[i].getImg().getY(),
                    map.Map.getObsLeft()[i].getImg().getWidth(), map.Map.getObsLeft()[i].getImg().getHeight(), null);
        }
        //打印英雄碰撞框
        big.drawRect(hero.hero.getMove().getX(),hero.hero.getMove().getY(),
                hero.image[0].getWidth(),hero.image[0].getHeight());
        //打印绳子碰撞框
        for (int i = 0; i < map.Map.getRope().length ; i++) {
            big.drawImage(map.Map.getRope()[i].getImg().getPicturePath(),
                    map.Map.getRope()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getRope()[i].getImg().getY(),
                    map.Map.getRope()[i].getImg().getWidth(), map.Map.getRope()[i].getImg().getHeight(), null);
        }


    }
}
