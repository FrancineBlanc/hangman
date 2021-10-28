package hangman;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MaskerTest {
    @Test
    public void testGetsMaskedWord() {
        Masker masker = new Masker();
        ArrayList<Character> guessedLetters = new ArrayList<>();
        guessedLetters.add('E');
        guessedLetters.add('R');
        assertEquals(masker.getMaskedWord("MAKERS", guessedLetters), "M__ER_");
    }
}
