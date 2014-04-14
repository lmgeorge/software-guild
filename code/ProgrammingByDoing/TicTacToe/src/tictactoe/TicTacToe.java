/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class TicTacToe {

  private static char[][] board = new char[3][3];

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int row, col;
    String check;

    initBoard();

    System.out.println("\tTIC TAC TOE\n\n");
    displayBoard();

    //test(); //uncomment to run test and comment code below
    do {
      System.out.print("'O', choose your location (row, column): ");
      row = ui.nextInt();
      col = ui.nextInt();
      user_choice(row, col, 'O');
      displayBoard();
      check = hasWon();

      System.out.print("'X', choose your location (row, column): ");
      row = ui.nextInt();
      col = ui.nextInt();
      user_choice(row, col, 'X');
      displayBoard();
      check = hasWon();
      
    } while (!(check.equals("stop")));
    //stop comment
  }


  public static String hasWon() {
    boolean won = false;
    char winChoice = 'O';
    String check = "";
    for (int r = 0; r < 3; r++) {
      for (int c = 0; c < 3; c++) {
        //if ( board[r][c] == 'X' || board[r][c] == 'O') {
          // rows
          if (( board[r][c] == 'X' || board[r][c] == 'O') &&
            board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } else if (( board[r][c] == 'X' || board[r][c] == 'O') && 
            board[1][0] == board[1][1] && board[1][0] == board[1][2]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } else if (( board[r][c] == 'X' || board[r][c] == 'O') && 
            board[2][0] == board[2][1] && board[2][0] == board[2][2]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } //cols
          else if (( board[r][c] == 'X' || board[r][c] == 'O') &&
            board[0][0] == board[1][0] && board[0][0] == board[2][0]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } else if (( board[r][c] == 'X' || board[r][c] == 'O') &&
            board[0][1] == board[1][1] && board[0][1] == board[2][1]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } else if (( board[r][c] == 'X' || board[r][c] == 'O') &&
            board[0][2] == board[1][2] && board[0][2] == board[2][2]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } //diagonals
          else if (( board[r][c] == 'X' || board[r][c] == 'O') &&
            board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } else if (( board[r][c] == 'X' || board[r][c] == 'O') &&
            board[2][0] == board[1][1] && board[2][0] == board[0][2]) {
            check = "stop";
            won = true;
            winChoice = board[r][c];
          } else {
            check = "go";
            won = false;
          }
//        }else {
//          check = "go";
//          won = false;
//        }
      }
    }
    if (won == true ) {
      System.out.println("'" + winChoice + "'" + " won!");
    } else if ((check.equals("stop")) && won == false) {
      System.out.println(check);
      System.out.println("The game is a tie.");
    } else {
      System.out.println(check);
    }
    return check;
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

  public static void user_choice(int row, int col, char marker) {
    board[row][col] = marker;

  }
  
  public static boolean keepPlaying(String check){
    boolean answer = true;
    
    if (check.equals("stop")){
      answer = false;
    }
    return answer;
  }
  public static void test() {
    // Check 'O' wins condition
    System.out.println();
    System.out.println("Check 'O' wins condition");
    board[0][0] = 'O';
    board[0][1] = 'O';
    board[0][2] = 'O';

    board[1][0] = 'O';
    board[1][1] = 'X';
    board[1][2] = 'X';

//    board[2][0] = 'X';
//    board[2][1] = 'X';
//    board[2][2] = 'O';
    displayBoard();
    hasWon();
    System.out.println();

    // Check 'X' wins condition
    System.out.println("Check 'X' wins condition");
    board[0][0] = 'X';
    board[0][1] = 'O';
    board[0][2] = 'O';

//    board[1][0] = 'O';
//    board[1][1] = 'X';
//    board[1][2] = 'X';
    board[2][0] = 'X';
    board[2][1] = 'X';
    board[2][2] = 'X';
    displayBoard();
    hasWon();
    System.out.println();
    // Check tie condition
    System.out.println("Check tie condition");
    board[0][0] = 'X';
    board[0][1] = 'O';
    board[0][2] = 'O';

    board[1][0] = 'O';
    board[1][1] = 'X';
    board[1][2] = 'X';

    board[2][0] = 'X';
    board[2][1] = 'X';
    board[2][2] = 'O';
    displayBoard();
    hasWon();
  }
}
