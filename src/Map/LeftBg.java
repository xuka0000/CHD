package Map;

import DataMask.Img;

import javax.swing.*;
import java.awt.*;

/**
 * ���Ͻǵ�����
 * @author shkstart
 * @create 2020-05-18-13:56
 */
public class LeftBg {
    //�ȼ�ͼƬ
    public static Image levelImg = new ImageIcon("Image\\�ȼ�.png").getImage();
    public static int X_LEVEL = 10, Y_LEVEL = 20;
    public static int highLevel = 30, widthLevel = 45;
    //Hp����
    public static Image hpImg = new ImageIcon("Image\\��ɫѪ��.png").getImage();
    public static int  X_HP = 15, Y_HP = 60;
    public static int highHp = 20, widthHp = 200;
    //Mp����
    public static Image mpImg = new ImageIcon("Image\\����.png").getImage();
    public static int X_MP = 15, Y_MP = 85;
    public static int highMp = 20, widthMp = 200;
    //����ͼ
    public static Image nullImg = new ImageIcon("Image\\���Ͽհ���.png").getImage();
    public static int X_HERO_EXP = 15, Y_HERO_EXP = 110;
    public static int highHeroExp = 20, widthHeroExp = 200;
    //EXPͼƬ
    public static Image expImg = new ImageIcon("Image\\��������Ѫ��.png").getImage();
}
