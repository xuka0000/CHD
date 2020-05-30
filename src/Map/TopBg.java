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
    //空白菜单栏
    public Image nullPicture = new ImageIcon("Image\\技能框.png").getImage();
    public TopBgSkill[] topBgSkills = {
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", "Image\\跳跃图标.png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("跳跃", "跳跃。", new Img("跳跃", ".png", 35, 35, 300, 38), false)
    };


    //空白技能栏的坐标
    public int X_NullPicture = 300, Y_NullPicture = 38;

    public int highNullPicture = 35, widthNullPicture = 35;

    //技能栏对应字母
    public String[] skillWord = {"CTRL","A","S","D","F","ALT","Shift","Z","X","C","V","SPACE","1","2","3","4","5","6","7","8","9","10","-","="};


}
