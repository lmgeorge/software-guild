/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whileloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingWhile {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);

    System.out.println("Type in a message, and I'll display how ever many times you want.");
    System.out.print("Message: ");
    String message = ui.nextLine();

    System.out.println("How many times do you want to repeat your message?");
    int n = Integer.parseInt(ui.nextLine());
    int i = 0;
    while (i < n) {
      System.out.println((i*10 + 10) + ". " + message);
      i++;
    }

  }
}
