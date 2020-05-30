package SQL;

import DataMask.Action;
import DataMask.Sound;
import util.SoundPlayer;

/**
 * ÈÎÎñ¶¯×÷¿â´æ
 * @author ¿­¿­
 *
 */
public class ActionSQL {
	
	public static Action[] ActionSQL = {

			new Action("×óÕ¾Á¢", false,ActionHeroImg.leftStand,null),
			new Action("ÓÒÕ¾Á¢", false,ActionHeroImg.rightStand,null),
			new Action("×óÅÜ²½", false,ActionHeroImg.leftRun,null),
			new Action("ÓÒÅÜ²½", false,ActionHeroImg.rightRun,null),
			new Action("×óÌøÔ¾", false,ActionHeroImg.leftJump, new Sound("ÌøÔ¾","Sound\\Ìø.mp3")),
			new Action("×ó½µÂä", false,ActionHeroImg.leftDown,null),
			new Action("ÓÒÌøÔ¾", false,ActionHeroImg.rightJump,null),
			new Action("ÓÒ½µÂä", false,ActionHeroImg.rightDown,null),

	};

}
