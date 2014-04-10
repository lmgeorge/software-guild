/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int rounds;
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

//        cp =1+ r.nextInt(3);
//        switch (cp) {
//            case 1:
//                user2 = "rock";
//                break;
//            case 2:
//                user2 = "paper";
//                break;
//            case 3:
//                user2 = "scissors";
//                break;
//            default: 
//                
//                break;                
//        }
//        System.out.println("User 2 picks: " + user2);
            if (user1.equalsIgnoreCase(user2)) {
                System.out.println("Its a tie.");
            } else if ((user1.equalsIgnoreCase("rock") && user2.equalsIgnoreCase("scissors"))) {
                System.out.println("User 1 win!n"
                        + "Rock breaks Scissors to win");
            } else if (user1.equalsIgnoreCase("paper") && user2.equalsIgnoreCase("rock")) {
                System.out.println("User 1 win!\n"
                        + "Paper wraps Rock to win!");
            } else if ((user1.equalsIgnoreCase("scissors") && user2.equalsIgnoreCase("paper"))) {
                System.out.println("User 1 win!\n"
                        + "Scissor cuts Paper to win!");
                
            } else if ((user2.equalsIgnoreCase("rock") && user1.equalsIgnoreCase("scissors"))) {
                System.out.println("User 2 win!\n"
                        + "Rock breaks Scissors to win");
            } else if (user2.equalsIgnoreCase("paper") && user1.equalsIgnoreCase("rock")) {
                System.out.println("User 2 win!\n"
                        + "Paper wraps Rock to win!");
            } else if ((user2.equalsIgnoreCase("scissors") && user1.equalsIgnoreCase("paper"))) {
                System.out.println("User 2 win!\n"
                        + "Scissor cuts Paper to win!");
            }

        }

    }

}
