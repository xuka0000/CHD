package DataMask;

public class Weapon extends TradableObject {
	private String type;
	private String profession ;
	private int levelLimit ;
	private int maxAddAttack ;
	private int minAddAttack ;
	private int addAttackDistance ;
	private int probability ;
	private String quality;



	public Weapon(String name, int number, long value, String description, Img[] img, Sound[] sound, String type,
			String profession, int levelLimit, int maxAddAttack, int minAddAttack, int addAttackDistance, int probability,
			String quality) {
		super(name, number, value, description, img, sound);
		this.type = type;
		this.profession = profession;
		this.levelLimit = levelLimit;
		this.maxAddAttack = maxAddAttack;
		this.minAddAttack = minAddAttack;
		this.addAttackDistance = addAttackDistance;
		this.probability = probability;
		this.quality = quality;
}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getLevelLimit() {
		return levelLimit;
	}
	public void setLevelLimit(int levelLimit) {
		this.levelLimit = levelLimit;
	}
	public int getMaxAddAttack() {
		return maxAddAttack;
	}
	public void setMaxAddAttack(int maxAddAttack) {
		this.maxAddAttack = maxAddAttack;
	}
	public int getMinAddAttack() {
		return minAddAttack;
	}
	public void setMinAddAttack(int minAddAttack) {
		this.minAddAttack = minAddAttack;
	}
	public int getAddAttackDistance() {
		return addAttackDistance;
	}
	public void setAddAttackDistance(int addAttackDistance) {
		this.addAttackDistance = addAttackDistance;
	}
	public int getProbability() {
		return probability;
	}
	public void setProbability(int probability) {
		this.probability = probability;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}



}
