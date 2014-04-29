/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmastery;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Controller {
  private final InvoicesInterface impl = new InvoicesImpl();
  ConsoleIO c = new ConsoleIOImpl();
  Calculator calc = new Calculator();
  
  public void menu() {
    c.println("MENU");
    int choice = c.getsNum("1. Display by Date "
      + "\n2. Add All"
      + "\n3. Edit"
      + "\n4. Remove"
      + "\n5. Save"
      + "\n0. Exit", 0, 5);
    
    switch (choice) {
      case 1: 
        c.print("case 1");
        break;
      case 2: 
        break;
      case 3:
        c.print("case 3");
        break;
      case 4:
        c.print("case 4");
        break;
      case 5:
        c.print("case 5");
        break;
      case 0:
        break;
    }
    
  }//close menu
  
  public void displayByDate() {
    
    
  }
  
  public void addOrder() {
    Order temp = new Order();
    
    temp.setCustomerName(c.gets("Customer Name: "));
    temp.setState(c.gets("State (New York -> NY): "));
    temp.setProductType(c.gets("Material Type: "));
    temp.setArea(c.getsDouble("Area (Sq. Ft.): "));
    
    temp.setTaxRate( 
      impl.getTax( temp.getState() ) );
    
    temp.setCostPerSqft( 
      impl.getProduct( 
        temp.getProductType()).getCostPerSqft() );
    
    temp.setLaborCostPerSqft( 
      impl.getProduct( 
        temp.getProductType()).getLaborPerSqft() );
    
    temp.setMaterialCost( 
      calc.calcMaterialCost( 
        temp.getArea(), temp.getCostPerSqft() 
      ) );
    
    temp.setLaborCost( 
      calc.calcLaborCost( 
        temp.getArea(), temp.getLaborCostPerSqft() 
      ) );
    
    temp.setTotalTax( 
      calc.calcTotalTax( temp.getTaxRate() ) );
    
    temp.setTotalCost( calc.calcTotalCost() );
  }//close addOrder
  
public String convertDate() {
  String entry = c.gets("Please enter a date (MMDDYYYY): ");
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMddyyyy");
  LocalDate date = LocalDate.parse(entry, formatter);
  
 
  //still need to convert date to string
  //return new string
  // How does LocalDate parse handle bad input??
    
  
  return entry;
}
  
}
