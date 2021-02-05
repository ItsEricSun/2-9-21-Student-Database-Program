
public class GraduateStudent extends Student{
	String major;
	
	GraduateStudent(String name, int idNumber, String major){
		super(name, idNumber);
		this.major = major;
	}
	
	void print() {
		super.print();
		System.out.println("Major: " + major);
	}
	
	boolean equals(GraduateStudent o) {
		if(this.major.equals(o.major)) return true;
		else return false;
	}
}
