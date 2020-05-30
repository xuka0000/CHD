package DataMask;
/**
 * 任务商品
 * @author 凯凯
 *
 */
public class TaskGoods extends TradableObject {

	private String type;
	private int probability;
	
	
	
	public TaskGoods(String name, int number, long value, String description, Img[] img, Sound[] sound, String type,
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
