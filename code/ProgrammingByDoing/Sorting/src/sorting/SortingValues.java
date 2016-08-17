/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SortingValues {

  public static void main(String[] args) {
    int[] arr = {45, 87, 39, 32, 93, 86, 12, 44, 75, 50};
    int swapper;
    // Display the original (unsorted values)
    System.out.print("before: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();

    for (int first = 0; first < arr.length; first++) {
      for (int second = 0; second < arr.length; second++) {
        if (arr[first] < arr[second]) {
          //if first is greater than second value
          // swap the values 
          swapper = arr[first];

          arr[first] = arr[second];

          arr[second] = swapper;
        }
      }

    } // Display the values again, now (hopefully) sorted.
    System.out.print("after : ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }
}
