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
public class Triangle extends Shape {
  private double a, b, c;

  public Triangle(double a, double b, double c  ) {
    this.a = a;
    this.b = b;
    this.c = c;
    name = "Triangle";
  }



  @Override
  public double area() {
    double sumDiv2 = perimeter()/2;
    
    return  Math.sqrt((sumDiv2)*(sumDiv2 - a)*(sumDiv2 - b)*(sumDiv2-c));
  }

  @Override
  public double perimeter() {
    return a + b + c;
  }

  public double getA() {
    return a;
  }

  public void setA(double a) {
    this.a = a;
  }

  public double getB() {
    return b;
  }

  public void setB(double b) {
    this.b = b;
  }

  public double getC() {
    return c;
  }

  public void setC(double c) {
    this.c = c;
  }
    
}
