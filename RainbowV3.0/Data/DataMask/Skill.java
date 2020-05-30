package DataMask;

public class Skill {

	private String name;
	private int skillPoint ;
	private int maxSkillPoint ;
	
	
	
	

	public Skill(String name, int skillPoint, int maxSkillPoint) {
		super();
		this.name = name;
		this.skillPoint = skillPoint;
		this.maxSkillPoint = maxSkillPoint;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSkillPoint() {
		return skillPoint;
	}
	public void setSkillPoint(int skillPoint) {
		this.skillPoint = skillPoint;
	}
	public int getMaxSkillPoint() {
		return maxSkillPoint;
	}
	public void setMaxSkillPoint(int maxSkillPoint) {
		this.maxSkillPoint = maxSkillPoint;
	}
	
	
}
