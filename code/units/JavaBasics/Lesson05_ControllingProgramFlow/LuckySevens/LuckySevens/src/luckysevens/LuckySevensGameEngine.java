/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class LuckySevensGameEngine {

  private int roll1, roll2, rollCounter = 0, betLimit, maxAmountBet = 0, maxAmountRoll = 0;
  private final Random rGen = new Random();
  private final Scanner sc = new Scanner(System.in);

  public void play() {
    System.out.print("How much money do you want to bet? ");
    betLimit = sc.nextInt();
    
    maxAmountBet = betLimit;
    if (betLimit > 0) {
      gamble();
    } else {
      System.out.println("Can't play!");
    }

  }

  public int rollDice() {
    roll1 = rGen.nextInt(6) + 1;
    roll2 = rGen.nextInt(6) + 1;
    int sum = roll1 + roll2;
    return sum;
  }

  public void gamble() {
    while (betLimit > 0) {
      rollCounter++;
      if (rollDice() == 7) {
        betLimit += 4;
        if (betLimit > maxAmountBet) {
          maxAmountBet = betLimit;
          maxAmountRoll = rollCounter;
        }
      } else {
        betLimit -= 1;
      }
    }
    System.out.println("You are broke after " + rollCounter + " rolls.");
    System.out.println(
      "You should have quit after " + maxAmountRoll + " rolls,"
      + " when you had $" + maxAmountBet + ".");
  }


}
