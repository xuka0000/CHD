package Hero;

/**
 * @author shkstart
 * @create 2020-05-26-1:12
 */
public interface HeroControl {
    /**
     *  �����ܵ��ж�
     */
    void heroRightRun();

    /**
     * �����ܵ��ж�
     */
    void heroLeftRun();

    /**
     * Ӣ����Ծ
     */
    void heroJump();

    /**
     * ��Ծ���亯��
     */
    public void jumpLogic();

    /**
     * ��ԾͼƬ�ı�
     */
    public void jumpImg();

    /**
     * �����ײ
     */
    public boolean hit(String dir);

    /**
     * �����߳�
     */
    public void Gravity();


}
