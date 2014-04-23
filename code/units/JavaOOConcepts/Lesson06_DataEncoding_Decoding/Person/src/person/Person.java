/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package person;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
//illustrates shadowing, scope, and inner classes
//see printHi() for 


public class Person {
  public int hairLength = 0;
  
  class Hair {
    private int hairLength = 20;
    
    
    void getHairLength(int hairLength){
      System.out.println("Hair length = " + hairLength); //exclusive to this method
      System.out.println("this.Hair length = " + this.hairLength); // exclusive to class Hair
      System.out.println("Person.this.Hair length = " + Person.this.hairLength); //at top level class
      
    }

    public int getHairLength() {
      return hairLength;
    }

    public void setHairLength(int hairLength) {
      this.hairLength = hairLength;
    }
  }
  
  
  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Person henry = new Person(); // in order to call non-static methods in main
    henry.printHi();
    
    Person.Hair henryHair = henry.new Hair();
    henryHair.getHairLength(30);
  }
  
  public void printHi(){
    hairLength = 7; // access the top(class) level variable
    int hairLength = 0; //local to this method
    System.out.println("Hi");
  }
  
}
