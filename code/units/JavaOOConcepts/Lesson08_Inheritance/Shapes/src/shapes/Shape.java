/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public abstract class Shape {
  
  protected String color;
  protected String name;
  public abstract double area();
  public abstract double perimeter();
 
  public String getColor(){
    return this.color;
  }
  
  public void setColor(String color){
    this.color = color;
  }
  
  
  @Override
  public String toString(){
    return name;
    
  }
  
}
