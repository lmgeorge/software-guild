/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package methods;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class DisplayingSomeMultiples {
  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int num;
    
    System.out.print("Choose a number: ");
    num = ui.nextInt();
    
    for (int i = 1; i <= 12; i++){
      System.out.println( 
        num + "x" + i + " = " + (num*i)
      );
    }
   
  
  }
}
