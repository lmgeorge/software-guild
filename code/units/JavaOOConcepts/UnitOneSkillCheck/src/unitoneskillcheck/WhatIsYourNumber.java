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
public class WhatIsYourNumber {

  private final ConsoleIO4 cio = new ConsoleIO4();
  private final Counter ctr = new Counter();

  public static void main(String[] args) {

    ConsoleIO4 cio = new ConsoleIO4();

    WhatIsYourNumber yourNum = new WhatIsYourNumber();

    yourNum.printer();
  }

  public void printer() {
    int c = cio.getNum("Please enter a whole number: ");
    
    cio.println("\n" + c);
    cio.println();
    
    ctr.toN(c);
    cio.println("\nThank you for playing!");
  }

}
