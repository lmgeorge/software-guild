/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.util.Random;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class BlackJackEngine {
  protected ConsoleIO c = new ConsoleIO();
  private final Random r = new Random();

  final int STAY = 1;
  final int HIT = 2;

  private int pDraw1, pDraw2, dDraw1, dDraw2, pSum, dSum;
  private String hitStay = "";

  public void play() throws Exception {

    c.println("Welcome to Blackjack!\n");

    runFirstPlay();

    runUserPlay();

    runDealerPlay();

  }

  public void draw2() {
    pDraw1 = 2 + r.nextInt(10);
    pDraw2 = 2 + r.nextInt(10);
    pSum = pDraw1 + pDraw2;

    dDraw1 = 2 + r.nextInt(10);
    dDraw2 = 2 + r.nextInt(10);
    dSum = dDraw1 + dDraw2;

  }

  public void runFirstPlay() {
    draw2();

    c.println("You drew " + pDraw1 + " and " + pDraw2 + ".\n"
      + "Your total is " + (pSum) + ".\n");

    if (pSum >= 21) {
      returnWinner(pSum, dSum);
    }

    c.println("The dealer has " + dDraw1 + " showing, and a hidden card.\n"
      + "Her total is hidden, too.\n");

    if (dSum >= 21) {
      returnWinner(pSum, dSum);
    }
  }

  public void runUserPlay() {
    do {
      
      hitStay = c.gets("Do you want to hit or stay? ");

      if (hitStay.equalsIgnoreCase("hit")) {
        pDraw1 = 1 + r.nextInt(11);
        pSum += pDraw1;
        c.println("You drew " + pDraw1 + ".\n"
          + "Your total is " + (pSum) + ".\n");
      }
      if (pSum >= 21) {
        hitStay = returnWinner(pSum, dSum);
      }
    } while (hitStay.equalsIgnoreCase("hit"));
  }

  public void runDealerPlay() throws Exception {
    if (pSum < 21) {
      c.println("\nOkay, dealer's turn...\n");

      Thread.sleep(1000);

      c.println(
        "Her hidden card was " + dDraw2 + ".\n"
        + "Her total was " + dSum + ".\n");

      do {

        if (dSum < 16) {

          if (dSum > 16) {

            Thread.sleep(2000);

            c.println("Dealer stays.\n");
            hitStay = returnWinner(pSum, dSum);

          } else if (dSum >= 21) {
            hitStay = returnWinner(pSum, dSum);

          } else {
            dDraw1 = 2 + r.nextInt(10);
            dSum += dDraw1;
            c.println(
              "Dealer chooses to hit.\n"
              + "She draws a " + dDraw1 + ".\n"
              + "Her total is " + dSum + ".\n");
            hitStay = returnWinner(pSum, dSum);
          }
        } else {

          Thread.sleep(2000);

          c.println("Dealer stays.\n");
          hitStay = returnWinner(pSum, dSum);
        }

      } while (dSum < 16 && hitStay.equalsIgnoreCase("hit"));
    }
  }

  public String returnWinner(int pSum, int dSum) {
    this.pSum = pSum;
    this.dSum = dSum;

    c.println(
      "Dealer total is " + dSum + ".\n"
      + "Your total is " + pSum + ".\n"
    );
    if ((dSum < pSum && pSum <= 21) || dSum > 21) {
      c.println("YOU WIN!");
      hitStay = "stay";
    } else if (dSum == pSum) {
      c.println("It's a tie...dealer wins.");
      hitStay = "stay";
    } else {
      c.println("YOU LOSE!");
      hitStay = "stay";
    }

    return hitStay;
  }

}
