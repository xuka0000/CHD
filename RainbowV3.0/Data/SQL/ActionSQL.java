package SQL;

import DataMask.Action;
import DataMask.Sound;
import util.SoundPlayer;

/**
 * ���������
 * @author ����
 *
 */
public class ActionSQL {
	
	public static Action[] ActionSQL = {

			new Action("��վ��", false,ActionHeroImg.leftStand,null),
			new Action("��վ��", false,ActionHeroImg.rightStand,null),
			new Action("���ܲ�", false,ActionHeroImg.leftRun,null),
			new Action("���ܲ�", false,ActionHeroImg.rightRun,null),
			new Action("����Ծ", false,ActionHeroImg.leftJump, new Sound("��Ծ","Sound\\��.mp3")),
			new Action("����", false,ActionHeroImg.leftDown,null),
			new Action("����Ծ", false,ActionHeroImg.rightJump,null),
			new Action("�ҽ���", false,ActionHeroImg.rightDown,null),

	};

}
