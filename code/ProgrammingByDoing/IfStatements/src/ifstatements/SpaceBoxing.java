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
          neptune6 = 1.23, 
          earthWeight; 
   int planetChoice;
   Scanner ui = new Scanner(System.in);
   
   System.out.println(
     "I have information for the following planets:\n"
       + "1. Venus  2. Mars   3. Jupiter\n"
       + "4. Saturn 5. Uranus 6. Neptune"
   );
   
   System.out.println("Please enter your earth weight:");
   earthWeight = Double.parseDouble(ui.nextLine());
   
   System.out.println("Which planet are you visiting (please enter the planet number)?");
   planetChoice = Integer.parseInt(ui.nextLine());
   
   switch (planetChoice){
     case 1:
       System.out.println("Your weight would be " + (earthWeight*venus1) + " pounds on that planet.");
       break;
     case 2:
       System.out.println("Your weight would be " + (earthWeight*mars2) + " pounds on that planet.");
       break;
     case 3:
       System.out.println("Your weight would be " + (earthWeight*jupiter3) + " pounds on that planet.");
       break;
     case 4:
       System.out.println("Your weight would be " + (earthWeight*saturn4) + " pounds on that planet.");
       break;
     case 5:
       System.out.println("Your weight would be " + (earthWeight*uranus5) + " pounds on that planet.");
       break;
     case 6:
       System.out.println("Your weight would be " + (earthWeight*neptune6) + " pounds on that planet.");
       break;
     default:
       System.out.println("You chose to go no where I know...");
       break;
     
   }
   
   
           
  }

}
