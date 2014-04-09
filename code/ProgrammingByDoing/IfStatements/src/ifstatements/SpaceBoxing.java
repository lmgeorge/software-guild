/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ifstatements;

/**
 *
 * @author apprentice
 */

import java.util.Scanner;
public class SpaceBoxing {
  public static void main (String[] args){
   double venus1 = 0.78,
          mars2 = 0.39,
          jupiter3 = 2.65,
          saturn4 = 1.17,
          uranus5 = 1.05,
          neptune6 = 1.23;
   int earthWeight, choice;
   Scanner ui = new Scanner(System.in);
   
   System.out.println(
     "I have information for the following planets:\n"
       + "1. Venus  2. Mars   3. Jupiter\n"
       + "4. Saturn 5. Uranus 6. Neptune"
   );
   
   System.out.println("Please enter your earth weight:");
   earthWeight = ui.nextInt();
   
   System.out.println("Which planet are you visiting?");
   choice = ui.nextInt();
   
   switch (choice){
     
   }
   
   
           
  }

}
