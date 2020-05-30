package VerusSQL;

import DataMask.NPCMask;

import static VerusSQL.Verus.VerusImg;

/**
 * Verus地图的NPC
 * @author shkstart
 * @create 2020-05-25-23:37
 */
public class VerusNPC {

    public static NPCMask[] verusNPC = {
            new NPCMask("名字", SQL.ActionSQL.ActionSQL, false, SQL.TempBag.tempBag,VerusTask.task , false, VerusImg, null, null, false, 0, 0),
    };

}
