package DataMask;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Img {

	private String name;
	private String picturePath;
	private int width;
	private int height;
	private int x;
	private int y;

@Override
public String toString() {
	return "Img [name=" + name + ", picturePath=" + picturePath + ", width=" + width + ", height=" + height + ", x=" + x
			+ ", y=" + y + "]";
}
public Img(String name, String picturePath, int width, int height, int x, int y) {
	super();
	this.name = name;
	this.picturePath = picturePath;
	this.width = width;
	this.height = height;
	this.x = x;
	this.y = y;
}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Image getPicturePath() {
		Image img=new ImageIcon(this.picturePath).getImage();
		return img;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
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
