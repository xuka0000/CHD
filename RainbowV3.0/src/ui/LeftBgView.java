package ui;

import java.awt.*;
import Map.LeftBg;
import Hero.Hero;
/**
 * 左上角的英雄属性
 * @author shkstart
 * @create 2020-05-26-0:28
 */
public class LeftBgView {

    public static void drawleftBg(Graphics big,LeftBg leftBg,Hero hero) {

        big.setFont(new Font("",Font.BOLD,15));
        //循环打印空白图片
        for (int i = 0; i < 3 ; i++) {
            int tempNumer = 25;
            big.drawImage(leftBg.nullImg, leftBg.X_HERO_EXP, leftBg.Y_HERO_EXP - tempNumer * i, leftBg.widthHeroExp, leftBg.highHeroExp, null);
        }
        //左上的lv标志
        big.drawImage(leftBg.levelImg, leftBg.X_LEVEL, leftBg.Y_LEVEL, leftBg.widthLevel, leftBg.highLevel, null);
        //左上血条
        big.drawImage(leftBg.hpImg, leftBg.X_HP, leftBg.Y_HP, leftBg.widthHp * hero.hero.getAbilityValue().getCurrHp() / hero.hero.getAbilityValue().getMaxHp(), leftBg.highHp, null);
        //将字体变成白色
        big.setColor(Color.white);
        //实际血量显示
        big.drawString(hero.hero.getAbilityValue().getCurrHp() + "", 50, 75);
        //血量实际分割
        big.drawString("/", 78, 75);
        //最大血量
        big.drawString(hero.hero.getAbilityValue().getMaxHp() + "", 90, 75);
        //左上蓝条
        big.drawImage(leftBg.mpImg, leftBg.X_MP, leftBg.Y_MP, leftBg.widthMp * hero.hero.getAbilityValue().getCurrBlue() / hero.hero.getAbilityValue().getMaxBlue(), leftBg.highMp, null);
        //实际MP
        big.drawString(hero.hero.getAbilityValue().getCurrBlue()+"",50,100);
        //MP实际分割
        big.drawString("/",78,100);
        //MP最大值
        big.drawString(hero.hero.getAbilityValue().getMaxBlue()+"",90,100);
        //显示等级
        big.drawString(hero.hero.getAbilityValue().getLevel()+"",50,45);
    }

}
