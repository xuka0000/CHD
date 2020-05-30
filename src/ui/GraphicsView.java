package ui;

import DataMask.HeroMask;
import DataMask.Img;

import java.awt.*;

/**
 * 画笔方法
 * @author shkstart
 * @create 2020-05-26-0:20
 */
public class GraphicsView {
    /**
     * 功能画图输入
     * @param big   画笔
     * @param img   图片
     */
    public static void drawImg(Graphics big, Img img) {
        big.drawImage(img.getPicturePath(), img.getX(), img.getY(), img.getWidth(), img.getHeight(), null);
    }

    /**
     * 绘画英雄的动作
     * @param big   画笔
     * @param actions   图片数组
     * @param heroMask  英雄摸具
     */
    public static void heroActionImg(Graphics big, Img[] actions, HeroMask heroMask) {
        for (int i = 0; i < actions.length; i++) {
            drawHeroImg(big,actions[i],heroMask);
        }
    }

    /**
     *  英雄绘制
     * @param big   画笔
     * @param img   图片
     * @param heroMask  英雄磨具
     */
    public static void drawHeroImg(Graphics big, Img img, HeroMask heroMask) {

        big.drawImage(img.getPicturePath(), heroMask.getMove().getX(), heroMask.getMove().getY(), img.getWidth(), img.getHeight(),null);

    }
}
