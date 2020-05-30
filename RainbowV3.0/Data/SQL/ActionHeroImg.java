package SQL;

import DataMask.Img;

/**
 * 人物运动属性图片
 * @author shkstart
 * @create 2020-05-20-22:41h
 */
public class ActionHeroImg {
    public static Img[] leftStand={
            new Img("基本图形左站立","Image\\站立左.gif",108,156,0,0)
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
