package cp213;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Testing class in simple example of inheritance / polymorphism.
 *
 * @author dbrown
 * @version 2017-06-09
 */
public class Main {

    public static void main(final String[] args) {

		// Create examples of Person, Student, Professor,
		// InstructionalAssistant.
		final Person person1 = new Person("Snord", "Cranston");
		final Student student1 = new Student("Sharma", "Priyanka", "7384737");
		final Professor prof1 = new Professor("Hakim", "Abdul", "History");
		final InstructionalAssistant ia1 = new InstructionalAssistant("Chin",
			"Li-meng", "9857478", "CP213");
		final CAS cas1 = new CAS("Mills", "Nick", "Science", "202005");
	
		// Defines an unsorted list of Person objects. (Uses generics).
		final ArrayList<Person> people = new ArrayList<Person>();
	
		// Add all above to the list of Person objects. Shows polymorphism -
		// since all have base class of Person, we are allowed to store all of
		// them in the same list.
		people.add(person1);
		people.add(student1);
		people.add(prof1);
		people.add(ia1);
		people.add(cas1);
	
		System.out.println("People:");
		System.out.println();
	
		for (final Person person : people) {
		    // Again shows polymorphism - calls print() appropriate to actual
		    // object type, not just Person print().
		    person.print();
		    System.out.println();
		}
		System.out.println("-----------------");
		// Defines a sorted set of Person objects. Sorted according to Person
		// compareTo method - sort applies to all child classes.
		final TreeSet<Person> set = new TreeSet<Person>();
		set.addAll(people);
	
		System.out.println("Sorted People:");
		System.out.println();
	
		for (final Person person : set) {
		    // Print all objects in sorted order by name.
		    person.print();
		    System.out.println();
		}
		
		// Task 3
		// Defines an unsorted list of CAS objects. (Uses generics)
		final ArrayList<CAS> teachers = new ArrayList<>();
		
		// Attempt to add all objects to this new list
		//teachers.add(person1);
		//teachers.add(student1);
		//teachers.add(prof1);
		//teachers.add(ia1);
		// Unable to add non-CAS objects since they do not
		// inherit from CAS (even though they have the same
		// parent class
		teachers.add(cas1);
		
		System.out.println("Attempting to print all objects"
				+ " in teacher ArrayList");
		// This will print when there are values in the list,
		// does not print anything if it is empty.
		// Also, this works
		for (final Person teacher : teachers)
		{
			teacher.print();
			System.out.println();
		}
    }

}
