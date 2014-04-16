/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SimpleCalcEngine {

  private final Scanner ui = new Scanner(System.in);
  private int menuChoice;
  private double a, b, c;

  public int displayMenu() {
    System.out.println(
      "Choose an operation:\n"
      + "1. Addition\n"
      + "2. Subtraction\n"
      + "3. Multiplication\n"
      + "4. Division\n"
      + "5.Exit"
    );
    menuChoice = Integer.parseInt(ui.nextLine());
    return menuChoice;
  }

  public void getUI() {

    do {
      displayMenu();
      
      a = ui.nextDouble();
      b = ui.nextDouble();
      c = simpleMath(menuChoice, a, b);
      
      
      
      if (displayMenu() == 5) {
        System.out.println();
        System.out.println("Thank you!");
      } else {
        System.out.println(c);
      }

    } while (displayMenu() != 5);

  }

  /**
   * @param menuChoice
   * @param userChoice
   *
   * @param a
   * @param op
   * @param b
   * @return
   */
  public double calculate(int menuChoice, double a, double b) {
    this.menuChoice = menuChoice;

    switch (menuChoice) {
      case 1:
        c = a + b;
        break;
      case 2:
        c = a - b;
        break;
      case 3:
        c = a * b;
        break;
      case 4:
        c = a / b;
        break;
      default:
        System.out.println("Incorrect menu choice: '" + userChoice + "'.");
        break;
    }
    return c;
  }
}
