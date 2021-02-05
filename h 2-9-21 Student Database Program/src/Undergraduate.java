
public class Undergraduate extends Student{
	int gradeLevel;
	
	Undergraduate(String name, int idNumber, int gradeLevel){
		super(name, idNumber);
		this.gradeLevel = gradeLevel;
	}
	
	void print() {
		super.print();
		System.out.print("Grade Level: ");
		if(gradeLevel == 1) System.out.println("Freshman");
		else if(gradeLevel == 2) System.out.println("Sophomore");
		else if(gradeLevel == 3) System.out.println("Junior");
		else System.out.println("Senior");
	}
	
	boolean equals(Undergraduate o) {
		if(this.gradeLevel == o.gradeLevel) return true;
		else return false;
	}
}
