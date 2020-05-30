package ui;

import java.awt.*;
import Map.LeftBg;
import Hero.Hero;
/**
 * ���Ͻǵ�Ӣ������
 * @author shkstart
 * @create 2020-05-26-0:28
 */
public class LeftBgView {

    public static void drawleftBg(Graphics big,LeftBg leftBg,Hero hero) {

        big.setFont(new Font("",Font.BOLD,15));
        //ѭ����ӡ�հ�ͼƬ
        for (int i = 0; i < 3 ; i++) {
            int tempNumer = 25;
            big.drawImage(leftBg.nullImg, leftBg.X_HERO_EXP, leftBg.Y_HERO_EXP - tempNumer * i, leftBg.widthHeroExp, leftBg.highHeroExp, null);
        }
        //���ϵ�lv��־
        big.drawImage(leftBg.levelImg, leftBg.X_LEVEL, leftBg.Y_LEVEL, leftBg.widthLevel, leftBg.highLevel, null);
        //����Ѫ��
        big.drawImage(leftBg.hpImg, leftBg.X_HP, leftBg.Y_HP, leftBg.widthHp * hero.hero.getAbilityValue().getCurrHp() / hero.hero.getAbilityValue().getMaxHp(), leftBg.highHp, null);
        //�������ɰ�ɫ
        big.setColor(Color.white);
        //ʵ��Ѫ����ʾ
        big.drawString(hero.hero.getAbilityValue().getCurrHp() + "", 50, 75);
        //Ѫ��ʵ�ʷָ�
        big.drawString("/", 78, 75);
        //���Ѫ��
        big.drawString(hero.hero.getAbilityValue().getMaxHp() + "", 90, 75);
        //��������
        big.drawImage(leftBg.mpImg, leftBg.X_MP, leftBg.Y_MP, leftBg.widthMp * hero.hero.getAbilityValue().getCurrBlue() / hero.hero.getAbilityValue().getMaxBlue(), leftBg.highMp, null);
        //ʵ��MP
        big.drawString(hero.hero.getAbilityValue().getCurrBlue()+"",50,100);
        //MPʵ�ʷָ�
        big.drawString("/",78,100);
        //MP���ֵ
        big.drawString(hero.hero.getAbilityValue().getMaxBlue()+"",90,100);
        //��ʾ�ȼ�
        big.drawString(hero.hero.getAbilityValue().getLevel()+"",50,45);
    }

}
