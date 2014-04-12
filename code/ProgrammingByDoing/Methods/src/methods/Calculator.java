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
import java.util.Scanner;

public class Calculator {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    double a, b, c;
    String op;

    do {
      System.out.print("> ");
      a = keyboard.nextDouble();
      op = keyboard.next();
      b = keyboard.nextDouble();

     c = simple_math(a,op,b);
     
      if (a == 0) {
        System.out.println("Bye, now.");
      } else {
        System.out.println(c);
      }

    } while (a != 0);

  }

 public static double simple_math(double a,  String op, double b){
   double c;
   switch (op) {
        case "+":
          c = a + b;
          break;
        case "-":
          c = a - b;
          break;
        case "*":
          c = a * b;
          break;
        case "/":
          c = a / b;
          break;
        case "^":
          c = Math.pow(a, b);
          break;
        default:
          System.out.println("Undefined operator: '" + op + "'.");
          c = 0;
          break;
      }
   return c;
 }
}