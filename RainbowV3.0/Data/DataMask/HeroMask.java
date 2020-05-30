package DataMask;

public class HeroMask extends BasicPerson{
	private int mapId;
	private String profession;
	private int setX;
	private int setY;
	private Bag bag;
	private Equipment equipment;
	private Equipment fashionEquipment;
	private HighAbilityValue abilityValue;
	private Move move;
	
	private Skill skill[];
	
	
	public HeroMask(String name, Action[] action, boolean isGravity, int mapId, String profession, int setX, int setY,
			Bag bag, Equipment equipment, Equipment fashionEquipment, HighAbilityValue abilityValue, Move move,
			Skill[] skill) {
		super(name, action, isGravity);
		this.mapId = mapId;
		this.profession = profession;
		this.setX = setX;
		this.setY = setY;
		this.bag = bag;
		this.equipment = equipment;
		this.fashionEquipment = fashionEquipment;
		this.abilityValue = abilityValue;
		this.move = move;
		this.skill = skill;
	}
	public int getMapId() {
		return mapId;
	}
	public void setMapId(int mapId) {
		this.mapId = mapId;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public int getSetX() {
		return setX;
	}
	public void setSetX(int setX) {
		this.setX = setX;
	}
	public int getSetY() {
		return setY;
	}
	public void setSetY(int setY) {
		this.setY = setY;
	}
	public Bag getBag() {
		return bag;
	}
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	public Equipment getEquipment() {
		return equipment;
	}
	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}
	public Equipment getFashionEquipment() {
		return fashionEquipment;
	}
	public void setFashionEquipment(Equipment fashionEquipment) {
		this.fashionEquipment = fashionEquipment;
	}
	public HighAbilityValue getAbilityValue() {
		return abilityValue;
	}
	public void setAbilityValue(HighAbilityValue abilityValue) {
		this.abilityValue = abilityValue;
	}
	public Move getMove() {
		return move;
	}
	public void setMove(Move move) {
		this.move = move;
	}

	public Skill[] getSkill() {
		return skill;
	}
	public void setSkill(Skill[] skill) {
		this.skill = skill;
	}
}
