import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {

    @Test
    public void testProductDescription() {
        Product product = new Product("Laptop", "High-end gaming laptop", "12345", 1200.00);
        assertEquals("Laptop: High-end gaming laptop - $1200.0", product.productDescription());
    }

    @Test
    public void testToCSV() {
        Product product = new Product("Laptop", "High-end gaming laptop", "12345", 1200.00);
        assertEquals("12345,Laptop,High-end gaming laptop,1200.0", product.toCSV());
    }

    @Test
    public void testToJSON() {
        Product product = new Product("Laptop", "High-end gaming laptop", "12345", 1200.00);
        assertEquals("{ \"ID\": \"12345\", \"name\": \"Laptop\", \"description\": \"High-end gaming laptop\", \"cost\": 1200.0 }", product.toJSON());
    }

    @Test
    public void testToXML() {
        Product product = new Product("Laptop", "High-end gaming laptop", "12345", 1200.00);
        assertEquals("<Product><ID>12345</ID><name>Laptop</name><description>High-end gaming laptop</description><cost>1200.0</cost></Product>", product.toXML());
    }
}
