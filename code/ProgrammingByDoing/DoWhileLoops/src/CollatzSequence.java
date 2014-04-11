
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
public class CollatzSequence {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);

    int start, original, counter = 0;

    System.out.println("Starting number: ");
    start = 27; //Integer.parseInt(ui.nextLine());
    original = start;
    while (start > 1) {
      if (start % 2 == 0) {
        start /= 2;
        System.out.print(start + "\t");
      } else {
        start = (start*3 + 1);
        System.out.print((start) + "\t");
      }
      
      if (start > original){
        original = start;
      }
      counter++;
    }
    
    System.out.println("\nTerminated after " + counter + "  steps."
      + "The largest value was " + original + ".");
  }
}
