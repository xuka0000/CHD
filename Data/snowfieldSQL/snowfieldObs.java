package snowfieldSQL;

import DataMask.Img;
import DataMask.Obstruction;
import DataMask.hill;

/**
 * @author shkstart
 * @create 2020-06-12-16:01
 */
public class snowfieldObs {
    public static Obstruction[] obsLeft = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 300, 800, 580)),

    };

    public static Obstruction[] obsRight = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 0, 0, 0, 0)),



    };

    public static Obstruction[] obsBottom = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 890, 20, 0, 540)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 2030, 20, 1100, 450)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 100, 20, 1000, 500)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 100, 20, 1100, 300)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 1060, 20, 0, 150)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 100, 20, 1200, 50)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 100, 20, 1200, 0)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 1000, 20, 1380, 100)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 820, 20, 0, -430)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 120, 20, 900, -310)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 620, 20, 1150, -190)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 20, 1930, -250)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 20, 2100, -250)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 20, 2270, -250)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 1000, 20, 2370, -300)),

    };

    public static Obstruction[] ladder = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static Obstruction[] rope = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 800, 2600, -300)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 440, 636, -430)),


    };

    public static hill[] leftHill = {
            new hill(1,1,1,1)
    };

    public static hill[] rightHill = {
            new hill(1,1,1,1),
            new hill(1,1,1,1)

    };
}
