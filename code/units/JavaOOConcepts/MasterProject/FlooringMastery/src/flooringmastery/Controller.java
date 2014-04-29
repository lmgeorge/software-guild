/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Controller {

	private final InvoicesInterface impl = new InvoicesImpl();
	ConsoleIO c = new ConsoleIOImpl();
	Calculator calc = new Calculator();
    
	public void run(){
		initProgram();
		menu();
	}
	public void menu() {
		c.println("\nMENU\n");
		int choice = c.getsNum("\t1. Display by Date "
			+ "\n\t2. Add an order"
			+ "\n\t3. Edit an order"
			+ "\n\t4. Remove an order"
			+ "\n\t5. Save"
			+ "\n\t0. Quit"
			+ "\n\nPlease enter your choice: ", 0, 5);

		switch (choice) {
			case 1:
				c.println("\nDISPLAY BY DATE\n");
				displayByDate();
				menu();
				break;
			case 2:
				c.println("\nADD ORDER\n");
				addOrder();
				menu();
				break;
			case 3:
				c.println("\nEDIT ORDER\n");
				c.println("Coming soon!");
				break;
			case 4:
				c.println("\nDELETE ORDER\n");
				deleteOrder();
				menu();
				break;
			case 5:
				c.println("\nSAVE\n");
				c.println("Coming soon!");
				break;
			case 0:
				c.println("\nQUIT\n");
				//Are you sure you want to quit without saving?
				c.println("Good bye.");
				break;
		}

	}//close menu

	public void initProgram() {
		try {
			impl.loadProducts("Products.txt");
			impl.loadTaxes("Taxes.txt");
			impl.loadConfig("config.txt");
		} catch (NullPointerException | FileNotFoundException ex) {
			c.println("Error: " + ex.getMessage());
		}
	}

	public String convertDate() {
		String entry = "";
		boolean badInput = true;
		do {
			try {
				entry = c.gets("\nPlease enter a date (MM/DD/YYYY): ");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
				LocalDate date = LocalDate.parse(entry, formatter);
				entry = entry.replaceAll("/", "");
				badInput = false;
			} catch (DateTimeParseException ex) {
				c.println("ERROR: \'" + entry + "\' is invalid.\n");
			}
		} while (badInput);
		return entry;
	}

	public void displayByDate() {
		String date;
		date = convertDate();

		try {

			c.println(impl.toString(impl.getByDate(date), ""));

		} catch (NullPointerException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void addOrder() {
		do {
			Order temp = new Order();
			String date;
			String state;
			date = convertDate();
			temp.setCustomerName(c.gets("Customer Name: "));
			do {
				state = c.gets("State (Ohio -> OH): ");
			} while (!(impl.getTaxKeys().contains(state)));
			temp.setState(state);

			temp.setProductType(c.gets("Material Type: "));
			temp.setArea(c.getsDouble("Area (Sq. Ft.): "));

			temp.setOrderNum(impl.getGlobalOrderNum());
			impl.setGlobalOrderNum();

			temp.setTaxRate(
				impl.getTax(temp.getState()));

			temp.setCostPerSqft(
				impl.getProduct(
					temp.getProductType()).getCostPerSqft());

			temp.setLaborCostPerSqft(
				impl.getProduct(
					temp.getProductType()).getLaborPerSqft());

			temp.setMaterialCost(
				calc.calcMaterialCost(
					temp.getArea(), temp.getCostPerSqft()
				));

			temp.setLaborCost(
				calc.calcLaborCost(
					temp.getArea(), temp.getLaborCostPerSqft()
				));

			temp.setTotalTax(
				calc.calcTotalTax(temp.getTaxRate()));

			temp.setTotalCost(calc.calcTotalCost());

			impl.add(temp, date);
		} while ((c.getsNum("Would you like to add another order (Yes = 1 / No = 0)? ", 0, 1) == 1));
	}//close addOrder

	public void deleteOrder() {
		Order tempOrder;
		String date; 
		do {
			do {
				date = convertDate();
				long response = c.getsLong("Enter the order number: ");

				tempOrder = impl.getOrder(date, response);
				c.println(impl.toString(tempOrder));

			} while ((c.getsNum("Are you sure that you want to delete this order (Yes = 1 / No = 0)? ", 0, 1) == 0));
			impl.remove(date, tempOrder);
		}while((c.getsNum("Would you like to delete another order (Yes = 1 / No = 0)? ", 0, 1) == 1) );
	}


}
