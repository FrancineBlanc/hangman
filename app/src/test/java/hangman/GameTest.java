package hangman;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    @Test
    public void testGetRemainingAttempts() {
        Hangman hangman = new Hangman(new WordChooser());
        assertEquals(hangman.getRemainingAttempts(), 10);
    }

    Hangman hangman;
    @Before
    public void initialise() {
        WordChooser mockedWordChooser = mock(WordChooser.class);
        when(mockedWordChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        hangman = new Hangman(mockedWordChooser);
    }
    @Test
    public void testGetsWordToGuessWithRandomWord() {
        assertEquals(hangman.getWordToGuess(), "M_____");
    }

    @Test
    public void testGuessLetterCorrect() {
        assertEquals(hangman.guessLetter('A'), true);
        assertEquals(hangman.getRemainingAttempts(), 10);

        Character c = hangman.getGuessedLetters().get(0);
        assertEquals(c, Character.valueOf('A'));

        assertEquals(hangman.getWordToGuess(), "MA____");
    }

    @Test
    public void testGuessLetterWrong() {
        assertEquals(hangman.guessLetter('B'), false);
        assertEquals(hangman.getRemainingAttempts(), 9);
        assertTrue(hangman.getGuessedLetters().isEmpty());
    }

}
