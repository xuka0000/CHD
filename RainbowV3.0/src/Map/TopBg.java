package Map;

import DataMask.Img;
import DataMask.TopBgSkill;

import javax.swing.*;
import java.awt.*;

/**
 * @author shkstart
 * @create 2020-05-19-22:26
 */
public class TopBg {
    //¿Õ°×²Ëµ¥À¸
    public Image nullPicture = new ImageIcon("Image\\¼¼ÄÜ¿ò.png").getImage();
    public TopBgSkill[] topBgSkills = {
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", "Image\\ÌøÔ¾Í¼±ê.png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("ÌøÔ¾", "ÌøÔ¾¡£", new Img("ÌøÔ¾", ".png", 35, 35, 300, 38), false)
    };


    //¿Õ°×¼¼ÄÜÀ¸µÄ×ø±ê
    public int X_NullPicture = 300, Y_NullPicture = 38;

    public int highNullPicture = 35, widthNullPicture = 35;

    //¼¼ÄÜÀ¸¶ÔÓ¦×ÖÄ¸
    public String[] skillWord = {"CTRL","A","S","D","F","ALT","Shift","Z","X","C","V","SPACE","1","2","3","4","5","6","7","8","9","10","-","="};


}
