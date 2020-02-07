package employeerecords;

/**
 * Represents an Employee.<br><br>
 * The name and age of the Employee are mutable,
 * meaning they can be changed by using the provided getter and setter
 * methods. <br>
 * <br>CP213 Lab page <a href="https://bohr.wlu.ca/cp213/labs/202001_CP213_Lab04_classes_continued.php?d=2020-02-02">bohr.wlu.ca/cp213/labs/</a>
 * <br>
 * <br>
 * Student ID: 180856100 <br>
 * Email: mill6100@mylaurier.ca <br>
 * @author Nicolas Mills
 * @version 2020-02-03
 */
public class EmployeeRecord {

	/** Employee name */
	private String empName;
	/** Employee age */
	private int empAge;
	
	/**
	 * <b>Constructor</b><br><br>
	 * Creates a new {@linkplain EmployeeRecord}.<br><br>
	 * The name and age are initialized to an empty String
	 * and zero (0), respectively.
	 */
	public EmployeeRecord()
	{
		empName = "";
		empAge = 0;
	}
	
	/**
	 * <b>Constructor</b><br><br>
	 * Creates a new {@linkplain EmployeeRecord}.<br><br>
	 * The name and age are initialized to the passed values:
	 * empName and empAge, respectively.
	 * @param empName name of Employee
	 * @param empAge age of Employee
	 */
	public EmployeeRecord(String empName, int empAge)
	{
		setEmpName(empName);
		setEmpAge(empAge);
	}

	/**
	 * Get this Employee's name
	 * @return the Employee's name
	 */
	public String getEmpName() { return empName; }
	/**
	 * Set this Employee's name
	 * @param newName the name of this Employee
	 */
	public void setEmpName(String newName) { empName = newName; }
	/**
	 * Get this Employee's age
	 * @return the Employee's age
	 */
	public int getEmpAge() { return empAge; }
	/**
	 * Set this Employee's age
	 * @param newAge the age of this Employee
	 */
	public void setEmpAge(int newAge) { empAge = newAge; }
	
	@Override
	public String toString()
	{
		return "Name: " + empName + "\tAge: " + empAge;
	}
}
