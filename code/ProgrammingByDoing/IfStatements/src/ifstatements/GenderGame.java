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
public class GenderGame {
  public static void main(String[] args){
    Scanner ui = new Scanner(System.in);
    String gender,
           firstName,
           lastName,
           maritalStatus = "";
    int age;
    
    System.out.print("What is your gender (M of F): ");
    gender = ui.nextLine();
    
    System.out.print("First Name: ");
    firstName = ui.nextLine();
    
    System.out.print("Last Name: ");
    lastName = ui.nextLine();
    
    System.out.print("Age: ");
    age = Integer.parseInt(ui.nextLine());
    
    if (age > 20 && gender.equalsIgnoreCase("f")){
    System.out.print("Are you married, "+ firstName + " (y or n)? ");
    maritalStatus = ui.nextLine();
    }
    
    if (gender.equalsIgnoreCase("m") && age > 20){
      System.out.println("Then I shall call you Mr. " + lastName);
    }
    if (gender.equalsIgnoreCase("f") && age > 20 && maritalStatus.equalsIgnoreCase("y")){
      System.out.println("Then I shall call you Mrs. " + lastName);
    }
    if (gender.equalsIgnoreCase("f") && age > 20 && maritalStatus.equalsIgnoreCase("n")){
      System.out.println("Then I shall call you Ms. " + lastName);
    }
    if (age < 20){
      System.out.println("Then I shall call you "+ firstName + " " + lastName + ".");
    }
    
  }
  
}
