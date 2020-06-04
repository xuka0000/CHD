package ui;

import DataMask.MapMask;
import Map.Portal;
import Map.BG;
import java.awt.*;
import java.util.Map;

/**
 * 传送门打印和提示
 * @author shkstart
 * @create 2020-05-30-14:29
 */
public class PortalView {

    public static void portalUse(Graphics big, Portal[] portal, BG map,GameFrame gf) {
        for (int i = 0; i < portal.length; i++) {
            big.drawImage(portal[i].portal.getImg()[0].getPicturePath(),
                    portal[i].portal.getImg()[0].getX() + map.Map.getImg()[4].getX(),
                    portal[i].portal.getImg()[0].getY()+(750+map.Map.getImg()[4].getY()),
                    portal[i].portal.getImg()[0].getWidth(),
                    portal[i].portal.getImg()[0].getWidth(),null);

            if (gf.hero.hit(gf.hero.DIR_PORTAL)) {
                //System.out.println(portal[i].portal.getImg()[1].getName());
                big.drawImage(portal[i].portal.getImg()[1].getPicturePath(),
                        portal[i].portal.getImg()[1].getX() + map.Map.getImg()[4].getX(),
                        portal[i].portal.getImg()[1].getY() + (750 + map.Map.getImg()[4].getY()),
                        portal[i].portal.getImg()[1].getWidth(),
                        portal[i].portal.getImg()[1].getWidth(), null);
            }
        }
    }

}
