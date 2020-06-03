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

    public static void portalUse(Graphics big, Portal[]portal, BG map) {
        for (int i = 0; i < portal.length ; i++) {
            big.drawImage(map.Map.getPortal()[i].getAction()[0].getImg()[0].getPicturePath(),
                    map.Map.getPortal()[i].getAction()[0].getImg()[0].getX() + map.Map.getImg()[4].getX(),
                    map.Map.getPortal()[i].getAction()[0].getImg()[0].getY(),
                    map.Map.getPortal()[i].getAction()[0].getImg()[0].getWidth(),
                    map.Map.getPortal()[i].getAction()[0].getImg()[0].getHeight(), null);

            if (portal[0].portal.getIsGravity()) {
                big.drawImage(map.Map.getPortal()[i].getAction()[0].getImg()[1].getPicturePath(),
                        map.Map.getPortal()[i].getAction()[0].getImg()[1].getX() + map.Map.getImg()[4].getX(),
                        map.Map.getPortal()[i].getAction()[0].getImg()[1].getY(),
                        map.Map.getPortal()[i].getAction()[0].getImg()[1].getWidth(),
                        map.Map.getPortal()[i].getAction()[0].getImg()[1].getHeight(), null);
            }
        }
    }

}
