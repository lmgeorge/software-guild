/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.Random;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SelectionSort {

  public static void selectionSort(int[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        swap(a, i, j);
      }
    }
  }

  public static void swap(int[] a, int i, int j) {
    int min;
    if (a[i] < a[j]) {
      min = a[i];
      a[i] = a[j];
      a[j] = min;
    }
  }

  public static void main(String[] args) {
    Random r = new Random();
    int[] arr = new int[10];
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
    selectionSort(arr);

    // Display it again to confirm that it's sorted
    System.out.print("after : ");
    for (i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
