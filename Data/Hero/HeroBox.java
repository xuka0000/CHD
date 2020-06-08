package Hero;

import DataMask.Img;

/**
 * 这里存放冒险家基本模型
 */
public class HeroBox {
    /**
     * 头部
      */
    public static Img[] head = {
            new Img("站立_左_肤色等级2","Image\\头-1-左站立.png",35,38,0,0),
            new Img("站立_右_肤色等级2","Image\\头 - 1 -右看.png",35,38,0,0),
    };
    /**
     * 身体
     */
    public static Img[] body = {
            new Img("站立_左_肤色等级2","Image\\身体1.gif",17,38,5,34),
    };
    /**
     * 左腿
     */
    public static Img[] legLeft = {
            new Img("站立_左_肤色等级2","Image\\左腿1.png",17,46,3,64),
    };

    /**
     * 右腿
     */
    public static Img[] legRight = {
            new Img("站立_左_肤色等级2","Image\\右腿1.png",21,44,11,64),
    };
    /**
     * 左脚
     */
    public static Img[] footLeft = {
            new Img("站立_左_肤色等级2","Image\\左脚1.png",21,11,-4,102),
    };
    /**
     * 右脚
     */
    public static Img[] footRight = {
            new Img("站立_左_肤色等级2","Image\\右脚1.png",16,11,12,104),
    };
    /**
     * 左手臂
     */
    public static Img[] armLeft = {
            new Img("站立_左_肤色等级2","Image\\左手臂1.png",25,31,-4,42),
    };

    /**
     * 右手臂
     */
    public static Img[] armRight = {
            new Img("站立_左_肤色等级2","Image\\右手臂.gif",10,27,18,40),
    };

    /**
     * 左手
     */
    public static Img[] handLeft = {
            new Img("站立_左_肤色等级2","Image\\左拳1.png",12,13,2,62),
    };

    /**
     * 右手
     */
    public static Img[] handRight = {
            new Img("站立_左_肤色等级2","Image\\右拳.gif",12,12,18,65),
    };

}
