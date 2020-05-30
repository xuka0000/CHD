package jungleSQL;

import DataMask.Img;
import DataMask.Sound;

/**
 * @author shkstart
 * @create 2020-05-29-18:37
 */
public class Jungle {

    public static Img[] jungleImg = {
            new Img("丛林天空动态图层", "Image\\云端图层(1).gif", 1532, 512, 0, 200),
            new Img("丛林地图图层4","Image\\丛林地图涂层4.png",3200,2000,0,-750),
            new Img("丛林地图图层3","Image\\丛林地图涂层3.png",3200,2000,0,-750),
            new Img("从林地图2","Image\\丛林地图2.png",3200,2000,0,-750),
            new Img("丛林地图1","Image\\丛林地图1.png",3200,2000,0,-750),
            new Img("丛林天空图层","Image\\丛林天空涂层.png",3200,2000,0,-750),
    };

    public static Sound jungleSound = new Sound("Verus'Sound", "Sound\\jungly.mp3");
}
