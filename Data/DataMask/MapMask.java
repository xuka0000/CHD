package DataMask;
/**
 * 地图的属性
 * @author OUT
 *
 */
public class MapMask {

	private String name ;
	private Img img[];
	private Sound sound ;
	private NPCMask NPC[];
	private MonsterMask monster[];
	private Obstruction obsLeft[];
	private Obstruction obsRight[];
	private Obstruction obsBottom[];
	private Obstruction ladder[];
	private Obstruction rope[];
	private PortalMask portal[];
	private hill[] leftHill ;
	private hill[] rightHill ;
	private Img smallMapMask[];
	private int id;

	public MapMask(String name, Img[] img, Sound sound, NPCMask[] NPC, MonsterMask[] monster, Obstruction[] obsLeft, Obstruction[] obsRight, Obstruction[] obsBottom, Obstruction[] ladder, Obstruction[] rope, PortalMask[] portal, hill[] leftHill, hill[] rightHill, Img[] smallMapMask, int id) {
		this.name = name;
		this.img = img;
		this.sound = sound;
		this.NPC = NPC;
		this.monster = monster;
		this.obsLeft = obsLeft;
		this.obsRight = obsRight;
		this.obsBottom = obsBottom;
		this.ladder = ladder;
		this.rope = rope;
		this.portal = portal;
		this.leftHill = leftHill;
		this.rightHill = rightHill;
		this.smallMapMask = smallMapMask;
		this.id = id;
	}

	public void setLeftHill(hill[] leftHill) {
		this.leftHill = leftHill;
	}

	public void setRightHill(hill[] rightHill) {
		this.rightHill = rightHill;
	}

	public hill[] getLeftHill() {
		return leftHill;
	}

	public hill[] getRightHill() {
		return rightHill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Img[] getImg() {
		return img;
	}

	public void setImg(Img[] img) {
		this.img = img;
	}

	public Sound getSound() {
		return sound;
	}

	public void setSound(Sound sound) {
		this.sound = sound;
	}

	public NPCMask[] getNPC() {
		return NPC;
	}

	public void setNPC(NPCMask[] NPC) {
		this.NPC = NPC;
	}

	public MonsterMask[] getMonster() {
		return monster;
	}

	public void setMonster(MonsterMask[] monster) {
		this.monster = monster;
	}

	public Obstruction[] getObsLeft() {
		return obsLeft;
	}

	public void setObsLeft(Obstruction[] obsLeft) {
		this.obsLeft = obsLeft;
	}

	public Obstruction[] getObsRight() {
		return obsRight;
	}

	public void setObsRight(Obstruction[] obsRight) {
		this.obsRight = obsRight;
	}

	public Obstruction[] getObsBottom() {
		return obsBottom;
	}

	public void setObsBottom(Obstruction[] obsBottom) {
		this.obsBottom = obsBottom;
	}

	public Obstruction[] getLadder() {
		return ladder;
	}

	public void setLadder(Obstruction[] ladder) {
		this.ladder = ladder;
	}

	public Obstruction[] getRope() {
		return rope;
	}

	public void setRope(Obstruction[] rope) {
		this.rope = rope;
	}

	public PortalMask[] getPortal() {
		return portal;
	}

	public void setPortal(PortalMask[] portal) {
		this.portal = portal;
	}

	public Img[] getSmallMapMask() {
		return smallMapMask;
	}

	public void setSmallMapMask(Img[] smallMapMask) {
		this.smallMapMask = smallMapMask;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
