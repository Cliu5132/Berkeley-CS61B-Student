import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByN {
    OffByN offBy5 = new OffByN(5);
    OffByN offBy4 = new OffByN(4);

    @Test
    public void testEqualChars() {
        assertTrue(offBy4.equalChars('A', 'E'));
        assertFalse(offBy4.equalChars('A', 'D'));
        assertFalse(offBy4.equalChars('%', '&'));
        assertTrue(offBy5.equalChars('A', 'F'));
        assertFalse(offBy5.equalChars('%', '&'));
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('f', 'a'));
        assertFalse(offBy5.equalChars('f', 'h'));
    }
}
