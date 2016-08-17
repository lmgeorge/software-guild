/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methoddemo;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class MethodDemo {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    
    System.out.println(args.length);
    
    for (int i = 0; i < args.length; i++){
      System.out.println(args[i]);
    }
    
    Scanner ui = new Scanner(System.in);
    int a = 9, 
        b = 7;
    int sum = add(a,b);
    
    
    System.out.println(sum);
    doStuff();
    get5();
    
  }
  
  public static int add1and1() {
    return 1 + 1;
  }

  public static int add(int a, int b) {
    return a + b;
  }
  
  public static void doStuff(){
    System.out.println("Hello");
  }
  
  public static int get5(){
    return 5;
  }
  
  public static void silly (int i){
    System.out.println("My param is " + i);
  }
  
}
