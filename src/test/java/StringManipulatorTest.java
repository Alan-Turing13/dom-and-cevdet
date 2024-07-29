import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringManipulatorTest {

    StringManipulator sm = new StringManipulator();

    @Test
    @DisplayName("turn a string back-to-front")
    void reverseString() {
        assertEquals("esrever", sm.reverseString("reverse"));
        assertEquals("", sm.reverseString(""));
    }

    @Test
    @DisplayName("check if a word is the same when reversed or not")
    void isPalindrome() {
        assertTrue(sm.isPalindrome("anna"));
        assertFalse(sm.isPalindrome("motorbike"));
    }
}