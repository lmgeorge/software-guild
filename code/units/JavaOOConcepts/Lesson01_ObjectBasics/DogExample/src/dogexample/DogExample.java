/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dogexample;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DogExample {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    String name ="Dante";
    int weight = 70, age = 1;
    Scanner ui = new Scanner(System.in);
    
    Dog dog1 = new Dog(name, age, weight);
    
    System.out.println("There are " + Dog.getCount()+ " dogs right now.");
    System.out.println(dog1.getDogName());
    System.out.println(dog1.getWeight());
    System.out.println(dog1.getAge());
    
    Dog dog2 = dog1;
    
    dog2.setWeight(135);
    
    System.out.println(dog1.getWeight());
    
    
    dog2 = new Dog("Jumbi", 10,135);
    System.out.println("There are " + Dog.getCount()+ " dogs right now.");
    dog2.bark();
    
  }
  
}
