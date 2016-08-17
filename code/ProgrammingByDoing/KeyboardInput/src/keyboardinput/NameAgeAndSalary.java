/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package keyboardinput;

import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class NameAgeAndSalary {
  public static void main (String[] args){
    Scanner userInput = new Scanner(System.in);
    String name, age, wage; //Not evaluating the info, so mutliple types unnecessary 
    
    System.out.println("Hello! What is your name?");
    name = userInput.next();
    
    System.out.println("Hi " + name + "! How old are you?");
    age = userInput.next();
    
    System.out.println("So, you're " + age + ", eh? That's not old at all!\n How much do you make, " + name + "?");
    wage = userInput.next();
    
    System.out.println(wage + "! I hope that's per hour and not per year! LOL!");
  }
}
