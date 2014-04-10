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
public class AlphabeticalOrder {
  public static void main(String[]args){
    Scanner ui = new Scanner(System.in);
    String name;
    
    System.out.println("What's your last name? ");
    name = ui.nextLine();
    
   
    if (name.compareTo("Carswell") <= 0) {
      System.out.println("You don't have to wait long.");
    }else if (name.compareTo("Jones") <= 0){
      System.out.println("That's not bad.");
    }else if (name.compareTo("Smith") <= 0){
      System.out.println("Looks like a bit of a wait.");
    }else if (name.compareTo("Young") <= 0){
      System.out.println("It's gonna be a while.");
    }else if (name.compareTo("Young") > 0){
      System.out.println("Not going anywhere for a while?");
    }

  }
}
