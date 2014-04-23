/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shapes;

import java.util.ArrayList;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Shapes {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    ArrayList<Shape> shapes = new ArrayList<>();
    
    shapes.add(new Circle(6));
    shapes.add(new Square(4));
    shapes.add(new Rectangle(3,4));
    shapes.add(new Triangle(3,4,5));
    
    shapes.stream()
      .forEach((shape) -> {
        System.out.println(shape.name);
        System.out.println("Perimeter: " + shape.perimeter());
        System.out.println("Area: "+ shape.area() + "\n");
    });
    
  }
  
}
