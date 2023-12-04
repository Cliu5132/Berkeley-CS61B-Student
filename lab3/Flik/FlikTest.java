import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    int a1 = 127;
    int b1 = 127;
    int a2 = 128;
    int b2 = 128;

    @Test
    public void testIsSameNumber(){
        assertTrue(Flik.isSameNumber(a1, b1));
        assertTrue(Flik.isSameNumber(a2, b2));
    }
}
