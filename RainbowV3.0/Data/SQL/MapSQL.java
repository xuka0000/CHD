package SQL;

import DataMask.MapMask;
import VerusSQL.*;
import jungleSQL.Jungle;

/**
 * ������е�ͼ��SQL
 */
public class MapSQL {

	public static MapMask[] MapSQL = {

			new MapMask("����˹����", Verus.VerusImg, Verus.VerusSdound, VerusNPC.verusNPC, VerusMonster.verusMonster, VerusObs.obsLeft, VerusObs.obsRight,VerusObs.obsBottom, VerusObs.ladder,VerusObs.rope, VerusPortal.portal, VerusSmallMap.VerusSmallMap, 0),
			new MapMask("����", Jungle.jungleImg, Jungle.jungleSound, VerusNPC.verusNPC, VerusMonster.verusMonster, VerusObs.obsLeft, VerusObs.obsRight,VerusObs.obsBottom, VerusObs.ladder,VerusObs.rope, VerusPortal.portal, VerusSmallMap.VerusSmallMap, 1),

	};

}
