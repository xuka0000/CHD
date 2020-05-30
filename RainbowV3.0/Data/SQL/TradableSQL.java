package SQL;

import DataMask.Armor;
import DataMask.Pet;
import DataMask.Weapon;
import TradableList.WeaponImg;

/**
 * 1----武器
 * @author 凯凯
 *
 */
public class TradableSQL {

	public static Weapon[] soldierWeapon = {
			new Weapon("长毛", 1, 480, "战斗物品---枪", WeaponImg.Spear, SoundList.WeaponSound.SpearSound, "装备", "战士", 4, 22, 18, 150,20, "普通"),
			
	};
	
	public static Weapon[] fashionSpear = {
			new Weapon(null, 0, 0, null, null, null, null, null, 0, 0, 0, 0, 0, null)
	};
	
	public static Weapon[] rangerWeapon = {
			
	};
	
	public static Armor[] armor = {
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
	};
	
	public static Armor[] fashionArmor = {
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
			new Armor(null, 0, 0, null, null, null, null, 0, 0, 0, 0, 0, 0, 0, 0, null),
	};
	
	public static Pet[] pet = {
			new Pet(null, 0, 0, null, null, null, null, null)
	};
	
	public static Weapon[] WeaponSQL = {
			new Weapon(null, 0, 0, null, null, null, null, null, 0, 0, 0, 0, 0, null),
	};
}
