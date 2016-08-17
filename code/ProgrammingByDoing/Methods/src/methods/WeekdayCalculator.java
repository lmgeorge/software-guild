/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.Scanner;


/**
 *
 * @author apprentice
 */
public class WeekdayCalculator {

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
// paste your functions from MonthName, WeekdayName, and MonthOffset here

    public static String month_name(int num) {
        String month = "";
        switch (num) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                month = "error";
                break;
        }
        return month;
    }

    public static String weekday_name(int weekday) {
        String result;
        switch (weekday) {
            case 1:
                result = "Sunday";
                break;
            case 2:
                result = "Monday";
                break;
            case 3:
                result = "Tuesday";
                break;
            case 4:
                result = "Wednesday";
                break;
            case 5:
                result = "Thursday";
                break;
            case 6:
                result = "Friday";
                break;
            case 7:
                result = "Saturday";
                break;
            case 0:
                result = "Saturday";
                break;
            default:
                result = "Error";
                break;
        }

        return result;
    }

    public static int month_offset(int num) {
        int daysOffset;
        switch (num) {
            case 1:
                daysOffset = 1;
                break;
            case 2:
                daysOffset = 4;
                break;
            case 3:
                daysOffset = 4;
                break;
            case 4:
                daysOffset = 0;
                break;
            case 5:
                daysOffset = 2;
                break;
            case 6:
                daysOffset = 5;
                break;
            case 7:
                daysOffset = 0;
                break;
            case 8:
                daysOffset = 3;
                break;
            case 9:
                daysOffset = 6;
                break;
            case 10:
                daysOffset = 1;
                break;
            case 11:
                daysOffset = 4;
                break;
            case 12:
                daysOffset = 6;
                break;
            default:
                daysOffset = -1;
                break;
        }
        return daysOffset;
    }

    public static boolean is_leap(int year) {
        // years which are evenly divisible by 4 are leap years,
        // but years divisible by 100 are not leap years,
        // though years divisible by 400 are leap years
        boolean result;

        if (year % 400 == 0 || year % 4 == 0) {
            result = true;
        } else if (year % 100 == 0) {
            result = false;
        } else {
            result = false;
        }

        return result;
    }
}
