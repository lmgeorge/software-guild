
import java.io.FileWriter;
import java.io.PrintWriter;
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
public class HighScore {

  public static void main(String[] args) throws Exception {
    PrintWriter out = new PrintWriter(new FileWriter("score.txt"));
    Scanner ui = new Scanner(System.in);
    
    String name, score;
    
    System.out.println("You got a high score!\n");

    System.out.print("Please enter your score: ");
    score = ui.nextLine();

    System.out.print("Please enter your name: ");
    name = ui.nextLine();

    System.out.println("Data stored into score.txt.");

    out.println("SCORES\n"
      + "===========\n"
      + name + ": " + score);
    out.close();
  }
}
