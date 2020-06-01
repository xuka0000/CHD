package Hero;

import ui.GameFrame;

/*
存放冒险家关于绳索的方法
 */
public class ropeHero {
    /*
    目前冒险家是否可以去判断绳索状态
     */
    public static void isRopeContraling(GameFrame gf){


        /**
         * 如果绳索
         */
        if(!gf.hero.isRopeContraling){
            new Thread(){
                public void run(){

                    try {
                        sleep(750);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    gf.hero.ropeToJump = true ;
                    gf.hero.isRopeContraling = true ;
                }
            }.start();
        }

    }
}
