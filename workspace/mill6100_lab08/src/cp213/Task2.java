package cp213;

import java.util.Scanner;

public class Task2 {

	public static String StringPrinter(int n, String str) throws Exception
	{
		if (n < 0) throw new Exception("Please Enter a Positive Integer!");
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++)
			builder.append(str);
		return builder.toString();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String str, result;
		int n;
		
		System.out.print("Enter String to repeat: ");
		str = in.next();
		System.out.print("Repetitions...........: ");
		n = in.nextInt();
		try
		{
			result = StringPrinter(n, str);
			System.out.println("Final String........: " + result);
		} catch (Exception e)
		{
			System.err.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("\n::: Program Terminated");
		in.close();
	}
	
}
