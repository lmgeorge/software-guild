/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

/**
 *
 * @author apprentice
 */
public class EvennessFunction {

  public static void main(String[] args) {
    for (int i = 1; i <= 20; i++) {
      if (isEven(i) && isDivisbleBy3(i)) {
        System.out.println(i + " <=");
      } else if (isDivisbleBy3(i)) {
        System.out.println(i + " =");
      } else if (isEven(i)) {
        System.out.println(i + " <");
      } else {
        System.out.println(i);
      }
    }
  }
  
  public static boolean isEven (int i){
   boolean bool = false;
    
    if (i%2 == 0){
     bool = true;
   } 
    return bool;
  }
  public static boolean isDivisbleBy3(int i){
   boolean bool = false;
    
    if (i%3 == 0){
     bool = true;
   } 
    return bool;
  }
}
