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
public class DumbCalculator {
  public static void main (String[] args) {
    Float num1, num2, num3;
    Scanner ui = new Scanner(System.in);
    
    
    System.out.println("What is your first number?");
    num1 = ui.nextFloat();
   
    System.out.println("What is your first number?");
    num2 = ui.nextFloat();
    
    System.out.println("What is your first number?");
    num3 = ui.nextFloat();
    
    System.out.println(
      "(" + num1 + " + " + num2 + " + " + num3 + ") / 2 is ..." + ((num1+num2+num3)/2)
        );
  }
}
