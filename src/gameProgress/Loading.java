package gameProgress;

import monster.Monster;
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
        //赋初值否则报空

        for (int j = 0; j < MapSQL.MapSQL.length; j++) {
            if (SQL.MapSQL.MapSQL[j].getId() == gf.hero.hero.getMapId()) {
                //给Map赋值切换
                gf.map.Map = SQL.MapSQL.MapSQL[j];
                gf.map.startMap = gf.map;
            }
        }


        //NPC赋值
        Npc[] tempNpc = new Npc[gf.map.Map.getNPC().length];
        gf.npcs =tempNpc ;
        for (int i = 0; i < gf.map.Map.getNPC().length; i++) {
            gf.npcs[i] = new Npc(gf);
            gf.npcs[i].npc= gf.map.Map.getNPC()[i];
        }

        for (int i = 0; i < gf.map.Map.getNPC().length ; i++) {
            gf.npcs[i].start();
        }



        //怪物赋值
        Monster[] tempMonster = new Monster[gf.map.Map.getMonster().length];
        gf.monsters = tempMonster ;
        for (int i = 0; i < gf.map.Map.getMonster().length; i++) {
            gf.monsters[i] = new Monster(gf);
            gf.monsters[i].monster = gf.map.Map.getMonster()[i];
        }
        for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
            gf.monsters[i].start();
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
        //怪物赋值
        Monster[] tempMonster = new Monster[gf.map.Map.getMonster().length];
        gf.monsters = tempMonster ;
        for (int i = 0; i < gf.map.Map.getMonster().length; i++) {
            gf.monsters[i] = new Monster(gf);
            gf.monsters[i].monster = gf.map.Map.getMonster()[i];
        }


        // 创建NPC(线程）
        //NPC赋值
        Npc[] tempNpc = new Npc[gf.map.Map.getNPC().length];
        gf.npcs =tempNpc ;
        for (int i = 0; i < gf.map.Map.getNPC().length; i++) {
            gf.npcs[i] = new Npc(gf);
            gf.npcs[i].npc= gf.map.Map.getNPC()[i];
        }


        // 创建传送门
        Portal[] tempPortal = new Portal[gf.map.Map.getPortal().length];
        gf.portals = tempPortal;
        for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
            gf.portals[i] = new Portal(gf);
            gf.portals[i].portal = gf.map.Map.getPortal()[i];
        }



        // 线程任务开始
        // 冒险家
        gf.hero.start();
        // 怪物

        for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
           gf.monsters[i].start();
        }

        // NPC
        for (int i = 0; i < gf.map.Map.getNPC().length ; i++) {
            gf.npcs[i].start();
        }
        // 传送门
        for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
            gf.portals[i].start();
        }

    }
}
