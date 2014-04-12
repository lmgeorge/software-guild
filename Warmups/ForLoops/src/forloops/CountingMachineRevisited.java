/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forloops;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CountingMachineRevisited {
  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int start, end, byNum;

    System.out.print("Count from: ");
    start = ui.nextInt();
    System.out.print("Count to: ");
    end = ui.nextInt();
    System.out.print("Count by: ");
    byNum = ui.nextInt();
    
    for (int i = start; i <= end; i+= byNum) {
      System.out.print(i + "  ");
    }
  }
}
