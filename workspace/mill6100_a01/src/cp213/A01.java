package cp213;

import java.util.Scanner;

/**
 * Assignment 1 for the Intro to Object Oriented Programming course at Wilfrid Laurier University.<br><br>
 * The assignment can be found here (requires WLU login):<br>
 * <a href="https://mylearningspace.wlu.ca/d2l/le/content/329075/viewContent/1954840/View">MyLS</a><br>
 * 
 * <br><strong>Email:</strong><br>&emsp;&emsp;&emsp;mill6100@mylaurier.ca
 * <br><strong>Student ID:</strong><br>&emsp;&emsp;&emsp;180856100
 * @author Nicolas Mills
 * @version 2020-01-28
 *
 */
public class A01 {

	/** Number of seconds in a minute */
	private final static int SECONDS_IN_MINUTE = 60;
	/** Number of seconds in an hour */
	private final static int SECONDS_IN_HOUR = SECONDS_IN_MINUTE*60;
	/** Number of seconds in a day */
	private final static int SECONDS_IN_DAY = SECONDS_IN_HOUR*24;
	/** Number of seconds in a month assuming 30 days in all months */
	private final static int SECONDS_IN_MONTH = SECONDS_IN_DAY*30;
	/** Number of seconds in a year */
	private final static int SECONDS_IN_YEAR = SECONDS_IN_MONTH*12;
	
	
	/**
	 * Determine if the provided year is a leap year.<br><br>
	 * <strong><u>Conditions:</u></strong><br>
	 * <ul>
	 * <li>Evenly divisible by 4
	 * <li>Evenly divisible by 100, but only if it is also evenly divisible by 400
	 * </ul>
	 * @param year year to test
	 * @return true if leap year, false otherwise
	 */
	public static boolean isLeapYear(int year)
	{
		// Use a switch
		switch(year % 4)
		{
			case 0: // Evenly divisible by 4
				if (year % 100 == 0)
					if (year % 400 == 0)	// Only a leapyear if evenly divisible by 100 and 400
						return true;	
					else
						return false;
				return true;	// Just divisble by 4
			default:
				return false;
		}
	}
	
	/**
	 * Determine if the first time-formatted string is older than the 
	 * second time-formatted string. Note that order is important!<br><br>
	 * isOlder(time1, time2) != isOlder(time2, time1),<br>
	 * for given time-formatted Strings time1, time2.<br>
	 * <br>The strings follow the following format:<br>
	 * <b>YYYY-MM-DD-hh-mm-ss</b><br>
	 * e.g. 2020-03-25-18-35-22
	 * @param time1 first time-formatted {@link String}
	 * @param time2 second time-formatted {@link String}
	 * @return whether 
	 */
	public static boolean isOlder(String time1, String time2)
	{
		/*int olderVal = arg1.compareTo(arg2);
		return (olderVal < 0) ? true : false;
		*/
		return (time1.compareTo(time2) < 0) ? true : false;
	}
	
	/**
	 * Calculates the difference in time (in seconds) between the provided time-formatted Strings.<br>
	 * <br>The string format is as follows:<br>
	 * <strong>YYYY-MM-DD-hh-mm-ss</strong><br>
	 * <br>The difference is calculated by the formula:<br>
	 * <code>newer_time - older_time</code><br>
	 * <br>This means that the order of the parameters <b>DOES NOT MATTER</b>
	 * @param time1 first time-formatted {@link String}
	 * @param time2 second time-formatted {@link String}
	 * @return (int) the number of seconds between the two times
	 */
	public static int timeSince(String time1, String time2)
	{
		String older;
		String newer;
		if (isOlder(time1, time2))
		{
			older = time1;
			newer = time2;
		} else
		{
			older = time2;
			newer = time1;
		}
		String[] newerComponents = newer.split("-");
		String[] olderComponents = older.split("-");
		
		/*
		 * For each of the below, parse the integer string from the components of the time-formatted input
		 * String and multiply by the number of seconds in that time duration.
		 * NOTE: the below constants are defined at the beginning of the class
		 */
		
		int years = SECONDS_IN_YEAR * (Integer.parseInt(newerComponents[0]) - Integer.parseInt(olderComponents[0]));
		int months = SECONDS_IN_MONTH * (Integer.parseInt(newerComponents[1]) - Integer.parseInt(olderComponents[1]));
		int days = SECONDS_IN_DAY * (Integer.parseInt(newerComponents[2]) - Integer.parseInt(olderComponents[2]));
		int hours = SECONDS_IN_HOUR *(Integer.parseInt(newerComponents[3]) - Integer.parseInt(olderComponents[3]));
		int minutes = SECONDS_IN_MINUTE * (Integer.parseInt(newerComponents[4]) - Integer.parseInt(olderComponents[4]));
		int seconds = Integer.parseInt(newerComponents[5]) - Integer.parseInt(olderComponents[5]);
		
		// Difference of times is the sum of the differences of each individual duration
		int diff = years + months + days + hours + minutes + seconds;
		//System.out.println("[DEBUG] MAX_INT_VALUE: " + Integer.MAX_VALUE);
		if (diff < 0)	// Integer overflow
			return -1;
		return diff;
	}
	
	/**
	 * Determines if the provided integers are coprime.
	 * @param num1 first int
	 * @param num2 second int
	 * @return (bool) true if the integers are coprime, false otherwise 
	 */
	public static boolean areCoprime(int num1, int num2)
	{
		// Determine larger number
		int max = (num1 > num2) ? num1 : num2;
		for (int i = 2; i <= max; i++)
			if ((num1 % i == 0) && (num2 % i == 0))	// not coprime if they share a common factor
				return false;
		return true;
	}
	
	/**
	 * Finds the largest n-digit coprime to the provided integer, where numDigits is the 
	 * number of digits in the coprime number
	 * @param num (int) number to determine coprimes
	 * @param numDigits (int) number of digits the coprime must have.
	 * @return (int) largest coprime with n-digits to num, -1 if such a coprime does not exist,
	 * -2 for any errors.
	 */
	public static int largestCoprime(int num, int numDigits)
	{
		try {
			int lowerBound = 1;
			// Lower bound is the lowest number with the desired digits
			for (int i = 1; i < numDigits; i++)
				lowerBound *= 10;
			// Upper bound is the highest number with the desired digits
			// Ex. if n = 3, lowerbound = 100, upperbound = 100*10 - 1 = 1000 - 1 = 999
			int upperBound = (lowerBound * 10) - 1;
			int largestCoprime = -1;
			//System.out.println("Lower bound: " + lowerBound + "\tUpper bound: " + upperBound);
			for (int i = lowerBound; i <= upperBound; i++)
			{
				if (areCoprime(num, i))
					largestCoprime = i;
			}
			// Returns -1 if not found, largestCoprime if it does find
			return largestCoprime;
		} catch (Exception e) { return -2; }	// Some error occured
	}
	
	public static void main(String[] args)
	{
		// Setup Scanner for testing
		Scanner in = new Scanner(System.in);

		System.out.println("Testing isLeapYear...");
		System.out.print("Enter a year: ");
		int year = in.nextInt();
		System.out.println("Leapyear? " + isLeapYear(year));
		
		System.out.println("Testing isOlder...");
		System.out.print("Enter a date in the form YYYY-MM-DD-hh-mm-ss: ");
		String year1 = in.next();
		System.out.print("Enter another date in the form YYYY-MM-DD-hh-mm-ss: ");
		String year2 = in.next();
		System.out.println("First date older than second date? " + isOlder(year1, year2));
	
		System.out.println("Testing timeSince...");
		System.out.print("Enter a date in the form YYYY-MM-DD-hh-mm-ss: ");
		String time1 = in.next();
		System.out.print("Enter another date in the form YYYY-MM-DD-hh-mm-ss: ");
		String time2 = in.next();
		System.out.println("Time difference between entered dates: " + timeSince(time1, time2));

		System.out.println("Testing areCoprime...");
		System.out.print("Enter an integer: ");
		int num1 = in.nextInt();
		System.out.print("Enter an integer: ");
		int num2 = in.nextInt();
		System.out.println("Are coprime? " + areCoprime(num1, num2));
		
		System.out.println("Testing largestCoprime...");
		System.out.print("Enter an integer: ");
		int num3 = in.nextInt();
		System.out.print("Enter max number of digits: ");
		int numDigits = in.nextInt();
		System.out.println("Largest coprime of " + num3 + " with " + numDigits + " digits: " + largestCoprime(num3, numDigits));
		
		in.close();
	}
}
