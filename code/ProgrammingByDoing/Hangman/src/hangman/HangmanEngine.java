///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class HangmanEngine {
//
//  private final String board;
//  private final String missed;
//
//  public HangmanEngine() {
//    this.missed = new String();
//    this.board = new String();
//
//  }

  public void play() throws Exception {

//Randomly select a word for the user to guess
    String hiddenWord = getWord();

    System.out.println("\tWelcome to Hangman!\n"
      + "===================================\n\n");
    System.out.println(hiddenWord);

    String[] board = initBoard(hiddenWord.length());
    displayBoard(board);
    //Scanner ui = new Scanner(System.in);
    //String userGuess = ui.nextLine();
  }

  public void checkGuess(String guess, String hiddenWord) {
    if (hiddenWord.matches(guess)) {

    } else {

    }
  }

  public String[] initBoard(int hiddenWordLength) throws Exception {
    String[] board;
    board = new String[hiddenWordLength];
    for (int i = 0; i < hiddenWordLength; i++) {
      board[i] = "_ ";
    }
    return board;
  }

  public void displayBoard(String[] board) {
    
    System.out.print("Word:  ");
    for (int i = 0; i < board.length; i++) {
      System.out.print(board[i]);
    }
    System.out.println();
    System.out.print("Missed:  ");
    
  }

  /**
   * @param filepath
   * @param url - the URL to read words from
   * @return An array of words, initialized from the given URL
   * @throws java.lang.Exception;
   */
  public String[] arrayFromFile() throws Exception {
    Scanner file = new Scanner(new BufferedReader(new FileReader("words.txt")));
    String[] words = new String[3260];

    for (int w = 0; w < words.length; w++) {
      String word = file.nextLine();
        words[w] = word;
    }
    return words;
  }

  public String getWord() throws Exception {
    Random r = new Random();
    String[] words = arrayFromFile();
    
    int hW = r.nextInt(words.length) + 20;
    
    String hiddenWord =  words[hW];

    return hiddenWord;
  }
}
