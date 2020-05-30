package DataMask;

/**
 *  上方技能类
 * @author shkstart
 * @create 2020-05-23-18:51
 */
public class TopBgSkill {
    /**
     * 技能名
     */
    private String skillName;
    /**
     * 技能描述
     */
    private String skillDescribe;
    /**
     * 技能图片
     */
    private Img skillImg;
    /**
     * 判断是否被接触
     */
    private boolean isTouth;

    public TopBgSkill() {

    }

    public TopBgSkill(String skillName, String skillDescribe, Img skillImg, boolean isTouth) {
        this.skillName = skillName;
        this.skillDescribe = skillDescribe;
        this.skillImg = skillImg;
        this.isTouth = isTouth;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDescribe() {
        return skillDescribe;
    }

    public void setSkillDescribe(String skillDescribe) {
        this.skillDescribe = skillDescribe;
    }

    public Img getSkillImg() {
        return skillImg;
    }

    public void setSkillImg(Img skillImg) {
        this.skillImg = skillImg;
    }

    public boolean isTouth() {
        return isTouth;
    }

    public void setTouth(boolean touth) {
        isTouth = touth;
    }
}
