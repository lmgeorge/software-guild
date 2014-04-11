/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interestcalculator;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class InterestCalculator {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    // TODO code application logic here
  
    Scanner ui = new Scanner(System.in);
    float currentBalance,
          newBalance,
          numberOfYears,
          compoundRate,
          annualInterestRate;
    String choice;
    
    System.out.println("Please enter annual interest rate:");
    annualInterestRate = Float.parseFloat(ui.nextLine());
    do {
      System.out.println("How would you like to compound your interest?:\n"
        + "Quarterly, Monthly or Daily");
      choice = ui.nextLine();

      switch (choice.toLowerCase()){
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
    }while(compoundRate == 0);
    
    System.out.println("Please enter the initial principal balance:");
    currentBalance = Float.parseFloat(ui.nextLine());
    
    System.out.println("Please enter the number of years for your principal to stay in the fund:");
    numberOfYears = Float.parseFloat(ui.nextLine());
    
    
    
    for (int i = 0; i < numberOfYears; i++){
      newBalance = currentBalance;
      for (int j = 0; j < compoundRate; j++){
        newBalance *= (1+((annualInterestRate/compoundRate)/100));
        
      }
      
      System.out.println("Years compounded: " + (i + 1));
      System.out.println("Principal at beginning of year: $" + currentBalance);
      System.out.println("Total amount of interest earned for the period: $" + (newBalance - currentBalance));
      System.out.println("Total principal at the end of the year: $" + newBalance);
      currentBalance = newBalance;
    }

}
}
