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
        
        String user, computer="";
        int cp;
        
        System.out.println("ROCK, PAPER, SCISSORS. PICK ONE.");
        
        user = sc.nextLine();
        cp =1+ r.nextInt(3);
        
        switch (cp) {
            case 1:
                computer = "rock";
                break;
            case 2:
                computer = "paper";
                break;
            case 3:
                computer = "scissors";
                break;
            default: 
                
                break;                
        }
        System.out.println("Computer picks: " + computer);
        
        if (user.equalsIgnoreCase(computer)) {
            System.out.println("Its a tie.");
        }
        else if ((user.equalsIgnoreCase("rock") && computer.equals("scissors")) || 
                 (user.equalsIgnoreCase("paper") && computer.equals("rock")) ||
                 (user.equalsIgnoreCase("scissors") && computer.equals("paper"))) {
            System.out.println("You win!");
        }
        else {
            System.out.println("Computer wins!");
        }
            
  }
  
}
