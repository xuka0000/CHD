package DataMask;
/**
 * »ù´¡ÈËÎï
 * @author ¿­¿­
 *
 */
public class BasicPerson {
	private String name;
	private Action action[];
	private boolean isGravity ;


	public BasicPerson(String name, Action[] action, boolean isGravity) {
		super();
		this.name = name;
		this.action = action;
		this.isGravity = isGravity;
	}


	public boolean getIsGravity() {
		return isGravity;
	}


	public void setIsGravity(boolean isGravity) {
		this.isGravity = isGravity;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Action[] getAction() {
		return action;
	}
	public void setAction(Action[] action) {
		this.action = action;
	}

}
