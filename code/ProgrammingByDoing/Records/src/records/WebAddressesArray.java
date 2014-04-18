/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class WebAddressesArray {

  Address a = new Address();

  public void run() {
    try {
      URL addys = new URL("http://cs.leanderisd.org/txt/fake-addresses.txt");
      
      Address[] addybook = new Address[6];
      
      Scanner fin = new Scanner(addys.openStream());
      
      for (int i = 0; i < addybook.length; i++) {
        addybook[i] = new Address();
        addybook[i].street = fin.nextLine();
        addybook[i].city = fin.nextLine();
        addybook[i].state = fin.next();
        addybook[i].zip = fin.nextInt();
        fin.skip("\n");
      }
      fin.close();
      
      for (int i = 0; i < addybook.length; i++) {
        System.out.println((i + 1) + ". " 
          + addybook[i].street + ", " 
          + addybook[i].city + ", " 
          + addybook[i].state + "  " 
          + addybook[i].zip);
      }
    } catch (MalformedURLException ex) {
      Logger.getLogger(WebAddressesArray.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(WebAddressesArray.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}
