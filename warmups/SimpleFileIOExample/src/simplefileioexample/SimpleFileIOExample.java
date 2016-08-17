/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplefileioexample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class SimpleFileIOExample {

  /**
   * @param args the command line arguments
   * @throws java.io.IOException
   */
  public static void main(String[] args) throws IOException {
    PrintWriter out;
    out = null;
    try {
      //writing to a new file with minimum error handling
      out = new PrintWriter(new FileWriter("OutFile.txt"));
      out.println(
        "this is a line in my file...\n"
        + "a second line in my file...\n"
        + "a third line in my file...");
      out.flush();

    } catch (IOException ioE) {
      System.out.println("ERROR: msg = " + ioE.getMessage());
      return;

    } finally {
      if (out != null) {
        out.close();
      }
    }

    //now read from file
    Scanner sc;
    sc = null;
    try {
      sc = new Scanner(new BufferedReader(new FileReader("OutFile.txt")));
    } catch (FileNotFoundException nofile) {
      System.out.println("ERROR: msg = " + nofile.getLocalizedMessage());
    } finally {
      if (sc != null ){
      sc.close();
      }
    }
  }

}
