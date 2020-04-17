/**
 * Answer for 73173 (Un-Finished)
 */
public class Calculator
{
    private static double result = 0.0d;
    private static String lastOp;
    private static double lastNum;


    private static void add(double num)
    {
        result += num;
    }

    private static void sub(double num)
    {
        result -= num;
    }

    private static void mul(double num)
    {
        result *= num;
    }

    private static void div(double num)
    {
        if (num != 0) result /= num;
    }

    private static void processExpression(String exp) throws UnknownOperatorException
    {
        String[] comps = exp.split(" ");
        String op = comps[0];
        double num = Double.parseDouble(comps[1]);

        // Process the operator
        if (op.equals("+")) add(num);
        else if (op.equals("-")) sub(num);
        else if (op.equals("*")) mul(num);
        else if (op.equals("/")) div(num);
        else throw new UnknownOperatorException("\n"+ op + " is an unknown operation\nReenter, your last line:");

        lastOp = op;
        lastNum = num;
    }

    private static void run(java.util.Scanner keyboard)
    {
        String userIn;
        int runs = 0;

        System.out.println("Calculator is on.");
        while (true)
        {
            if (runs == 0)
                System.out.println("result = " + result);
            else if (runs == 1)
                System.out.println("new result = " + result);
            else
                System.out.println("updated result = " + result);

            try
            {
                System.out.print("Enter an operation:");
                userIn = keyboard.nextLine();
                // Check for quit signal (r/R String)
                if (userIn.equalsIgnoreCase("r"))
                    break;
                processExpression(userIn);
                System.out.println("\nresult " + lastOp + " " + lastNum + " = " + result);
            } catch (UnknownOperatorException uoe)
            {
                System.out.println(uoe.getMessage());
            }

            runs++;
        }
    }

    public static void main(String[] args)
    {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        String userAgain;
        boolean isRunning = true;

        while (isRunning)
        {
            run(keyboard);
            System.out.println("\nFinal result = " + result);
            System.out.println("Enter (Y/N) to go again:");
            userAgain = keyboard.next();
            if (userAgain.equalsIgnoreCase("n"))
                isRunning = false;
        }

        System.out.println("End of Program");

        keyboard.close();
    }
}

class UnknownOperatorException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public UnknownOperatorException(String msg)
    {
        super(msg);
    }
}