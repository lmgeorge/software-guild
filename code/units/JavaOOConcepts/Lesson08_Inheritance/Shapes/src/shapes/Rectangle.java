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
public class Rectangle extends Shape{
  private double length;
  private double width;
  
  
  public Rectangle(double length, double width){
    this.length = length;
    this.width = width;
    name = "Rectangle";
  }

  @Override
  public double area() {
    return length*width;
  }

  @Override
  public double perimeter() {
    return 2*(length+width);
  }

  public double getLength() {
    return length;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }
  
  
  
}
