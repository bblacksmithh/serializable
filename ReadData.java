import java.io.*;
import java.util.*;

public class ReadData {
	
	static ObjectInputStream ois;
	
	public static void openFile() {
		
		try {
			
		ois = new ObjectInputStream(new FileInputStream("people.ser"));
		}
		catch(IOException e) {
			
			System.out.println("Failed to open file...");
		}
	}
	
	public static void closeFile() {
		
		try {
			
			ois.close();
		}
		catch(IOException e) {
			
			System.out.println("Failed to close file...");
		}
	}
	
	
	public static void main(String[] args) {
		ReadData rd = new ReadData();
		Person[] people = new Person[10];
		int count = 0;
		
		openFile();
		
		try {
			
			while (true) {
				
				people[count++] = (Person) ois.readObject();
				System.out.println("Object " + count + " read from file...");
			}
		}
		catch (EOFException e) {
			
			System.out.println("End of file reached...");
		}
		catch (IOException e) {
			
			System.out.println("Problem reading from file...");
		}
		catch (Exception e) {
			
			System.out.println("Huge error");
		}
		
		Person[] tempPeople = Arrays.copyOf(people, count-1);
		
		for (Person person : tempPeople) {
			
			System.out.println(person.getName() + "\t" + person.getAge());
		}
		
		closeFile();
	}
}