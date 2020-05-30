package DataMask;
/**
 * µÕº∂ Ù–‘
 * @author ø≠ø≠
 *
 */
public class LowAbilityValue {

	private int level ;
	private int currHp ;
	private int maxHp ;
	private int minAttack ;
	private int maxAttack ;
	private int defense ;
	private int attackDistance ;
	private int critical ;
	private int criticalDamage ;
	
	
	
	
	public LowAbilityValue(int level, int currHp, int maxHp, int minAttack, int maxAttack, int defense,
			int attackDistance, int critical, int criticalDamage) {
		super();
		this.level = level;
		this.currHp = currHp;
		this.maxHp = maxHp;
		this.minAttack = minAttack;
		this.maxAttack = maxAttack;
		this.defense = defense;
		this.attackDistance = attackDistance;
		this.critical = critical;
		this.criticalDamage = criticalDamage;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getCurrHp() {
		return currHp;
	}
	public void setCurrHp(int currHp) {
		this.currHp = currHp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	public int getMinAttack() {
		return minAttack;
	}
	public void setMinAttack(int minAttack) {
		this.minAttack = minAttack;
	}
	public int getMaxAttack() {
		return maxAttack;
	}
	public void setMaxAttack(int maxAttack) {
		this.maxAttack = maxAttack;
	}
	public int getDefense() {
		return defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public int getAttackDistance() {
		return attackDistance;
	}
	public void setAttackDistance(int attackDistance) {
		this.attackDistance = attackDistance;
	}
	public int getCritical() {
		return critical;
	}
	public void setCritical(int critical) {
		this.critical = critical;
	}
	public int getCriticalDamage() {
		return criticalDamage;
	}
	public void setCriticalDamage(int criticalDamage) {
		this.criticalDamage = criticalDamage;
	}
	
	
}
