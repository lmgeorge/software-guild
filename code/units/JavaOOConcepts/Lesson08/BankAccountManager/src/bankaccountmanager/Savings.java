/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountmanager;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Savings extends Account {

  public Savings() {
    name = "Savings";
    balance = 16000;
  }

  @Override
  public boolean withdraw(double amount) {
    if (amount <= balance) {
      balance -= amount;
      return true;
    }
    return false;
  }

}
