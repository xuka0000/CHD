package Hero;

/**
 * @author shkstart
 * @create 2020-05-26-1:12
 */
public interface HeroControl {
    /**
     *  向右跑的判断
     */
    void heroRightRun();

    /**
     * 向左跑的判断
     */
    void heroLeftRun();

    /**
     * 英雄跳跃
     */
    void heroJump();

    /**
     * 跳跃降落函数
     */
    public void jumpLogic();

    /**
     * 跳跃图片改变
     */
    public void jumpImg();

    /**
     * 检测碰撞
     */
    public boolean hit(String dir);

    /**
     * 重力线程
     */
    public void Gravity();


}
