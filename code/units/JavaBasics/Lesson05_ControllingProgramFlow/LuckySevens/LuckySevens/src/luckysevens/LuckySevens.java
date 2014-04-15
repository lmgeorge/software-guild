/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package luckysevens;

/**
 *
 * @author apprentice
 */
public class LuckySevens {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
      LuckySevensGameEngine game = new LuckySevensGameEngine();
      game.play();
      
    
    
//    int roll1, roll2, rollCounter = 0, betLimit, maxAmountBet = 0, maxAmountRoll = 0;
//    Random rGen = new Random();
//    Scanner sc = new Scanner(System.in);
//
//    System.out.print("How much money do you want to bet? ");
//    betLimit = sc.nextInt();
//    
//    // luckySevens.play(betLimit); //game code should stop here
//    
//   //Move everything to new class
//    maxAmountBet = betLimit;
//    if (betLimit > 0) {
//      while (betLimit > 0) {
//        roll1 = rGen.nextInt(6) + 1;
//        roll2 = rGen.nextInt(6) + 1;
//        rollCounter++;
//        if (roll1 + roll2 == 7) {
//          betLimit += 4;
//          if (betLimit > maxAmountBet) {
//            maxAmountBet = betLimit;
//            maxAmountRoll = rollCounter;
//          }
//        } else {
//          betLimit -= 1;
//        }
//      }
//      System.out.println("You are broke after " + rollCounter + " rolls.");
//      System.out.println("You should have quit after " + maxAmountRoll + " rolls, when you had " + maxAmountBet + ".");
//    } else {
//      System.out.println("Can't play!");
    
    }

}
