import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;

public class SafeInputObjTest {

    @Test
    public void testGetNonZeroLenString() {
        Scanner scanner = new Scanner("Test String\n");
        SafeInputObj input = new SafeInputObj(scanner);
        String result = input.getNonZeroLenString("Enter a non-empty string");
        assertEquals("Test String", result);
    }

    @Test
    public void testGetInt() {
        Scanner scanner = new Scanner("42\n");
        SafeInputObj input = new SafeInputObj(scanner);
        int result = input.getInt("Enter an integer");
        assertEquals(42, result);
    }

    @Test
    public void testGetYNConfirmYes() {
        Scanner scanner = new Scanner("Y\n");
        SafeInputObj input = new SafeInputObj(scanner);
        boolean result = input.getYNConfirm("Do you want to proceed?");
        assertTrue(result);
    }

    @Test
    public void testGetYNConfirmNo() {
        Scanner scanner = new Scanner("N\n");
        SafeInputObj input = new SafeInputObj(scanner);
        boolean result = input.getYNConfirm("Do you want to proceed?");
        assertFalse(result);
    }

    @Test
    public void testGetDouble() {
        Scanner scanner = new Scanner("3.14\n");
        SafeInputObj input = new SafeInputObj(scanner);
        double result = input.getDouble("Enter a decimal value");
        assertEquals(3.14, result, 0.001);
    }
}
