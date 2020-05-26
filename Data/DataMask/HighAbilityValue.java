package DataMask;
/**
 * ∏ﬂº∂ Ù–‘
 * @author ø≠ø≠
 *
 */
public class HighAbilityValue extends LowAbilityValue {

	private int currExp ;
	private int maxExp ;
	private int power ;
	private int physicalStength ;
	private int Endurance ;
	private int currBlue ;
	private int maxBlue ;
	private int magic ;
	
	
	
	public HighAbilityValue(int level, int currHp, int maxHp, int minAttack, int maxAttack, int defense,
			int attackDistance, int critical, int criticalDamage, int currExp, int maxExp, int power,
			int physicalStength, int endurance, int currBlue, int maxBlue, int magic) {
		super(level, currHp, maxHp, minAttack, maxAttack, defense, attackDistance, critical, criticalDamage);
		this.currExp = currExp;
		this.maxExp = maxExp;
		this.power = power;
		this.physicalStength = physicalStength;
		Endurance = endurance;
		this.currBlue = currBlue;
		this.maxBlue = maxBlue;
		this.magic = magic;
	}
	public int getCurrExp() {
		return currExp;
	}
	public void setCurrExp(int currExp) {
		this.currExp = currExp;
	}
	public int getMaxExp() {
		return maxExp;
	}
	public void setMaxExp(int maxExp) {
		this.maxExp = maxExp;
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public int getPhysicalStength() {
		return physicalStength;
	}
	public void setPhysicalStength(int physicalStength) {
		this.physicalStength = physicalStength;
	}
	public int getEndurance() {
		return Endurance;
	}
	public void setEndurance(int endurance) {
		Endurance = endurance;
	}
	public int getCurrBlue() {
		return currBlue;
	}
	public void setCurrBlue(int currBlue) {
		this.currBlue = currBlue;
	}
	public int getMaxBlue() {
		return maxBlue;
	}
	public void setMaxBlue(int maxBlue) {
		this.maxBlue = maxBlue;
	}
	public int getMagic() {
		return magic;
	}
	public void setMagic(int magic) {
		this.magic = magic;
	}
	
	
}
