package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordChooserTest {
    @Test
    public void testHasDictionary() {
        WordChooser wordChooser = new WordChooser();
        assertEquals(wordChooser.getDictionary()[1], "CANDIES");
    }
}
