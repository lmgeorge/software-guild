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
public class Labrador extends Dog{
  public String color;
  
  public Labrador(String name, String color){
   super(name);
  }
  
  public String color(String name, String color){
    super(name);
    this.color = color;
  }
  
  
  public void hunt(){
    c.println(dogName + " is hunting...");
  }
}
