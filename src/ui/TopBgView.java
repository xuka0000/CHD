package ui;

import Map.TopBg;

import java.awt.*;

/**
 * @author shkstart
 * @create 2020-05-26-0:44
 */
public class TopBgView {
    //顶部技能栏
    public static void  topBgView(Graphics big, TopBg topBg) {
        big.setFont(new Font("", Font.BOLD, 9));
        for (int i = 0; i < 12; i++) {
            big.drawImage(topBg.nullPicture, topBg.X_NullPicture + i * 35, topBg.Y_NullPicture, topBg.widthNullPicture, topBg.highNullPicture, null);
            big.drawImage(topBg.topBgSkills[i].getSkillImg().getPicturePath(), topBg.topBgSkills[i].getSkillImg().getX() + i * 35,
                    topBg.topBgSkills[i].getSkillImg().getY(), topBg.topBgSkills[i].getSkillImg().getWidth(), topBg.topBgSkills[i].getSkillImg().getHeight(), null);
            big.drawString(topBg.skillWord[i], topBg.X_NullPicture + i * 35 + 2, topBg.Y_NullPicture + 10);
        }
        for (int i = 0; i < 12; i++) {
            big.drawImage(topBg.nullPicture, topBg.X_NullPicture + i * 35, topBg.Y_NullPicture + 35, topBg.widthNullPicture, topBg.highNullPicture, null);
            big.drawString(topBg.skillWord[i + 12], topBg.X_NullPicture + i * 35 + 2, topBg.Y_NullPicture + 35 + 10);
        }
    }

}
