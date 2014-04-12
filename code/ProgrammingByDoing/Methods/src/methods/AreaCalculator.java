package methods;


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
public class AreaCalculator {

    public static void main(String[] args) {
        int choice;
        double length, width, radius, side, base, height;
        Scanner ui = new Scanner(System.in);

        System.out.println("1) Triangle\n"
          + "2) Rectangle\n"
          + "3) Square\n"
          + "4) Circle\n"
          + "5) Quit\n"
          + "Which shape:");
        choice = Integer.parseInt(ui.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Base: ");
                base = Double.parseDouble(ui.nextLine());
                System.out.print("Height: ");
                height = Double.parseDouble(ui.nextLine());

                System.out.println("The area is " + area_triangle(base, height));
                break;
            case 2:
                System.out.print("Length: ");
                length = Double.parseDouble(ui.nextLine());
                System.out.print("Width: ");
                width = Double.parseDouble(ui.nextLine());

                System.out.println("The area is " + area_rectangle(length, width));
                break;
            case 3:
                System.out.print("Side: ");
                side = Double.parseDouble(ui.nextLine());

                System.out.println("The area is " + area_square(side));
                break;
            case 4:
                System.out.print("Radius: ");
                radius = Double.parseDouble(ui.nextLine());

                System.out.println("The area is " + area_circle(radius));
                break;
            default:
                System.out.println("Goodbye.");
                break;

        }

    }

    public static double area_circle(double radius) { // returns the area of a circle
        double area;
        area = Math.PI * Math.pow(radius, 2);
        return area;

    }

    public static double area_rectangle(double length, double width) { // returns the area of a rectangle
        double area;
        area = length * width;
        return area;

    }

    public static double area_square(double side) {// returns the area of a square
        double area;
        area = Math.pow(side, 2);
        return area;

    }

    public static double area_triangle(double base, double height) { // returns the area of a triangle   
        double area;
        area = (base * height) / 2;
        return area;

    }
}
