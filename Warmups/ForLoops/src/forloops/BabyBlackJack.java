/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forloops;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class BabyBlackJack {
  public static void main(String[]  args){
    Random r = new Random();
    
    
    int pDraw1, pDraw2, dDraw1, dDraw2, pSum, dSum;
    
    System.out.println("Baby Blackjack!");
    
    pDraw1 = 1 + r.nextInt(10);
    pDraw2 = 1 + r.nextInt(10);
    pSum = pDraw1 + pDraw2;
    
    
    dDraw1 = 1 + r.nextInt(10);
    dDraw2 = 1 + r.nextInt(10);
    dSum = dDraw1 + dDraw2;
    
    System.out.println("You drew " + pDraw1 + " and " + pDraw2 + ".\n"
      + "Your total is " + (pSum) + ".");
    
    System.out.println("The dealer has " + dDraw1 + " and " + dDraw2 + ".\n"
      + "Dealer's total is " + (dSum) + ".");
    
    if (dSum < pSum){
      System.out.println("YOU WIN!");
    }else{
      System.out.println("YOU LOSE!");
    }
  }
}
