# serializable
Development

a Java project

This project focusses on reading from a text file, sorting the objects, writing an object to a .ser file and then reading those objects from the .ser file.

I started this project by creating a Person class with attributes: name, age, and ID, with a constructor and getters & setters for the object,
and adding a compareTo method to compare people's ages with one another.

Then the TestPeople class goes and creates a people.ser file to store the serialized object into. A text file is then read using a scanner, which
creates object according to the People class inside of an array. The array is then sorted according to age and then written to the people.ser file.

The ReadData class then opens the serializable file, reads the objects within the people.ser file and then displays them in the console sorted according to the people's age.