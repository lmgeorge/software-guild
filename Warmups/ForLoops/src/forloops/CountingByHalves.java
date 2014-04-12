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
public class CountingByHalves {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    float num = -10;
    System.out.println("x \t y \n"
      + "_______________________");
    for (float i = num; i <= 10; i+= 0.5) {
      System.out.println(i + " \t " + Math.pow(i,2));
    }
  }
}
