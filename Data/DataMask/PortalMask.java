package DataMask;

public class PortalMask extends BasicPerson {
	private int changeMapId;
	private int changeHeroX;
	private int changeHeroY;
	private int addMapX;
	private int addMapY;
	//传送门自己的位置啦
	private int x;
	private int y;
	
	private Img[] img;

	public PortalMask(String name, Action[] action, boolean isGravity, int changeMapId, int changeHeroX, int changeHeroY, int addMapX, int addMapY, int x, int y, Img[] img) {
		super(name, action, isGravity);
		this.changeMapId = changeMapId;
		this.changeHeroX = changeHeroX;
		this.changeHeroY = changeHeroY;
		this.addMapX = addMapX;
		this.addMapY = addMapY;
		this.x = x;
		this.y = y;
		this.img = img;
	}

	public void setAddMapX(int addMapX) {
		this.addMapX = addMapX;
	}

	public void setAddMapY(int addMapY) {
		this.addMapY = addMapY;
	}

	public int getAddMapX() {
		return addMapX;
	}

	public int getAddMapY() {
		return addMapY;
	}

	public int getChangeMapId() {
		return changeMapId;
	}

	public void setChangeMapId(int changeMapId) {
		this.changeMapId = changeMapId;
	}

	public int getChangeHeroX() {
		return changeHeroX;
	}

	public void setChangeHeroX(int changeHeroX) {
		this.changeHeroX = changeHeroX;
	}

	public int getChangeHeroY() {
		return changeHeroY;
	}

	public void setChangeHeroY(int changeHeroY) {
		this.changeHeroY = changeHeroY;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Img[] getImg() {
		return img;
	}

	public void setImg(Img[] img) {
		this.img = img;
	}
}
