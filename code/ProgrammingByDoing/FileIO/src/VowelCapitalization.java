
import java.net.URL;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class VowelCapitalization {

  public static void main(String[] args) throws Exception {
    String fileAddress, readLine;
    Scanner ui = new Scanner(System.in);

    //Get file address
    System.out.print("Open which file: ");
    fileAddress = ui.nextLine();

    //Access file and open it
    URL webpage = new URL(fileAddress);
    Scanner webIn = new Scanner(webpage.openStream());

    //Start processing the vowels and switching the casing
    while (webIn.hasNextLine()) {
      readLine = webIn.nextLine();

      for (int i = 0; i < readLine.length(); i++) {
        Character letter = readLine.charAt(i); //access the character at each index
        String letStr = letter.toString(); // convert the character into a string

        //Uses a simple regex to find all of the downcased vowels 
        if (letStr.matches("[aeiou]")) {
          System.out.print(letStr.toUpperCase());
        } else {
          System.out.print(letStr);
        }
      }
      System.out.println();
    }
  }
}
