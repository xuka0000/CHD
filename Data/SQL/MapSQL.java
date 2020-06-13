package SQL;

import DataMask.MapMask;
import VerusSQL.*;
import jungleSQL.*;
import snowfieldSQL.*;

/**
 * 存放所有地图的SQL
 */
public class MapSQL {

	public static MapMask[] MapSQL = {

			new MapMask("贝罗斯城镇", Verus.VerusImg, Verus.VerusSdound, VerusNPC.verusNPC, VerusMonster.verusMonster, VerusObs.obsLeft, VerusObs.obsRight,VerusObs.obsBottom, VerusObs.ladder,VerusObs.rope, VerusPortal.portal,VerusObs.leftHill,VerusObs.rightHill, VerusSmallMap.VerusSmallMap, 0),
			new MapMask("丛林", Jungle.jungleImg, Jungle.jungleSound, VerusNPC.verusNPC, VerusMonster.verusMonster, JungleObs.obsLeft, JungleObs.obsRight, JungleObs.obsBottom, JungleObs.ladder,JungleObs.rope, JunglePortal.portal,JungleObs.leftHill,JungleObs.rightHill, VerusSmallMap.VerusSmallMap, 1),
			new MapMask("雪地", snowfield.snowImg, snowfield.jungleSound, VerusNPC.verusNPC, VerusMonster.verusMonster, snowfieldObs.obsLeft, snowfieldObs.obsRight, snowfieldObs.obsBottom,snowfieldObs.ladder,snowfieldObs.rope,snowfieldPortal.portal,snowfieldObs.leftHill,snowfieldObs.rightHill, VerusSmallMap.VerusSmallMap, 2),

	};

}
