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
    //�հײ˵���
    public Image nullPicture = new ImageIcon("Image\\���ܿ�.png").getImage();
    public TopBgSkill[] topBgSkills = {
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", "Image\\��Ծͼ��.png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false),
            new TopBgSkill("��Ծ", "��Ծ��", new Img("��Ծ", ".png", 35, 35, 300, 38), false)
    };


    //�հ׼�����������
    public int X_NullPicture = 300, Y_NullPicture = 38;

    public int highNullPicture = 35, widthNullPicture = 35;

    //��������Ӧ��ĸ
    public String[] skillWord = {"CTRL","A","S","D","F","ALT","Shift","Z","X","C","V","SPACE","1","2","3","4","5","6","7","8","9","10","-","="};


}
