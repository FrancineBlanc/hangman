package hangman;

import java.util.ArrayList;

public class Hangman {
    private String wordToGuess;
    private int counter = 10;
    private ArrayList<Character> guessedLetters = new ArrayList<>();
    private String playerName;
    public WordChooser wordChooser;
    public Masker masker;
    public String maskedWord;

    public Hangman(String playerName, WordChooser wordChooser, Masker masker) {
        this.playerName = playerName;
        this.wordChooser = wordChooser;
        this.wordToGuess = wordChooser.getRandomWordFromDictionary();
        this.masker = masker;
    }
    public String getPlayerName() { return this.playerName; }
    public String getWordToGuess() {
        return masker.getMaskedWord(this.wordToGuess, this.guessedLetters);
    }

    public int getRemainingAttempts() {
        return this.counter;
    }

    public ArrayList<Character> getGuessedLetters() {
        return guessedLetters;
    }

    public boolean guessLetter(Character guess) {
        int index = this.wordToGuess.indexOf(guess);
        if (index > -1) {
            guessedLetters.add(guess);
            return true;
        }
        this.counter--;
        return false;
    }

    public boolean isGameLost() {
        return this.getRemainingAttempts() == 0;
    }

    public boolean isGameWon() {
        for (int i = 1; i < wordToGuess.length(); i++) {
            char letter = wordToGuess.charAt(i);
            if (!guessedLetters.contains(letter)) {
                return false;
            }
        }
        return true;
    }
}
