
public class Person implements Comparable<Person>{
	String name;
	
	Person(String name){
		this.name = name;
	}
	
	void print() {
		System.out.println("\nName: " + name);
	}

	@Override
	public int compareTo(Person p2) {
		if(this.getClass().equals(p2.getClass())) {
			return this.name.compareTo(p2.name);
		}
		else {
			if(this.getClass() == Person.class) {
				return -1;
			} else if(this.getClass() == GraduateStudent.class) {
				return 1;
			} else if(this.getClass() == Student.class){
				if(p2.getClass() == Person.class) {
					return 1;
				} else {
					return -1;
				}
				
			} else {
				if(p2.getClass() == GraduateStudent.class) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}
}
