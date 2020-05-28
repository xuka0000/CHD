package gameProgress;

import DataMask.MapMask;
import Hero.Hero;
import Map.BG;
import Map.Monster;
import Map.NPC;
import Map.Portal;
import SQL.MapSQL;
import ui.GameFrame;

/**
 * @author shkstart
 * @create 2020-05-27-22:48
 */
public class Loading extends Thread {

    private GameFrame gf;
    public Loading(GameFrame gf) {
        this.gf = gf;
    }

    @Override
    public void run() {
        while (true) {
            for (int j = 0; j < MapSQL.MapSQL.length; j++) {
                if (SQL.MapSQL.MapSQL[j].getId() == gf.hero.hero.getMapId()) {
                    //��Map
                    gf.map.Map = SQL.MapSQL.MapSQL[j];
                    System.out.println(gf.map.Map.getId());
                }
            }
            // ��������(�̣߳�
            for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
                gf.monster[i] = new Monster(gf);
            }
            // ����NPC(�̣߳�
            for (int i = 0; i < gf.map.Map.getNPC().length - 1; i++) {
                gf.NPC[i] = new NPC(gf);
            }
            // ����������
            for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
                gf.portal[i] = new Portal(gf);
                gf.portal[i].portal = gf.map.Map.getPortal()[i];
            }
            // �߳�����ʼ
            // ð�ռ�
            try {
                gf.hero.start();
            } catch (Exception e) {

            }

            // ����
//            for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
//               gf.monster[i].start();
//            }
//            // NPC
//            for (int i = 0; i < gf.map.Map.getNPC().length - 1; i++) {
//                gf.NPC[i].start();
//            }
            // ������
            for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
                gf.portal[i].start();
            }
            try {
                sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
