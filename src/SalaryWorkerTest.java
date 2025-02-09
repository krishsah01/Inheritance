import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {
    private SalaryWorker salaryWorker;

    @BeforeEach
    void setUp() {
        salaryWorker = new SalaryWorker("456", "Jane", "Smith", "Manager", 1980, 30.0, 104000.0);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("456", salaryWorker.getID());
        assertEquals("Jane", salaryWorker.getFirstName());
        assertEquals("Smith", salaryWorker.getLastName());
        assertEquals("Manager", salaryWorker.getTitle());
        assertEquals(1980, salaryWorker.getYOB());
        assertEquals(30.0, salaryWorker.getHourlyPayRate());
        assertEquals(104000.0, salaryWorker.getAnnualSalary());
    }

    @Test
    void testSetAnnualSalary() {
        salaryWorker.setAnnualSalary(120000.0);
        assertEquals(120000.0, salaryWorker.getAnnualSalary());
    }

    @Test
    void testCalculateWeeklyPay() {
        // Test weekly pay calculation
        assertEquals(2000.0, salaryWorker.calculateWeeklyPay(40.0));  // 104,000 annual salary divided by 52 weeks
        assertEquals(2000.0, salaryWorker.calculateWeeklyPay(60.0));  // Weekly pay is fixed regardless of hours worked
        assertEquals(2000.0, salaryWorker.calculateWeeklyPay(0.0));   // Weekly pay is fixed regardless of hours worked
    }

    @Test
    void testDisplayWeeklyPay() {
        // Ensure the method runs without exceptions
        salaryWorker.displayWeeklyPay(45.0);
    }

    @Test
    void testToJSON() {
        String expectedJSON = "Worker{\n" +
                "\"firstName\": \"Jane\",\n" +
                "\"lastName\": \"Smith\",\n" +
                "\"ID\": \"456\",\n" +
                "\"title\": \"Manager\",\n" +
                "\"YOB\": 1980\",\n" +
                "\"hourlyPayRate\": 30.0\",\n" +
                "\"annualSalary\": 104000.0\n" +
                "}";
        assertEquals(expectedJSON, salaryWorker.toJSON());
    }

    @Test
    void testToXML() {
        String expectedXML = "<Worker>\n" +
                "<firstName>Jane</firstName>\n" +
                "<lastName>Smith</lastName>\n" +
                "<ID>456</ID>\n" +
                "<title>Manager</title>\n" +
                "<YOB>1980</YOB>\n" +
                "<hourlyPayRate>30.0</hourlyPayRate>\n" +
                "<annualSalary>104000.0</annualSalary>\n" +
                "</Worker>";
        assertEquals(expectedXML, salaryWorker.toXML());
    }

    @Test
    void testToCSV() {
        String expectedCSV = "456, Jane, Smith, Manager, 1980, 30.0, 104000.0";
        assertEquals(expectedCSV, salaryWorker.toCSV());
    }
}
