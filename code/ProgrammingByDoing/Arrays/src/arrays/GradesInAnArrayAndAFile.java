/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class GradesInAnArrayAndAFile {

  public static void main(String[] args) throws Exception {
    Scanner ui = new Scanner(System.in);
    String fileName, name;
    int[] grades = new int[5];
    
    //Get name
    System.out.print("Name (first last): ");
    name = ui.nextLine();
    
    //Get file name
    System.out.print("Filename: ");
    fileName = ui.nextLine();
    
    //Create file and write name and fileName to it
    PrintWriter out = new PrintWriter(new FileWriter(fileName));
    out.println(name);
    for (int i = 0; i < grades.length; i++){
      Random r = new Random();
      grades[i] = r.nextInt(100) + 1;
      out.print(grades[i] + " ");
    }
    out.close();

    //Print grades to console
    System.out.println("Here are your randomly-selected grades (hope you pass):");
  
    for (int i = 0; i < grades.length; i++){
      System.out.println("Grade "+ (i+1) + ": "+ grades[i]);
    }
    
    System.out.println("Data saved in " + fileName);
    
  }
}
