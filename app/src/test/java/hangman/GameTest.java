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

    @Test
    public void testIsGameLost() {
        hangman.guessLetter('Q');
        hangman.guessLetter('W');
        hangman.guessLetter('T');
        hangman.guessLetter('Y');
        hangman.guessLetter('U');
        hangman.guessLetter('I');
        hangman.guessLetter('O');
        hangman.guessLetter('P');
        hangman.guessLetter('D');
        hangman.guessLetter('F');
        assertEquals(hangman.getRemainingAttempts(), 0);
        assertTrue(hangman.isGameLost());
    }

    @Test
    public void testIsGameWon() {
        hangman.guessLetter('A');
        hangman.guessLetter('K');
        hangman.guessLetter('E');
        hangman.guessLetter('R');
        hangman.guessLetter('S');
        assertEquals(hangman.getRemainingAttempts(), 10);
        assertTrue(hangman.isGameWon());
    }

}
