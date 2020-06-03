package jungleSQL;

import DataMask.Img;
import DataMask.Obstruction;
import DataMask.hill;

/**
 * 从林障碍物
 * @author shkstart
 * @create 2020-05-29-18:46
 */
public class JungleObs {
    public static Obstruction[] obsLeft = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 300, 1400, 500)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 300, 2150, 650)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 120, 800, -95)),
    };

    public static Obstruction[] obsRight = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 50, 120, 800, 500)),



    };

    public static Obstruction[] obsBottom = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 770, 50, 0, 600)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 720, 50, 720, 480)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 800, 50, 1400, 620)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 445, 50, 0, -30)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 620, 50, 2000, 245)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 1220, 50, 855, -40)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 150, 50, 720, -145)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 800, 30, 2650, -175)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 300, 30, 3050, 600)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 600, 30, 2230, 726)),
    };

    public static Obstruction[] ladder = {
            new Obstruction(new Img("", null, 0, 0, 0, 0)),
    };

    public static Obstruction[] rope = {
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 360, 2480, 230)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 260, 1950, -10)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 2000, 200, 0)),
            new Obstruction(new Img("", "Image\\绿色小点.png", 10, 800, 2750, -200)),

    };

    public static hill[] leftHill = {
            new hill(1,1,1,1)
    };

    public static hill[] rightHill = {
            new hill(450,-10,700,-170),
            new hill(2750,745,3070,600)

    };

}
