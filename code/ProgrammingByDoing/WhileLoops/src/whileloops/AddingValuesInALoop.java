/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whileloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class AddingValuesInALoop {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
   
    System.out.println("I will add up the numbers you give me.\n"
      + "Number: ");
      float num = 1, i = 0;
    while (num != 0){ 
      num = Float.parseFloat(ui.nextLine());
      i+= num;
  
      System.out.println("The total so far is " + i);
      System.out.println("Number: ");
  }
      System.out.println("\n\nThe total so far is " + i);
      
      
  }
}
