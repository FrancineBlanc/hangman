package hangman;

import java.util.ArrayList;

public class Hangman {
    private String wordToGuess;
    private int counter = 10;
    private ArrayList<Character> guessedLetters = new ArrayList<>();
    public WordChooser wordChooser;

    public Hangman(WordChooser wordChooser) {
        this.wordChooser = wordChooser;
        this.wordToGuess = wordChooser.getRandomWordFromDictionary();
    }

    public String getWordToGuess() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < wordToGuess.length(); i++) {
            char currentLetter = wordToGuess.charAt(i);
            if (i == 0) {
                stringBuilder.append(currentLetter);
            } else {
                if (guessedLetters.contains(currentLetter)) {
                    stringBuilder.append(currentLetter);
                } else {
                    stringBuilder.append("_");
                }
            }
        }
        return stringBuilder.toString();
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
