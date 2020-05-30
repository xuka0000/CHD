package SQL;

import DataMask.MapMask;
import VerusSQL.*;
import jungleSQL.Jungle;

/**
 * 存放所有地图的SQL
 */
public class MapSQL {

	public static MapMask[] MapSQL = {

			new MapMask("贝罗斯城镇", Verus.VerusImg, Verus.VerusSdound, VerusNPC.verusNPC, VerusMonster.verusMonster, VerusObs.obsLeft, VerusObs.obsRight,VerusObs.obsBottom, VerusObs.ladder,VerusObs.rope, VerusPortal.portal, VerusSmallMap.VerusSmallMap, 0),
			new MapMask("丛林", Jungle.jungleImg, Jungle.jungleSound, VerusNPC.verusNPC, VerusMonster.verusMonster, VerusObs.obsLeft, VerusObs.obsRight,VerusObs.obsBottom, VerusObs.ladder,VerusObs.rope, VerusPortal.portal, VerusSmallMap.VerusSmallMap, 1),

	};

}
