/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whileloops;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class KeepGuessing {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    Random rGen = new Random();

    int guess,
      r = 1 + rGen.nextInt(10);

    System.out.println(
      "I'm thinking of a number from 1 to 10.\n"
      + "Your guess: "
    );
    guess = Integer.parseInt(ui.nextLine());

    while (guess != r) {
      System.out.println("That is incorrect. Guess again.");
      guess = Integer.parseInt(ui.nextLine());
    }
    
    if (guess == r) {
      System.out.println("That's right! You're a good guesser.");
    }
  }
}
