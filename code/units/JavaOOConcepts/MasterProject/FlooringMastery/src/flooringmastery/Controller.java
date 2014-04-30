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
public class Controller {

	private final InvoicesInterface impl = new InvoicesImpl();
	private final ConsoleIO c = new ConsoleIOImpl();
	private final Calculator calc = new Calculator();
	private final FlooringGooeyImpl gui = new FlooringGooeyImpl();

	public void run() {
		initProgram();
		menu();
	}

	public void menu() {
		int choice = gui.mainMenu();

		switch (choice) {
			case 1:
				displayByDate();
				menu();
				break;
			case 2:
				addOrder();
				menu();
				break;
			case 3:
				edit();
				menu();
				break;
			case 4:
				deleteOrder();
				menu();
				break;
			case 5:
				save();
				menu();
				break;
			case 0:
				quit();
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
		c.println("\nDISPLAY BY DATE\n");

		String date;
		date = convertDate();
		try {
			if (!impl.getOrderKeys().contains(date)) {
				impl.loadFile(date);
			}
			c.println(impl.toString(impl.getByDate(date), ""));

		} catch (NullPointerException | FileNotFoundException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void addOrder() {
		c.println("\nADD ORDER\n");
		do {
			Order temp = new Order();
			String date;
			String state;
			String matType;
			double area;
			date = convertDate();
			temp.setCustomerName(gui.getUserCustName());

			state = gui.getUserState();
			temp.setState(state);

			matType = gui.getUserMatType();
			temp.setProductType(matType);
			
			area = gui.getUserArea();
			temp.setArea(area);

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
		} while (gui.confirm("Would you like to add another order"));
	}//close addOrder

	public void deleteOrder() {
		c.println("\nDELETE ORDER\n");

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
						Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
		}else{
			c.println("Good bye.");
		}
	}

	public void save() {
		c.println("\nSAVE\n");

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
				Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else if (impl.isTestMode()) {
			c.println("Error: In test mode. Cannot save.");
		} else if (keys.isEmpty()) {
			c.println("Error: there is nothing to save.");
		}
	}

	public void edit() {
		c.println("\nEDIT ORDER\n");
		long orderNum = c.getsLong("Enter Order Number: ");
		String date = convertDate();
		try {
			if (!impl.getOrderKeys().contains(date)) {
				impl.loadFile(date);
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
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
