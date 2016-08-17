/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fizzbuzz;

/**
 *
 * @author apprentice
 */
public class Fizzbuzz {

  public static void main(String[] args) {
    for (int i = 0; i <= 100; i++) {
      if (i%15 == 0) {
        System.out.println("FIZZBUZZ");
      } else if (i%5 == 0) {
        System.out.println("BUZZ");
      } else if (i%3 == 0) {
        System.out.println("FIZZ");
      } else {
        System.out.println(i);
      }
    }
  }
}
