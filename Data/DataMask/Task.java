package DataMask;
/**
 * ÈÎÎñ
 * @author ¿­¿­
 *
 */
public class Task {
	private String name;
	private String description;
	private int getMoney;
	private TradableObject getTradableObject[];
	private int getExp;
	
	
	public Task(String name, String description, int getMoney, TradableObject[] getTradableObject, int getExp) {
		super();
		this.name = name;
		this.description = description;
		this.getMoney = getMoney;
		this.getTradableObject = getTradableObject;
		this.getExp = getExp;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getGetMoney() {
		return getMoney;
	}


	public void setGetMoney(int getMoney) {
		this.getMoney = getMoney;
	}


	public TradableObject[] getGetTradableObject() {
		return getTradableObject;
	}


	public void setGetTradableObject(TradableObject[] getTradableObject) {
		this.getTradableObject = getTradableObject;
	}


	public int getGetExp() {
		return getExp;
	}


	public void setGetExp(int getExp) {
		this.getExp = getExp;
	}
}
