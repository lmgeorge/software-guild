/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alminmaxavg;

import java.util.ArrayList;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ArrayListGenerator {

  private ArrayList<Integer> al = new ArrayList<>();
  private ConsoleIOv5 cio = new ConsoleIOv5();
  private int x = 0;
  private String s;
  private int min = 0;
  private int max = 0;
  private float sum = 0;

  public void start() {
    do {
      s = cio.get("Please enter a number ('x' to quit): ");
      if (!(s.equalsIgnoreCase("x"))) {
        x = Integer.parseInt(s);
        al.add(x);
      }
    } while (!(s.equalsIgnoreCase("x")));

    for (int i = 0; i < al.size(); i++) {
      for (int j = 0; j < al.size(); j++) {
        int swapper;
        if (al.get(i) < al.get(j)) {
          swapper = al.get(j);
          al.set(j, al.get(i));
          al.set(i, swapper);
        }
        
      }
      
    }
    
    for (int i = 0; i < al.size(); i++){
      sum += al.get(i);
    }
    
    cio.println(al.toString());
    min = al.get(0);
    max = al.get(al.size()-1);
    
    cio.println("Min: " + min);
    cio.println("Max: " + max);
    cio.println("Sum: " + sum);
    cio.println("Average: " + (sum / al.size()));

  }

}
