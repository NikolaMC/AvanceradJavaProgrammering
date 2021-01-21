package javaStreamsPackage;

public class MyObject {
	private boolean bool;
	private int value;
	private String name;
	
	public MyObject(boolean bool, int value, String name) { 
		setBool(bool);
		setValue(value);
		setName(name);
	}
	
	public String toString() {
		String returnObject = "[" + this.name + ", " + this.value + ", " + this.bool + "]";
		return returnObject;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public boolean getBool() {
		return this.bool;
	}
	
	public void setBool(boolean bool) {
		this.bool = bool;
	}
}
