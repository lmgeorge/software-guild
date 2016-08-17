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
public class AgeMessages3 {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    String name;
    int age;

    System.out.println("Hey, what's your name? (Sorry, I keep forgetting.)");
    name = ui.nextLine();

    System.out.println("Ok, " + name + ", how old are you?");
    age = Integer.parseInt(ui.nextLine());

    if (age < 16) {
      System.out.println("You can't drive, " + name + ".");
    }
    if (age < 18 && age >= 16) {
      System.out.println("You can drive, but you can't vote " + name + ".");
    }
    if (age < 25 && age >= 18) {
      System.out.println("You can vote, but you can't rent a car, " + name + ".");
    }     
    if (age >= 25){
      System.out.println("You can do pretty much anything that's legal.");
    }
  }
}
