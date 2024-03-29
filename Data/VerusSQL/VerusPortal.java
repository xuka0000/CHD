package VerusSQL;

import DataMask.Action;
import DataMask.Img;
import DataMask.MapMask;
import DataMask.PortalMask;
import Hero.Hero;

import static jungleSQL.JunglePortal.*;


/**
 * @author shkstart
 * @create 2020-05-25-23:50
 */
public class VerusPortal {

    public static Img[] verusPortalImg = {
            new Img("Verus传送门", "Image\\光环.gif", 200, 200, 4750, 550),   //4750
            new Img("Verus传送", "Image\\前往古木丛林.png", 300, 400, 4300, 300)
    };
    /**
     * 一个地图有
     */
    public static Action[] verusPortal = {
            new Action("Verus传送门", false, verusPortalImg, null)
    };
    /**
     * 传送门数据
     */
    public static PortalMask[] portal = {
            new PortalMask("Verus", verusPortal, false, 1,10,150,0,750, 20, 20, verusPortalImg),

    };


}
