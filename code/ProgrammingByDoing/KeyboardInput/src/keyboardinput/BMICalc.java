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
public class BMICalc {
  
  public static void main (String[] args){
    float height, heightInches, weight, bmi;
    Scanner ui = new Scanner(System.in);

    System.out.println("Your height in (feet only):");
    height = ui.nextFloat();
    
    System.out.println("Your height in (inches only):");
    heightInches = ui.nextFloat();

    System.out.println("Your weight in pounds: ");
    weight = ui.nextFloat();
    
    
    System.out.println("Your BMI is " + ( (weight/2.2)/(((height*12 + heightInches) * 0.0254)*((height*12 + heightInches) * 0.0254)) ) );
  }  
}
