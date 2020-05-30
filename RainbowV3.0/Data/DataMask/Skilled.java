package DataMask;

public class Skilled extends Skill {

	private Img img;
	private int addMaxAttack ;
	private int addCritical ;
	private int addCriticalDamage ;
	private int addMaxHp;
	
	
	
	public Skilled(String name, int skillPoint, int maxSkillPoint, Img img, int addMaxAttack, int addCritical,
			int addCriticalDamage, int addMaxHp) {
		super(name, skillPoint, maxSkillPoint);
		this.img = img;
		this.addMaxAttack = addMaxAttack;
		this.addCritical = addCritical;
		this.addCriticalDamage = addCriticalDamage;
		this.addMaxHp = addMaxHp;
	}
	public Img getImg() {
		return img;
	}
	public void setImg(Img img) {
		this.img = img;
	}
	public int getAddMaxAttack() {
		return addMaxAttack;
	}
	public void setAddMaxAttack(int addMaxAttack) {
		this.addMaxAttack = addMaxAttack;
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
	public int getAddMaxHp() {
		return addMaxHp;
	}
	public void setAddMaxHp(int addMaxHp) {
		this.addMaxHp = addMaxHp;
	}
	
	
}
