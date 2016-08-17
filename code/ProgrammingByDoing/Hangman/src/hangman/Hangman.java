/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

//import java.net.URL;
//import java.util.Random;
//import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Hangman {

  /**
   * @param args the command line arguments
   * @throws java.lang.Exception
   */
  //private static final char[] board = {};
  //private static final String[] missed = {};

  public static void main(String[] args){

    HangmanEngine game = new HangmanEngine();
    game.play();

  }
}
//  public static void play() throws Exception {
//    String[] words = arrayFromUrl("http://cs.leanderisd.org/txt/nouns.txt");
//    Random r = new Random();
//
//    //Randomly select a word for the user to guess
//    int hW = r.nextInt(words.length);
//    String hiddenWord = words[hW];
//
//    //char[] board = initBoard(hiddenWord.length());
//    //char[] missed;
//    System.out.println("\tWelcome to Hangman!\n"
//      + "===================================\n\n");
//
//    initBoard(6);
//    //displayBoard();
//
//    Scanner ui = new Scanner(System.in);
//    //String userGuess = ui.nextLine();
//
//    //System.out.println(hiddenWord);
//  }
//
//  public static void checkGuess(String guess, String hiddenWord) {
//    if (hiddenWord.matches(guess)) {
//
//    } else {
//
//    }
//  }
//
//  public static void initBoard(int hiddenWordLength) throws Exception {
//    for (int i = 0; i < hiddenWordLength; i++) {
//      board[i] = '_';
//    }
//  }
//
//  public static void displayBoard() {
//    System.out.print("Word:  ");
//    for (int i = 0; i < board.length; i++) {
//      System.out.print(board[i]);
//    }
//    System.out.println();
//    System.out.print("Missed:  ");
//    for (String missed1 : missed) {
//      System.out.print(missed1 + " ");
//    }
//
//  }
//
//  /**
//   * @param url - the URL to read words from
//   * @return An array of words, initialized from the given URL
//   * @throws java.lang.Exception;
//   */
//  public static String[] arrayFromUrl(String url) throws Exception {
//    Scanner finder = new Scanner((new URL(url)).openStream());
//    int count = finder.nextInt();
//    String word;
//    String[] words = new String[count];
//
//    for (int i = 0; i < words.length; i++) {
//
//      word = finder.next();
//      if (word.length() > 6) {
//        words[i] = word;
//      }
//    }
//    finder.close();
//
//    return words;
//  }
//}
