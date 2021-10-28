package hangman;

import java.util.ArrayList;

public class Masker {
    public String getMaskedWord(String word, ArrayList<Character> guessedLetters) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < word.length(); i++) {
            char currentLetter = word.charAt(i);
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
}
