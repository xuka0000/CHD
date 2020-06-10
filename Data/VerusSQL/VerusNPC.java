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
            new NPCMask("药水店NPC", NpcActionSQL.action, false, SQL.TempBag.tempBag,VerusTask.task , false, VerusImg, null, null, false, 1435, 600),
            new NPCMask("武器店NPC", NpcActionSQL.NPCtowAction, false, SQL.TempBag.tempBag,VerusTask.task , false, VerusImg, null, null, false, 2165, 600),
            new NPCMask("情报店NPC", NpcActionSQL.NPCthereAction, false, SQL.TempBag.tempBag,VerusTask.task , false, VerusImg, null, null, false, 2675, 600),
            new NPCMask("广场的NPC", NpcActionSQL.NPCfourAction, false, SQL.TempBag.tempBag,VerusTask.task , false, VerusImg, null, null, false, 3785, 600),
            new NPCMask("传送门NPC", NpcActionSQL.NPCfiverAction, false, SQL.TempBag.tempBag,VerusTask.task , false, VerusImg, null, null, false, 4525, 600),
    };

}
