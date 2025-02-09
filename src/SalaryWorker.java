public class SalaryWorker extends Worker{
    private double annualSalary;

    public SalaryWorker(String ID, String firstName, String lastName, String title, int YOB, double hourlyPayRate, double annualSalary) {
        super(ID, firstName, lastName, title, YOB, hourlyPayRate);
        this.annualSalary = annualSalary;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(double annualSalary) {
        this.annualSalary = annualSalary;
    }

    @Override
    public double calculateWeeklyPay(double hoursWorked) {
        return annualSalary/52;
    }

    @Override
    public void displayWeeklyPay(double hoursWorked) {
        System.out.println("Weekly Pay: $" + annualSalary/52 + "is the weekly fraction of annual salary, i.e.,: $" + annualSalary);
    }

    @Override
    public String toJSON() {
        return "Worker{\n" +
                "\"firstName\": \"" + this.getFirstName() + "\",\n" +
                "\"lastName\": \"" + this.getLastName() + "\",\n" +
                "\"ID\": \"" + this.getID() + "\",\n" +
                "\"title\": \"" + this.getTitle() + "\",\n" +
                "\"YOB\": " + this.getYOB() + "\",\n" +
                "\"hourlyPayRate\": " + this.getHourlyPayRate() + "\",\n" +
                "\"annualSalary\": " + this.annualSalary + "\n" +
                "}";
    }
    public String toXML() {
        return "<Worker>\n" +
                "<firstName>" + this.getFirstName() + "</firstName>\n" +
                "<lastName>" + this.getLastName() + "</lastName>\n" +
                "<ID>" + this.getID() + "</ID>\n" +
                "<title>" + this.getTitle() + "</title>\n" +
                "<YOB>" + this.getYOB() + "</YOB>\n" +
                "<hourlyPayRate>" + this.getHourlyPayRate() + "</hourlyPayRate>\n" +
                "<annualSalary>" + this.annualSalary + "</annualSalary>\n" +
                "</Worker>";
    }
    public String toCSV()
    {
        return this.getID() + ", " + this.getFirstName() + ", " + this.getLastName() + ", " + this.getTitle() + ", " + this.getYOB() + ", " + this.getHourlyPayRate() + ", " + this.annualSalary;
    }
}
