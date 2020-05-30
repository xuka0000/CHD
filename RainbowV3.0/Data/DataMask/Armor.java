package DataMask;
/*
 * ·À¾ßÄ£°å
 */
public class Armor extends TradableObject {
private String type;
private int levelLimit;
private int addDefense;
private int addMaxHp ; 
private int addSpeed ; 
private int addJump ;
private int addCritical ;
private int addCriticalDamage ; 
private int probability ;
private String quality;





public Armor(String name, int number, long value, String description, Img[] img, Sound[] sound, String type, int levelLimit,
		int addDefense, int addMaxHp, int addSpeed, int addJump, int addCritical, int addCriticalDamage,
		int probability, String quality) {
	super(name, number, value, description, img, sound);
	this.type = type;
	this.levelLimit = levelLimit;
	this.addDefense = addDefense;
	this.addMaxHp = addMaxHp;
	this.addSpeed = addSpeed;
	this.addJump = addJump;
	this.addCritical = addCritical;
	this.addCriticalDamage = addCriticalDamage;
	this.probability = probability;
	this.quality = quality;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public int getLevelLimit() {
	return levelLimit;
}
public void setLevelLimit(int levelLimit) {
	this.levelLimit = levelLimit;
}
public int getAddDefense() {
	return addDefense;
}
public void setAddDefense(int addDefense) {
	this.addDefense = addDefense;
}
public int getAddMaxHp() {
	return addMaxHp;
}
public void setAddMaxHp(int addMaxHp) {
	this.addMaxHp = addMaxHp;
}
public int getAddSpeed() {
	return addSpeed;
}
public void setAddSpeed(int addSpeed) {
	this.addSpeed = addSpeed;
}
public int getAddJump() {
	return addJump;
}
public void setAddJump(int addJump) {
	this.addJump = addJump;
}
public int getAddCritical() {
	return addCritical;
}
public void setAddCritical(int addCritical) {
	this.addCritical = addCritical;
}
public int getAddCriticalDamage() {
	return addCriticalDamage;
}
public void setAddCriticalDamage(int addCriticalDamage) {
	this.addCriticalDamage = addCriticalDamage;
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
