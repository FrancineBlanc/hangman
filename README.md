# Hangman

This program is an implementation of the classic game of hangman using Java, which uses the following specification:

- [x] When the game starts, it chooses a random word from a list of words.
- [x] The game then displays the word to guess, with only the first letter visible (e.g H____ for "HOUSE").
- [x] The player starts with 10 attempts.
- [x] The player is prompted to enter a letter they think might be in the word.
- [x] If the letter is in the word, the game displays the word to guess, with the new letter visible.
- [x] If the letter is not in the word, the game will display the same letters as before, and decrease the counter 
  of remaining attempts.
- [x] If the number of attempts reaches zero, the player loses.
- [x] If the player finds all the letters in the word, they win.