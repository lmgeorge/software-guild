/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class GivingAnArrayABunchOfValuesAtOnce {

  public static void main(String[] args) {
    String[] arr1 = {"alpha", "bravo", "charlie", "delta", "echo"};
    int[] arr2 = {11, 23,37, 41, 53};

    System.out.print("The first array is filled with the following values:\n\t");
    for (String word : arr1) {
      System.out.print(word + " ");
    }
    System.out.println();
    
    System.out.print("The second array is filled with the following values:\n\t");
    for (int num : arr2){
      System.out.print(num + " ");
    }
  }
}

//int i = 0; i < arr1.length; i++