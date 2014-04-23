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
public abstract class Account {

  protected final int pin = 1234;
  protected String name;
  protected double balance;

  public abstract boolean withdraw(double amount);

  public boolean deposit(double amount) {
    if (amount <= 10000) {
      balance += amount;
      return true;
    }
    return false;
  }

  public boolean checkPin(int pin) {
    return this.pin == pin;
  }


  public double getBalance() {
    return balance;
  }

}
