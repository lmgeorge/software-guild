/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class BubbleSort {

  public static void bubbleSort(int[] a) {
   for (int firstNum = 0; firstNum < a.length; firstNum++){
     for (int secondNum = 0; secondNum < a.length; secondNum++){
       swap(a, firstNum, secondNum);
     }
   }
  }

  public static void swap(int[] a, int i, int j) {
    int swapper;
    //System.out.println("Is " + a[i] + " < " + a[j]+ "?");
    //System.out.println(Arrays.toString(a) + "\n");
    if (a[i] < a[j]){
      swapper = a[j];
      a[j] = a[i];
      a[i] = swapper;
      //System.out.println(Arrays.toString(a) + "\n");
    }
  }

  public static void main(String[] args) {
    Random r = new Random();
    int[] arr = new int[5];
    int i;

    // Fill up the array with random numbers
    for (i = 0; i < arr.length; i++) {
      arr[i] = 1 + r.nextInt(100);
    }

    // Display it
    System.out.print("before: ");
    for (i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    // Sort it
    bubbleSort(arr);

    // Display it again to confirm that it's sorted
    System.out.print("after : ");
    for (i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
