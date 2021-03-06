package cp213;

import java.util.Scanner;


/**
 * Name: Nicolas Mills
 * Email: mill6100@mylaurier.ca
 * Student ID: 180856100
 * Course: CP213
 * Section: L1
 * @author mill6100
 *
 */
public class Lab01 {

    /**
     * @param a
     * @param b
     * @return
     */
    public static int gcd(int a, int b) {
        // your code here
    	if (b == 0)	// GCD(a,b) = a if b = 0
    	{
    		return a;
    	} 
    	else if (a == 0)	// GCD(a,b) = b if a = 0
    	{
    		return b;
    	}
    	else	// Recursive call to calculate GCD using Euclid's Algorithm
    	{
    		int temp_a = b;
    		int temp_b = a % b;
    		return gcd(temp_a, temp_b);
    	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int a = 0;
        int b = 0;
        int c = 0;
        
        // Read an integer from the keyboard.
        System.out.print("Enter a (0 to quit): ");
        a = keyboard.nextInt();

        // your code here
        
        // Keep asking for input until user enters 0 for 'a'
        while (a != 0)
        {
	        System.out.print("Enter b: ");
	        b = keyboard.nextInt();
	        
	        // gcd function call
	        c = Lab01.gcd(a, b);
	
	        // your code here
	        System.out.printf("The GCD of %d and %d is %d\n", a,b,c);
	        
	        // Ask for 'a' again to continue the loop
	        System.out.print("Enter a (0 to quit): ");
	        a = keyboard.nextInt();
        }
        
        keyboard.close();
    }

}