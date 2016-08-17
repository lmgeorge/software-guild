/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefinder;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class PrimeFinder {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int num1, num2;
    boolean prime;

    System.out.println(
      "PRIME FINDER!!\n"
      + "Please enter two numbers, I will return all of the primes in between.\n"
      + "First number:"
    );

    num1 = 3;//ui.nextInt();

    while (num1 < 0) {
      System.out.println("Error: Please enter a number greater than zero: ");
      num1 = ui.nextInt();
    }

    System.out.println("Please enter a second number: ");
    num2 = 12;//ui.nextInt();

    while (num2 < num1) {
      System.out.println("Error: Please enter a number greater than your first number: ");
      num2 = ui.nextInt();
    }

    System.out.println(" Here are your primes:");
    for (int i = num1; i <= num2; i++) {
      prime = true;
      for (int j = 2; j < i; j++) {
        if (i % j == 0) {
          prime = false;
        }
      }
      if (prime == true) {
        System.out.println(i);
      }
    }

  }
}
