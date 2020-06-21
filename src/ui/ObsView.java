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
                    map.Map.getObsBottom()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getObsBottom()[i].getImg().getY()+(750+map.Map.getImg()[4].getY()),
                    map.Map.getObsBottom()[i].getImg().getWidth(), map.Map.getObsBottom()[i].getImg().getHeight(), null);
        }
        //打印左碰撞图片
        for (int i = 0; i < map.Map.getObsRight().length ; i++) {
            big.drawImage(map.Map.getObsRight()[i].getImg().getPicturePath(),
                    map.Map.getObsRight()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getObsRight()[i].getImg().getY()+(750+map.Map.getImg()[4].getY()),
                    map.Map.getObsRight()[i].getImg().getWidth(), map.Map.getObsRight()[i].getImg().getHeight(), null);
        }
        //打印左碰撞图片
        for (int i = 0; i < map.Map.getObsLeft().length ; i++) {
            big.drawImage(map.Map.getObsLeft()[i].getImg().getPicturePath(),
                    map.Map.getObsLeft()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getObsLeft()[i].getImg().getY()+(750+map.Map.getImg()[4].getY()),
                    map.Map.getObsLeft()[i].getImg().getWidth(), map.Map.getObsLeft()[i].getImg().getHeight(), null);
        }
       // System.out.println(map.Map.getNPC().length);
        //打印英雄碰撞框
            big.drawRect(hero.hero.getMove().getX(),hero.hero.getMove().getY()+hero.image[0].getHeight()-20,hero.image[0].getWidth(),20);


            big.drawRect(hero.hero.getMove().getX(), hero.hero.getMove().getY(), hero.image[0].getWidth(), 20);

            big.drawRect(hero.hero.getMove().getX()+hero.image[0].getWidth(), hero.hero.getMove().getY(), 20, hero.image[0].getHeight());

            big.drawRect(hero.hero.getMove().getX(), hero.hero.getMove().getY(), 20, hero.image[0].getHeight());

            big.drawRect(hero.hero.getMove().getX()+hero.image[0].getWidth()/2-15, hero.hero.getMove().getY(), 30, hero.image[0].getHeight());

            big.drawRect(hero.hero.getMove().getX()+hero.image[0].getWidth()/2-15, hero.hero.getMove().getY(), 30, hero.image[0].getHeight());

        //打印绳子碰撞框
        for (int i = 0; i < map.Map.getRope().length ; i++) {
            big.drawImage(map.Map.getRope()[i].getImg().getPicturePath(),
                    map.Map.getRope()[i].getImg().getX() + map.Map.getImg()[4].getX(), map.Map.getRope()[i].getImg().getY()+(750+map.Map.getImg()[4].getY()),
                    map.Map.getRope()[i].getImg().getWidth(), map.Map.getRope()[i].getImg().getHeight(), null);
        }
        //斜坡画画
        for(int i =0 ;i < map.Map.getLeftHill().length ; i++){
            big.drawLine(map.Map.getLeftHill()[i].getX1()+map.Map.getImg()[4].getX(),
                    map.Map.getLeftHill()[i].getY1()+(750+map.Map.getImg()[4].getY()),
                    map.Map.getLeftHill()[i].getX2()+map.Map.getImg()[4].getX(),
                    map.Map.getLeftHill()[i].getY2()+(750+map.Map.getImg()[4].getY()));
        }

        for(int i =0 ;i < map.Map.getRightHill().length ; i++){
            big.drawLine(map.Map.getRightHill()[i].getX1()+map.Map.getImg()[4].getX(),
                    map.Map.getRightHill()[i].getY1()+(750+map.Map.getImg()[4].getY()),
                    map.Map.getRightHill()[i].getX2()+map.Map.getImg()[4].getX(),
                    map.Map.getRightHill()[i].getY2()+(750+map.Map.getImg()[4].getY()));
        }
        //传送门碰撞
        for (int i = 0; i < map.Map.getPortal().length; i++) {
            big.drawRect(map.Map.getPortal()[i].getImg()[0].getX() + map.Map.getImg()[4].getX(),
                    map.Map.getPortal()[i].getImg()[0].getY() + map.Map.getPortal()[i].getImg()[0].getHeight() - 20 + (750 + map.Map.getImg()[4].getY()),
                    map.Map.getPortal()[i].getImg()[0].getHeight(), 50);
        }

    }
}
