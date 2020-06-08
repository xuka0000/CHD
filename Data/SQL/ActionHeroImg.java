package SQL;

import DataMask.Img;
import Hero.HeroBox;
import Hero.HeroDecoration;

/**
 * 人物运动属性图片
 * @author shkstart
 * @create 2020-05-20-22:41h
 */
public class ActionHeroImg {

    public static Img[] leftStand={
            HeroBox.body[0],
            HeroBox.head[0],

            HeroBox.armLeft[0],
            HeroBox.handLeft[0],

            HeroBox.legLeft[0],
            HeroBox.footLeft[0],
            HeroBox.legRight[0],
            HeroBox.footRight[0],


            HeroDecoration.face[0],
            HeroDecoration.hair[1],
            HeroDecoration.hair[0],
            HeroDecoration.underWear_Up[0],
            HeroDecoration.underWear_Down[0],

            HeroBox.armRight[0],
            HeroBox.handRight[0],
    };

    public static Img[] rightStand={
            new Img("基本图形右站立","Image\\站立右.gif",108,156,0,0)
    };
    public static Img[] leftRun={
            new Img("基本图形左跑步","Image\\玩家左跑.gif",210,165,0,0)
    };
    public static Img[] rightRun={
            new Img("基本图形右跑步","Image\\玩家右跑.gif",210,165,0,0)
    };
    /**
     * 右跳
     */
    public static Img[] leftJump = {
            new Img("左跳跃","Image\\玩家左跳跃.gif",108,156,0,0)
    };
    /**
     * 左降落
     */
    public static Img[] leftDown = {
            new Img("左降落","Image\\左下降.png",108,156,0,0)
    };
    /**
     *  右跳跃
     */
    public static Img[] rightJump = {
            new Img("右跳跃","Image\\右跳.png",108,156,0,0)
    };
    /**
     * 左降落
     */
    public static Img[] rightDown = {
            new Img("右降落","Image\\右下降.png",108,156,0,0)
    };


}
