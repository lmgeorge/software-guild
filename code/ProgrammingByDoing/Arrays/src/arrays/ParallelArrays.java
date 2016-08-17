/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ParallelArrays {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    String[] lastName = {"Mitchell", "Ortiz", "Luu", "Zimmerman", "Brooks"};
    int[] id = {123456, 813225, 823669, 307760, 827131};
    double[] grades = {99.5, 78.5, 95.6, 96.8, 82.7};

    System.out.print("Values:\n\t");
    for (int i = 0; i < lastName.length; i++) {
      System.out.print(lastName[i] + " " + grades[i] + " " + id[i] + "\n\t");
    }
    
    System.out.println();
    
    System.out.print("ID number to find: ");
    int entry = ui.nextInt();
    for (int i = 0; i < id.length; i++) {
      if (id[i] == entry) {
        System.out.print("Found in slot " + i + "\n\t"
          + "Name: "+ lastName[i] + "\n\t" 
          + "Average: "+ grades[i] + "\n\t" 
          + "ID: " +id[i] + "\n\t");
      }
    }

  }
}
