package SQL;

import DataMask.Bag;
import DataMask.LittleBag;

/**
 * �������ĵط�
 * @author ����
 *
 */
public class TempBag {

	public static LittleBag[] tempLitteBag = {
			new LittleBag(true, "װ��", null, null, null),
			new LittleBag(false, "����Ʒ", null, null, null),
			new LittleBag(false, "����", null, null, null),
			new LittleBag(false, "����", null, null, null),
			new LittleBag(false, "����", null, null, null),
	};
	
	public static Bag tempBag = new Bag(false, tempLitteBag, 0);
}
