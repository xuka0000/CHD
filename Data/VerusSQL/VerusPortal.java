package VerusSQL;

import DataMask.Action;
import DataMask.Img;
import DataMask.PortalMask;

/**
 * @author shkstart
 * @create 2020-05-25-23:50
 */
public class VerusPortal {

    public static Img[] verusPortalImg = {
            new Img("Verus������", "Image\\�⻷.gif", 200, 200, 4750, 550),
            new Img("Verus����", "Image\\ǰ����ľ����.png", 300, 200, 4600, 300)
    };
    /**
     * һ����ͼ��
     */
    public static Action[] verusPortal = {
            new Action("Verus������", false, verusPortalImg, null)
    };

    //public static
    /**
     * ����������
     */
    public static PortalMask[] portal = {
            new PortalMask(null, verusPortal, false, 1, 0, 0, 0, 0,verusPortalImg),
    };
}
