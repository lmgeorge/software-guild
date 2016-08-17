/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.Scanner;
import static methods.MonthName.month_name;
import static methods.WeekdayCalculator.is_leap;
import static methods.WeekdayCalculator.month_offset;
import static methods.WeekdayCalculator.weekday_name;


/**
 *
 * @author apprentice
 */
public class CallingFunctionsFromOtherFiles {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to Mr. Mitchell's fantastic birth-o-meter!");
        System.out.println();
        System.out.println("All you have to do is enter your birth date, and it will");
        System.out.println("tell you the day of the week on which you were born.");
        System.out.println();
        System.out.println("Some automatic tests....");
        System.out.println("12 10 2003 => " + weekday(12, 10, 2003));
        System.out.println(" 2 13 1976 => " + weekday(2, 13, 1976));
        System.out.println(" 2 13 1977 => " + weekday(2, 13, 1977));
        System.out.println(" 7  2 1974 => " + weekday(7, 2, 1974));
        System.out.println(" 1 15 2003 => " + weekday(1, 15, 2003));
        System.out.println("10 13 2000 => " + weekday(10, 13, 2000));
        System.out.println();

        System.out.println("Now it's your turn!  What's your birthday?");
        System.out.print("Birth date (mm dd yyyy): ");
        int mm = keyboard.nextInt();
        int dd = keyboard.nextInt();
        int yyyy = keyboard.nextInt();

        System.out.println("You were born on " + weekday(mm, dd, yyyy));
    }

    public static String weekday(int mm, int dd, int yyyy) {
        int yy, total;
        String date;

        // bunch of calculations go here
        yy = yyyy - 1900;

        if (is_leap(yyyy) && (mm == 1 || mm == 2)) {
            total = yy / 4 + yy + dd + month_offset(mm) - 1;
        } else {
            total = yy / 4 + yy + dd + month_offset(mm);
        }
        
        date = weekday_name(total % 7) + ", " + month_name(mm) + " " + dd + ", " + yyyy;

        return date;
    }
    
}
