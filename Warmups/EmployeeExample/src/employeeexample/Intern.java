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
public class Intern extends Employee{
  
  private String school;

  public void getPerformanceReview() {
    c.println("Intern getting performance review...");
  }

  
  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  @Override
  public void doWork() {
    System.out.println("%s is doing some work...");
  }

}
