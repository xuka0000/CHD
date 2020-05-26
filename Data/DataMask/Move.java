package DataMask;
/**
 * ÒÆ¶¯
 * @author ¿­¿­
 *
 */
public class Move {

	private int X;
	private int Y;
	private int leftSpeed ;
	private int rightSpeed ;
	private int upSpeed ;
	private int downSoeed ;
	private int junpable ;
	
	
	
	public Move(int x, int y, int leftSpeed, int rightSpeed, int upSpeed, int downSoeed, int junpable) {
		super();
		X = x;
		Y = y;
		this.leftSpeed = leftSpeed;
		this.rightSpeed = rightSpeed;
		this.upSpeed = upSpeed;
		this.downSoeed = downSoeed;
		this.junpable = junpable;
	}
	public int getX() {
		return X;
	}
	public void setX(int x) {
		X = x;
	}
	public int getY() {
		return Y;
	}
	public void setY(int y) {
		Y = y;
	}
	public int getLeftSpeed() {
		return leftSpeed;
	}
	public void setLeftSpeed(int leftSpeed) {
		this.leftSpeed = leftSpeed;
	}
	public int getRightSpeed() {
		return rightSpeed;
	}
	public void setRightSpeed(int rightSpeed) {
		this.rightSpeed = rightSpeed;
	}
	public int getUpSpeed() {
		return upSpeed;
	}
	public void setUpSpeed(int upSpeed) {
		this.upSpeed = upSpeed;
	}
	public int getDownSoeed() {
		return downSoeed;
	}
	public void setDownSoeed(int downSoeed) {
		this.downSoeed = downSoeed;
	}
	public int getJunpable() {
		return junpable;
	}
	public void setJunpable(int junpable) {
		this.junpable = junpable;
	}
	
	
}
