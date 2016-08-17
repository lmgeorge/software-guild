/*
 * To change this license header, choose License Headers in Project PropertiesAry[0].
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package records;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class LilDatabase {
  ConsoleIO cio = new ConsoleIO();
  Student[] sAry = new Student[3];
  public void run(){
    
    
    
    sAry[0] = new Student();
    sAry[0].name =  cio.gets("Enter the student's name: ");
    sAry[0].year = cio.gets("Enter the student's year: ");
    sAry[0].gradeAvg = cio.getsFloat("Enter the student's average: ");
    
    cio.println();
    
    sAry[1] = new Student();
    sAry[1].name =  cio.gets("Enter the student's name: ");
    sAry[1].year = cio.gets("Enter the student's year: ");
    sAry[1].gradeAvg = cio.getsFloat("Enter the student's average: ");
    
    cio.println();
    
    sAry[2] = new Student();
    sAry[2].name =  cio.gets("Enter the student's name: ");
    sAry[2].year = cio.gets("Enter the student's year: ");
    sAry[2].gradeAvg = cio.getsFloat("Enter the student's average: ");
    
    cio.println("The names are: \n"
      + sAry[0].name + "\n"
      + sAry[1].name + "\n"
      + sAry[2].name + "\n"
    );
    cio.println("The years are: \n"
      + sAry[0].year + "\n"
      + sAry[1].year + "\n"
      + sAry[2].year + "\n"
    );
    cio.println("The grade averages are: \n"
      + sAry[0].gradeAvg + "\n"
      + sAry[1].gradeAvg + "\n"
      + sAry[2].gradeAvg + "\n"
    );
    
    cio.println("The average for the three students is: " 
      + (sAry[0].gradeAvg + sAry[1].gradeAvg + sAry[2].gradeAvg)/3);
    
    
  }
  
  
  
  
  
}
