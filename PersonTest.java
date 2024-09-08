import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testFullName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(currentYear - 1980, person.getAge());
    }

    @Test
    public void testGetAgeForYear() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals(40, person.getAge(2020));
    }

    @Test
    public void testToCSV() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("12345,John,Doe,Mr.,1980", person.toCSV());
    }

    @Test
    public void testToJSON() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("{ \"ID\": \"12345\", \"firstName\": \"John\", \"lastName\": \"Doe\", \"title\": \"Mr.\", \"YOB\": 1980 }", person.toJSON());
    }

    @Test
    public void testToXML() {
        Person person = new Person("John", "Doe", "12345", "Mr.", 1980);
        assertEquals("<Person><ID>12345</ID><firstName>John</firstName><lastName>Doe</lastName><title>Mr.</title><YOB>1980</YOB></Person>", person.toXML());
    }
}
