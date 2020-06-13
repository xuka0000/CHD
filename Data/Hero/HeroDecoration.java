package Hero;

import DataMask.Img;

/**
 * 冒险家装饰品
 */
public class HeroDecoration {

    public static Img[] face = {
            new Img("测瞄表情","Image\\眨眼一.gif",25,25,2,14),
            new Img("测瞄表情","Image\\眨眼一右.gif",25,25,8,14),
    };

    public static Img[] hair = {
            new Img("头发1","Image\\头发左-1.png",60,75,-2,-3),
            new Img("头发1","Image\\头发右-1.png",60,75,-24,-3),

    };

    public static Img[] underWear_Up = {
            new Img("蓝色小背心-女","Image\\蓝色小背心-女.png",13,15,9,42),
            new Img("蓝色小背心-女","Image\\蓝色小背心右-女.png",13,15,13,42),
    };

    public static Img[] underWear_Down = {
            new Img("蓝色新手短裤-女","Image\\蓝色新手短裤-女.png",21,14,2,61),
            new Img("蓝色新手短裤-女","Image\\蓝色新手短裤右-女.png",21,14,12,61),
    };
}
