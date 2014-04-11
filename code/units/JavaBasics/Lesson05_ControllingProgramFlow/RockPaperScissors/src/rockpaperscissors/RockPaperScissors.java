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
public class RockPaperScissors {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
        Random r = new Random();
        
        String user1, user2="";
        int cp;
        
        System.out.println("ROCK, PAPER, SCISSORS. PICK ONE.");
        
        user1 = sc.nextLine();
        cp =1+ r.nextInt(3);
        
        switch (cp) {
            case 1:
                user2 = "rock";
                break;
            case 2:
                user2 = "paper";
                break;
            case 3:
                user2 = "scissors";
                break;
            default: 
                
                break;                
        }
        System.out.println("User 1 picks: " + user2);
        
        if (user1.equalsIgnoreCase(user2)) {
            System.out.println("Its a tie.");
        }
        else if ((user1.equalsIgnoreCase("rock") && user2.equals("scissors")) || 
                 (user1.equalsIgnoreCase("paper") && user2.equals("rock")) ||
                 (user1.equalsIgnoreCase("scissors") && user2.equals("paper"))) {
            System.out.println("You win!");
        }
        else {
            System.out.println("User 1 wins!");
        }
            
  }
  
}
