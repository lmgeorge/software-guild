/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interestcalculator;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class InterestCalculatorMachine {

  private final Scanner ui = new Scanner(System.in);
  private float currentBalance;
  private float newBalance;
  private float numberOfYears;
  private float compoundRate;
  private float annualInterestRate;
  private String choice;

  public void calculateInterest() {

    getAnnualInterestRate();
    System.out.println();
    
    getCompoundRate();
    System.out.println();
    
    getCurrentBalance();
    System.out.println();
    
    getNumberOfYears();
    System.out.println();
    
    setNewBalance(currentBalance);
    System.out.println();
    
    returnInvestment();
  }

  public void returnInvestment() {
    System.out.println("Years compounded: " + numberOfYears + " year[s]");
    System.out.println("Principal at beginning of year: $" + currentBalance);
    System.out.println("Total amount of interest earned for the period: $" + (newBalance - currentBalance));
    System.out.println("Total principal at the end of the year: $" + newBalance);
  }

  public float getCurrentBalance() {
    System.out.println("Please enter the initial principal balance:");
    currentBalance = Float.parseFloat(ui.nextLine());
    return currentBalance;
  }

  /**
   * @param currentBalance
   */
  public void setNewBalance(float currentBalance) {
    this.currentBalance = currentBalance;
    for (int i = 0; i < numberOfYears; i++) {
      newBalance = currentBalance;
      for (int j = 0; j < compoundRate; j++) {
        newBalance *= (1 + ((annualInterestRate / compoundRate) / 100));
      }
      currentBalance = newBalance;
    }

  }

  public float getNumberOfYears() {
    System.out.println("Please enter the number of years for your principal to stay in the fund:");
    numberOfYears = Float.parseFloat(ui.nextLine());
    return numberOfYears;
  }

  public void setNumberOfYears(float numberOfYears) {
    this.numberOfYears = numberOfYears;
  }

  public float getCompoundRate() {
    do {
      System.out.println("How would you like to compound your interest?:\n"
        + "Quarterly, Monthly or Daily");
      choice = ui.nextLine();

      switch (choice.toLowerCase()) {
        case "quarterly":
          compoundRate = 4;
          break;
        case "monthly":
          compoundRate = 12;
          break;
        case "daily":
          compoundRate = 365;
          break;
        default:
          compoundRate = 0;
          break;
      }
    } while (compoundRate == 0);

    return compoundRate;
  }

  public float getAnnualInterestRate() {
    System.out.println("Please enter annual interest rate:");
    annualInterestRate = Float.parseFloat(ui.nextLine());
    return annualInterestRate;
  }

}
