package game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GameTest {
    @Test
    public void testGetsWordToGuessWithRandomWord() {
        WordChooser mockedWordChooser = mock(WordChooser.class);
        when(mockedWordChooser.getRandomWordFromDictionary()).thenReturn("MAKERS");
        Game game = new Game(mockedWordChooser);
        assertEquals(game.getWordToGuess(), "M_____");
    }

    @Test
    public void testGetRemainingAttempts() {
        Game game = new Game(new WordChooser());
        assertEquals(game.getCounter(), 10);
    }
}
