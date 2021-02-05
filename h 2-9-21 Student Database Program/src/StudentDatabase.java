import java.util.*;

public class StudentDatabase {
	static Person[] array;
	static Scanner sc;
	static PersonsComparator pc;
	
	public static void main(String[] args) throws InputMismatchException {
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("How long should the array be? (Min size of 1 and Max size of 10)");
				int length = sc.nextInt();
				if(length < 1 || length > 10) {
					System.out.println("Make sure input is between 1 and 10");
					continue;
				}
				array = new Person[length];
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		
		for(int i = 0; i < array.length; i++) {
			while(true) {
				sc = new Scanner(System.in);
				try {
					System.out.println("Enter in number for the corresponding option");
					System.out.println("1. Person");
					System.out.println("2. Student");
					System.out.println("3. Undergraduate");
					System.out.println("4. Graduate Student");
					int option = sc.nextInt();
					if(option < 1 || option > 4) {
						System.out.println("Make sure input is between 1 and 4");
						continue;
					}
					if(option == 1) inputPerson(i);
					else if(option == 2) inputStudent(i);
					else if(option == 3) inputUndergraduate(i);
				    else inputGraduateStudent(i);	
					break;
				} catch (InputMismatchException e) {
					System.out.println("Make sure input is a number");
				}
			}
		}
	
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("\nEnter in number for the corresponding option");
				System.out.println("1. Print all Persons");
				System.out.println("2. Print all Students");
				System.out.println("3. Print all Undergraduates");
				System.out.println("4. Print all Graduate Students");
				System.out.println("5. Input a Undergraduate or GraduateStudent and print those "
						+ "Persons already in the array that are equal to the given object");
				System.out.println("6. Print all Persons in order of Person, Student, Undergraduate, "
						+ "and Graduate Student and within those alphabetically");
				System.out.println("7. End Program");
				int option = sc.nextInt();
				if(option < 1 || option > 7) {
					System.out.println("Make sure input is between 1 and 6");
					continue;
				}
				if(option == 1) printPersons();
				else if(option == 2) printStudents();
				else if(option == 3) printUndergraduates();
				else if(option == 4) printGraduateStudents();
				else if(option == 5) inputOutput();
				else if(option == 6) printSorted();
				else {
					sc.close();
					System.out.println("Program ended");
					return;
				}
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			} 
		}
	}
	
	public static void inputPerson(int i) {
		String name;
		sc = new Scanner(System.in);
		System.out.println("Enter in name");
		name = sc.nextLine();
		Person p = new Person(name);
		array[i] = p;
	}
	
	public static void inputStudent(int i) throws InputMismatchException {
		String name;
		int id;
		sc = new Scanner(System.in);
		System.out.println("Enter in name");
		name = sc.nextLine();
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in student ID number");
				id = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		Person s = new Student(name, id);
		array[i] = s;
	}

	public static void inputUndergraduate(int i) throws InputMismatchException {
		String name;
		int id;
		int gradeLevel;
		sc = new Scanner(System.in);
		System.out.println("Enter in name");
		name = sc.nextLine();
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in student ID number");
				id = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter the corresponding number for the student's grade level (1-4)");
				System.out.println("1. Freshman");
				System.out.println("2. Sophomore");
				System.out.println("3. Junior");
				System.out.println("4. Senior");
				gradeLevel = sc.nextInt();
				if(gradeLevel < 1 || gradeLevel > 4) {
					System.out.println("Make sure input is between 1 and 4");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		Person ug = new Undergraduate(name, id, gradeLevel);
		array[i] = ug;
	}
	
	public static void inputGraduateStudent(int i) throws InputMismatchException {
		String name;
		int id;
		String major;
		sc = new Scanner(System.in);
		System.out.println("Enter in name");
		name = sc.nextLine();
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in student ID number");
				id = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		sc = new Scanner(System.in);
		System.out.println("Enter in major");
		major = sc.nextLine();
		Person gs = new GraduateStudent(name, id, major);
		array[i] = gs;
	}
	
	public static void printPersons() {
		for(Person p : array) {
			p.print();
		}
	}
	
	public static void printStudents() {
		for(Person p : array) {
			if(p instanceof Student) {
				p.print();
			}
		}
	}
	
	public static void printUndergraduates() {
		for(Person p : array) {
			if(p instanceof Undergraduate) {
				p.print();
			}
		}
	}
	
	public static void printGraduateStudents() {
		for(Person p : array) {
			if(p instanceof GraduateStudent) {
				p.print();
			}
		}
	}
	
	public static void inputOutput() throws InputMismatchException {
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in number for the corresponding option");
				System.out.println("1. Undergraduate");
				System.out.println("2. Graduate Student");
				int option = sc.nextInt();
				if(option < 1 || option > 2) {
					System.out.println("Make sure input is between 1 and 2");
					continue;
				}
				if(option == 1) inputOutputUndergraduate();
				else inputOutputGraduateStudent();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
	}
	
	public static void inputOutputUndergraduate() throws InputMismatchException {
		String name;
		int id;
		int gradeLevel = 0;
		sc = new Scanner(System.in);
		System.out.println("Enter in name");
		name = sc.nextLine();
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in student ID number");
				id = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter the corresponding number for the student's grade level (1-4)");
				System.out.println("1. Freshman");
				System.out.println("2. Sophomore");
				System.out.println("3. Junior");
				System.out.println("4. Senior");
				gradeLevel = sc.nextInt();
				if(gradeLevel < 1 || gradeLevel > 4) {
					System.out.println("Make sure input is between 1 and 4");
					continue;
				}
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		Undergraduate ug = new Undergraduate(name, id, gradeLevel);
		for(Person p : array) {
			if(p instanceof Undergraduate) {
				if(ug.equals((Undergraduate) p)) p.print();
			}
		}
	}
	
	public static void inputOutputGraduateStudent() throws InputMismatchException {
		String name;
		int id;
		String major;
		sc = new Scanner(System.in);
		System.out.println("Enter in name");
		name = sc.nextLine();
		while(true) {
			sc = new Scanner(System.in);
			try {
				System.out.println("Enter in student ID number");
				id = sc.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.out.println("Make sure input is a number");
			}
		}
		sc = new Scanner(System.in);
		System.out.println("Enter in major");
		major = sc.nextLine();
		GraduateStudent gs = new GraduateStudent(name, id, major);
		for(Person p : array) {
			if(p instanceof GraduateStudent) {
				if(gs.equals((GraduateStudent) p)) p.print();
			}
		}
	}
	
	public static void printSorted() {
		PriorityQueue<Person> pq = new PriorityQueue<>(pc);
		for(Person p : array) {
			pq.add(p);
		}
		while (!pq.isEmpty()) {
			Person p = pq.poll();
            p.print();
        }
	}
}
