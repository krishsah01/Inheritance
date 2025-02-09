public class Worker extends Person {
    private double hourlyPayRate;

    public Worker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate) {
        super(ID, firstName, lastName, title, YOB);
        this.hourlyPayRate = hourlyPayRate;
    }

    public double getHourlyPayRate() {
        return hourlyPayRate;
    }

    public void setHourlyPayRate(double hourlyPayRate) {
        this.hourlyPayRate = hourlyPayRate;
    }

    public double calculateWeeklyPay(double hoursWorked) {
        double weeklyPay;
        if(hoursWorked <= 40){
            double regularPay = hourlyPayRate * hoursWorked;
            weeklyPay = regularPay;
        }else {
            double regularPay = hourlyPayRate * 40;
            double extraPay = (hoursWorked - 40) * hourlyPayRate * 1.5;
            weeklyPay = regularPay + extraPay;
        }
        return weeklyPay;
    }

    public void displayWeeklyPay(double hoursWorked){
        double regularHours = Math.min(40, hoursWorked);
        double extraHours = Math.max(0, hoursWorked -40);
        System.out.println("Regular Hours Worked: " + regularHours + ", Total Pay for Regular Hours: $" + regularHours * hourlyPayRate);
        System.out.println("Extra Hours Worked: " + extraHours + ", Total Pay for Extra Hours: $" + extraHours * hourlyPayRate * 1.5);
        System.out.println("Total combined pay: $" + calculateWeeklyPay(hoursWorked));
    }
    public String toJSON() {
        return "Worker{\n" +
                "\"firstName\": \"" + this.getFirstName() + "\",\n" +
                "\"lastName\": \"" + this.getLastName() + "\",\n" +
                "\"ID\": \"" + this.getID() + "\",\n" +
                "\"title\": \"" + this.getTitle() + "\",\n" +
                "\"YOB\": " + this.getYOB() + "\",\n" +
                "\"hourlyPayRate\": " + this.hourlyPayRate + "\n" +
                "}";
    }
    public String toXML() {
        return "<Worker>\n" +
                "<firstName>" + this.getFirstName() + "</firstName>\n" +
                "<lastName>" + this.getLastName() + "</lastName>\n" +
                "<ID>" + this.getID() + "</ID>\n" +
                "<title>" + this.getTitle() + "</title>\n" +
                "<YOB>" + this.getYOB() + "</YOB>\n" +
                "<hourlyPayRate>" + this.hourlyPayRate + "</hourlyPayRate>\n" +
                "</Worker>";
    }
    public String toCSV()
    {
        return this.getID() + ", " + this.getFirstName() + ", " + this.getLastName() + ", " + this.getTitle() + ", " + this.getYOB() + ", " + this.hourlyPayRate;
    }

}


