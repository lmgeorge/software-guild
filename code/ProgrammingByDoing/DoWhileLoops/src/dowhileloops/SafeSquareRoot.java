/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dowhileloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SafeSquareRoot {
public static void main (String[] args){
  Scanner ui = new Scanner(System.in);
  
  double n;
  
  System.out.println("SQUARE ROOT!\n"
    + "Enter a number:");
  
//  n = Double.parseDouble(ui.nextLine());
//  while (n < 0) {
//    System.out.println("You can't take the square root of a negative number, silly.\n"
//      + "Try again:");
//    n = Double.parseDouble(ui.nextLine());
//  }
   do {
    n = Double.parseDouble(ui.nextLine());
    if (n < 0){
    System.out.println("You can't take the square root of a negative number, silly.\n"
      + "Try again:");
    }
  }while (n < 0);
  
  System.out.println(
    "The square root of " + n + " is " + Math.sqrt(n)
  );
  
}  
}
