/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */

import java.util.Scanner;
public class HowOldAreYou {
  public static void main (String[] args){
      Scanner ui = new Scanner(System.in);
      String name;
      int age;
      
      System.out.println("Hey, what's your name?");
      name = ui.next();
      
      System.out.println("Ok, " + name + ", how old are you?");
      age = ui.nextInt();
      
      if (age < 16) {
        System.out.println("You can't drive, " + name + ".");
        System.out.println("You can't vote, " + name + ".");
        System.out.println("You can't rent a car, " + name);
      }else if(age < 18) {
        System.out.println("You can't vote, " + name + ".");
        System.out.println("You can't rent a car, " + name + ".");
      } else if (age < 25) {
        System.out.println("You can't rent a car, " + name + ".");
      } else{
        System.out.println("You can do anything that's legal.");
      } 
        
      
   
      
  }

}
