/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package employeeexample;

import java.io.PrintStream;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class EmployeeExample {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Intern intern = new Intern();
    
    
    intern.setFirstName("Joe");
    intern.setLastName("White");
    intern.setDepartment("HR");
    intern.setSchool("UVa");
    intern.doWork();
    intern.getPerformanceReview();
    intern.createObjectives();
    
    Manager mgr = new Manager();
    mgr.setFirstName("Gina");
    mgr.setLastName("Harold");
    mgr.createObjectives();
    mgr.doWork();
    
    Employee emp = new Manager();
    emp.createObjectives();
    Manager mgr2 = (Manager)emp;
    mgr.setFirstName("Gina");
    mgr.setLastName("Harold");
    mgr2.fire();
    
    String word = "Java";
    System.out.printf("%s some things\n", word);
  }
  
}
