package DataMask;
/*
 * 可交易物品的模具
 */

public class TradableObject {

	private  String name ; 
	private  int number ; 
	private  long value ;
	private  String description;
	private  Img[] img;
	private  Sound[] sound;
	
	
	
	
	@Override
	public String toString() {
		return "TradableObject [name=" + name + ", number=" + number + ", value=" + value + ", description="
				+ description + ", img=" + img + ", sound=" + sound + "]";
	}
	
	public TradableObject(String name, int number, long value, String description, Img[] img, Sound[] sound) {
		super();
		this.name = name;
		this.number = number;
		this.value = value;
		this.description = description;
		this.img = img;
		this.sound = sound;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Img[] getImg() {
		return img;
	}
	public void setImg(Img[] img) {
		this.img = img;
	}
	public Sound[] getSound() {
		return sound;
	}
	public void setSound(Sound[] sound) {
		this.sound = sound;
	}
	
	
	
	
	
	
}
