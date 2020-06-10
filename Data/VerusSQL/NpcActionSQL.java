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

    /**
     * 第二个NPC的动作
     * */
    public static Img[] twoImgLeftStand= {
            new Img("左站立","Image\\女枪站立左.gif",66,128,1435,600)
    };
    public static Img[] twoImgRightStand={
            new Img("右站立","Image\\女枪站立右.gif",66,128,1435,600)
    };
    public static Action[] NPCtowAction = {
            new Action("左站立",false,twoImgLeftStand,new Sound("null","null")),
            new Action("右站立",false,twoImgRightStand,new Sound("null","null"))
    };
    /**
     * 第三个NPC的动作
     * */
    public static Img[] thereImgLeftStand= {
            new Img("左站立","Image\\女枪站立左.gif",66,128,1435,600)
    };
    public static Img[] thereImgRightStand={
            new Img("右站立","Image\\女枪站立右.gif",66,128,1435,600)
    };
    public static Action[] NPCthereAction = {
            new Action("左站立",false,thereImgLeftStand,new Sound("null","null")),
            new Action("右站立",false,thereImgRightStand,new Sound("null","null"))
    };
    /**
     * 第四个NPC的动作
     * */
    public static Img[] fourImgLeftStand= {
            new Img("左站立","Image\\女枪站立左.gif",66,128,1435,600)
    };
    public static Img[] fourImgRightStand={
            new Img("右站立","Image\\女枪站立右.gif",66,128,1435,600)
    };
    public static Action[] NPCfourAction = {
            new Action("左站立",false,fourImgLeftStand,new Sound("null","null")),
            new Action("右站立",false,fourImgRightStand,new Sound("null","null"))
    };
    /**
     * 第五个NPC的动作
     * */
    public static Img[] fiveImgLeftStand= {
            new Img("左站立","Image\\女枪站立左.gif",66,128,1435,600)
    };
    public static Img[] fiveImgRightStand={
            new Img("右站立","Image\\女枪站立右.gif",66,128,1435,600)
    };
    public static Action[] NPCfiverAction = {
            new Action("左站立",false,fiveImgLeftStand,new Sound("null","null")),
            new Action("右站立",false,fiveImgRightStand,new Sound("null","null"))
    };
}
