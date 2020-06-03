package SQL;

import DataMask.*;

/**
 * 冒险家库
 * @author 凯凯
 *
 */
public class HeroSQL {

	public static Equipment equipment = new Equipment(SQL.TradableSQL.WeaponSQL[0], SQL.TradableSQL.armor[0], SQL.TradableSQL.armor[1], SQL.TradableSQL.armor[2], SQL.TradableSQL.armor[3], SQL.TradableSQL.armor[4],SQL.TradableSQL.pet[0]);
	public static Equipment fashionEquipment = new Equipment(SQL.TradableSQL.WeaponSQL[0], SQL.TradableSQL.fashionArmor[0], SQL.TradableSQL.fashionArmor[1], SQL.TradableSQL.fashionArmor[2], SQL.TradableSQL.fashionArmor[3], SQL.TradableSQL.fashionArmor[4], SQL.TradableSQL.pet[0]);
	public static Skill[] skill ={

	};
	/**
	 * 英雄的移动
	 */
	public static Move[] move = {
			new Move(400, 300, 5, 5, 1, 1, 1)

	};
	/**
	 * 英雄全局属性
	 */
	public static HighAbilityValue[] abilityValue = {
			new HighAbilityValue(0, 80, 100, 20, 30, 10, 100, 20, 40, 0, 100, 20, 20, 20, 20, 100, 20)
	};


	public static HeroMask[] soldier = {
			new HeroMask("无名氏1", ActionSQL.ActionSQL, false, 0, "战士", 400, 750, SQL.TempBag.tempBag, equipment, fashionEquipment, abilityValue[0], move[0], skill),
			new HeroMask("无名氏1", ActionSQL.ActionSQL, false, 0, "战士", 400, 750, SQL.TempBag.tempBag, equipment, fashionEquipment, abilityValue[0], move[0], skill),
	};

	public static HeroMask[] Ranger = {
			new HeroMask("无名氏", ActionSQL.ActionSQL, false, 0, "战士", 400, 750, SQL.TempBag.tempBag, equipment, fashionEquipment, null, null, null),
	};
}
