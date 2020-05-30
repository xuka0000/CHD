package VerusSQL;

import DataMask.Img;
import DataMask.Obstruction;

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
            new Obstruction(new Img("", "Image\\绿色小点.png", 300, 50, 2500, 600)),
    };

    public static Obstruction[] ladder = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static Obstruction[] rope = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };
}
