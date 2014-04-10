/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netbeansprojectwarmups.pkg2;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MinMaxAvg {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    long numInputs;
    float min = 0,
      max = 0,
      avg,
      sum = 0, 
      num;
    

    System.out.print("How many numbers do you want to use?");
    numInputs = Long.parseLong(ui.nextLine());

    for (int i = 0; i < numInputs; i++) {
      System.out.println("Input a number:");
      num = Float.parseFloat(ui.nextLine());

      if (i == 0) {
        min = num;
        max = num;
      } 
      if (num < min) {
        min = num;
      }
      if (num < max){
        max = num;
      } 
      
      sum += num;
    }
    
    avg = sum/numInputs;
    
    System.out.println(
      "Minimum: " + min + "\n"
        + "Maximum: " + max + "\n"
        + "Average: " + avg + "\n"
        + "Sum: " + sum
      
    );

  }
}
