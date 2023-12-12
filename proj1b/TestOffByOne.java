import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();
    
    @Test
    public void testEqualChars() {
        assertTrue(offByOne.equalChars('l', 'k'));
        assertTrue(offByOne.equalChars('k', 'l'));
        assertFalse(offByOne.equalChars('a', 'c'));
    }
}
