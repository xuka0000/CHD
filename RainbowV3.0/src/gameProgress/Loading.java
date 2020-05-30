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

    @Override
    public void run() {
        for (int j = 0; j < MapSQL.MapSQL.length; j++) {
            if (SQL.MapSQL.MapSQL[j].getId() == gf.hero.hero.getMapId()) {
                //��Map��ֵ�л�
                gf.map.Map = SQL.MapSQL.MapSQL[j];
            }
        }
        try {
            loadingPlus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (true) {
            for (int j = 0; j < MapSQL.MapSQL.length; j++) {
                if (SQL.MapSQL.MapSQL[j].getId() == gf.hero.hero.getMapId()) {
                    //��Map��ֵ�л�
                    gf.map.Map = SQL.MapSQL.MapSQL[j];
                }
            }

            try {
                if (!gf.map.Map.getPortal()[0].getName().equals(gf.portal[0].portal.getName())) {
                    loadingPlus();
                }
            } catch (Exception e) {
               
            }

            try {
                sleep(20);
            } catch (InterruptedException e) {
                //����ӡ��
            }
        }

    }

    public void loadingPlus() {
        // ��������(�̣߳�
        //                for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
        //                    gf.Monster[i] = new Monster(gf);
        //                    gf.Monster[i].Monster = gf.map.Map.getMonster()[i];
        //                }
        //                // ����NPC(�̣߳�
        //                for (int i = 0; i < gf.map.Map.getNPC().length - 1; i++) {
        //                    gf.NPC[i] = new NPC(gf);
        //                }
        // ����������
        for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
            gf.portal[i] = new Portal(gf);
            gf.portal[i].portal = gf.map.Map.getPortal()[i];
        }
        // �߳�����ʼ
        // ð�ռ�

        gf.hero.start();
        // ����
//            for (int i = 0; i < gf.map.Map.getMonster().length - 1; i++) {
//               gf.Monster[i].start();
//            }
//            // NPC
//            for (int i = 0; i < gf.map.Map.getNPC().length - 1; i++) {
//                gf.NPC[i].start();
//            }
        // ������
        for (int i = 0; i < gf.map.Map.getPortal().length; i++) {
            gf.portal[i].start();
        }
    }
}
