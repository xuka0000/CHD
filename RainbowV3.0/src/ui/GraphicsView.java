package ui;

import DataMask.HeroMask;
import DataMask.Img;

import java.awt.*;

/**
 * »­±Ê·½·¨
 * @author shkstart
 * @create 2020-05-26-0:20
 */
public class GraphicsView {
    /**
     * ¹¦ÄÜ»­Í¼ÊäÈë
     * @param big   »­±Ê
     * @param img   Í¼Æ¬
     */
    public static void drawImg(Graphics big, Img img) {
        big.drawImage(img.getPicturePath(), img.getX(), img.getY(), img.getWidth(), img.getHeight(), null);
    }

    /**
     * »æ»­Ó¢ÐÛµÄ¶¯×÷
     * @param big   »­±Ê
     * @param actions   Í¼Æ¬Êý×é
     * @param heroMask  Ó¢ÐÛÃþ¾ß
     */
    public static void heroActionImg(Graphics big, Img[] actions, HeroMask heroMask) {
        for (int i = 0; i < actions.length; i++) {
            drawHeroImg(big,actions[i],heroMask);
        }
    }

    /**
     *  Ó¢ÐÛ»æÖÆ
     * @param big   »­±Ê
     * @param img   Í¼Æ¬
     * @param heroMask  Ó¢ÐÛÄ¥¾ß
     */
    public static void drawHeroImg(Graphics big, Img img, HeroMask heroMask) {

        big.drawImage(img.getPicturePath(), heroMask.getMove().getX(), heroMask.getMove().getY(), img.getWidth(), img.getHeight(),null);

    }
}
