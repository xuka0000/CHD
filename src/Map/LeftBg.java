package Map;

import DataMask.Img;

import javax.swing.*;
import java.awt.*;

/**
 * 左上角的属性
 * @author shkstart
 * @create 2020-05-18-13:56
 */
public class LeftBg {
    //等级图片
    public static Image levelImg = new ImageIcon("Image\\等级.png").getImage();
    public static int X_LEVEL = 10, Y_LEVEL = 20;
    public static int highLevel = 30, widthLevel = 45;
    //Hp参数
    public static Image hpImg = new ImageIcon("Image\\红色血条.png").getImage();
    public static int  X_HP = 15, Y_HP = 60;
    public static int highHp = 20, widthHp = 200;
    //Mp参数
    public static Image mpImg = new ImageIcon("Image\\蓝条.png").getImage();
    public static int X_MP = 15, Y_MP = 85;
    public static int highMp = 20, widthMp = 200;
    //白条图
    public static Image nullImg = new ImageIcon("Image\\左上空白条.png").getImage();
    public static int X_HERO_EXP = 15, Y_HERO_EXP = 110;
    public static int highHeroExp = 20, widthHeroExp = 200;
    //EXP图片
    public static Image expImg = new ImageIcon("Image\\人物左上血条.png").getImage();
}
