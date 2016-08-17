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
public abstract class Employee { 
 protected String firstName;
 protected String lastName;
 protected String department;
 protected final ConsoleIO10 c = new ConsoleIO10();
 
 
 public abstract void doWork(); 
 
 public void createObjectives(){
   c.println(firstName + " creating objectives...");
 }
 
 
 
 
 
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }
}
