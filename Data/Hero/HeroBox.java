package Hero;

import DataMask.Img;

/**
 * 这里存放冒险家基本模型
 */
public class HeroBox {

    //人物动作基础模型
     //左-后驱图
    public static Img[] HeroBBLMask = {
            new Img("淡黄色的站立--向左","Image\\浅黄色肤色左站立的后驱图片.gif",96,128,0,0),
    };

    //人物动作基础模型
    //左-前驱图
    public static Img[] HeroBOLMask = {
            new Img("淡黄色的站立--向左","Image\\浅黄色肤色左站立的前驱图.gif",96,128,0,0),
    };



    //右-后驱图
    public static Img[] HeroBBRMask = {
            new Img("淡黄色的站立--向左","Image\\浅黄色肤色右站立的后驱图片.gif",96,128,0,0),
    };

    //人物动作基础模型
    //右-前驱图
    public static Img[] HeroBORMask = {
            new Img("淡黄色的站立--向左","Image\\浅黄色肤色右站立的前驱图.gif",96,128,0,0),
    };



}
