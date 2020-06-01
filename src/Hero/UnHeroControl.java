package Hero;

import DataMask.Img;
import DataMask.Obstruction;
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
    public static void arrayObsSetY_Down( Obstruction[] obs , int speed){
        for(int i = 0 ; i< obs.length ; i++){
            obs[i].getImg().setY(obs[i].getImg().getY() - speed);
        }
    }

    /**
     * 控制障碍物数组X集体上升
     */
    public static void arrayObsSetX_Down( Obstruction[] obs , int speed){
        for(int i = 0 ; i< obs.length ; i++){
            obs[i].getImg().setX(obs[i].getImg().getX() - speed);
        }
    }

    /**
     * 控制障碍物数组X集体上升
     */
    public static void arrayObsSetX_Up( Obstruction[] obs , int speed){
        for(int i = 0 ; i< obs.length ; i++){
            obs[i].getImg().setX(obs[i].getImg().getX() - speed);
        }
    }

}
