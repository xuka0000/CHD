package DataMask;

public class Action {

	private String name ;
	private boolean isDirection ;
	private Img img[];
	private Sound sound;
	public Action(String name, boolean isDirection, Img[] img, Sound sound) {
		super();
		this.name = name;
		this.isDirection = isDirection;
		this.img = img;
		this.sound = sound;
	}


	public Sound getSound() {
		return sound;
	}


	public void setSound(Sound sound) {
		this.sound = sound;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDirection() {
		return isDirection;
	}
	public void setDirection(boolean isDirection) {
		this.isDirection = isDirection;
	}
	public Img[] getImg() {
		return img;
	}
	public void setImg(Img[] img) {
		this.img = img;
	}
	
	
}
