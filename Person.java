import java.util.*;
import java.io.*;

public class Person implements Comparable<Person>, Serializable{
	
	private String name;
	private int age;
	private String ID;
	
	public Person() {
		
		this("", 0, "");
	}
	
	public Person(String name, int age, String ID) {
		
		setName(name);
		setAge(age);
		setID(ID);
	}
	
	public void setName(String name) {
		
		this.name = name;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setAge(int age) {
		
		this.age = age;
	}
	
	public int getAge() {
		
		return age;
	}
	
	public void setID(String ID) {
		
		this.ID = ID;
	}
	
	public String getID() {
		
		return ID;
	}
	
	@Override
	public int compareTo(Person other) {
		
		int thisField = getAge();
		int otherField = other.getAge();
		
		if (thisField < otherField)
			return - 1;
		else if (thisField > otherField)
			return 1;
		else
			return 0;
	}
	
	public String toString() {
		
		return "Person with Name: " + getName() + " and Age: " + getAge() + " with ID number: " + getID();
	}
}