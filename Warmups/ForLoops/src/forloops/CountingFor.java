/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingFor {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    System.out.println("Type in a message, and I'll display it five times.");
    System.out.print("Message: ");
    String message = keyboard.nextLine();

    for (int n = 1; n <= 10; n ++) {
      System.out.println((n*2) + ". " + message);
    }

  }
  
}
