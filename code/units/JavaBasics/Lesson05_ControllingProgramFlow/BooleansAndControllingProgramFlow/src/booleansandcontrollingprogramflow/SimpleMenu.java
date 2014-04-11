/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package booleansandcontrollingprogramflow;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class SimpleMenu {
  public static void main (String[] args){
    Scanner ui = new Scanner(System.in);
    
    System.out.println(
        "Please choose one of the following (enter the number only!) \n"
                + "1. Open File\n"
                + "2. New Document\n"
                + "3. Save Document\n"
                + "4. Exit"
    );
    
    String choice = ui.nextLine();
    
    switch (choice){
        case "1":
            System.out.println("Opening File...");
            break;
        case "2":
            System.out.println("Creating a new document...");
            break;
        case "3":
            System.out.println("Saving document...");
            break;
        case "4":
            System.out.println("Exiting...");
            break;
        default:
            System.out.println("That choice is not available.");
            break;
    }
    
  }
}
