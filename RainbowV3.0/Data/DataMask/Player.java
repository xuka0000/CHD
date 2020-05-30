package DataMask;
/**
 * Íæ¼ÒµÄÕËºÅ
 * @author ¿­¿­
 *
 */
public class Player {

	private String name ;
	private String ID ;
	private String Password ;
	private String Hero[];
	public Player(String name, String iD, String password, String[] hero) {
		super();
		this.name = name;
		ID = iD;
		Password = password;
		Hero = hero;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String[] getHero() {
		return Hero;
	}
	public void setHero(String[] hero) {
		Hero = hero;
	}
	
	
}
