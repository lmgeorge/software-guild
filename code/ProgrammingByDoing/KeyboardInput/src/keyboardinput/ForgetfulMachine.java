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
public class ForgetfulMachine {
  public static void main (String[] args){
    Scanner keyboard = new Scanner(System.in);
    //String first, second;
    //int num1, num2;
    
    System.out.println("Give me a word!");
    //first =
    keyboard.next();
    
    System.out.println("Give me a second word!");
    //second = 
    keyboard.next();
    
    System.out.println("Great, now what's your favorit number?");
    //num1 = 
    keyboard.nextInt();
    
    System.out.println("And your second favorite number?");
    //num2 =
    keyboard.nextInt();
    
    System.out.println("Whew! Wasn't that fun?");
    //System.out.println(first + second + num1 + num2);
  }
}
