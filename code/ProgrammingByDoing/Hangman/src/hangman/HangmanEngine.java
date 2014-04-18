///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package hangman;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class HangmanEngine {

  private String[] board;
  private String missed = "";
  private final ConsoleIO cio = new ConsoleIO();
  private String guess;
  private String finalWord;
  private String hiddenWord;

  public void play() {

//Randomly select a word for the user to guess
    hiddenWord = getWord();

    cio.println("\tWelcome to Hangman!\n"
      + "===================================\n\n");

    //cio.println(hiddenWord);
    initBoard(hiddenWord.length());
    
    displayBoard();
    
    do {
      guess = cio.get("Guess: ");

      checkGuess();

      cio.println();

      finalWord = toString(board, "");

      displayBoard();

    } while (keepPlaying() != true);

    if (finalWord.contains(hiddenWord)) {
      cio.println("You got it!\n");
    } else {
      cio.println("Maybe next time...\n");
    }

    playAgain();

  }

  public void checkGuess() {

    String[] wordAry = hiddenWord.split("");

    for (int i = 0; i < wordAry.length; i++) {
      if (guess.equalsIgnoreCase(wordAry[i])) {
        board[i] = wordAry[i];
      }
    }

    if (hiddenWord.contains(guess) == false) {
      missed = missed.concat(guess.toLowerCase());
    }
  }

  public boolean keepPlaying() {
    return finalWord.contains(hiddenWord) || missed.length() > 6;
  }

  public void playAgain() {
    String answer = cio.get("Would you like to play again? (y/n) ");
    cio.println();
    if (answer.equalsIgnoreCase("y")) {
      play();
    } else {
      cio.println("Thanks for playing!");
    }
  }

  public void initBoard(int hiddenWordLength) {
    board = new String[hiddenWordLength];
    missed = "";
    for (int i = 0; i < hiddenWordLength; i++) {
      board[i] = "_";
    }
  }

  public void displayBoard() {
    cio.print("Word:  " + toString(board, " "));
    cio.println();
    cio.print("Missed: " + missed);
    cio.println();
  }

  public String toString(String[] ary, String delimiter) {
    String word = "";
    for (int i = 0; i < ary.length; i++) {
      word = word + ary[i] + delimiter;
    }
    return word;
  }

  public String getWord() {
    Random r = new Random();
    String[] words = arrayFromFile();

    int hW = r.nextInt(words.length) + 1;

    hiddenWord = words[hW];

    return hiddenWord;
  }

  /**
   * @return An array of words, initialized from the given URL
   */
  public String[] arrayFromFile() {
    Scanner file = null;
    try {
      file = new Scanner(new BufferedReader(new FileReader("words.txt")));
    } catch (FileNotFoundException ex) {
      Logger.getLogger(HangmanEngine.class.getName()).log(Level.SEVERE, null, ex);
    }
    String[] words = new String[2000];

    for (int w = 0; w < words.length; w++) {
      String word = file.nextLine();
      words[w] = word;
    }
    return words;
  }

}
