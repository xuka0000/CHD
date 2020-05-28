package SQL;

import DataMask.MapMask;
import VerusSQL.*;

/**
 * 存放所有地图的SQL
 */
public class MapSQL {

	public static MapMask[] MapSQL = {

			new MapMask("贝罗斯城镇", Verus.VerusImg, Verus.VerusSdound, VerusNPC.verusNPC, VerusMonster.verusMonster, VerusObs.obsLeft, VerusObs.obsRight,VerusObs.obsBottom, VerusObs.ladder,VerusObs.rope, VerusPortal.portal, VerusSmallMap.VerusSmallMap, 0),
			new MapMask("2223", Verus.VerusImg1, Verus.VerusSdound, VerusNPC.verusNPC, VerusMonster.verusMonster, VerusObs.obsLeft, VerusObs.obsRight,VerusObs.obsBottom, VerusObs.ladder,VerusObs.rope, VerusPortal.portal, VerusSmallMap.VerusSmallMap, 1),

	};

}
