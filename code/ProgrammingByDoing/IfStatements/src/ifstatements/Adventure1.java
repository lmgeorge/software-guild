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
public class Adventure1 {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    String choice;
    System.out.println(
      "WELCOME TO LAUREN'S TINY ADVENTURE!\n"
      + "\nYou are in a creepy house! Would you like to go \"upstairs\" or into the \"kitchen\"?"
    );
    choice = ui.nextLine();

    if (choice.equalsIgnoreCase("kitchen")) {
      System.out.println(
        "There is a long countertop with dirty dishes everywhere.  Off to one side\n"
        + "there is, as you'd expect, a refrigerator. You may open the \"refrigerator\"\n"
        + "or look in a \"cabinet\"."
      );
      choice = ui.nextLine();
      if (choice.equalsIgnoreCase("refrigerator")) {
        System.out.println(
          "Inside the refrigerator you see food and stuff.  It looks pretty nasty.\n"
          + "Would you like to eat some of the food? (\"yes\" or \"no\")"
        );
        choice = ui.nextLine();
        if (choice.equalsIgnoreCase("no")) {
          System.out.println("You die of starvation... eventually.");
        } else if (choice.equalsIgnoreCase("yes")) {
          System.out.println("You died violently and mysteriously involving rat poison. Thanks for playing!");
        }else{
          System.out.println("I didn't catch that. Please try again.");
        }
      } else  if (choice.equalsIgnoreCase("cabinet"))  {
        System.out.println(
          "Inside the cabinet you see food and stuff.  It looks pretty tasty.\n"
          + "Would you like to eat some of the food? (\"yes\" or \"no\")"
        );
        choice = ui.nextLine();
        if (choice.equalsIgnoreCase("no")) {
          System.out.println("You die of starvation... eventually.");
        } else  if (choice.equalsIgnoreCase("yes")) {
          System.out.println("You died violently and mysteriously involving asphyxiation. Thanks for playing!");
        }else{
          System.out.println("I didn't catch that. Please try again.");
        }
      }else{
          System.out.println("I didn't catch that. Please try again.");
        }
    } else  if (choice.equalsIgnoreCase("upstairs")) {
      System.out.println(
        "Upstairs you see a hallway.  At the end of the hallway is the master\n"
        + "\"bedroom\".  There is also a \"bathroom\" off the hallway.  Where would you like\n"
        + "to go?"
      );
      choice = ui.nextLine();
      if (choice.equalsIgnoreCase("bedroom")) {
        System.out.println(
          "You are in a plush bedroom, with expensive-looking hardwood furniture.  The\n"
          + "bed is unmade.  In the back of the room, the closet door is ajar.  Would you\n"
          + "like to open the door? (\"yes\" or \"no\")"
        );
        choice = ui.nextLine();
        if (choice.equalsIgnoreCase("yes")) {
          System.out.println("You died violently and mysteriously involving an axe. Thanks for playing!");
        } else  if (choice.equalsIgnoreCase("no")) {
          System.out.println(
            "Well, then I guess you'll never know what was in there.  Thanks for playing,\n"
            + "I'm tired of making nested if statements."
          );
        }else{
          System.out.println("I didn't catch that. Please try again.");
        }
      } else  if (choice.equalsIgnoreCase("bathroom")) {
        System.out.println("You are in a dirty bathroom. It reeks! You hear the shower curtain rustle.\n"
          + "Do you \"stay\" or \"run\"?");
        choice = ui.nextLine();
        if (choice.equalsIgnoreCase("run")) {
          System.out.println("Finally, someone smart. Too bad you die anyway. Thanks for playing!");
        } else  if (choice.equalsIgnoreCase("stay")) {
          System.out.println("You died violently and mysteriously in a toilet. Thanks for playing!");
        }else{
          System.out.println("I didn't catch that. Please try again.");
        }
      }else{
          System.out.println("I didn't catch that. Please try again.");
        }
    }else{
          System.out.println("I didn't catch that. Please try again.");
        }
  }
}
