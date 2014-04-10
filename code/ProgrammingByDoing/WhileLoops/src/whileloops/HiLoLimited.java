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
public class HiLoLimited {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner ui = new Scanner(System.in);

    int rGen = 1 + r.nextInt(100),
      guess, i = 1;

    System.out.println("I'm thinking of a number between 1-100.  Try to guess it.\n"
      + "First guess: ");
    guess = Integer.parseInt(ui.nextLine());

    while (i < 7 && guess != rGen) {
      if (guess > rGen) {
        System.out.println("Sorry, you are too high.");
      } else if (guess < rGen) {
        System.out.println("Sorry, you are too low.");
      }

      System.out.println("Guess #" + (i+1) + ":");
      guess = Integer.parseInt(ui.nextLine());
      i++;
      if (i == 7) {
        System.out.println("Sorry, you didn't guess it in 7 tries.  You lose.");
      }
    }
    if (guess == rGen) {
      System.out.println("You guessed it!  What are the odds?!?");
    } else {
      
    }
  }
}
