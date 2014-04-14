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
public class Dog {
  private String dogName;
  private int age;
  private int weight;
  public static int count = 0;
  
  public Dog(String name, int age, int weight){
    this.dogName = name;
    this.age = age;
    this.weight = weight;
  }

  public String getDogName() {
    return dogName;
  }
// Now dogName is read only;
//  public void setDogName(String dogName) {
//    this.dogName = dogName;
//  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }
  
  public void bark(){
    System.out.println("Woof!");
  }
  public void sit(){
    System.out.println("Sitting...");
  }

  public static int getCount() {
    return count;
  }

  public static void setCount(int count) {
    Dog.count = count;
  }
  
}
