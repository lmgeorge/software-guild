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
    // Predetermined constants
    final double MAX_HEIGHT = 25.5;
    final double MAX_WIDTH = 18.75;
    final double MIN_HEIGHT = 1.0;
    final double MIN_WIDTH = 1.0;
    final double MAX_COST = 10000;
    final double MIN_COST = 0;

    //Grab all variables of the window
    double  height,
            width,
            cost,
            perimeterWindow,
            areaWindow,
            glassCost,
            trimCost;
    
    //Get measures
    height = readValue("Please enter window height:", MAX_HEIGHT, MIN_HEIGHT);
    width = readValue("Please enter window width:", MAX_WIDTH, MIN_WIDTH);

    //Get cost
    glassCost = readValue("Please enter the cost of glass per square inch.", MAX_COST, MIN_COST);
    trimCost = readValue("Please enter the cost of trim per linear inch.", MAX_COST, MIN_COST);

    //Calculate area, perimeter, and total cost of window
    areaWindow = height * width;
    perimeterWindow = 2 * (height * width);
    cost = (glassCost * areaWindow + trimCost * perimeterWindow);

    //Print all measures, calculations, and total cost of window
    System.out.println(
      "Window height = " + height + "\n"
      + "Window width = " + width + "\n"
      + "Window area = " + areaWindow + "\n"
      + "Window perimeterWindow = " + perimeterWindow + "\n"
      + "Total cost = " + cost
    );

  }

  public static double readValue(String prompt, double max, double min) {
    Scanner ui = new Scanner(System.in);
    System.out.println(prompt);
    double value;

    do {
      value = ui.nextFloat();
      if (value < min || value > max) {
        System.out.println("Error: Please enter a value between" + min + " and " + max + "\n");
      }
    } while (value < min || value > max);

    return value;
  }

}
