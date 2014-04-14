/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessinggame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class GuessingGame {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Random r = new Random();
    Scanner ui = new Scanner(System.in);

    int userGuess = 0, compNumber = 0;

    compNumber = r.nextInt(20) + 1;

    System.out.println("Welcome to the Guessing Game!");
    do {
      while (userGuess > 20 || userGuess < 1) {
        System.out.print("Please enter your guess: ");
        userGuess = ui.nextInt();

        if (userGuess > 20 || userGuess < 1) {
          System.out.println("Please enter a number in the range.");
        }
      }
      if (userGuess < compNumber) {
        System.out.println("Your guess is too low.\n");
      } else if (userGuess > compNumber) {
        System.out.println("Your guess is too high.\n");
      }
      System.out.print("Please enter your guess: ");
      userGuess = ui.nextInt();
    } while (userGuess != compNumber);
    
    System.out.println("You guess right! The answer was " + compNumber + ".");
  }

}
