package DataMask;

public class PortalMask extends BasicPerson {
	private int changeMapId;
	private int changeHeroX;
	private int changeHeroY;
	//´«ËÍÃÅ×ø±ê
	private int x;
	private int y;

	private Img[] img;


	public PortalMask(String name, Action[] action, boolean isGravity, int changeMapId, int changeHeroX, int changeHeroY, int x, int y, Img[] img) {
		super(name, action, isGravity);
		this.changeMapId = changeMapId;
		this.changeHeroX = changeHeroX;
		this.changeHeroY = changeHeroY;
		this.x = x;
		this.y = y;
		this.img = img;
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
