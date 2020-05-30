package DataMask;
/**
 * 鼠标放置会变好看的特殊字幕
 * @author 凯凯
 *
 */
public class Choice extends Topic {

	private boolean isSelected ;
	private boolean isStayed ;
	private Img whiteBg;
	
	
	
	public Choice(String description, String name, String color, int x, int y, int size, boolean isSelected,
			boolean isStayed, Img whiteBg) {
		super(description, name, color, x, y, size);
		this.isSelected = isSelected;
		this.isStayed = isStayed;
		this.whiteBg = whiteBg;
	}
	public boolean isSelected() {
		return isSelected;
	}
	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}
	public boolean isStayed() {
		return isStayed;
	}
	public void setStayed(boolean isStayed) {
		this.isStayed = isStayed;
	}
	public Img getWhiteBg() {
		return whiteBg;
	}
	public void setWhiteBg(Img whiteBg) {
		this.whiteBg = whiteBg;
	}
	
	
	
}
