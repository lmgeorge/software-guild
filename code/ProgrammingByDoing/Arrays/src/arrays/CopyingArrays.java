/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Random;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class CopyingArrays {

  public static void main(String[] args) {
    Random r = new Random();
    int[] nums = new int[10];
    int[] nums2 = new int[10];

    for (int i = 0; i < nums.length; i++) {
      int rGen = r.nextInt(100) + 1;
      nums[i] = rGen;
      nums2[i] = nums[i];
      if (i == nums.length - 1){
        rGen = r.nextInt(100) + 1;
        nums2[i] = rGen;
        nums[i] = -7;
      }
    }
    System.out.print("Array 1: ");
    for (int i = 0; i < nums.length; i++){
      System.out.print(nums[i] + "  ");
    }
    System.out.println();
    System.out.print("Array 2: ");
    for (int i = 0; i < nums2.length; i++){
      System.out.print(nums2[i] + "  ");
    }
  }
}
