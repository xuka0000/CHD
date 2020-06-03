package VerusSQL;

import DataMask.Action;
import DataMask.Img;
import DataMask.Sound;

/**崔悦
 * NPC动作库
 * */
public class NpcActionSQL {
    /**左站立*/
    public static Img[] imgLeftStand= {
            new Img("左站立","Image\\女枪站立左.gif",66,128,1435,600)
    };
    public static Img[] imgRightStand={
            new Img("右站立","Image\\女枪站立右.gif",66,128,1435,600)
    };
    public static Action[] action = {
            new Action("左站立",false,imgLeftStand,new Sound("null","null")),
            new Action("右站立",false,imgRightStand,new Sound("null","null"))
    };
}
