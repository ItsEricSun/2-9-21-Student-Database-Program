import java.util.Comparator;

public class PersonsComparator implements Comparator<Person> {

	@Override
	public int compare(Person p1, Person p2) {
		return p1.compareTo(p2);
	}

}
