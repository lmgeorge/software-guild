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
public class NoticingEvenNumbers {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int num = 20;

    for (int i = 1; i <= num; i++) {
      if (i % 2 == 0) {
        System.out.println(i + " <");
      } else {
        System.out.println(i);
      }
    }
  }
}
