/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbers;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class OneShotHiLo {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner ui = new Scanner(System.in);

    int rGen = 1 + r.nextInt(100),
      guess;

    System.out.println("I'm thinking of a number between 1-100.  Try to guess it.");
    guess = Integer.parseInt(ui.nextLine());

    if (guess == rGen) {
      System.out.println("You guessed it!  What are the odds?!?");
    } else if (guess > rGen) {
      System.out.println("Sorry, you are too high.  I was thinking of " + rGen);
    } else if (guess < rGen) {
      System.out.println("Sorry, you are too low.  I was thinking of " + rGen);
    }
  }
}
