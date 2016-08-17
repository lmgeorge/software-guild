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
public class MoreUserInputOfData {
  public static void main (String[] args){
    String firstName,
           lastName,
           grade,
           login;
    Float gpa;
    int studentID;
    Scanner ui = new Scanner(System.in);
    
    
    System.out.println("Please enter the following information so I can sell it for a profit!");
    
    System.out.print("First name: ");
    firstName = ui.next();
    
    System.out.print("Last name: ");
    lastName = ui.next();
    
    System.out.print("Grade (9-12): ");
    grade = ui.next();
    
    System.out.print("Student ID: ");
    studentID = ui.nextInt();
    
    System.out.print("Login: ");
    login = ui.next();
    
    System.out.print("GPA (0.0 - 4.0): ");
    gpa = ui.nextFloat();
    
    System.out.println(
      "Your information: \n"
        + "Login: " + login + "\n"
        + "ID: " + studentID + "\n"
        + "Name: " + firstName + " " + lastName + "\n"
        + "GPA: " + gpa + "\n"
        + "Grade: " + grade
    );
  }
}
