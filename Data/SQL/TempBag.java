package SQL;

import DataMask.Bag;
import DataMask.LittleBag;

/**
 * 存放书包的地方
 * @author 凯凯
 *
 */
public class TempBag {

	public static LittleBag[] tempLitteBag = {
			new LittleBag(true, "装备", null, null, null),
			new LittleBag(false, "消耗品", null, null, null),
			new LittleBag(false, "其他", null, null, null),
			new LittleBag(false, "任务", null, null, null),
			new LittleBag(false, "宠物", null, null, null),
	};
	
	public static Bag tempBag = new Bag(false, tempLitteBag, 0);
}
