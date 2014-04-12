/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package methods;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class FlickerPhrase {

  public static void main(String[] args) throws Exception{
    Random rng = new Random();
    int r;
    
    for (int i = 0; i < 10; i++) {
      r = 1 + rng.nextInt(5);
      
      switch (r) {
        case 1:
          first();
          break;
        case 2:
          second();
          break;
        case 3:
          third();
          break;
        case 4:
          fourth();
          break;
        case 5:
          fifth();
          break;
      }
     Thread.sleep(600); 
    }
    
    System.out.println("I pledge allegiance to the flag.");
    
  }
  
  public static void first() {
    System.out.print("I                               \n");
  }
  
  public static void second() {
    System.out.print("  pledge                        \n");
  }
  
  public static void third() {
    System.out.print("         allegiance             \n");
  }
  
  public static void fourth() {
    System.out.print("                    to the      \n");
  }
  
  public static void fifth() {
    System.out.print("                           flag.\n");
  }
}
