import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int choice = chooser.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                ArrayList<Person> personRecords = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    String id = data[0];
                    String firstName = data[1];
                    String lastName = data[2];
                    String title = data[3];
                    int yob = Integer.parseInt(data[4]);

                    // Create a new Person object and add it to the list
                    Person person = new Person(firstName, lastName, id, title, yob);
                    personRecords.add(person);
                }

                // Print out all person records
                for (Person person : personRecords) {
                    System.out.println(person);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
