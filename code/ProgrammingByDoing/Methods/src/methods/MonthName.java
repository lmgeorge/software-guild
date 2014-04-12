/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package methods;

/**
 *
 * @author apprentice
 */
public class MonthName {
    public static void main( String[] args ){

    System.out.println( "Month 1: " + month_name(1) );
    System.out.println( "Month 2: " + month_name(2) );
    System.out.println( "Month 3: " + month_name(3) );
    System.out.println( "Month 4: " + month_name(4) );
    System.out.println( "Month 5: " + month_name(5) );
    System.out.println( "Month 6: " + month_name(6) );
    System.out.println( "Month 7: " + month_name(7) );
    System.out.println( "Month 8: " + month_name(8) );
    System.out.println( "Month 9: " + month_name(9) );
    System.out.println( "Month 10: " + month_name(10) );
    System.out.println( "Month 11: " + month_name(11) );
    System.out.println( "Month 12: " + month_name(12) );
    System.out.println( "Month 43: " + month_name(43) );
}
    
    public static String month_name(int num){
        String month = "";
        switch(num){
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
}
