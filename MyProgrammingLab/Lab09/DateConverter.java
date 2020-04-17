/**
 * Answer for 73172 (Finished)
 */
public class DateConverter
{
    private static int day;
    private static Month month;
    private static int year;

    private static boolean isLeapYear;

    private static boolean checkLeapYear(int year) {
        return (year % 4 == 0) ? (year % 100 == 0) ? (year % 400 == 0) ? true : false : true : false;
    }

    private static void ensureValidDay(int day) throws DayException {
        if (day < 1 || day > month.getNumDays())
            throw new DayException("Invalid date for month " + month.getName());

    }

    private static void ensureValidYear(int year) throws YearException {
        if (year < 1000 || year > 3000)
            throw new YearException("Year must be between 1000 and 3000");
    }

    private static void ensureValidMonth(int month) throws MonthException {
        if (month < 1 || month > 12)
            throw new MonthException("Month must be between 1 and 12");
    }

    public static void main(String[] args) {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        String dateString;
        boolean invalidYear = false;
        boolean invalidMonth = false;
        boolean invalidDay = false;

        System.out.print("Enter the date string:");
        dateString = keyboard.next();
        String[] comps = dateString.split("/");

        // Process the year first
        year = Integer.parseInt(comps[2]);
        try {
            ensureValidYear(year);
        } catch (YearException ye) {
            System.out.println(ye.getMessage());
            invalidYear = true;
        }
        // Loop until a valid year is entered
        while (invalidYear) {
            System.out.print("Enter year:");
            try {
                year = keyboard.nextInt();
                ensureValidYear(year);
                invalidYear = false;
            } catch (YearException ye) {
                System.out.println(ye.getMessage());
            }
        }
        // Year valid, check if leapyear, used later
        isLeapYear = checkLeapYear(year);

        // Process the month
        int month_i = Integer.parseInt(comps[0]);
        try
        {
            ensureValidMonth(month_i);
        } catch (MonthException me)
        {
            System.out.println(me.getMessage());
            invalidMonth = true;
        }

        // Loop until a valid month has been entered
        while (invalidMonth)
        {
            System.out.print("Enter month:");
            try
            {
                month_i = keyboard.nextInt();
                ensureValidMonth(month_i);
                invalidMonth = false;
            } catch (MonthException me)
            {
                System.out.println(me.getMessage());
            }
        }
        // Month valid, create Month enum to hold its data
        month = Month.getMonth(month_i, isLeapYear);

        // Process the day
        day = Integer.parseInt(comps[1]);
        try
        {
            ensureValidDay(day);
        } catch (DayException de)  
        {
            System.out.println(de.getMessage());
            invalidDay = true;
        }

        // Loop until a valid day is entered
        while (invalidDay)
        {
            System.out.print("Enter date:");
            try
            {
                day = keyboard.nextInt();
                ensureValidDay(day);
                invalidDay = false;
            } catch (DayException de)
            {
                System.out.println(de.getMessage());
            }
        }

        System.out.println(month.getName() + " " + day + ", " + year);

        keyboard.close();
    }
}

enum Month
{
    JAN("January", 31),
    FEB("February", 28),
    FEB_LY("February", 29),
    MAR("March", 31),
    APR("April", 30),
    MAY("May", 31),
    JUN("June", 30),
    JUL("July", 31),
    AUG("August", 31),
    SEP("September", 30),
    OCT("October", 31),
    NOV("November", 30),
    DEC("December", 31);

    private String name;
    private int numDays;

    Month(String name, int numDays)
    {
        this.name = name;
        this.numDays = numDays;
    }

    public String getName() { return this.name; }
    public int getNumDays() { return this.numDays; }

    public static Month getMonth(int month, boolean isLeapYear)
    {
        if (month == 2 && isLeapYear) return FEB_LY;
        if (month >= 3) return values()[month];
        return values()[month-1];

        /*
        switch(month)
        {
            case 1: return JAN;
            case 2: return isLeapYear ? FEB_LY : FEB;
            case 3: return MAR;
            case 4: return APR;
            case 5: return MAY;
            case 6: return JUN;
            case 7: return JUL;
            case 8: return AUG;
            case 9: return SEP;
            case 10: return OCT;
            case 11: return NOV;
            case 12: return DEC;
            default: return JAN;
        }
        */
    }

}

class MonthException extends Exception
{
    private static final long serialVersionUID = 1L;

    public MonthException(String msg)
    {
        super(msg);
    }
}

class DayException extends Exception
{
    private static final long serialVersionUID = 1L;

    public DayException(String msg)
    {
        super(msg);
    }

}

class YearException extends Exception
{
    private static final long serialVersionUID = 1L;
    
    public YearException(String msg)
    {
        super(msg);
    }
}