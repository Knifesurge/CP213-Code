/**
 * Answer for 73170 (Finished)
 */
public class Average
{

    private static void ensureValidInput(int input, String msg) throws Exception
    {
        if (input < 0)
            throw new Exception(msg);
    }
    public static void main(String[] args)
    {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        double result;
        int numNumbers = 0;
        int total = 0;
        int userIn;

        // Prompt user for number of pos. ints. to average
        while (true)
        {
            System.out.print("Enter the number of positive integers to be averaged:");
            userIn = keyboard.nextInt();
            try
            {
                // Ensure the input is positive, throws an Exception if not positive
                ensureValidInput(userIn, "N must be positive");
                // Input OK, set N and break out of loop
                numNumbers = userIn;
                break;
            } catch (java.util.InputMismatchException ime)
            {
                System.out.println("Please enter a positive integer");
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        // Get the proper amount of valid inputs from the user
        for (int i = 0; i < numNumbers; i++)
        {
            while (true)
            {
                System.out.print("Enter next number:");
                try
                {
                    userIn = keyboard.nextInt();
                    ensureValidInput(userIn, "Number must be positive. Try again");
                    total += userIn;
                    break;
                } catch (java.util.InputMismatchException ime)
                {
                    System.out.println("Please enter a positive integer");
                } catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }
            }
        }

        result = (double) total / (double) numNumbers;
        System.out.println("Average of " + numNumbers + " positive integers is: " + result);

        keyboard.close();
    }
}