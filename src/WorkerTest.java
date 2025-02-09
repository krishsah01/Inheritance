import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WorkerTest {
    private Worker worker;

    @BeforeEach
    void setUp() {
        worker = new Worker("123", "John", "Doe", "Engineer", 1985, 20.0);
    }

    @Test
    void testConstructorAndGetters() {
        assertEquals("123", worker.getID());
        assertEquals("John", worker.getFirstName());
        assertEquals("Doe", worker.getLastName());
        assertEquals("Engineer", worker.getTitle());
        assertEquals(1985, worker.getYOB());
        assertEquals(20.0, worker.getHourlyPayRate());
    }

    @Test
    void testSetHourlyPayRate() {
        worker.setHourlyPayRate(25.0);
        assertEquals(25.0, worker.getHourlyPayRate());
    }

    @Test
    void testCalculateWeeklyPay() {
        // Test for 40 hours (regular pay)
        assertEquals(800.0, worker.calculateWeeklyPay(40.0));

        // Test for overtime pay (50 hours)
        assertEquals(1100.0, worker.calculateWeeklyPay(50.0));

        // Test for zero hours worked
        assertEquals(0.0, worker.calculateWeeklyPay(0.0));
    }

    @Test
    void testDisplayWeeklyPay() {
        // Note: This method prints to console. We will just ensure it runs without errors.
        worker.displayWeeklyPay(45.0);
    }

    @Test
    void testToJSON() {
        String expectedJSON = "Worker{\n" +
                "\"firstName\": \"John\",\n" +
                "\"lastName\": \"Doe\",\n" +
                "\"ID\": \"123\",\n" +
                "\"title\": \"Engineer\",\n" +
                "\"YOB\": 1985\n" +
                "\"hourlyPayRate\": 20.0\n" +
                "}";
        assertEquals(expectedJSON, worker.toJSON());
    }

    @Test
    void testToXML() {
        String expectedXML = "<Worker>\n" +
                "<firstName>John</firstName>\n" +
                "<lastName>Doe</lastName>\n" +
                "<ID>123</ID>\n" +
                "<title>Engineer</title>\n" +
                "<YOB>1985</YOB>\n" +
                "<hourlyPayRate>20.0</hourlyPayRate>\n" +
                "</Worker>";
        assertEquals(expectedXML, worker.toXML());
    }

    @Test
    void testToCSV() {
        String expectedCSV = "123, John, Doe, Engineer, 1985, 20.0";
        assertEquals(expectedCSV, worker.toCSV());
    }
}
