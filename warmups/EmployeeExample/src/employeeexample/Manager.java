/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeeexample;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Manager extends Employee {


  public void hire() {
    c.println("Manager hiring...");
  }

  @Override
 public void createObjectives(){
   //super.createObjectives();
   c.println("Manager " + firstName +" " + lastName + " creating objectives...");
 }

  public void fire() {
    c.println("Manager firing...");
  }

  

  public void givePerformanceReview() {
    c.println("Giving performance review...");
  }

  @Override
  public void doWork() {
    c.println("Manager " + lastName + " doing some work...");
  }
}