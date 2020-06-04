package VerusSQL;

import DataMask.Img;
import DataMask.Obstruction;
import DataMask.hill;

/**
 * Verus的碰撞
 * @author shkstart
 * @create 2020-05-25-23:40
 */
public class VerusObs {
    public static Obstruction[] obsLeft = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static Obstruction[] obsRight = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static Obstruction[] obsBottom = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 100, 10, 2280, 665)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 100, 10, 2300, 550)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 100, 10, 2300, 500)),
    };

    public static Obstruction[] ladder = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static Obstruction[] rope = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static hill[] leftHill = {
            new hill(2100,200,2300,500)
    };

    public static hill[] rightHill = {
            new hill(1,1,1,1)
    };

}
