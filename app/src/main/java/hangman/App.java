/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException {
        WordChooser wordChooser = new WordChooser();
        Hangman hangman = new Hangman(wordChooser);
        String wordToGuess = hangman.getWordToGuess();

        System.out.println("Welcome! Today the word to guess is:\n" + wordToGuess);
        int remainingAttempts = hangman.getRemainingAttempts();

        while (remainingAttempts > 0 && wordToGuess.indexOf('_') !=-1) {
            System.out.println("Enter one letter to guess (" + remainingAttempts + ") remaining:");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            Character c = reader.readLine().charAt(0);

            if (hangman.guessLetter(c)) {
                System.out.println("Right!");
                wordToGuess = hangman.getWordToGuess();
            } else {
                System.out.println("Wrong...");
            }
            System.out.println(wordToGuess);
            remainingAttempts = hangman.getRemainingAttempts();
        }
    }
}