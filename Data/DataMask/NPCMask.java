package DataMask;
/**
 * NPC
 * @author
 *
 */
public class NPCMask extends BasicPerson{
	private Bag bag;
	private Task task[];
	private boolean isPressed;
	private Img talkImg[];
	private Topic topic[];
	private Choice Choice[];
	private boolean isClicked;
	//NPC的XY
	private int x;
	private int y;






	public NPCMask(String name, Action[] action, boolean isGravity, Bag bag, Task[] task, boolean isPressed, Img[] talkImg,
			Topic[] topic, DataMask.Choice[] choice, boolean isClicked, int x, int y) {
		super(name, action, isGravity);
		this.bag = bag;
		this.task = task;
		this.isPressed = isPressed;
		this.talkImg = talkImg;
		this.topic = topic;
		Choice = choice;
		this.isClicked = isClicked;
		this.x = x;
		this.y = y;
	}


	public Bag getBag() {
		return bag;
	}


	public void setBag(Bag bag) {
		this.bag = bag;
	}


	public Task[] getTask() {
		return task;
	}


	public void setTask(Task[] task) {
		this.task = task;
	}


	public boolean isPressed() {
		return isPressed;
	}


	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}


	public Img[] getTalkImg() {
		return talkImg;
	}


	public void setTalkImg(Img[] talkImg) {
		this.talkImg = talkImg;
	}


	public Topic[] getTopic() {
		return topic;
	}


	public void setTopic(Topic[] topic) {
		this.topic = topic;
	}


	public Choice[] getChoice() {
		return Choice;
	}


	public void setChoice(Choice[] choice) {
		Choice = choice;
	}


	public boolean isClicked() {
		return isClicked;
	}


	public void setClicked(boolean isClicked) {
		this.isClicked = isClicked;
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
}
