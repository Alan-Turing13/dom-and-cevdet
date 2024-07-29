import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordAnalyserTest {

    WordAnalyser w;

    @BeforeEach
    void setUp() {
        w = new WordAnalyser();
    }

    @Test
    void findLongestWords() {
        assertAll("find longest word(s) in input string",
                () -> assertArrayEquals(new String[]{"longest"}, w.findLongestWords("The longest word")),
                () -> assertArrayEquals(new String[]{"sentence"}, w.findLongestWords("This is a fairly boring sentence."))
        );
    }

    @Test
    void calculateLetterFrequency() {
        assertAll("find the frequency of each letter",
                () -> assertEquals(3, w.calculateLetterFrequency("Hello world").get('l')),
                () -> assertEquals(0, w.calculateLetterFrequency("This is a fairly boring thing.").get('z'))
        );
    }
}