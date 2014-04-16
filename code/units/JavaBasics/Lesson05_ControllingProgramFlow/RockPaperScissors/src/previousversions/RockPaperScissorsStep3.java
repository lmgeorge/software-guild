/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package previousversions;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int rounds, user1Wins = 0, user2Wins = 0, tie = 0;
        String user1, user2 = "";
//        int cp;

        System.out.println("HOW MANY ROUNDS? (1-10)");
        rounds = sc.nextInt();

        while (rounds < 1 || rounds > 10) {
            System.out.println("Invalid number. Pick a number between 1 and 10");
            rounds = sc.nextInt();
        }
        sc.nextLine();
        for (int i = 0; i < rounds; i++) {
            System.out.println("USER 1: ROCK, PAPER, SCISSORS. PICK ONE: ");
            user1 = sc.nextLine();
            System.out.println("USER 2: ROCK, PAPER, SCISSORS. PICK ONE: ");
            user2 = sc.nextLine();

            if (user1.equalsIgnoreCase(user2)) {
                System.out.println("Its a tie.");
                tie++;
            } else if ((user1.equalsIgnoreCase("rock") && user2.equalsIgnoreCase("scissors"))) {
                System.out.println("User 1 win!n"
                        + "Rock breaks Scissors to win");
                user1Wins++;
            } else if (user1.equalsIgnoreCase("paper") && user2.equalsIgnoreCase("rock")) {
                System.out.println("User 1 win!\n"
                        + "Paper wraps Rock to win!");
                user1Wins++;
            } else if ((user1.equalsIgnoreCase("scissors") && user2.equalsIgnoreCase("paper"))) {
                System.out.println("User 1 win!\n"
                        + "Scissor cuts Paper to win!");
                user1Wins++;

            } else if ((user2.equalsIgnoreCase("rock") && user1.equalsIgnoreCase("scissors"))) {
                System.out.println("User 2 win!\n"
                        + "Rock breaks Scissors to win");
                user2Wins++;
            } else if (user2.equalsIgnoreCase("paper") && user1.equalsIgnoreCase("rock")) {
                System.out.println("User 2 win!\n"
                        + "Paper wraps Rock to win!");
                user2Wins++;

            } else if ((user2.equalsIgnoreCase("scissors") && user1.equalsIgnoreCase("paper"))) {
                System.out.println("User 2 win!\n"
                        + "Scissor cuts Paper to win!");
                user2Wins++;

            }

        }
            System.out.println("Ties: " + tie);
            System.out.println("User 1 wins: " + user1Wins);
            System.out.println("User 2 wins: " + user2Wins);
            
            if (user1Wins == user2Wins) {
                System.out.println("Its a tie.");
            }
            else if (user1Wins > user2Wins) {
                System.out.println("User 1 wins.");
            }
            else {
                System.out.println("User 2 wins.");
            }
        
        
    }

}
