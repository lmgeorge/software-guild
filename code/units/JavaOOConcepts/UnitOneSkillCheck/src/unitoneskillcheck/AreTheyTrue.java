/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitoneskillcheck;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class AreTheyTrue {

  public static void main(String[] args) {
    ConsoleIO4 cio = new ConsoleIO4();
    AreTheyTrue bool = new AreTheyTrue();
    int percent = 0;
    
    String test = bool.howTrue(true, true);
    if (test.equalsIgnoreCase("BOTH")) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }
    
    test = bool.howTrue(false, false);
    if (test.equalsIgnoreCase("NEITHER")) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }
    
    test = bool.howTrue(true, false);
    if (test.equalsIgnoreCase("ONLY ONE")) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }
    
    test = bool.howTrue(false, true);
    if (test.equalsIgnoreCase("ONLY ONE")) {
      cio.println("True");
      percent++;
    } else {
      cio.println("False");
    }
    cio.println((percent / 4) * 100 + "% of AreTheyTrue tests passed.\n");

  }

  public String howTrue(boolean first, boolean second) {
    String bool = "";

    if (first != second) {
      bool = "ONLY ONE";

    } else if (!(first && second)) {
      bool = "NEITHER";
    } else if (first && second) {
      bool = "BOTH";
    }

    return bool;
  }

}
