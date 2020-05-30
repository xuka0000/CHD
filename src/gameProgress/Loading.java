package gameProgress;

import Map.Monster;
import Map.NPC;
import Map.Portal;
import SQL.MapSQL;
import ui.GameFrame;
import util.AudioPlayer;

/**
 * @author shkstart
 * @create 2020-05-30-0:13
 */
public class Loading extends Thread {
    private GameFrame gf;
    public Loading(GameFrame gf) {
        this.gf = gf;
    }
    boolean flag = true;
    @Override
    public void run() {
        while (true) {
            for (int j = 0; j < MapSQL.MapSQL.length; j++) {
                if (SQL.MapSQL.MapSQL[j].getId() == gf.hero.hero.getMapId()) {
                    //给Map赋值切换
                    gf.map.Map = SQL.MapSQL.MapSQL[j];
                }
            }
            // 创建怪兽(线程）
            for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
                gf.monster[i] = new Monster(gf);
            }
            // 创建NPC(线程）
            for (int i = 0; i < gf.map.Map.getNPC().length - 1; i++) {
                gf.NPC[i] = new NPC(gf);
            }
            // 创建传送门
            for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
                gf.portal[i] = new Portal(gf);
                gf.portal[i].portal = gf.map.Map.getPortal()[i];
            }
            // 线程任务开始
            // 冒险家
            try {
                gf.hero.start();
            } catch (Exception e) {
                //不打印了
            }

            // 怪物
//            for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
//               gf.Monster[i].start();
//            }
//            // NPC
//            for (int i = 0; i < gf.map.Map.getNPC().length - 1; i++) {
//                gf.NPC[i].start();
//            }
            // 传送门
            for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
                gf.portal[i].start();
            }
            try {
                sleep(20);
            } catch (InterruptedException e) {
                //不打印了
            }
        }

    }
}
