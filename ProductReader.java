import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        int choice = chooser.showOpenDialog(null);
        if (choice == JFileChooser.APPROVE_OPTION) {
            try (BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()))) {
                ArrayList<Product> productRecords = new ArrayList<>();
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    String id = data[0];
                    String name = data[1];
                    String description = data[2];
                    double cost = Double.parseDouble(data[3]);

                    Product product = new Product(name, description, id, cost);
                    productRecords.add(product);
                }

                for (Product product : productRecords) {
                    System.out.println(product);
                }

            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        }
    }
}
