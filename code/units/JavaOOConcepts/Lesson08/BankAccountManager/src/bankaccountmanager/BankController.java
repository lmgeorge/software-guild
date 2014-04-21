/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountmanager;

import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class BankController {

  private ConsoleIO10 c = new ConsoleIO10();
  private NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
  private Checking checkAcc = new Checking();
  private Savings savingAcc = new Savings();
  private Account acc;

  public void exec() {
    int ui, ui2;
    while (!checkAcc.checkPin(c.getsNum("Enter PIN: "))) {
    }

    while (true) {
      ui = c.getsNum("\nPlease select an account:\n"
        + "1. Checking\n"
        + "2. Savings\n"
        + "0. Exit\n", 0, 2);
      if(ui == 0) {
        return;
      }
      if (ui == 1) {
        acc = (Checking) checkAcc;
      } else {
        acc = (Savings) savingAcc;
      }
      c.println(n.format(acc.getBalance()));

      ui2 = c.getsNum("\nPlease choose an operation:\n"
        + "1. Withdraw\n"
        + "2. Deposit\n", 1, 2);

      double amount = c.getsNum("\nPlease enter the amount: ");

      switch (ui2) {
        case 1:
          withdraw(amount, ui);
          break;
        case 2:
          deposit(amount, ui);
          break;
      }
      c.println(n.format(acc.getBalance()));
    }
  }

  public void withdraw(double amount, int ui) {

    if (!acc.withdraw(amount)) {
      c.println("Insufficient funds.");
    }
  }

  public boolean deposit(double amount, int ui) {
    if (amount > 10000) {
      c.println("Please contact the bank manager.");
      return false;
    }
    switch (ui) {
      case 1:
        checkAcc.deposit(amount);
        break;
      case 2:
        savingAcc.deposit(amount);
        break;
    }
    return true;
  }

}
