package snowfieldSQL;

import DataMask.Action;
import DataMask.Img;
import DataMask.PortalMask;

/**
 * @author shkstart
 * @create 2020-06-12-16:02
 */
public class snowfieldPortal {
    public static Img[] snowfieldPortalImg1= {
            new Img("Jungle传送门", "Image\\光环.gif", 200, 200, 0, 350),
            new Img("Jungle传送", "Image\\前往古木丛林.png", 300, 400, 400, -300)
    };
    public static Img[] snowfieldPortalImg2 = {
            new Img("Jungle传送门", "Image\\光环.gif", 200, 200, 2900, -490),
            new Img("Jungle传送", "Image\\前往古木丛林.png", 300, 400, 2500, -150)
    };
    /**
     * 一个地图有
     */
    public static Action[] snowfieldPortal1 = {
            new Action("Jungle传送门", false, snowfieldPortalImg1, null)
    };
    public static Action[] snowfieldPortal2 = {
            new Action("Jungle传送门", false, snowfieldPortalImg2, null)
    };
    /**
     * 传送门数据
     */
    public static PortalMask[] portal = {
            new PortalMask("Jungle1", snowfieldPortal1, false, 1,1000,100,0,750, 20, 20, snowfieldPortalImg1),
            new PortalMask("Jungle2", snowfieldPortal2, false, 3,800,100,0,750, 20, 20, snowfieldPortalImg2),
    };
}
