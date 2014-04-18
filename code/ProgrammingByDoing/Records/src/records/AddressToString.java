/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */




public class AddressToString {
  
  
  public void run() throws Exception{
    URL addys = new URL("http://cs.leanderisd.org/txt/fake-addresses.txt");

    Address[] addybook = new Address[6];

    Scanner fin = new Scanner(addys.openStream());

    for (int i = 0; i < 5; i++) {
      addybook[i] = new Address();
      addybook[i].street = fin.nextLine();
      addybook[i].city = fin.nextLine();
      addybook[i].state = fin.next();
      addybook[i].zip = fin.nextInt();
      fin.skip("\n");
    }
    fin.close();

    for (int i = 0; i < 5; i++) {
      System.out.println((i + 1) + ". " + addybook[i]);
    }
    
    
    addybook.toString();
  }
}
