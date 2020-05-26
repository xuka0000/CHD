package DataMask;
/**
 * ³èÎïÄ£¾ß
 * @author ¿­¿­
 *
 */
public class Pet extends TradableObject{

    private String type;
    private Skill skill[];
    
    
    
	
	public Pet(String name, int number, long value, String description, Img[] img, Sound[] sound, String type,
			Skill[] skill) {
		super(name, number, value, description, img, sound);
		this.type = type;
		this.skill = skill;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Skill[] getSkill() {
		return skill;
	}
	public void setSkill(Skill[] skill) {
		this.skill = skill;
	}
    
    
}
