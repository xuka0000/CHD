package jungleSQL;

import DataMask.Action;
import DataMask.Img;
import DataMask.PortalMask;

import static VerusSQL.VerusPortal.*;

/**
 * 从林传送门
 * @author shkstart
 * @create 2020-05-29-18:46
 */
public class JunglePortal {
    public static Img[] JunglePortalImg1= {
            new Img("Jungle传送门", "Image\\光环.gif", 200, 200, 0, -210),
            new Img("Jungle传送", "Image\\前往古木丛林.png", 300, 400, 400, -300)
    };
    public static Img[] JunglePortalImg2 = {
            new Img("Jungle传送门", "Image\\光环.gif", 200, 200, 3000, -380),    //x 2900 y -380
            new Img("Jungle传送", "Image\\前往古木丛林.png", 300, 400, 2500, -150)
    };
    /**
     * 一个地图有
     */
    public static Action[] JunglePortal1 = {
            new Action("Jungle传送门", false, JunglePortalImg1, null)
    };
    public static Action[] JunglePortal2 = {
            new Action("Jungle传送门", false, JunglePortalImg2, null)
    };
    /**
     * 传送门数据
     */
    public static PortalMask[] portal = {
            new PortalMask("Jungle1", JunglePortal1, false, 0,800,100,0,750, 20, 20, JunglePortalImg1),
            new PortalMask("Jungle2", JunglePortal2, false, 2,0,400,0,100, 20, 20, JunglePortalImg2),
    };
}
