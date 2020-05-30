package DataMask;
/**
 * 교관
 * @author 열열
 *
 */
public class Bag {
	private boolean isOpened;
	private LittleBag[] littleBag;
	private int money;
	
	
	public Bag(boolean isOpened, LittleBag[] littleBag, int money) {
		super();
		this.isOpened = isOpened;
		this.littleBag = littleBag;
		this.money = money;
	}


	public boolean isOpened() {
		return isOpened;
	}


	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}


	public LittleBag[] getLittleBag() {
		return littleBag;
	}


	public void setLittleBag(LittleBag[] littleBag) {
		this.littleBag = littleBag;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}

}
