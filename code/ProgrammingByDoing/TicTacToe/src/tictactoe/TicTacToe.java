/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class TicTacToe {
  ConsoleIO c = new ConsoleIOImpl();
  private static char[][] board = new char[3][3];

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int row, col, rounds = 0;
    String check;

    initBoard();

    System.out.println("\tTIC TAC TOE\n\n");
    displayBoard();

    do {
      rounds++;
      System.out.print("'O', choose your location (row, column): ");
      row = ui.nextInt();
      col = ui.nextInt();
      userChoice(row, col, 'O');
        
      displayBoard();

      check = hasWon(rounds);
      
      if (!(check.equals("stop"))) {
        System.out.print("'X', choose your location (row, column): ");
        row = ui.nextInt();
        col = ui.nextInt();
        userChoice(row, col, 'X');

        displayBoard();
        check = hasWon(rounds);
      }
    } while (!(check.equals("stop")));

  }

  public static String hasWon(int rounds) {
    boolean won;
    char winChoice = 'O';
    String check;

    //rows
    if (board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
      won = true;
      winChoice = board[0][0];
      
    } else if (board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
      won = true;
      winChoice = board[1][0];
      
    } else if (board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
      won = true;
      winChoice = board[2][0];
    } 

    //cols
    else if (board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
      won = true;
      winChoice = board[0][0];
      
    } else if (board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
      won = true;
      winChoice = board[0][1];
      
    } else if (board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
      won = true;
      winChoice = board[0][2];
    } 

    //diagonals
    else if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
      won = true;
      winChoice = board[0][0];
      
    } else if (board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
      won = true;
      winChoice = board[2][0];
      
    } else {
      check = "go";
      won = false;
    }
    
    //Check if the game continues
    //If not, print winner or if it is a tie
    
    if (won == true && winChoice != ' ') {
      System.out.println("'" + winChoice + "'" + " won!");
      check = "stop";
      
    } else if (won == false && rounds >= 5) {
      System.out.println("The game is a tie.");
      check = "stop";
      
    } else {
      check = "go";
    }
    return check;
  }

  public static void userChoice(int row, int col, char marker) {
    board[row][col] = marker;

  }

  public static void initBoard() {
    // fills up the board with blanks
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        board[r][c] = ' ';
      }
    }
  }

  public static void displayBoard() {
    System.out.println("  0  " + board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
    System.out.println("    --+-+--");
    System.out.println("  1  " + board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
    System.out.println("    --+-+--");
    System.out.println("  2  " + board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    System.out.println("     0 1 2 ");
  }

  public static void displayBoard2() {
    for (int r = 0; r < 3; r++) {
      System.out.print("\t" + r + " ");
      for (int c = 0; c < 3; c++) {
        System.out.print(board[r][c] + " ");
      }
      System.out.println();
    }
    System.out.println("\t  0 1 2 ");
  }

}
