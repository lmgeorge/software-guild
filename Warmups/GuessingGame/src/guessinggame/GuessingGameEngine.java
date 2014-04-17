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
  private int totalGuess = 0;
  private int wrongGuess = 0;
  private int avgGuesses = 0;
  private int sumTotalGuesses = 0;
  private String playAgain = "y";
  private ConsoleIO1 cio = new ConsoleIO1();

  public void play() {

    while (playAgain.equalsIgnoreCase("y")) {
      userGuess = 0;
      compNumber = r.nextInt(20) + 1;
      rounds++;

      cio.println("\nWelcome to the Guessing Game!\n"
        + "I'm thinking of a number between 1 and 20.");

      //cio.println(compNumber);
      getUserGuess();

      printResults();

      playAgain = cio.get("Do you want to play again? (y/n) ");

      sumTotalGuesses += totalGuess;

    }
    avgGuesses = sumTotalGuesses / rounds;
    cio.println("You average number of guesses per round: " + avgGuesses);
  }

  public void getUserGuess() {
    do {
      while (userGuess > 20 || userGuess < 1) {
        userGuess = cio.getNum("Please enter your guess: ");
        cio.println();
        checkWrongGuess(userGuess);
      }

      totalGuess++;

      isValid();

    } while (userGuess != compNumber);
  }

  public void checkWrongGuess(int userGuess) {
    this.userGuess = userGuess;

    //cio.setValidNum(cio.getNum(), 1, 20, "WRONG!! OUT OF BOUNDS!!");
    if (userGuess > 20 || userGuess < 1) {
      totalGuess++;
      cio.println("WRONG!! OUT OF BOUNDS!!");
      wrongGuess++;
    }
  }

  public void isValid() {
    if (userGuess < compNumber) {
      cio.println("Your guess is too low.\n");
      userGuess = cio.getNum("Please enter your guess: ");
      cio.println();

    } else if (userGuess > compNumber) {
      cio.println("Your guess is too high.\n");
      userGuess = cio.getNum("Please enter your guess: ");
      cio.println();
    }
  }

  public void printResults() {
    cio.println("You guessed right! The answer was " + compNumber + ".\n\n"
      + "Out of bounds guesses: " + wrongGuess + "\n"
      + "In bound guesses: " + (totalGuess - wrongGuess) + "\n"
      + "It only took you " + totalGuess + " tries this round.\n"
      + "You've played " + rounds + " rounds."
    );
  }
}
