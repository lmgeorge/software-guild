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

    int userGuess = 0, compNumber = 0, counter = 1;

    compNumber = r.nextInt(20) + 1;

    System.out.println("Welcome to the Guessing Game!\n"
      + "I'm thinking of a number between 1 and 20.");
    do {
      
      while (userGuess > 20 || userGuess < 1) {
        System.out.print("Please enter your guess: ");
        userGuess = ui.nextInt();

        if (userGuess > 20 || userGuess < 1) {
          counter++;
          System.out.println("WRONG!! OUT OF BOUNDS!!");
        }
       
      }
      
      counter++;
      
      
      if (userGuess < compNumber) {
        System.out.println("Your guess is too low.\n");
      } else if (userGuess > compNumber) {
        System.out.println("Your guess is too high.\n");
      }
      System.out.print("Please enter your guess: ");
      userGuess = ui.nextInt();
    } while (userGuess != compNumber);
    
    System.out.println("You guessed right! The answer was " + compNumber + ".\n"
      + "It only took you " + counter + " tries.");
  }

}
