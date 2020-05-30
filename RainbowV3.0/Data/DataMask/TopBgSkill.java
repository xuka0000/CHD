package DataMask;

/**
 *  �Ϸ�������
 * @author shkstart
 * @create 2020-05-23-18:51
 */
public class TopBgSkill {
    /**
     * ������
     */
    private String skillName;
    /**
     * ��������
     */
    private String skillDescribe;
    /**
     * ����ͼƬ
     */
    private Img skillImg;
    /**
     * �ж��Ƿ񱻽Ӵ�
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
