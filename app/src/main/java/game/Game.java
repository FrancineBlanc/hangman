package game;

public class Game {
    private String wordToGuess;
    private int counter = 10;
    public WordChooser wordChooser;

    public Game(WordChooser wordChooser) {
        this.wordToGuess = wordChooser.getRandomWordFromDictionary();
        this.wordChooser = wordChooser;
    }

    public String getWordToGuess() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < wordToGuess.length(); i++) {
            if (i == 0) {
                stringBuilder.append(wordToGuess.charAt(i));
            } else {
                stringBuilder.append("_");
            }
        }
        return stringBuilder.toString();
    }

    public int getCounter() {
        return this.counter;
    }
}
