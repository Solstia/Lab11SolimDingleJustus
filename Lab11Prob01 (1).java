import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
* File: Lab11Prob1.java
* Class: CSCI 1302 
* Author:  Batuhan Solium, Elizabeth Justus, Parker Dingle
* Description: Reads data from a file, then outputs the copy to a new file.
* Created on Apr 25, 2025
* Last Modified: Apr 25, 2025
*/

public class Lab11Prob01 {
	public static void main(String[] args) {
		
		// Data members
		int age;
		String name;
		String address;
		int zipcode;
		double salary;
		
		// Try catch block to deal with any exceptions
		try (
				DataInputStream input = new DataInputStream(new FileInputStream("src/people.dat"));
				DataOutputStream output = new DataOutputStream(new FileOutputStream("src/people-copy.dat"));
				) {
			while (true) {
				// Read data from file
				age = input.readInt();
				name = input.readUTF();
				address = input.readUTF();
				zipcode = input.readInt();
				salary = input.readDouble();
				
				// Print data to console
				System.out.printf("%d %s %s %d %.2f\n", age, name, address, zipcode, salary);
				
				// Print data to file
				output.writeInt(age);
				output.writeUTF(name);
				output.writeUTF(address);
				output.writeInt(zipcode);
				output.writeDouble(salary);
				
			}
		// Exception handling.
		} catch (EOFException ex) {
			
		} catch (FileNotFoundException ex) {
			System.out.println("file not found");
		} catch (Exception ex) {
			System.out.println("error");
		}
	}
}
