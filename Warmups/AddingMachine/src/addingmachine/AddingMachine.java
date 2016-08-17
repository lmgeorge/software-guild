/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addingmachine;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class AddingMachine {
  public static void main (String[] args){
    Scanner ui = new Scanner(System.in);
    int num1;
    String response;
    boolean repeater = true;   
 
    
  System.out.println("Please enter a number:");
  num1 = ui.nextInt();  
  
  do { 
    System.out.println("Please enter another number:");
    num1 += ui.nextInt();
    
    System.out.println(num1);
    
    System.out.println("Would you like to add another number?");
    response = ui.next();
    
  }while(!response.equalsIgnoreCase("no"));
  
 
    
  }
}
