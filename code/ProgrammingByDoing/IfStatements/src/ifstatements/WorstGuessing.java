/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifstatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class WorstGuessing {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    
    int guess;
    

    System.out.println(
      "TEH WORST NUBMER GESSING GAME EVAR!!!!!!!1!\n"
      + "\n"
      + "I\"M THKING OF A NBR FROM 1-10.  TRY 2 GESS! "
    );
    guess = Integer.parseInt(ui.nextLine());
    
    if (guess == 5){
      System.out.println("LOL!!! U GOT IT!  I CANT BELEIVE U GESSED IT WAS 5!");
    }else{
      System.out.println("W00T!  U SUX0R!!!  I PWN J00!!!  IT WAS 5!");
    }
    

  }
}
