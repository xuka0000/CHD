package DataMask;
/**
 * ‘”ªı
 * @author ø≠ø≠
 *
 */
public class NormalTrade extends TradableObject {

	private String type;
	private int probability ;
	
	
	
	public NormalTrade(String name, int number, long value, String description, Img[] img, Sound[] sound, String type,
			int probability) {
		super(name, number, value, description, img, sound);
		this.type = type;
		this.probability = probability;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getProbability() {
		return probability;
	}
	public void setProbability(int probability) {
		this.probability = probability;
	}
	
	
}
