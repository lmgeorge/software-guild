/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BlackJack {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Random r = new Random();
    Scanner ui = new Scanner(System.in);
    final int STAY = 1;
    final int HIT = 2;

    int pDraw1, pDraw2, dDraw1, dDraw2, pSum, dSum, dHitStay;
    String hitStay = "";
    System.out.println("Welcome to Blackjack!\n");

    pDraw1 = 1 + r.nextInt(11);
    pDraw2 = 1 + r.nextInt(11);
    pSum = pDraw1 + pDraw2;

    dDraw1 = 1 + r.nextInt(11);
    dDraw2 = 1 + r.nextInt(11);
    dSum = dDraw1 + dDraw2;

    System.out.println("You drew " + pDraw1 + " and " + pDraw2 + ".\n"
      + "Your total is " + (pSum) + ".\n");

    System.out.println("The dealer has " + dDraw1 + " showing, and a hidden card.\n"
      + "Her total is hidden, too.\n");

    do {
      System.out.println("Do you want to hit or stay?");
      hitStay = ui.nextLine();
      if (hitStay.equalsIgnoreCase("hit")) {
        pDraw1 = 1 + r.nextInt(11);
        pSum += pDraw1;
        System.out.println("You drew " + pDraw1 + ".\n"
          + "Your total is " + (pSum) + ".\n");
      }
      if (pSum > 21) {
        //System.out.println("YOU LOSE!\n");
        hitStay = "stay";
      }
    } while (hitStay.equalsIgnoreCase("hit"));
    
    
    if (pSum <= 21) {
      System.out.println("\nOkay, dealer's turn.\n"
        + "Her hidden card was " + dDraw2 + ".\n"
        + "Her total was " + dSum + ".\n");

      do {
        dHitStay = 1 + r.nextInt(2);

        if (dHitStay == HIT) {
          dDraw1 = 1 + r.nextInt(11);
          dSum += dDraw1;

          System.out.println(
            "Dealer chooses to hit."
            + "She draws a " + dDraw1 + ".\n"
            + "Her total is " + dSum + ".\n");
          if (dSum > 16) {
            System.out.println("Dealer stays.\n");
          }
        } else {
          System.out.println("Dealer stays.\n");
          dHitStay = STAY;
        }

      } while (pSum <= 21 && dSum < 16 && dHitStay == HIT);
    }

    
    System.out.println(
      "Dealer total is " + dSum + ".\n"
      + "Your total is " + pSum + ".\n"
    );

    if (dSum < pSum && pSum <= 21) {
      System.out.println("YOU WIN!");
    } else {
      System.out.println("YOU LOSE!");
    }
  }

}
