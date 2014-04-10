/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifstatements;

import static java.lang.Math.pow;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class BMICategories {

  public static void main(String[] args) {
    double height, weight, bmi;
    Scanner ui = new Scanner(System.in);

    System.out.println("Your height in inches only :");
    height = Double.parseDouble(ui.nextLine());

    System.out.println("Your weight in pounds: ");
    weight = Double.parseDouble(ui.nextLine());
    
    bmi = (weight/2.2)/ pow((height*0.0254), 2);
    
    if(bmi < 18.5){
      System.out.println("Your BMI is" + bmi + "\n"
        + "BMI Category: underweight");
    }
    if(bmi <= 24.9 && bmi >= 18.5){
      System.out.println("Your BMI is" + bmi + "\n"
        + "BMI Category: underweight");
    }
    if(bmi <= 25.0 && bmi >= 29.9){
      System.out.println("Your BMI is" + bmi + "\n"
        + "BMI Category: underweight");
    }
    if(bmi <= 25.0 && bmi >= 29.9){
      System.out.println("Your BMI is" + bmi + "\n"
        + "BMI Category: underweight");
    }
    
      
  }
}
