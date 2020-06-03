package gameProgress;

import Map.Portal;
import SQL.MapSQL;
import npc.Npc;
import ui.GameFrame;

/**
 * @author shkstart
 * @create 2020-05-30-0:13
 */
public class Loading  {
    private GameFrame gf;
    public Loading(GameFrame gf) {
        this.gf = gf;
    }

    public static void loadStart(GameFrame gf) {
        for (int j = 0; j < MapSQL.MapSQL.length; j++) {
            if (SQL.MapSQL.MapSQL[j].getId() == gf.hero.hero.getMapId()) {
                //给Map赋值切换
                gf.map.Map = SQL.MapSQL.MapSQL[j];
            }
        }
        for (int i = 0; i < gf.map.Map.getNPC().length; i++) {
            gf.npcs[i] = new Npc(gf);
            gf.npcs[i].npc= gf.map.Map.getNPC()[i];
        }
        for (int i = 0; i < gf.map.Map.getNPC().length ; i++) {
            gf.npcs[i].start();
        }
        try {
            loadingPlus(gf);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadingMap(GameFrame gf) {
            for (int j = 0; j < MapSQL.MapSQL.length; j++) {
                if (SQL.MapSQL.MapSQL[j].getId() == gf.hero.hero.getMapId()) {
                    //给Map赋值切换
                    gf.map.Map = SQL.MapSQL.MapSQL[j];
                }
            }
        try {
            loadingPlus(gf);
        } catch (Exception e) {
            //刨了
        }

    }

    public static void loadingPlus(GameFrame gf) {
        // 创建怪兽(线程）
        //                for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
        //                    gf.Monster[i] = new Monster(gf);
        //                    gf.Monster[i].Monster = gf.map.Map.getMonster()[i];
        //                }
                        // 创建NPC(线程）
                        for (int i = 0; i < gf.map.Map.getNPC().length; i++) {
                            gf.npcs[i] = new Npc(gf);
                            gf.npcs[i].npc= gf.map.Map.getNPC()[i];
                        }
        // 创建传送门
        for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
            gf.portal[i] = new Portal(gf);
            gf.portal[i].portal = gf.map.Map.getPortal()[i];
        }
        // 线程任务开始
        // 冒险家

        gf.hero.start();
        // 怪物
//            for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
//               gf.Monster[i].start();
//            }
            // NPC
            for (int i = 0; i < gf.map.Map.getNPC().length ; i++) {
                gf.npcs[i].start();
            }
        // 传送门
        for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
            gf.portal[i].start();
        }

    }
}
