import java.util.*;
import java.io.*;

public class TestPeople {
	
	static ObjectOutputStream oos;
	
	public static void openFile() {
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream("people.ser"));
		}
		catch (IOException e) {
			
			System.out.println("Failed to open file...");
		}
	}
	
	public static void closeFile() {
		
		try {
			
			oos.close();
		}
		catch (IOException e) {
			
			System.out.println("Failed to close file...");
		}
	}
	
	public static void main(String[] args) {
		
		String line, name, id;
		int age, count = 0;
		Person[] people = new Person[10];
		
		try {
			
			Scanner input = new Scanner(new File("people.txt"));
			
			while (input.hasNext()) {
				
				line = input.nextLine();
				String[] fields = line.split(",");
				
				name = fields[0];
				age = Integer.parseInt(fields[1]);
				id = fields[2];
				
				
				people[count++] = new Person(name, age, id);
			}
		}
		catch(IOException e) {
			
			System.out.println(e);
		}
		
		Person[] tempPeople = Arrays.copyOf(people, count);
		Arrays.sort(tempPeople);
		
		for (Person person : tempPeople) {
			
			System.out.println(person.toString());
			
		}
		
		openFile();
		for (int i = 0; i < count; i++) {
			
			try {
				
				oos.writeObject(tempPeople[i]);
				System.out.println("Object " + (i + 1) + " written to file...");
			}
			catch(IOException e) {
				
				System.out.println("Failed writing object to file...");
			}
		}
		closeFile();
	}
}