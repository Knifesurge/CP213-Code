class SalariedEmployee{
    private double salary;
    private String name, date;

    public SalariedEmployee(){
        name = "";
        date = "";
        salary = 0;
    }

    public SalariedEmployee(String theName, String theDate, double theSalary){
        name = theName;
        date = theDate;
        setSalary(theSalary);
    }

    public String getName(){
        return this.name;
    }

    public String getDate(){
        return this.date;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDate(String date){
        this.date = date;
    }


    public double getSalary(){
        return salary;
    }

    public double getPay(){
        return salary/12;
    }

    public void setSalary(double theSalary){
        if(theSalary>=0){
            salary = theSalary;
        }else{
            System.out.println("Fatal Error: Negative Salary");
            System.exit(0);
        }
    }

    public String toString(){
        return name+" "+date+"\n$"+this.salary+" per year";
    }

    public boolean equals(SalariedEmployee other){
        return name.equalsIgnoreCase(other.name)&&date.equalsIgnoreCase(other.date)&&salary==other.salary;
    }

    private void mainMenu(java.util.Scanner in)
    {
        while (!in.hasNextInt(10))
        {
            
        }
    }

    private void handleOption(int selection)
    {
        switch(selection)
        {

        }
    }

    public static void main(String[] args)
    {
        java.util.Scanner keyboard = new java.util.Scanner(System.in);

        System.out.print("Enter name:");
        String name = keyboard.next();
        System.out.print("Enter title:");
        String title = keyboard.next();
        System.out.print("Enter responsibility:");
        String responsibility = keyboard.next();
        System.out.print("Enter supervisor:");
        String supervisor = keyboard.next();
        System.out.print("Enter date:");
        String date = keyboard.next();
        System.out.print("Enter salary:");
        double salary = keyboard.nextDouble();

    }
}

class Administrator extends SalariedEmployee
{
    private String title;
    private String areaOfResponsibility;
    private String nameOfSupervisor;

    public Administrator(){
        super();
    }

    public Administrator(String theName, String theDate, double theSalary){
        super(theName, theDate, theSalary);
    }

    public Administrator(String t, String aor, String nos)
    {
        this.title = t;
        this.areaOfResponsibility = aor;
        this.nameOfSupervisor = nos;
    }

    public String getTitle() { return this.title; }
    public String getAreaOfResponsibility() { return this.areaOfResponsibility; }
    public String getNameOfSupervisor() { return this.nameOfSupervisor; }

    public void setTitle(String t) { this.title = t; }
    public void setAreaOfResponsibility(String aor) { this.areaOfResponsibility = aor; }
    public void setNameOfSupervisor(String nos) { this.nameOfSupervisor = nos; }

    @Override
    public String toString()
    {
        StringBuilder b = new StringBuilder();
        b.append(super.toString());
        b.append(this.areaOfResponsibility);
        b.append(this.title);
        b.append(this.nameOfSupervisor);
        return b.toString();
    }

    @Override
    public boolean equals(SalariedEmployee other)
    {
        if (other instanceof Administrator)
        {
            Administrator _other = (Administrator) other;
            return super.equals(_other) && this.title==_other.getTitle() && this.areaOfResponsibility==_other.getAreaOfResponsibility()
            && this.nameOfSupervisor==_other.getNameOfSupervisor();
        } else
            return super.equals(other);
    }

}