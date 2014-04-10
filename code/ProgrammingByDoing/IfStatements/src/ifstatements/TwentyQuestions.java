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
public class TwentyQuestions {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    String animalSmall = "squirrel",
      animalBig = "moose",
      vegSmall = "carrot",
      vegBig = "watermelon",
      mineralSmall = "paper clip",
      mineralBig = "Camaro",
      answer1,
      answer2,
      compGuess = "";

    System.out.println(
      "TWO QUESTIONS!\n"
      + "Think of an object, and I'll try to guess it.\n"
    );
    do {
      System.out.println("Question 1) Is it animal, mineral, or vegetable?");
      answer1 = ui.nextLine();

      switch (answer1.toLowerCase()) {
        case "animal":
          break;
        case "mineral":
          break;
        case "vegetable":
          break;
        default:
          answer1 = "I have no idea.";
          System.out.println("\nPlease enter a valid type.\n");
          break;
      }
    } while (answer1.equalsIgnoreCase("I have no idea."));

    do {
      System.out.println("\nQuestion 2) Is it bigger than a breadbox?");
      answer2 = ui.nextLine();

      if (answer2.equalsIgnoreCase("yes")) {
        switch (answer1.toLowerCase()) {
          case "animal":
            compGuess = animalBig;
            break;
          case "mineral":
            compGuess = mineralBig;
            break;
          case "vegetable":
            compGuess = vegBig;
            break;
          default:
            compGuess = "I have no idea.";
            break;
        }
      } else if (answer2.equalsIgnoreCase("no")) {
        switch (answer1.toLowerCase()) {
          case "animal":
            compGuess = animalSmall;
            break;
          case "mineral":
            compGuess = mineralSmall;
            break;
          case "vegetable":
            compGuess = vegSmall;
            break;
          default:
            compGuess = "I have no idea.";
            break;
        }
      } else {
        answer2 = "Error";
        System.out.println("\nPlease answer yes or no.");
      }
    }while (answer2.equals("Error"));
    System.out.println(
      "\nMy guess is that you are thinking of a " + compGuess + ".\n"
      + "I would ask you if I'm right, but I don't actually care."
    );
  }
}
