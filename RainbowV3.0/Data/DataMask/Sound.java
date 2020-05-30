package DataMask;

public class Sound {
	private String name ;
	private String soundPath ;



	@Override
	public String toString() {
		return "Sound [name=" + name + ", soundPath=" + soundPath + "]";
	}

	public Sound(String name, String soundPath) {
		super();
		this.name = name;
		this.soundPath = soundPath;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSoundPath() {
		return soundPath;
	}
	public void setSoundPath(String soundPath) {
		this.soundPath = soundPath;
	}


}
