/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifstatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class LittleQuiz {

  public static void main(String[] args) {
    String start;
    int answer1, answer2, answer3;
    int i = 0;
    Scanner ui = new Scanner(System.in);
    // Ask the user if they're ready to start the quiz
    do {
      System.out.println("Are you ready for a quiz? (y/n)");
      start = ui.nextLine();
    } while (start.equalsIgnoreCase("n"));

    //Start quiz
    //Question 1
    do {
      System.out.println(
        "Q1) What is the capital of Alaska? (Enter 1, 2, or 3)\n"
        + "1) Melbourne\n"
        + "2) Anchorage\n"
        + "3) Juneau\n"
      );
      answer1 = Integer.parseInt(ui.nextLine());
    } while (answer1 < 0 || answer1 > 3);
    if (answer1 == 3) {
      System.out.println("\nThat's right!\n");
      i++;
    } else {
      System.out.println("\nSorry, but the answer is Juneau.\n");
    }

    //Question 2
    do {
      System.out.println(
        "Q2) Can you store the value \"cat\" in a variable type of int? (Enter 1 or 2)\n"
        + "1) yes\n"
        + "2) no\n"
      );
      answer2 = Integer.parseInt(ui.nextLine());
    } while (answer1 < 0 || answer1 > 2);
    if (answer2 == 2) {
      System.out.println("\nThat's right!\n");
      i++;
    } else {
      System.out.println("\nSorry, \"cat\" is a string. ints can only store numbers.\n");
    }

    //Question 3
    do {
      System.out.println(
        "Q3) What is the result of 9+6/3? (Enter 1, 2, or 3)?\n"
        + "1) 5\n"
        + "2) 11\n"
        + "3) 15/3\n"
      );
      answer3 = Integer.parseInt(ui.nextLine());
    } while (answer1 < 0 || answer1 > 3);

    if (answer3 == 2) {
      System.out.println("\nThat's right!\n");
      i++;
    } else {
      System.out.println("\nSorry, but the answer is 11. Pay close attention to the order of operations\n");
    }

    //Results
    System.out.println(
      "Overall, you got " + i + " out of 3 correct.\n"
      + "Thanks for playing!"
    );

  }
}
