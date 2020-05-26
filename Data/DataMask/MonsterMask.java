package DataMask;
/**
 * π÷ŒÔ
 * @author ø≠ø≠
 *
 */
public class MonsterMask extends BasicPerson {
	private int getMoney;
	private int getExp;
	private TradableObject tradableObject[];
	private Skill skill[];
	private LowAbilityValue abilityValue;
	private Move move;
	private int setX ;
	private int serY ;
	private int MoveRange ;
	

	public MonsterMask(String name, Action[] action, boolean isGravity, int getMoney, int getExp,
			TradableObject[] tradableObject, Skill[] skill, LowAbilityValue abilityValue, Move move, int setX, int serY,
			int moveRange) {
		super(name, action, isGravity);
		this.getMoney = getMoney;
		this.getExp = getExp;
		this.tradableObject = tradableObject;
		this.skill = skill;
		this.abilityValue = abilityValue;
		this.move = move;
		this.setX = setX;
		this.serY = serY;
		MoveRange = moveRange;
	}


	public int getSetX() {
		return setX;
	}


	public void setSetX(int setX) {
		this.setX = setX;
	}


	public int getSerY() {
		return serY;
	}


	public void setSerY(int serY) {
		this.serY = serY;
	}


	public int getMoveRange() {
		return MoveRange;
	}


	public void setMoveRange(int moveRange) {
		MoveRange = moveRange;
	}


	public int getGetMoney() {
		return getMoney;
	}


	public void setGetMoney(int getMoney) {
		this.getMoney = getMoney;
	}


	public int getGetExp() {
		return getExp;
	}


	public void setGetExp(int getExp) {
		this.getExp = getExp;
	}


	public TradableObject[] getTradableObject() {
		return tradableObject;
	}


	public void setTradableObject(TradableObject[] tradableObject) {
		this.tradableObject = tradableObject;
	}


	public Skill[] getSkill() {
		return skill;
	}


	public void setSkill(Skill[] skill) {
		this.skill = skill;
	}


	public LowAbilityValue getAbilityValue() {
		return abilityValue;
	}


	public void setAbilityValue(LowAbilityValue abilityValue) {
		this.abilityValue = abilityValue;
	}


	public Move getMove() {
		return move;
	}


	public void setMove(Move move) {
		this.move = move;
	}


}
