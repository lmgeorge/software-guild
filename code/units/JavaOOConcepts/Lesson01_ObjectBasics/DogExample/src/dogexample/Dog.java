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
  protected ConsoleIO c = new ConsoleIO();
  
  protected String dogName;
  protected int age;
  protected int weight;
  public static int count = 0;

  public Dog(String name){
    this.dogName = name;
  }

  public String getDogName() {
    return dogName;
  }

  public void setDogName(String dogName) {
    this.dogName = dogName;
  }

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

  
}
