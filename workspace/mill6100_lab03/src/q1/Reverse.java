package q1;

import java.util.Scanner;

/**
 * 
 * Write a Java program called "Reverse" that reads an input message string from the keyboard and output the message backwords. That is, in the reverse order as shown below in the "Sample Dialog".
	<br>
    NOTE:<br>
        The output message must be enclosed within square brackets, as shown.
        No other character(s), or nulls, must appear between the square brackets.
        The program output should look like as shown in the Sample Dialog.
        Titles, and underlines, should also appear in the output as shown.
<br>
 * From CP213 Lab page <a href="https://bohr.wlu.ca/cp213/labs/202001_CP213_Lab03_classes_encapsulation.php?d=2020-01-26">bohr.wlu.ca/cp213/labs/</a>
 * <br>
 * <br>
 * Student ID: 180856100 <br>
 * Email: mill6100@mylaurier.ca <br>
 * @author Nicolas Mills
 * @version 2020-01-27
 *
 */
public class Reverse {

	/**
	 * Prompts user for input message and displays it in reverse
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Input Message:\n==============\n");
		
		// Consume user input
		String input = s.nextLine();
		// No further input needed, close Scanner
		s.close();
		System.out.println("Output Message (reverse):\n=========================\n");
		System.out.print("[");
		// Loop backwards over the string
		for (int i = input.length()-1; i >= 0; i--)
			System.out.print(input.charAt(i));
		System.out.print("]\n");
		
	}
	
}
