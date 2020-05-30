package util;

/**
 * @author shkstart
 * @create 2020-05-24-22:58
 */
public class SoundPlayer {
    public void soundPlayer(String path,int time) {
        new Thread(){
            @Override
            public void run() {
                AudioPlayer startSound = new AudioPlayer(path);
                startSound.run();
                try {
                    sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
