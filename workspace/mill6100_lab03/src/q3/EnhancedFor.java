package q3;

/**
 * This question demonstrate the syntax of creating a simple java class called "EnhancedFor", having a
 * number of methods, including a main method to test the class. Given a list of integers, this class
 * performs a number of operations on such a list to demonstrate the use of the enhanced For Loop.
 * The action/operation performed by a particular method is described in the method documentation.  
 * <br>
 * From CP213 Lab page <a href="https://bohr.wlu.ca/cp213/labs/202001_CP213_Lab03_classes_encapsulation.php?d=2020-01-26">bohr.wlu.ca/cp213/labs/</a>
 * <br><br>
 * Student ID: 180856100
 * <br>
 * Email: mill6100@mylaurier.ca
 * @author Nicolas Mills
 * @version 2020-01-27
 */
public class EnhancedFor {

    /**
      * Main program to test the various methods.
      * @param args unused
      */
    public static void main(String[] args) {
    //====================================
       int[] list ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // List containing 10 integer values.
		
       int sum;                                     // Sum of all the elements in the array "list"
		
       System.out.println("Original List");
       System.out.println("=============");
       printList(list);
       System.out.println();
		
       sum = sumListEnhanced(list);
       System.out.println("Sum of elements in list: [" + sum + "]");
       System.out.println();
		
       System.out.println("===> Calling addOne");
       addOne(list);
       System.out.println();
		
       System.out.println("List after call to addOne");
       System.out.println("=========================");
       printList(list);
       System.out.println();
		
       System.out.println("Calling addOneError");
       System.out.println("===================");
       addOneError(list);
       System.out.println();
		
       System.out.println("List after call to addOneError. Note elements of list did not change.");
       System.out.println("==============================");
       printList(list);
    }

    /**
      * The method shows the use of the enhanced for loop.
      * @param list int array to sum
      * @return total (sum of elements in the list)
      */
    public static int sumListEnhanced(int[] list) {
    //===========================================
    	int total = 0;
    	for (int i : list)
    	  total += i;
    	return total;
    }

    /**
      * Method to increase the value of each element of the list by 1!
      * @param list int array to add one to each element
      * @return none
      */
    public static void addOneError(int[] list) {
    //========================================
                                    // NOTE: The code appears to add one to every element in the list,
                                    //       but it does not. Can you explain why this is so?	
       for (int val : list) {
          val = val + 1;
       }
       return;
    }

    /**
      * Method to increase the value of each element of the list by 1!
      * @param list int array to add one to each element
      * @return none
      */
    public static void addOne(int[] list) {
    //===================================
    	for (int i = 0; i < list.length; i++)
    		list[i] += 1;
    }
 
    /**
      * Method to print the contents of the list.
      * Prints the list contents in two columns:
      *       index    value
      *         0        2
      *         1        3
      *            :::
      * @param list int array to print
      * @return none
      */
    public static void printList(int[] list) {
    //======================================
	
    	System.out.println("index\tvalue");
	   
    	for (int i = 0; i < list.length; i++)
    		System.out.println("  " + i + "\t  " + list[i]);
    }
}