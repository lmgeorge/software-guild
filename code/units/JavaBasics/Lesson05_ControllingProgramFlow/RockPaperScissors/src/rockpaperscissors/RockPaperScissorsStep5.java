/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock.paper.scissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class RockPaperScissorsStep5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int MIN_ROUNDS = 1;
        final int MAX_ROUNDS = 10;
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        int rounds;
        int[] winCounter = new int[3];
        String user1, user2 = "", playAgain;
        do {
            rounds = readValue("HOW MANY ROUNDS? (1-10)", MIN_ROUNDS, MAX_ROUNDS);

            for (int i = 0; i < rounds; i++) {
                System.out.println("USER 1: ROCK, PAPER, SCISSORS. PICK ONE: ");
                user1 = sc.nextLine();
                System.out.println("USER 2: ROCK, PAPER, SCISSORS. PICK ONE: ");
                user2 = sc.nextLine();
                winner(winCounter, user1, user2);

            }
            System.out.println("Ties: " + winCounter[0]);
            System.out.println("User 1 wins: " + winCounter[1]);
            System.out.println("User 2 wins: " + winCounter[2]);

            if (winCounter[1] == winCounter[2]) {
                System.out.println("Its a tie.");
            } else if (winCounter[1] > winCounter[2]) {
                System.out.println("User 1 wins.");
            } else {
                System.out.println("User 2 wins.");
            }
            System.out.println("Would you like to play again?");
            playAgain = sc.nextLine();

        } while (playAgain.equalsIgnoreCase("yes"));
        System.out.println("Thanks for playing!");
    }

    public static int[] winner(int[] winCounter, String user1, String user2) {
        if (user1.equalsIgnoreCase(user2)) {
            System.out.println("Its a tie.");
            winCounter[0]++;
        } else if ((user1.equalsIgnoreCase("rock") && user2.equalsIgnoreCase("scissors"))) {
            declareWinner(1, "rock");
            winCounter[1]++;
        } else if (user1.equalsIgnoreCase("paper") && user2.equalsIgnoreCase("rock")) {
            declareWinner(1, "paper");
            winCounter[1]++;
        } else if ((user1.equalsIgnoreCase("scissors") && user2.equalsIgnoreCase("paper"))) {
            declareWinner(1, "scissors");
            winCounter[1]++;

        } else if ((user2.equalsIgnoreCase("rock") && user1.equalsIgnoreCase("scissors"))) {
            declareWinner(2, "rock");
            winCounter[2]++;
        } else if (user2.equalsIgnoreCase("paper") && user1.equalsIgnoreCase("rock")) {
            declareWinner(2, "paper");
            winCounter[2]++;
        } else if ((user2.equalsIgnoreCase("scissors") && user1.equalsIgnoreCase("paper"))) {
            declareWinner(2, "scissors");
            winCounter[2]++;
        }

        return winCounter;
    }

    public static void declareWinner(int user, String s) {
        System.out.println("User " + user + " wins!");
        switch (s) {
            case "rock":
                System.out.println("Rock breaks Scissors to win");
                break;
            case "paper":
                System.out.println("Paper wraps Rock to win!");
                break;
            case "scissors":
                System.out.println("Scissor cuts Paper to win!");
                break;
        }
    }

    public static int readValue(String s, int min, int max) {
        int result = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println(s);
            result = sc.nextInt();
        } while (result < min || result > max);

        return result;
    }

}
