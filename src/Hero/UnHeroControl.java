package Hero;

import DataMask.*;
import Map.Portal;
import monster.Monster;
import npc.Npc;
import ui.GameFrame;

/**
 * 除了Hero 以外的所有属性的控制
 */
public class UnHeroControl {
    /**
     * 控制图片数组Y集体上升
     */
    public static void arraySetY_Up( Img[] img , int speed){
        for(int i = 0 ; i< img.length ; i++){
            img[i].setY(img[i].getY() + speed);
        }
    }

    /**
     * 控制图片数组Y集体下降
     */
    public static void arraySetY_Down( Img[] img , int speed){
        for(int i = 0 ; i< img.length ; i++){
            img[i].setY(img[i].getY() - speed);
        }
    }

    /**
     * 控制图片数组X集体下降
     */
    public static void arraySetX_Down( Img[] img , int speed){
        for(int i = 0 ; i< img.length ; i++){
            img[i].setX(img[i].getX() - speed);
        }
    }

    /**
     * 控制图片数组X集体上升
     */
    public static void arraySetX_Up( Img[] img , int speed){
        for(int i = 0 ; i< img.length ; i++){
            img[i].setX(img[i].getX() + speed);
        }
    }
    //*****************************
    /**
     * 控制传送门数组Y集体上升
     */
    public static void arrayPortalSetY_Up(PortalMask[] portals, int speed){

        for(int i = 0 ; i< portals.length ; i++){
            portals[i].getImg()[0].setY(portals[i].getImg()[0].getY() + speed);
        }
    }

    /**
     * 控制传送门数组Y集体下降
     */
    public static void arrayPortalSetY_Down(PortalMask[] portals, int speed){
        for(int i = 0 ; i< portals.length ; i++){
            portals[i].getImg()[0].setY(portals[i].getImg()[0].getY() - speed);
        }
    }

    /**
     * 控制传送门数组X集体下降
     */
    public static void arrayPortalSetX_Down(PortalMask[] portals, int speed){
        for(int i = 0 ; i< portals.length ; i++){
            portals[i].getImg()[0].setX(portals[i].getImg()[0].getX() - speed);
        }
    }

    /**
     * 控制传送门数组X集体上升
     */
    public static void arrayPortalSetX_Up(PortalMask[] portals, int speed){
        for(int i = 0 ; i< portals.length ; i++){
            portals[i].getImg()[0].setX(portals[i].getImg()[0].getX() + speed);
        }
    }
    //*****************************

    /**
     * 控制怪物数组的Y集体上移
     * @param
     * @param speed
     */
    public static void arrayMonsterSetY_Up(Monster[] monsters, int speed){

        for(int i = 0 ; i< monsters.length ; i++){
            monsters[i].monster.setX(monsters[i].monster.getX() - speed);
        }
    }

    /**
     * 控制怪物数组的Y集体下移
     * @param
     * @param speed
     */
    public static void arrayMonsterSetY_Down(Monster[] monsters, int speed){
        for(int i = 0 ; i< monsters.length ; i++){
            monsters[i].monster.setX(monsters[i].monster.getX() + speed);
        }
    }


    //*****************************

    /**
     * 控制NPC的Y集体上移
     * @param npcs
     * @param speed
     */
    public static void arrayNpcSetY_Up(Npc[] npcs, int speed){

        for(int i = 0 ; i< npcs.length ; i++){
            npcs[i].npc.setY(npcs[i].npc.getY() + speed);
        }
    }

    /**
     * 控制NPC的Y集体下移
     * @param npcs
     * @param speed
     */
    public static void arrayNpcSetY_Down(Npc[] npcs, int speed){
        for(int i = 0 ; i< npcs.length ; i++){
            npcs[i].npc.setY(npcs[i].npc.getY() - speed);
        }
    }


    //*****************************
    /**
     * 控制障碍物数组Y集体上升
     */
    public static void arrayObsSetY_Up(Obstruction[] obs , int speed){
        for(int i = 0 ; i< obs.length ; i++){
            obs[i].getImg().setY(obs[i].getImg().getY() + speed);
        }
    }

    /**
     * 控制障碍物数组Y集体上升
     */
    public static void arrayObsSetY_Down(Obstruction[] obs , int speed){
        for(int i = 0 ; i< obs.length ; i++){
            obs[i].getImg().setY(obs[i].getImg().getY() - speed);
        }
    }

    /**
     * 控制障碍物数组X集体上升
     */
    public static void arrayObsSetX_Down(Obstruction[] obs , int speed){
        for(int i = 0 ; i< obs.length ; i++){
            obs[i].getImg().setX(obs[i].getImg().getX() - speed);
        }
    }

    /**
     * 控制障碍物数组X集体上升
     */
    public static void arrayObsSetX_Up(Obstruction[] obs , int speed){
        for(int i = 0 ; i< obs.length ; i++){
            obs[i].getImg().setX(obs[i].getImg().getX() - speed);
        }
    }

    /**
     * Hill数组集体改Y上升
     */
    public static void arrayHillSetY_Up(hill[] hill , int speed){
        for(int i = 0 ; i< hill.length ; i++){
            hill[i].setY1(hill[i].getY1()+speed);
            hill[i].setY2(hill[i].getY2()+speed);
        }
    }

    /**
     * Hill数组集体改Y下降
     */
    public static void arrayHillSetY_Down(hill[] hill , int speed){
        for(int i = 0 ; i< hill.length ; i++){
            hill[i].setY1(hill[i].getY1()-speed);
            hill[i].setY2(hill[i].getY2()-speed);
        }
    }

    /**
     * Hill数组集体改X上升
     */
    public static void arrayHillSetX_Up(hill[] hill , int speed){
        for(int i = 0 ; i< hill.length ; i++){
            hill[i].setX1(hill[i].getX1()+speed);
            hill[i].setX2(hill[i].getX2()+speed);
        }
    }

    /**
     * Hill数组集体改X下降
     */
    public static void arrayHillSetX_Down(hill[] hill , int speed){
        for(int i = 0 ; i< hill.length ; i++){
            hill[i].setX1(hill[i].getX1()-speed);
            hill[i].setX2(hill[i].getX2()-speed);
        }
    }

}
