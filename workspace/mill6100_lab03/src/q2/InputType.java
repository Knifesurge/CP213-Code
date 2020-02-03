package q2;

import java.util.Scanner;

/**
 * Task 2 of Lab 3 for CP213.<br>
 * From the lab page: <a href="https://bohr.wlu.ca/cp213/labs/202001_CP213_Lab03_classes_encapsulation.php?d=2020-01-26">bohr.wlu.ca/cp213/labs/</a>
 * <br>
 * Write a Java program that reads tokens from the keyboard, 
 * one token per line, and output the "type" of the token. 
 * The program can distinguish and identify tokens of type: <br>
 * Integer, Float, Boolean, and String. <br>
 * The program keeps asking for tokens until the word "Quit" is entered.
 * <br><br>
 * Student ID: 180856100<br>
 * Email: mill6100@mylaurier.ca
 * @author Nicolas Mills
 * @version 2020-01-27
 */
public class InputType {

	/**
	 * Prompts user to enter a token and prints out its type.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		String input = "";
		String type = "";
		
		while(!input.equals("Quit"))
		{
			System.out.print("Enter a token. Enter 'Quit' to stop: ");
			if (s.hasNextInt())
			{
				type = "Integer";
			} else if (s.hasNextFloat())
			{
				type = "Float";
			} else if (s.hasNextBoolean())
			{
				type = "Boolean";
			} else
			{
				type = "String";
			}
			
			System.out.println("The token is of type ..............: " + type);
			
			input = s.nextLine();	// Consume the inputted token
		}
		
		s.close();
		System.out.println(":::> Program Terminated.");
	}	
}
