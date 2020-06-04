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
    public static Img[] JunglePortalImg = {
            new Img("Jungle传送门", "Image\\光环.gif", 200, 200, 0, -210),
            new Img("Jungle传送", "Image\\前往古木丛林.png", 300, 400, 400, -300)
    };
    /**
     * 一个地图有
     */
    public static Action[] JunglePortal = {
            new Action("Jungle传送门", false, JunglePortalImg, null)
    };
    /**
     * 传送门数据
     */
    public static PortalMask[] portal = {
            new PortalMask("Jungle", JunglePortal, false, 0,800,100,0,750, 20, 20, JunglePortalImg),
            //new PortalMask("Verus", verusPortal, false, 1,10,150,0,750, 20, 20, verusPortalImg),
    };
}
