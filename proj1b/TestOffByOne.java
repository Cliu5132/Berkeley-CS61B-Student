import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();
    
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('a', 'b')); // True for lowercase
        assertTrue(offByOne.equalChars('b', 'a')); // True for lowercase
        assertTrue(offByOne.equalChars('A', 'B')); // True for uppercase
        assertTrue(offByOne.equalChars('B', 'A')); // True for uppercase

        assertFalse(offByOne.equalChars('a', 'c')); // False for lowercase
        assertFalse(offByOne.equalChars('c', 'a')); // False for lowercase
        assertFalse(offByOne.equalChars('A', 'C')); // False for uppercase
        assertFalse(offByOne.equalChars('C', 'A')); // False for uppercase
        assertFalse(offByOne.equalChars('a', 'B')); // False for one upper and one lower
        assertFalse(offByOne.equalChars('A', 'b')); // False for one upper and one lower

        // Test non-letter characters
        assertTrue(offByOne.equalChars('%', '&'));
        assertTrue(offByOne.equalChars('3', '4'));
    }
}
