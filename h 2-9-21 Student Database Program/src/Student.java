
public class Student extends Person{
	int idNumber;
	
	Student(String name, int idNumber){
		super(name);
		this.idNumber = idNumber;
	}
	
	void print() {
		super.print();
		System.out.println("Student ID number: " + idNumber);
	}
}
