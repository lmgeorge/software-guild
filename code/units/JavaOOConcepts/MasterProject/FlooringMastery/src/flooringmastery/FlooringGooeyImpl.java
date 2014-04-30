/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class FlooringGooeyImpl {
	private String printed = "";
	private final NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private final DecimalFormat d = new DecimalFormat("#.##");
	private final ConsoleIO c = new ConsoleIOImpl();

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

	public String getUserState(Set keys) {
		String state;
		state = c.gets("State (Ohio -> OH): ");
		while (!(keys.contains(state))) {
			c.println("\nError: Invalid entry.");
			state = c.gets("State (Ohio -> OH): ");
		}
		return state;
	}

	public String getUserMatType(Set keys) {
		String matType;
		matType = c.gets("Material Type: ");
		while (!(keys.contains(matType))) {
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

	public long getUserOrderNum() {
		long entry = c.getsLong("Enter the order number: ");
		while (entry < 1) {
			c.println("Error: Invalid entry.\n");
			entry = c.getsLong("Enter the order number: ");
		}

		return entry;
	}

	public String getUserCustName(String oldName) {
		return c.gets("Customer Name" + oldName +": ");
	}

	public boolean confirm(String prompt) {
		return c.getsNum(prompt + " (1 = Yes /  0 = No)? ", 0, 1) == 1;
	}

	public void print(String str) {
		c.print(str);
	}

	public void printTitle(int choice) {
		switch (choice) {
			case 1:
				c.println("\nDISPLAY BY DATE\n");
				break;
			case 2:
				c.println("\nADD ORDER\n");
				break;
			case 3:
				c.println("\nEDIT ORDER\n");
				break;
			case 4:
				c.println("\nDELETE ORDER\n");
				break;
			case 5:
				c.println("\nSAVE\n");
				break;
			case 0:
				break;
		}
	}

	public String toString(Order order) {
		return "\n================================================================\n"
			+ "\n\tOrder Number: " + order.getOrderNum()
			+ "\n\tName: " + order.getCustomerName()
			+ "\n\tState: " + order.getState()
			+ "\n\tTax Rate: " + d.format(order.getTaxRate()) + "%"
			+ "\n\tProduct Type: " + order.getProductType()
			+ "\n\tArea: " + d.format(order.getArea())
			+ "\n\tCost per sqft: " + n.format(order.getCostPerSqft())
			+ "\n\tLabor per sqft: " + n.format(order.getLaborCostPerSqft())
			+ "\n\tTotal Material: " + n.format(order.getMaterialCost())
			+ "\n\tTotal Labor: " + n.format(order.getLaborCost())
			+ "\n\tTotal Tax: " + n.format(order.getTotalTax())
			+ "\n\tTotal Cost: " + n.format(order.getTotalCost())
			+ "\n\n================================================================\n\n";
	}


	public String toString(List<Order> al, String delimiter) {
		printed = "";
		al
			.stream()
			.forEach(order -> {
				printed += (delimiter + toString(order));
			});
		return printed;
	}
}
