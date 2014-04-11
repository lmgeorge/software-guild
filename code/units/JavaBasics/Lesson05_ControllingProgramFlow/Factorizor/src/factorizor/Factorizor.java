/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factorizor;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class Factorizor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long sumFactors = 0, prime = 0, initial;
        do {
            System.out.println("What number would you like to factor?");
            initial = sc.nextLong();

            if (initial <= 0) {
                System.out.println("Error: Enter a positive whole number.");
            }

        } while (initial <= 0);

        if (initial == 1) {
            System.out.println("One has no factors.  It's special.");
        } else {
            System.out.println("The factors of " + initial + " are:");
        }

        for (int i = 1; i < initial; i++) {
            if (initial % i == 0) {
                System.out.println(i);
                sumFactors += i;
                prime++;
            }//end if
        }//end for

        if (sumFactors == initial) {
            System.out.println(initial + " is a perfect number");
        }
        if (prime == 1) {

            System.out.println(initial + " is a prime number");
        } else {
            System.out.println(initial + " is not a prime number");

        }

    }

}
