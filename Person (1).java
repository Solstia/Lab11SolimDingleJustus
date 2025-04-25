
public class Person implements Comparable<Person> {

	// Data members
	int age;
	String name;
	String address;
	int zipcode;
	double salary;
	
	// Default constructor
	public Person() {
	}
	
	// convenience Constructor
	public Person(int age, String name, String address, int zipcode, double salary) {
		setAge(age);
		setName(name);
		setAddress(address);
		setZipcode(zipcode);
		setSalary(salary);
	}
	
	// Accessor and Mutator Methods
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getZipcode() {
		return zipcode;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	// To String method
	@Override
	public String toString() {
		return String.format("%d %s %s %d %.2f", getAge(), getName(), getAddress(), getZipcode(), getSalary());
	}
	
	// Compare method
	public int compareTo(Person person) {
		if (this.getSalary() < person.getSalary()) {
			return -1;
		} else if (this.getSalary() > person.getSalary()) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
}
