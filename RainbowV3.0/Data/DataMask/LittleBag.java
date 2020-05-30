package DataMask;
/**
 * 一类物品栏
 * @author 凯凯
 *
 */
public class LittleBag {
	private boolean isSelected;
	private String name;
	private String room[][];
	private Img imgBag;
	private TradableObject object[];
	
	
	public LittleBag(boolean isSelected, String name, String[][] room, Img imgBag, TradableObject[] object) {
		super();
		this.isSelected = isSelected;
		this.name = name;
		this.room = room;
		this.imgBag = imgBag;
		this.object = object;
	}


	public boolean isSelected() {
		return isSelected;
	}


	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String[][] getRoom() {
		return room;
	}


	public void setRoom(String[][] room) {
		this.room = room;
	}


	public Img getImgBag() {
		return imgBag;
	}


	public void setImgBag(Img imgBag) {
		this.imgBag = imgBag;
	}


	public TradableObject[] getObject() {
		return object;
	}


	public void setObject(TradableObject[] object) {
		this.object = object;
	}
}
