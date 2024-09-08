import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> personRecords = new ArrayList<>();
        boolean done = false;

        while (!done) {
            String id = SafeInput.getNonZeroLenString("Enter ID: ");
            String firstName = SafeInput.getNonZeroLenString("Enter First Name: ");
            String lastName = SafeInput.getNonZeroLenString("Enter Last Name: ");
            String title = SafeInput.getNonZeroLenString("Enter Title: ");
            int yob = SafeInput.getInt("Enter Year of Birth: ");

            Person person = new Person(firstName, lastName, id, title, yob);
            personRecords.add(person);

            done = !SafeInput.getYNConfirm("Do you want to enter another person? ");
        }

        String fileName = SafeInput.getNonZeroLenString("Enter the file name to save: ");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Person person : personRecords) {
                writer.write(person.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
