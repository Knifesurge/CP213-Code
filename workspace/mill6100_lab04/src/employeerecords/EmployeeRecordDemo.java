package employeerecords;

import java.util.Scanner;
/**
 * Driver code to test the {@linkplain EmployeeRecord} class. <br>
 * <br>CP213 Lab page <a href="https://bohr.wlu.ca/cp213/labs/202001_CP213_Lab04_classes_continued.php?d=2020-02-02">bohr.wlu.ca/cp213/labs/</a>
 * <br>
 * <br>
 * Student ID: 180856100 <br>
 * Email: mill6100@mylaurier.ca <br>
 * @author Nicolas Mills
 * @version 2020-02-03
 */
public class EmployeeRecordDemo {

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter first employee name: ");
		String firstEmpName = in.next();
		System.out.println("Enter first employee age: ");
		int firstEmpAge = in.nextInt();
		
		System.out.println("Enter second employee name: ");
		String secondEmpName = in.next();
		System.out.println("Enter second employee age: ");
		int secondEmpAge = in.nextInt();
		
		EmployeeRecord firstEmp = new EmployeeRecord(firstEmpName, firstEmpAge);
		EmployeeRecord secondEmp = new EmployeeRecord(secondEmpName, secondEmpAge);
		
		if (firstEmp.getEmpAge() > secondEmp.getEmpAge())
		{
			System.out.println(secondEmp + "\t::: Is the youngest employee.");
		} else if (firstEmp.getEmpAge() < secondEmp.getEmpAge())
		{
			System.out.println(firstEmp + "\t::: Is the youngest employee.");
		} else
		{
			System.out.println(firstEmp);
			System.out.println(secondEmp);
			System.out.println("::: Employees have the same age.");
		}
		
		in.close();
	}
	
}
