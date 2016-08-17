/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package steamsandlambdas;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
  
import java.time.chrono.IsoChronology;
import java.time.LocalDate;
 
public class Person {
   
    public enum Sex {
        MALE, FEMALE
    }
   
    String name; 
    LocalDate birthday;
    Sex gender;
    String emailAddress;
   
    Person(String nameArg, LocalDate birthdayArg,
        Sex genderArg, String emailArg) {
        name = nameArg;
        birthday = birthdayArg;
        gender = genderArg;
        emailAddress = emailArg;
    }  
 
    public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
    }
 
    public void printPerson() {
      System.out.println(name + ", " + this.getAge());
    }
     
    public Sex getGender() {
        return gender;
    }
     
    public String getName() {
        return name;
    }
     
    public String getEmailAddress() {
        return emailAddress;
    }
     
    public LocalDate getBirthday() {
        return birthday;
    }
     
    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }
 

     
}
