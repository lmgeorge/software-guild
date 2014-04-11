package dowhileloops;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class RightTriangleChecker {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    float height, base, hypotenuse;

    System.out.println("Enter three integers:");

    System.out.println("Side 1:");
    height = Float.parseFloat(ui.nextLine());
    while (height <= 0) {
      System.out.println("Please enter a number greater than 0.");
    }
    
    //Checking that the next number is greater than the last number
    System.out.println("Side 2:");
    base = Float.parseFloat(ui.nextLine());
    while (base < height) {
      System.out.println(base + " is smaller than " + height + ".  Try again: ");
      base = Float.parseFloat(ui.nextLine());
    }

    System.out.println("Side 3:");
    hypotenuse = Float.parseFloat(ui.nextLine());
    while (hypotenuse < base) {
      System.out.println(height + " is smaller than " + base + ".  Try again: ");
      hypotenuse = Float.parseFloat(ui.nextLine());
    }
    
    // if height^2 + base^ == hypotenuse^2 --> right triangle
    if (Math.pow(height,2) + Math.pow(base,2) == Math.pow(hypotenuse,2)){
      System.out.println("Your three sides are: " + height + "\t" + base + "\t" + hypotenuse + "\n"
      + "These *do* make a right triangle!");
    }else{
      System.out.println("Your three sides are: " + height + "\t" + base + "\t" + hypotenuse + "\n"
      + "NO! These do not make a right triangle!");
    }
    
    
    

  }
}
