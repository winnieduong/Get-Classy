import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<Product> productRecords = new ArrayList<>();
        boolean done = false;

        while (!done) {
            String id = SafeInput.getNonZeroLenString("Enter Product ID: ");
            String name = SafeInput.getNonZeroLenString("Enter Product Name: ");
            String description = SafeInput.getNonZeroLenString("Enter Product Description: ");
            double cost = SafeInput.getInt("Enter Product Cost: ");

            Product product = new Product(name, description, id, cost);
            productRecords.add(product);

            done = !SafeInput.getYNConfirm("Do you want to enter another product? ");
        }

        String fileName = SafeInput.getNonZeroLenString("Enter the file name to save: ");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : productRecords) {
                writer.write(product.toCSV());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
