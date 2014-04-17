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
public class SimpleCalcEngine2 {

  private final Scanner ui = new Scanner(System.in);
  private int menuChoice;
  private double a, b, c;
  private boolean valid;
  private final ConsoleIO cio = new ConsoleIO();
  public void startCalculator() {
    do {
      menuChoice = displayMenu();
      cio.println();

      if (menuChoice != 5) {
        getOperands(menuChoice);

        simpleMath(menuChoice, a, b);
      }
    } while (menuChoice != 5);
  }

  public int displayMenu() {
    cio.println(
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

  public boolean isValid(int menuChoice) {

    this.menuChoice = menuChoice;

    if (menuChoice < 1 || menuChoice > 5) {
      cio.println("Incorrect menu choice.");
      cio.print("Please choose a valid menu option: ");
      valid = false;

    } else if (menuChoice == 5) {
      cio.println();
      cio.println("Thank you!");
      valid = true;

    } else {
      valid = true;
    }

    return valid;
  }

  public void getOperands(int menuChoice) {
    this.menuChoice = menuChoice;

    cio.print("Please enter your first operand: ");
    a = ui.nextDouble();
    cio.println();
    do {
      cio.print("Please enter your second operand: ");
      b = ui.nextDouble();

      if (b == 0) {
        cio.println("Error: Cannot divide by zero.\n");
      }

    } while (b == 0);

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
  public void simpleMath(int menuChoice, double a, double b) {
    this.menuChoice = menuChoice;
    this.a = a;
    this.b = b;

    switch (menuChoice) {
      case 1:
        add(a, b);
        break;
      case 2:
        subtract(a, b);
        break;
      case 3:
        multiply(a, b);
        break;
      case 4:
        divide(a, b);
        break;
      default:
        break;
    }
  }

  public double add(double a, double b) {
    this.a = a;
    this.b = b;
    cio.println(a + " + " + b + " = " + (a + b) + "\n");
    return a + b;
  }

  public double subtract(double a, double b) {
    this.a = a;
    this.b = b;
    cio.println(a + " - " + b + " = " + (a - b) + "\n");
    return a - b;
  }

  public double multiply(double a, double b) {
    this.a = a;
    this.b = b;
    cio.println(a + " x " + b + " = " + (a * b) + "\n");
    return a * b;
  }

  public double divide(double a, double b) {
    this.a = a;
    this.b = b;
    cio.println(a + " / " + b + " = " + (a / b) + "\n");
    return a / b;
  }

}
