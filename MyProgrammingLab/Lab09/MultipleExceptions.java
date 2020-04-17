/**
 * Answer for 73171 (Finished)
 */
public class MultipleExceptions
{
    private static void ensureValidInput(int input, String msg) throws Exception
    {
        if (input == 0)
            throw new Exception(msg);
    }

    public static void main(String[] args)
    {
        java.util.Scanner scan = new java.util.Scanner(System.in);
        int n1, n2;
        double r;
        while (true)
        {
            try
            {
                System.out.print("Enter first number:");
                n1 = scan.nextInt();
                System.out.print("Enter second number:");
                n2 = scan.nextInt();
                ensureValidInput(n2, "Dividing by zero is not allowed");
                r = (double) n1 / n2;
                break;
            } catch (java.util.InputMismatchException ime)
            {
                System.out.println("Input must be a number");
                scan.next();
            } catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        System.out.println(r);

        scan.close();
    }
}