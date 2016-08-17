
import java.io.BufferedReader;
import java.io.FileReader;
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
public class SimpleFileInput {
  public static void main (String[] args) throws Exception{
    Scanner ui = new Scanner(new BufferedReader(new FileReader("name.txt")));
    
    while (ui.hasNextLine()){
      String currentLine = ui.nextLine();
      System.out.print("Using my psychic powers (aided by reading data from the file), I have determined that your name is " + currentLine+ ".");
    }
    
  }
}
