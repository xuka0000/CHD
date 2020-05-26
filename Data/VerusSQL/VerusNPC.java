package VerusSQL;

import DataMask.NPCMask;

import static VerusSQL.Verus.VerusImg;

/**
 * VerusµØÍ¼µÄNPC
 * @author shkstart
 * @create 2020-05-25-23:37
 */
public class VerusNPC {
    public static NPCMask[] verusNPC = {
            new NPCMask("Ãû×Ö", SQL.ActionSQL.ActionSQL, false, SQL.TempBag.tempBag,VerusTask.task , false, VerusImg, null, null, false, 0, 0),
    };

}
