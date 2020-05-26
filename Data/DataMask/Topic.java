package DataMask;
/**
 * 单纯的聊天对话字幕
 * @author 凯凯
 *
 */
public class Topic {

	private String description ;
	private String name ;
	private String color ;
	private int x;
	private int y ;
	private int size ;
	
	
	
	public Topic(String description, String name, String color, int x, int y, int size) {
		super();
		this.description = description;
		this.name = name;
		this.color = color;
		this.x = x;
		this.y = y;
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	
}
