package jungleSQL;

import DataMask.Img;
import DataMask.Obstruction;

/**
 * 从林障碍物
 * @author shkstart
 * @create 2020-05-29-18:46
 */
public class JungleObs {
    public static Obstruction[] obsLeft = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 300, 1400, 500)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 300, 2150, 650)),
    };

    public static Obstruction[] obsRight = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 300, 800, 500)),


    };

    public static Obstruction[] obsBottom = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 770, 50, 0, 600)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 720, 50, 720, 480)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 800, 50, 1400, 620)),
    };

    public static Obstruction[] ladder = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static Obstruction[] rope = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 360, 2480, 230)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 1000, 200, 0)),
    };
}
