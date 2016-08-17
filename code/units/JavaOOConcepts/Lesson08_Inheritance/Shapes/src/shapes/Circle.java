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
public class Circle extends Shape{
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
    name = "Circle";
  }

  @Override
  public double area() {
    return Math.PI*Math.pow(radius, 2);
  }

  @Override
  public double perimeter() {
    return 2*radius*Math.PI;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

}
