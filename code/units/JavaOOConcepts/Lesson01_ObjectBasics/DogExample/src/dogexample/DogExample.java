/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dogexample;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DogExample {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ConsoleIO c = new ConsoleIO();

    Dog dog1 = new Dog("jumbi");
    dog1.setAge(14);
    dog1.setDogName("Jumbi");
    dog1.setWeight(135);
    
    Labrador dante = new Labrador("Dante", "chocolate");
    
    c.println(dante.getDogName());

    
    
  }
  
}
