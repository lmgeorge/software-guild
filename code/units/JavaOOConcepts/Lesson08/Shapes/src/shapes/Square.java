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
public class Square extends Shape {
private double side;


public Square (double side){
  this.side = side;
  name = "Square";
  
}

  @Override
  public double area() {
    return Math.pow(side, 2);
  }

  @Override
  public double perimeter() {
    return side*4;
  }

  public double getSide() {
    return side;
  }

  public void setSide(double side) {
    this.side = side;
  }
  
}
