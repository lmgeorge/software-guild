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
public class TwoMoreQuestions {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    String insideAlive = "houseplant",
      insideNotAlive = "shower curtain",
      outsideAlive = "bison",
      outsideNotAlive = "billboard",
      bothAlive = "dog",
      bothNotAlive = "cellphone",
      answer1,
      answer2,
      compGuess = "";
    int i = 0, j=0;

    System.out.println(
      "TWO MORE QUESTIONS!\n"
      + "Think of an object, and I'll try to guess it.\n"
    );
    do {
     // Is the counter greater than 1? They did not enter a correct input so print this error.
      if (i == 1) {
        System.out.println("\nError: Please enter a valid option.\n"); 
      }
      i = 0; // reset the counter before asking the user for an answer
      
      System.out.print("Question 1) Does it stay \"inside\" or \"outside\" or \"both\"?");
      answer1 = ui.nextLine();
      
      i++;
    } while (!(answer1.equalsIgnoreCase("inside") || answer1.equalsIgnoreCase("outside") || answer1.equalsIgnoreCase("both")));

    do {
      if (j == 1) {
        System.out.println("Please enter a valid option.\n");
      }
      j = 0; 
      
      System.out.print("Question 2) Is it a living thing? \"Yes\" or \"no\"?");
      answer2 = ui.nextLine();
      
      j++;
      
    } while (!(answer2.equalsIgnoreCase("yes") || answer2.equalsIgnoreCase("no")));
    
    if (answer1.equalsIgnoreCase("inside") && answer2.equalsIgnoreCase("yes")){
      System.out.println("Then what else could you be thinking of besides a " + insideAlive + "?!?");
    }
    if (answer1.equalsIgnoreCase("inside") && answer2.equalsIgnoreCase("no")){
      System.out.println("Then what else could you be thinking of besides a " + insideNotAlive + "?!?");
    }
    if (answer1.equalsIgnoreCase("outside") && answer2.equalsIgnoreCase("yes")){
      System.out.println("Then what else could you be thinking of besides a " + outsideAlive + "?!?");
    }
    if (answer1.equalsIgnoreCase("outside") && answer2.equalsIgnoreCase("no")){
      System.out.println("Then what else could you be thinking of besides a " + outsideNotAlive + "?!?");
    }
    if (answer1.equalsIgnoreCase("both") && answer2.equalsIgnoreCase("yes")){
      System.out.println("Then what else could you be thinking of besides a " + bothAlive + "?!?");
    }
    if (answer1.equalsIgnoreCase("both") && answer2.equalsIgnoreCase("no")){
      System.out.println("Then what else could you be thinking of besides a " + bothNotAlive + "?!?");
    }
    
    
    
    
    
    
    
    
  }
}
