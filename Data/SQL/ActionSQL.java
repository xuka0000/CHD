package SQL;

import DataMask.Action;
import DataMask.Sound;
import util.SoundPlayer;

/**
 * 任务动作库存
 * @author 凯凯
 *
 */
public class ActionSQL {

	public static Action[] ActionSQL = {

			new Action("左站立", false,ActionHeroImg.leftStand,null),
			new Action("右站立", false,ActionHeroImg.rightStand,null),
			new Action("左跑步", false,ActionHeroImg.leftRun,null),
			new Action("右跑步", false,ActionHeroImg.rightRun,null),
			new Action("左跳跃", false,ActionHeroImg.leftJump, new Sound("跳跃","Sound\\跳.mp3")),
			new Action("左降落", false,ActionHeroImg.leftDown,null),
			new Action("右跳跃", false,ActionHeroImg.rightJump,null),
			new Action("右降落", false,ActionHeroImg.rightDown,null),

	};

}
