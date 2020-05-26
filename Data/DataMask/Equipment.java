package DataMask;
/**
 * 穿上的装备
 * @author 凯凯
 *
 */
public class Equipment {
	private Weapon weapon;
	private Armor cap;
	private Armor cloth;
	private Armor pants;
	private Armor shoes;
	private Armor glove;
	private Pet pet;
	
	
	public Equipment(Weapon weapon, Armor cap, Armor cloth, Armor pants, Armor shoes, Armor glove, Pet pet) {
		super();
		this.weapon = weapon;
		this.cap = cap;
		this.cloth = cloth;
		this.pants = pants;
		this.shoes = shoes;
		this.glove = glove;
		this.pet = pet;
	}


	public Weapon getWeapon() {
		return weapon;
	}


	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}


	public Armor getCap() {
		return cap;
	}


	public void setCap(Armor cap) {
		this.cap = cap;
	}


	public Armor getCloth() {
		return cloth;
	}


	public void setCloth(Armor cloth) {
		this.cloth = cloth;
	}


	public Armor getPants() {
		return pants;
	}


	public void setPants(Armor pants) {
		this.pants = pants;
	}


	public Armor getShoes() {
		return shoes;
	}


	public void setShoes(Armor shoes) {
		this.shoes = shoes;
	}


	public Armor getGlove() {
		return glove;
	}


	public void setGlove(Armor glove) {
		this.glove = glove;
	}


	public Pet getPet() {
		return pet;
	}


	public void setPet(Pet pet) {
		this.pet = pet;
	}
}
