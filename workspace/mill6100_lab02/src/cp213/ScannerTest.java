package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to test the capabilities of the {@link java.util.Scanner} class.
 * @author mill6100
 */
public class ScannerTest {
	/**
	 * Driver method. Asks user to input series of integers, prints sum of the provided 
	 * integers. Prints error message for non-valid integer values. Exits integer entry 
	 * once q is entered.
	 * @param args - Command-line arguments
	 */
    public static void main(String args[]) {
        System.out.println("Enter a series of integers. Press 'q' to quit.");
        // Read from the keyboard.
        Scanner s = new Scanner(System.in);
        int result = 0;
        int input = 0;
        
        while (input != 'q' && s.hasNext()) {
        	if (s.hasNextInt())	// Valid int input, add to result
        	{
        		input = s.nextInt();
        		result += input;
        	} else	// Invalid input: print err msg
        	{
        		// Get the ASCII value of the first character of the String
        		input = s.next().charAt(0);
        		System.out.println("Please enter a valid integer!");
        	}
        }

        s.close();
        System.out.println("The total is " + result + "\n\n\n\n");
        
        int numLines = readSelf();
        System.out.println("\n\nNum lines: " + numLines);
    }
    
    /**
     * Read this file's tokens and print them out, one on each line.<br>
     * Also returns the number of lines in this file.
     * @return numLines - number of lines in this file.
     */
    public static int readSelf()
    {
    	File file = new File("src/cp213/ScannerTest.java");
    	Scanner src;
    	int numLines = 0;
		try {
			src = new Scanner(file);
			while (src.hasNext())
			{
				System.out.println(src.next());
			}
			src.close();
			src = new Scanner(file);	// Reopen file to count lines
			while (src.hasNextLine())
			{
				src.nextLine();
				numLines++;
			}
			src.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numLines;
    }
}