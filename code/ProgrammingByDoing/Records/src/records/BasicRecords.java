/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package records;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class BasicRecords {
  ConsoleIO7 cio = new ConsoleIO7();
 
  public void run(){
    Student s = new Student();
    s.name =  cio.get("Enter the student's name: ");
    s.year = cio.get("Enter the student's year: ");
    s.gradeAvg = cio.getFlt("Enter the student's average: ");
    
    cio.println();
    
    Student s1 = new Student();
    s1.name =  cio.get("Enter the student's name: ");
    s1.year = cio.get("Enter the student's year: ");
    s1.gradeAvg = cio.getFlt("Enter the student's average: ");
    
    cio.println();
    
    Student s2 = new Student();
    s2.name =  cio.get("Enter the student's name: ");
    s2.year = cio.get("Enter the student's year: ");
    s2.gradeAvg = cio.getFlt("Enter the student's average: ");
    
    cio.println("The names are: \n"
      + s.name + "\n"
      + s1.name + "\n"
      + s2.name + "\n"
    );
    cio.println("The years are: \n"
      + s.year + "\n"
      + s1.year + "\n"
      + s2.year + "\n"
    );
    cio.println("The grade averages are: \n"
      + s.gradeAvg + "\n"
      + s1.gradeAvg + "\n"
      + s2.gradeAvg + "\n"
    );
    
    cio.println("The average for the three students is: " 
      + (s.gradeAvg + s1.gradeAvg + s2.gradeAvg)/3);
    
    
  }
  
  
  
  
  
}
