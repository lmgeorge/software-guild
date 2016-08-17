/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package methods;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Refresher2 {
  public static void main(String[] args){
    Scanner ui = new Scanner(System.in);
    String name;
    int counter = 10;
   
    System.out.print("What is your name? ");
    name = ui.nextLine();
    
    if (name.equalsIgnoreCase("Mitchell")){
      counter = 5;
    }
    
    for (int i = 0; i < counter; i++){
      System.out.println(name);
    }
    
  }
}
