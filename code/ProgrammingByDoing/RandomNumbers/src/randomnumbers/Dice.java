/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package randomnumbers;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class Dice {
  public static void main (String[] args){
    Random r = new Random();
    
    int rGen1 = 1 + r.nextInt(6),
        rGen2 = 1 + r.nextInt(6);
    
    System.out.println(
      "HERE COMES THE DICE!\n"
        + "Roll #1: " + rGen1 + "\n"
        + "Roll #2: " + rGen2 + "\n"
        + "The total is " + (rGen2 + rGen1)
    );
  }
}
