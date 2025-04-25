import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

/**
* File: Lab11Prob3.java
 Class: CSCI 1302 
* Author:  Batuhan Solium, Elizabeth Justus, Parker Dingle
* Description: Reads serializable data from an binary IO file to the console and into an arraylist, sorts them, and prints them back out to a new file.
* Created on Apr 25, 2025
* Last Modified: Apr 25, 2025
*/

public class Lab11Prob03 {
	public static void main(String[] args) {
		
		// Data members
		int age;
		String name;
		String address;
		int zipcode;
		double salary;
		
		// Init arraylist.

		ArrayList<Person> list = new ArrayList<>();
		
		// Try catch block to read data into array.
		try (DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"))) {
			while (true) {
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipcode = input.readInt();
				salary = input.readDouble();
				
				list.add(new Person(age, name, address, zipcode, salary));
				
			}
		} catch (EOFException ex) {
			
		} catch (FileNotFoundException ex) {
			System.out.println("file not found");
		} catch (Exception ex) {
			System.out.println("error");
		}
		
		// Sort array
		java.util.Collections.sort(list);
		
		// Print info abput each object in the array.
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		// Try catch block to print sorted array to binary IO file.
		try (DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-salary-stored-objects.dat"))) {
			
			for (int i = 0; i < list.size(); i++) {
				output.writeInt(list.get(i).getAge());
				output.writeUTF(list.get(i).getName());
				output.writeUTF(list.get(i).getAddress());
				output.writeInt(list.get(i).getZipcode());
				output.writeDouble(list.get(i).getSalary());
			}
			
		} catch (FileNotFoundException ex) {
			System.out.println("file not found");
		} catch (Exception ex) {
			System.out.println("error");
		}
		
	}
}
