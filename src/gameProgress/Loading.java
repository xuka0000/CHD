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
                    //��Map��ֵ�л�
                    gf.map.Map = SQL.MapSQL.MapSQL[j];
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
                //����ӡ��
            }

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
            try {
                sleep(20);
            } catch (InterruptedException e) {
                //����ӡ��
            }
        }

    }
}
