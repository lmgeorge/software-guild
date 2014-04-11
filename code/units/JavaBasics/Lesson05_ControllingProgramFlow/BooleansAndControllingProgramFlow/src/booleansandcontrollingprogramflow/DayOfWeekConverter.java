/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package booleansandcontrollingprogramflow;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class DayOfWeekConverter {
  public static void main (String[] args){
    Scanner ui = new Scanner(System.in);
    
    
    System.out.println("Please input the number of the day of the week:");
    int dayNumber = ui.nextInt();
    
    String dayName = "";
    
//    switch (dayNumber) {
//      case 1:
//        dayName = "Monday";
//        break;
//      case 2:
//        dayName = "Tuesday";
//        break;
//      case 3:
//        dayName = "Wednesday";
//        break;
//      case 4:
//        dayName = "Thursday";
//        break;
//      case 5:
//        dayName = "Friday";
//        break;
//      case 6:
//        dayName = "Saturday";
//        break;
//      case 7:
//        dayName = "Sunday";
//        break;
//      default:
//        System.out.println("I don't think that's right...");
//        break;
//      
//    }System.out.println("The day of the week is " + dayName);
    
    
    
    
    
    
   if ((dayNumber > 0) && (dayNumber < 8)){ 
      if (dayNumber == 1) {
        dayName = "Monday";
        System.out.println("The day of the week is " + dayName);
      }else if (dayNumber == 2){
        dayName = "Tuesday";
        System.out.println("The day of the week is " + dayName);
      }else if (dayNumber == 3){
        dayName = "Wednesday";
        System.out.println("The day of the week is " + dayName);
      }else if (dayNumber == 4){
        dayName = "Thursday";
        System.out.println("The day of the week is " + dayName);
      }else if (dayNumber == 5){
        dayName = "Friday";
        System.out.println("The day of the week is " + dayName);
      }else if (dayNumber == 6){
        dayName = "Saturday";
        System.out.println("The day of the week is " + dayName);
      }else {
        dayName = "Sunday";
        System.out.println("The day of the week is " + dayName);
      }
   }else {
        System.out.println("Uh...I don't think that exists in a 7 day week!");
   }
  }
}
