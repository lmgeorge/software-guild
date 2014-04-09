package windowmaster;
import java.util.Scanner;
/**
 *
 * @author apprentice
 */
public class WindowMaster {

  /**
   * @param args the command line arguments
   */
// Need a calculator for cost of a window
// Calculate total cost = glass + trim
// Need area of glass and trim, all floats
  public static void main(String[] args) {
    final double MAX_HEIGHT = 25.5;
    final double MAX_WIDTH = 18.75;
    final double MIN_HEIGHT = 1.0;
    final double MIN_WIDTH = 1.0;
      
    //Grab user input
    Scanner unit = new Scanner(System.in);
    
    //Grab all float variables of the window
    float height, 
          width, 
          cost, 
          perimeterWindow, 
          areaWindow,
          glassCost,
          trimCost;

             
    
    do {
        System.out.println("Please enter window height between 1 and 25.5:");
        height = Float.parseFloat(unit.nextLine());
        if (height <= MIN_HEIGHT || height >= MAX_HEIGHT){
            System.out.println("Error: Please enter a height between 1 and 25.");
        }
    }while (height <= MIN_HEIGHT || height >= MAX_HEIGHT);
    
    
    do {
        System.out.println("Please enter window width 1 and 18.75:");
        width = Float.parseFloat(unit.nextLine());
        if (width <= MIN_WIDTH || width >= MAX_WIDTH){
            System.out.println("Error: Please enter a width between 1 and 18.75.");
        }
    }while (width <= MIN_WIDTH || width >= MAX_WIDTH);    
    
    System.out.println("Please enter the cost of glass per square inch.");
    glassCost = Float.parseFloat(unit.nextLine());
    
    System.out.println("Please enter the cost of trim per linear inch.");
    trimCost = Float.parseFloat(unit.nextLine());
    
    
    areaWindow = height * width;
    perimeterWindow = 2 * (height * width);
    cost = (glassCost * areaWindow + trimCost * perimeterWindow);

    System.out.println(
      "Window height = " + height + "\n"
      + "Window width = " + width + "\n"
      + "Window area = " + areaWindow + "\n"
      + "Window perimeterWindow = " + perimeterWindow + "\n"
      + "Total cost = " + cost
    );

  }
  
}
