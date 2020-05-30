package DataMask;

public class Skilling extends Skill {

	private Img img;
	private Sound sound ;
	private int attackDistance ;
	private int blueNeeded ;
	private int addMaxDamage ;
    private int addMinDamage ;
	private int addNumber ;
	private String weaponLimited ;
	private int continue_time ;
	private int trigger_time ;
	
	
	
	
	public Skilling(String name, int skillPoint, int maxSkillPoint, Img img, Sound sound, int attackDistance,
			int blueNeeded, int addMaxDamage, int addMinDamage, int addNumber, String weaponLimited, int continue_time,
			int trigger_time) {
		super(name, skillPoint, maxSkillPoint);
		this.img = img;
		this.sound = sound;
		this.attackDistance = attackDistance;
		this.blueNeeded = blueNeeded;
		this.addMaxDamage = addMaxDamage;
		this.addMinDamage = addMinDamage;
		this.addNumber = addNumber;
		this.weaponLimited = weaponLimited;
		this.continue_time = continue_time;
		this.trigger_time = trigger_time;
	}
	public int getContinue_time() {
		return continue_time;
	}
	public void setContinue_time(int continue_time) {
		this.continue_time = continue_time;
	}
	public int getTrigger_time() {
		return trigger_time;
	}
	public void setTrigger_time(int trigger_time) {
		this.trigger_time = trigger_time;
	}
	public Img getImg() {
		return img;
	}
	public void setImg(Img img) {
		this.img = img;
	}
	public Sound getSound() {
		return sound;
	}
	public void setSound(Sound sound) {
		this.sound = sound;
	}
	public int getAttackDistance() {
		return attackDistance;
	}
	public void setAttackDistance(int attackDistance) {
		this.attackDistance = attackDistance;
	}
	public int getBlueNeeded() {
		return blueNeeded;
	}
	public void setBlueNeeded(int blueNeeded) {
		this.blueNeeded = blueNeeded;
	}
	public int getAddMaxDamage() {
		return addMaxDamage;
	}
	public void setAddMaxDamage(int addMaxDamage) {
		this.addMaxDamage = addMaxDamage;
	}
	public int getAddMinDamage() {
		return addMinDamage;
	}
	public void setAddMinDamage(int addMinDamage) {
		this.addMinDamage = addMinDamage;
	}
	public int getAddNumber() {
		return addNumber;
	}
	public void setAddNumber(int addNumber) {
		this.addNumber = addNumber;
	}
	public String getWeaponLimited() {
		return weaponLimited;
	}
	public void setWeaponLimited(String weaponLimited) {
		this.weaponLimited = weaponLimited;
	}
	
	
}
