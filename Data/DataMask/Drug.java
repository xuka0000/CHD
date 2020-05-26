package DataMask;
/*
 * Ò©µÄÄ£°å
 */
public class Drug extends TradableObject {

	private String type;
	private int levelLimit ;
	private int addBlue ;
	private int addHp;
	private int cd ;
	private int lastTime;
	private int addCriticalDamege ;
	
	
	
	
	
	public Drug(String name, int number, long value, String description, Img[] img, Sound[] sound, String type,
			int levelLimit, int addBlue, int addHp, int cd, int lastTime, int addCriticalDamege) {
		super(name, number, value, description, img, sound);
		this.type = type;
		this.levelLimit = levelLimit;
		this.addBlue = addBlue;
		this.addHp = addHp;
		this.cd = cd;
		this.lastTime = lastTime;
		this.addCriticalDamege = addCriticalDamege;
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
	public int getAddBlue() {
		return addBlue;
	}
	public void setAddBlue(int addBlue) {
		this.addBlue = addBlue;
	}
	public int getAddHp() {
		return addHp;
	}
	public void setAddHp(int addHp) {
		this.addHp = addHp;
	}
	public int getCd() {
		return cd;
	}
	public void setCd(int cd) {
		this.cd = cd;
	}
	public int getLastTime() {
		return lastTime;
	}
	public void setLastTime(int lastTime) {
		this.lastTime = lastTime;
	}
	public int getAddCriticalDamege() {
		return addCriticalDamege;
	}
	public void setAddCriticalDamege(int addCriticalDamege) {
		this.addCriticalDamege = addCriticalDamege;
	}
	
	
}
