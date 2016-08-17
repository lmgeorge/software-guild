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
public class BasicArrays0thru2 {

  public static void main(String[] args) {
    Random r = new Random();
    int[] nums = new int[10];

    for (int i = 0; i < nums.length; i++) {
      int rGen = r.nextInt(100) + 1;
      nums[i] = rGen;
      System.out.println("Slot " + i + " contains a " + nums[i]);
    }
  }
}
