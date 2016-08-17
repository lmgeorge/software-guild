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
public class AddingValuesForLoop {
  public static void main(String[] args){
    Scanner ui = new Scanner(System.in);
    
    int num, sum = 0;
    
    System.out.print("Number: ");
    num = ui.nextInt();
    
    for (int i = 0; i <= num; i++){
      System.out.print(i + "  ");
      sum +=i;
    }
    
    System.out.println("\nThe sum is " + sum);
    
    
  }
}
