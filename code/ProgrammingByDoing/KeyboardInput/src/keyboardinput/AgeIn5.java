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
public class AgeIn5 {
  public static void main (String[] args){
    String name;
    int age;
    Scanner ui = new Scanner(System.in);
    
    System.out.println("Hello, what is your name? ");
    name = ui.next();
    
    System.out.println(
      "Hi, " + name + "! How old are you? "
    );
    age = ui.nextInt();
    
    System.out.println(
      "Did you know that in five years you will be " + (age + 5) + " years old?\n"
        + "And five years ago you were " + (age - 5) + "! Imagine that!"
    );
    
  }
}
