
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
public class SummingThreeNumbersFromAFile {
  public static void main(String[] args) throws Exception{
    
    Scanner file = new Scanner(System.in);
    String fileName;
    
    System.out.print("Which file would you like to read numbers from: ");
    fileName = file.nextLine();
    
    Scanner ui = new Scanner(new BufferedReader(new FileReader(fileName)));
    
    while (ui.hasNextLine()){
      int a = Integer.parseInt(ui.nextLine());
      int b = Integer.parseInt(ui.nextLine());
      int c = Integer.parseInt(ui.nextLine());
      
      System.out.println("Reading numbers from file \""+ fileName + "\"\n"
        + a + " + "+ b + " + "+ c + " = " + (a+b+c));
    }
  }
}
