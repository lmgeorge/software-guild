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
public class FindingTheLargestValueInAnArray {

  public static void main(String[] args) {
    int[] values = new int[10];
    int[] valuesCopy = new int[10];
    Random r = new Random();
    Scanner ui = new Scanner(System.in);

    System.out.print("Array: ");
    for (int i = 0; i < values.length; i++) {
      values[i] = r.nextInt(100) + 1;
      valuesCopy[i] = values[i];
      System.out.print(values[i] + " ");
    }

    System.out.print("\nThe largest value is ");
    int largest = 0, slot = 0;
    for (int i = 0; i < values.length - 1; i++) {

      for (int j = 1; j < values.length; j++) {

        if (values[i] > values[j]) {
          largest = values[i];

        } else {
          largest = values[j];
          values[i] = values[j];
        }
      }

      if (i == 0 && valuesCopy[i] == largest) {
        slot = i;
      } else if (valuesCopy[i] == largest) {
        slot = i;
      } else if (i == 0 && valuesCopy[i] != largest) {
        slot = values.length - 1;
      }
    }

    System.out.print(largest + ".\n");
    System.out.println("It is in slot " + slot);
  }
}
