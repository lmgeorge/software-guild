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
 * @author lmgeorge <lauren.george@live.com>
 */
public class BlackJackEngine {

  private Random r = new Random();
  private Scanner ui = new Scanner(System.in);
  final int STAY = 1;
  final int HIT = 2;

  private int pDraw1, pDraw2, dDraw1, dDraw2, pSum, dSum, dHitStay;
  private String hitStay = "";

  public void play() throws Exception {

    System.out.println("Welcome to Blackjack!\n");

    runFirstPlay();

    runUserPlay();

    runDealerPlay();
    
    
  }

  public void draw2() {
    pDraw1 = 1 + r.nextInt(11);
    pDraw2 = 1 + r.nextInt(11);
    pSum = pDraw1 + pDraw2;

    dDraw1 = 1 + r.nextInt(11);
    dDraw2 = 1 + r.nextInt(11);
    dSum = dDraw1 + dDraw2;

  }

  public void runFirstPlay() {
    draw2();
    System.out.println("You drew " + pDraw1 + " and " + pDraw2 + ".\n"
      + "Your total is " + (pSum) + ".\n");
    
    if (pSum >= 21){
      returnWinner();
    }

    System.out.println("The dealer has " + dDraw1 + " showing, and a hidden card.\n"
      + "Her total is hidden, too.\n");
    
    if (dSum >= 21){
      returnWinner();
    }
  }

  public void runUserPlay() {
    do {
      System.out.println("Do you want to hit or stay?");
      hitStay = ui.nextLine();

      if (hitStay.equalsIgnoreCase("hit")) {
        pDraw1 = 1 + r.nextInt(11);
        pSum += pDraw1;
        System.out.println("You drew " + pDraw1 + ".\n"
          + "Your total is " + (pSum) + ".\n");
      }
      if (pSum >= 21) {
        returnWinner();
        hitStay = "stay";
      }
    } while (hitStay.equalsIgnoreCase("hit"));
  }

  public void runDealerPlay() throws Exception {
    if (pSum < 21) {
      System.out.println("\nOkay, dealer's turn...\n");

      Thread.sleep(1000);

      System.out.println(
        "Her hidden card was " + dDraw2 + ".\n"
        + "Her total was " + dSum + ".\n");

      do {
        dHitStay = 1 + r.nextInt(2);

        if (dHitStay == HIT) {
          dDraw1 = 1 + r.nextInt(11);
          dSum += dDraw1;
          if (dSum > 16) {
            Thread.sleep(2000);
            System.out.println("Dealer stays.\n");
            returnWinner();
          } else if (dSum >= 21) {
            returnWinner();
            dHitStay = STAY;
          } else {
            System.out.println(
              "Dealer chooses to hit.\n"
              + "She draws a " + dDraw1 + ".\n"
              + "Her total is " + dSum + ".\n");
          }
        } else {
          Thread.sleep(2000);
          System.out.println("Dealer stays.\n");
          returnWinner();
          dHitStay = STAY;
        }

      } while (dSum < 16 && dHitStay == HIT);
    }
  }

  public void returnWinner() {

    System.out.println(
      "Dealer total is " + dSum + ".\n"
      + "Your total is " + pSum + ".\n"
    );
    if (dSum < pSum && pSum <= 21) {
      System.out.println("YOU WIN!");
    } else if (dSum == pSum) {
      System.out.println("It's a tie...");
    } else {
      System.out.println("YOU LOSE!");
    }
  }


}
