/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class RPSEngine {

  final int MIN_ROUNDS = 1;
  final int MAX_ROUNDS = 10;
  private final Scanner sc = new Scanner(System.in);
  private final Random r = new Random();
  private int rounds;
  private int[] winCounter = new int[3];
  private String user1 = "";
  private String user2 = "";
  private String playAgain = "";

  public void play() {

    do {
      rounds = readValue("HOW MANY ROUNDS? (1-10):  ", MIN_ROUNDS, MAX_ROUNDS);

      for (int i = 0; i < rounds; i++) {
        System.out.println();
        System.out.print("USER 1: ROCK, PAPER, SCISSORS. \nPICK ONE:  ");
        user1 = sc.nextLine();
        System.out.println();
        
        System.out.print("USER 2: ROCK, PAPER, SCISSORS. \nPICK ONE:  ");
        user2 = sc.nextLine();
        System.out.println();
        
        evalWinner(winCounter, user1, user2);

      }
      
      returnResults();

      System.out.println("Would you like to play again?");
      playAgain = sc.nextLine();
      System.out.println();

    } while (playAgain.equalsIgnoreCase("yes"));
    System.out.println("Thanks for playing!");
  }

  public int[] evalWinner(int[] winCounter, String user1, String user2) {
    this.winCounter = winCounter;
    this.user1 = user1;
    this.user2 = user2;

    if (user1.equalsIgnoreCase(user2)) {
      System.out.println("Its a tie.");
      winCounter[0]++;
    } else if ((user1.equalsIgnoreCase("rock") && user2.equalsIgnoreCase("scissors"))) {
      declareWinner(1, "rock");
      winCounter[1]++;
    } else if (user1.equalsIgnoreCase("paper") && user2.equalsIgnoreCase("rock")) {
      declareWinner(1, "paper");
      winCounter[1]++;
    } else if ((user1.equalsIgnoreCase("scissors") && user2.equalsIgnoreCase("paper"))) {
      declareWinner(1, "scissors");
      winCounter[1]++;

    } else if ((user2.equalsIgnoreCase("rock") && user1.equalsIgnoreCase("scissors"))) {
      declareWinner(2, "rock");
      winCounter[2]++;
    } else if (user2.equalsIgnoreCase("paper") && user1.equalsIgnoreCase("rock")) {
      declareWinner(2, "paper");
      winCounter[2]++;
    } else if ((user2.equalsIgnoreCase("scissors") && user1.equalsIgnoreCase("paper"))) {
      declareWinner(2, "scissors");
      winCounter[2]++;
    }

    return winCounter;
  }

  public void declareWinner(int user, String s) {
    System.out.println("User " + user + " wins!");
    switch (s) {
      case "rock":
        System.out.println("Rock breaks Scissors!");
        System.out.println();
        break;
      case "paper":
        System.out.println("Paper wraps Rock!");
        System.out.println();
        break;
      case "scissors":
        System.out.println("Scissor cuts Paper!");
        System.out.println();
        break;
    }
  }

  public int readValue(String s, int min, int max) {
    int result = 0;

    do {
      System.out.print(s);
      result = Integer.parseInt(sc.nextLine());
    } while (result < min || result > max);

    return result;
  }

  public void returnResults() {
    System.out.println("Ties: " + winCounter[0]);
    System.out.println("User 1 wins: " + winCounter[1]);
    System.out.println("User 2 wins: " + winCounter[2]);
    System.out.println();

    if (winCounter[1] == winCounter[2]) {
      System.out.println("Its a tie.");
      System.out.println();
    } else if (winCounter[1] > winCounter[2]) {
      System.out.println("User 1 wins.");
      System.out.println();
    } else {
      System.out.println("User 2 wins.");
      System.out.println();
    }
  }
}
