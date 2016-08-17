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
public class Checking extends Account{


  public Checking() {
    name = "Checking";
    balance = 6000;
  }

  @Override
  public boolean withdraw(double amount) {
    if (amount <= balance ){
      balance -= amount;
      return true;
    } else { 
      double newBalance = balance - amount;
      if(newBalance >= -100) {
        balance -= 10;
      balance -= amount;
      return true;
      }
    }
    return false; 
  }

  
}
