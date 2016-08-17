/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class FindingAValueInAnArray {

  public static void main(String[] args) {
    int[] values = new int[10];
    Random r = new Random();
    Scanner ui = new Scanner(System.in);

    System.out.print("Array: ");
    for (int i = 0; i < values.length; i++) {
      values[i] = r.nextInt(50) + 1;
      System.out.print(values[i] + " ");
    }
    
    
    System.out.print("\nValue to find: ");
    int checkValue = ui.nextInt();
    int j = 0;
    for (int i = 0; i < values.length; i++) {

      if (values[i] == checkValue) { 
        j++;  
      }
     
    }
    System.out.println(checkValue + " was found " + j + " times.");
  }
}
