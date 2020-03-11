package cp213;

public class CAS extends Professor {

	String term;
	
	public CAS(String lastName, String firstName, String department, String term) {
		super(lastName, firstName, department);
		this.term = term;
	}

	@Override
	public void print() {
		System.out.println(this.lastName + ", " + this.firstName);
		System.out.println("Department: " + this.department);
		System.out.println("Term: " + this.term);
	}
	
	/*
	 * Unable to implement the Comparable<T> interface since 
	 * CAS inherits it from Person and the types must match.
	 * If CAS implements it, CAS != Person, so won't work.
	 */
}
