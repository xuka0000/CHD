package ui;

import DataMask.HeroMask;
import DataMask.Img;

import java.awt.*;

/**
 * ���ʷ���
 * @author shkstart
 * @create 2020-05-26-0:20
 */
public class GraphicsView {
    /**
     * ���ܻ�ͼ����
     * @param big   ����
     * @param img   ͼƬ
     */
    public static void drawImg(Graphics big, Img img) {
        big.drawImage(img.getPicturePath(), img.getX(), img.getY(), img.getWidth(), img.getHeight(), null);
    }

    /**
     * �滭Ӣ�۵Ķ���
     * @param big   ����
     * @param actions   ͼƬ����
     * @param heroMask  Ӣ������
     */
    public static void heroActionImg(Graphics big, Img[] actions, HeroMask heroMask) {
        for (int i = 0; i < actions.length; i++) {
            drawHeroImg(big,actions[i],heroMask);
        }
    }

    /**
     *  Ӣ�ۻ���
     * @param big   ����
     * @param img   ͼƬ
     * @param heroMask  Ӣ��ĥ��
     */
    public static void drawHeroImg(Graphics big, Img img, HeroMask heroMask) {

        big.drawImage(img.getPicturePath(), heroMask.getMove().getX(), heroMask.getMove().getY(), img.getWidth(), img.getHeight(),null);

    }
}
