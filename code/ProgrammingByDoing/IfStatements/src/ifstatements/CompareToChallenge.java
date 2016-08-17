/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifstatements;

import java.util.Scanner;

/**
 *
 * @author apprentice
 */
public class CompareToChallenge {

  public static void main(String[] args) {
    //compared strings returns negative integer
    System.out.print("Comparing \"axe\" with \"dog\" produces ");
    int i = "axe".compareTo("dog");
    System.out.println(i);
    
    System.out.print("Comparing \"a\" with \"b\" produces ");
    int x = "a".compareTo("b");
    System.out.println(x);
    
    System.out.print("Comparing \"ace\" with \"car\" produces ");
    int j= "ace".compareTo("car");
    System.out.println(j);
    
    System.out.print("Comparing \"smith\" with \"white\" produces ");
    int k= "smith".compareTo("white");
    System.out.println(k);
    
    System.out.print("Comparing \"c\" with \"t\" produces ");
    int l= "c".compareTo("t");
    System.out.println(l + "\n");
    
    //compared strings returns positive integer
    System.out.print("Comparing \"taxi\" with \"cash\" produces ");
    int m= "taxi".compareTo("cash");
    System.out.println(m);
    
    System.out.print("Comparing \"ca\" with \"ac\" produces ");
    int n= "ca".compareTo("ac");
    System.out.println(n);
    
    System.out.print("Comparing \"zebra's stripes\" with \"wishful thinking\" produces ");
    int p= "zebra's stripes".compareTo("wishful thinking");
    System.out.println(p);
    
    System.out.print("Comparing \"exit\" with \"ENTER\" produces ");
    int q= "exit".compareTo("ENTER");
    System.out.println(q);
    
    System.out.print("Comparing \"e\" with \"E\" produces ");
    int r= "e".compareTo("E");
    System.out.println(r + "\n");
    
    // compared strings returns 0
    System.out.print("Comparing \"smith\" with \"smith\" produces ");
    int s= "smith".compareTo("smith");
    System.out.println(s);
    
    System.out.print("Comparing \"john\" with \"john\" produces ");
    int t= "john".compareTo("john");
    System.out.println(t);
    
    
//    .compareTo() toy program
    
//    Scanner ui = new Scanner(System.in);
//
//    String x, y, repeater;
//    do {
//      System.out.println("Please enter the first word:");
//      x = ui.nextLine();
//
//      System.out.println("Please enter the second string:");
//      y = ui.nextLine();
//
//      System.out.print("Comparing \"" + x + "\" with \"" + y + "\" produces ");
//      int u = x.compareTo(y);
//      System.out.println(u);
//
//      System.out.println("Would you like to continue?(y/n)");
//      repeater = ui.nextLine();
//    }while(repeater.equals("y"));
    }
}
