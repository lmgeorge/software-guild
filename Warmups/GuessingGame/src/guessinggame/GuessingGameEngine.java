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
public class GuessingGameEngine {

  private Random r = new Random();
  private Scanner ui = new Scanner(System.in);

  private int rounds = 0;
  private int userGuess = 0;
  private int compNumber = 0;
  private int totalGuess = 1;
  private int wrongGuess = 0;
  private int avgGuesses = 0;
  private int sumTotalGuesses = 0;
  private String playAgain = "y";

  public void play() {

    while (playAgain.equalsIgnoreCase("y")) {
      userGuess = 0;
      compNumber = r.nextInt(20) + 1;
      rounds++;

      System.out.println("\nWelcome to the Guessing Game!\n"
        + "I'm thinking of a number between 1 and 20.");
      System.out.println(compNumber);
      getUserGuess();

      printResults();

      System.out.print("Do you want to play again? (y/n) ");
      playAgain = ui.next();

      sumTotalGuesses += totalGuess;

    }
    avgGuesses = sumTotalGuesses / rounds;
    System.out.println("You average number of guesses per round: " + avgGuesses);
  }

  public void getUserGuess() {
    do {
      while (userGuess > 20 || userGuess < 1) {
        System.out.print("Please enter your guess: ");
        userGuess = ui.nextInt();
        checkWrongGuess(userGuess);
      }

      totalGuess++;

      isValid();

      System.out.print("Please enter your guess: ");
      userGuess = ui.nextInt();
    } while (userGuess != compNumber);
  }

  public void checkWrongGuess(int userGuess) {
    this.userGuess = userGuess;

    if (userGuess > 20 || userGuess < 1) {
      totalGuess++;
      System.out.println("WRONG!! OUT OF BOUNDS!!");
      wrongGuess++;
    }
  }

  public void isValid() {
    if (userGuess < compNumber) {
      System.out.println("Your guess is too low.\n");
    } else if (userGuess > compNumber) {
      System.out.println("Your guess is too high.\n");
    }
  }

  public void printResults() {
    System.out.println("You guessed right! The answer was " + compNumber + ".\n"
      + "Out of bounds guesses: " + wrongGuess + "\n"
      + "In bound guesses: " + (totalGuess - wrongGuess) + "\n"
      + "It only took you " + totalGuess + " tries this round.\n"
      + "You've played " + rounds + " rounds."
    );
  }
}
