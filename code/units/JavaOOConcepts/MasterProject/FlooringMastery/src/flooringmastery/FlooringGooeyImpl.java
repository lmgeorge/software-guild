/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class FlooringGooeyImpl {

	private final InvoicesInterface impl = new InvoicesImpl();
	private final ConsoleIO c = new ConsoleIOImpl();
	private final Calculator calc = new Calculator();

	public void run() {
		initProgram();
		menu();
	}

	public int mainMenu() {
		c.println("\nMENU\n");
		int choice = c.getsNum("\t1. Display by Date "
			+ "\n\t2. Add an order"
			+ "\n\t3. Edit an order"
			+ "\n\t4. Remove an order"
			+ "\n\t5. Save"
			+ "\n\t0. Quit"
			+ "\n\nPlease enter your choice: ", 0, 5);

		return choice;
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
				edit();
				menu();
				break;
			case 4:
				c.println("\nDELETE ORDER\n");
				deleteOrder();
				menu();
				break;
			case 5:
				c.println("\nSAVE\n");
				save();
				menu();
				break;
			case 0:
				quit();
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
			if (!impl.getOrderKeys().contains(date)) {
				impl.loadFile(date);
			}
			c.println(impl.toString(impl.getByDate(date), ""));

		} catch (NullPointerException | FileNotFoundException ex) {
			Logger.getLogger(FlooringGooeyImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public String getUserState() {
		String state;
		state = c.gets("State (Ohio -> OH): ");
		while (!(impl.getTaxKeys().contains(state))) {
			c.println("\nError: Invalid entry.");
			state = c.gets("State (Ohio -> OH): ");
		}
		return state;
	}

	public String getUserMatType() {
		String matType;
		matType = c.gets("Material Type: ");
		while (!(impl.getProdKeys().contains(matType))) {
			c.println("\nError: Invalid entry.");
			matType = c.gets("Material Type: ");
		}
		return matType;
	}

	public double getUserArea() {
		double area;

		area = c.getsDouble("Area (Sq. Ft.): ");
		while (area < 1) {
			c.println("Error: Invalid entry.\n");
			area = c.getsDouble("Area (Sq. Ft.): ");
		}
		return area;
	}
	
	public String getUserCustName(){
		return c.gets("Customer Name: ");
	}
	
	public boolean confirm(String prompt){
		return c.getsNum(prompt + " (1 = Yes /  0 = No)? ", 0, 1) == 0;
	}
 
	public void addOrder() {
		do {
			Order temp = new Order();
			String date;
			String state;
			String matType;
			date = convertDate();
			temp.setCustomerName(c.gets("Customer Name: "));

			state = c.gets("State (Ohio -> OH): ");
			while (!(impl.getTaxKeys().contains(state))) {
				c.println("\nError: Invalid entry.");
				state = c.gets("State (Ohio -> OH): ");
			}
			temp.setState(state);

			matType = c.gets("Material Type: ");
			while (!(impl.getProdKeys().contains(matType))) {
				c.println("\nError: Invalid entry.");
				matType = c.gets("Material Type: ");
			}
			temp.setProductType(matType);

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

				if (!impl.getOrderKeys().contains(date)) {
					try {
						impl.loadFile(date);
					} catch (FileNotFoundException ex) {
						Logger.getLogger(FlooringGooeyImpl.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				tempOrder = impl.getOrder(date, response);
				c.println(impl.toString(tempOrder));

			} while ((c.getsNum("Are you sure that you want to delete this order (Yes = 1 / No = 0)? ", 0, 1) == 0));
			impl.remove(date, tempOrder);
		} while ((c.getsNum("Would you like to delete another order (Yes = 1 / No = 0)? ", 0, 1) == 1));
	}

	public void quit() {

		c.println("ATTENTION: Quitting will discard any unsaved changes.\n");

		if (c.getsNum("Are you sure you want to Quit? (Yes = 1 / No = 0) ", 0, 1) == 0) {
			menu();
		}
	}

	public void save() {

		Set<String> keys = impl.getOrderKeys();
		if (c.getsNum("ATTENTION: Are you sure you want to save (Yes = 1 / No = 0)?  ", 0, 1) == 1
			&& !impl.isTestMode() && keys.size() > 0) {

			keys
				.stream()
				.forEach(key -> {
					impl.writeFile(key);
				});
			try {
				impl.writeConfig("config.txt");
			} catch (IOException ex) {
				Logger.getLogger(FlooringGooeyImpl.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if (impl.isTestMode()) {
			c.println("Error: In test mode. Cannot save.");
		} else if (keys.isEmpty()) {
			c.println("Error: there is nothing to save.");
		}
	}

	public void edit() {
		long orderNum = c.getsLong("Enter Order Number: ");
		String date = convertDate();
		try {
			if (!impl.getOrderKeys().contains(date)) {
				impl.loadFile(date);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(FlooringGooeyImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		Order toEdit = impl.getOrder(date, orderNum);
		double area = toEdit.getArea();
		String tempArea;
		String state;
		String matType;
		boolean badInput = true;

		String tempName = c.gets("\nCustomer Name (" + toEdit.getCustomerName() + "): ");
		if (!tempName.equals("")) {
			toEdit.setCustomerName(tempName);
		}

		state = c.gets("State (" + toEdit.getState() + "): ");
		if (!state.equals("")) {
			while (!(impl.getTaxKeys().contains(state))) {
				c.println("\nError: Invalid entry.");
				state = c.gets("State (Ohio -> OH): ");
			}
			toEdit.setState(state);
			toEdit.setTaxRate(
				impl.getTax(toEdit.getState()));
		}

		matType = c.gets("Material Type (" + toEdit.getProductType() + "): ");
		if (!matType.equals("")) {
			while (!(impl.getProdKeys().contains(matType))) {
				c.println("\nError: Invalid entry.");
				matType = c.gets("Material Type: ");
			}
			toEdit.setProductType(matType);

			toEdit.setCostPerSqft(
				impl.getProduct(matType).getCostPerSqft());

			toEdit.setLaborCostPerSqft(
				impl.getProduct(matType).getLaborPerSqft());
		}

		do {
			tempArea = c.gets("Area (" + toEdit.getArea() + "sqft.) : ");
			try {
				if (!tempArea.equals("")) {
					area = Double.parseDouble(tempArea);
					badInput = false;
				} else if (tempArea.equals("")) {
					badInput = false;
				}
			} catch (NumberFormatException ex) {
				c.println("Error: Invalid Input");
			}
		} while (badInput);
		if (!tempArea.equals("")) {
			toEdit.setArea(area);

			toEdit.setMaterialCost(
				calc.calcMaterialCost(
					area, toEdit.getCostPerSqft()
				));

			toEdit.setLaborCost(
				calc.calcLaborCost(
					area, toEdit.getLaborCostPerSqft()
				));

			toEdit.setTotalTax(
				calc.calcTotalTax(toEdit.getTaxRate()));

			toEdit.setTotalCost(calc.calcTotalCost());
		}
	}


}
