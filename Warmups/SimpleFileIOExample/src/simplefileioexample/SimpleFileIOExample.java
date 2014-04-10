/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package simplefileioexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class SimpleFileIOExample {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception {
    //writing to a new file with minimum error handling
    PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
    out.println(
      "this is a line in my file...\n"
        + "a second line in my file...\n"
        + "a third line in my file...");
    out.flush();
    out.close();
    
    //now read from file
    
    Scanner sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
              
    
  }
  
}
