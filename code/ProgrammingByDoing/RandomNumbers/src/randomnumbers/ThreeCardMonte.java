/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomnumbers;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class ThreeCardMonte {

  public static void main(String[] args) {
    Random r = new Random();
    Scanner ui = new Scanner(System.in);

    int cupNumber = 1 + r.nextInt(3), guess;

    System.out.println(
      "You slide up to Fast Eddie's card table and plop down your cash.\n"
      + "He glances at you out of the corner of his eye and starts shuffling.\n"
      + "He lays down three cards.\n"
      + "\n"
      + "Which one is the ace?\n"
      + "\n"
      + "	##  ##  ##\n"
      + "	##  ##  ##\n"
      + "	1   2   3");
    guess = Integer.parseInt(ui.nextLine());

    if (guess == cupNumber && cupNumber == 1) {
      System.out.println(
        "You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n"
        + "\n"
        + "	AA  ##  ##\n"
        + "	AA  ##  ##\n"
        + "	1   2   3");
    } else if (guess == cupNumber && cupNumber == 2) {
      System.out.println(
        "You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n"
        + "\n"
        + "	##  AA  ##\n"
        + "	##  AA  ##\n"
        + "	1   2   3");
    } else if (guess == cupNumber && cupNumber == 3) {
      System.out.println(
        "You nailed it! Fast Eddie reluctantly hands over your winnings, scowling.\n"
        + "\n"
        + "	##  ##  AA\n"
        + "	##  ##  AA\n"
        + "	1   2   3");
    }
    
    if (guess != cupNumber && cupNumber == 1) {
      System.out.println(
        "Ha! Fast Eddie wins again! The ace was card number."+ cupNumber +"\n"
        + "\n"
        + "	AA  ##  ##\n"
        + "	AA  ##  ##\n"
        + "	1   2   3");
    } else if (guess != cupNumber && cupNumber == 2) {
      System.out.println(
        "Ha! Fast Eddie wins again! The ace was card number."+ cupNumber +"\n"
        + "\n"
        + "	##  AA  ##\n"
        + "	##  AA  ##\n"
        + "	1   2   3");
    } else if (guess != cupNumber && cupNumber == 3) {
      System.out.println(
        "Ha! Fast Eddie wins again! The ace was card number."+ cupNumber +"\n"
        + "\n"
        + "	##  ##  AA\n"
        + "	##  ##  AA\n"
        + "	1   2   3");
    }
  }
}
