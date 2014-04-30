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
	private final FlooringGooeyImpl gui = new FlooringGooeyImpl();

	public void run() {
		initProgram();
		menu();
	}

	public void menu() {
		int choice = gui.mainMenu();
		gui.printTitle(choice);

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
			gui.print("Error: " + ex.getMessage() + "\n");
		}
	}

	public void displayByDate() {
		String date;
		date = gui.convertDate();
		try {
			if (!impl.getOrderKeys().contains(date)) {
				impl.loadFile(date);
			}
			gui.print(gui.toString(impl.getByDate(date), "") + "\n");

		} catch (NullPointerException | FileNotFoundException ex) {
			Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void addOrder() {
		do {
			Order temp = new Order();
			String date;
			String state;
			String matType;
			double area;
			date = gui.convertDate();
			temp.setCustomerName(gui.getUserCustName(""));

			state = gui.getUserState(impl.getTaxKeys());
			temp.setState(state);

			matType = gui.getUserMatType(impl.getProdKeys());
			temp.setProductType(matType);

			area = gui.getUserArea();
			temp.setArea(area);
			
			temp.setOrderNum(impl.getGlobalOrderNum());
			
			impl.setGlobalOrderNum();
			
			temp = impl.completeOrder(temp);

			impl.add(temp, date);

			gui.print(gui.toString(temp) + "\n");
		} while (gui.confirm("Would you like to add another order"));
	}//close addOrder

	public void deleteOrder() {

		Order tempOrder;
		String date;
		do {
			do {
				date = gui.convertDate();
				long response = gui.getUserOrderNum();
				if (!impl.orderExists(response)) {
					gui.print("No order found.\n");
					return;
				}

				if (!impl.getOrderKeys().contains(date)) {
					try {
						impl.loadFile(date);
					} catch (FileNotFoundException ex) {
						Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
					}
				}
				tempOrder = impl.getOrder(date, response);
				gui.print(gui.toString(tempOrder));

			} while (gui.confirm("Are you sure that you want to delete this order"));

			impl.remove(date, tempOrder);
		} while (gui.confirm("Would you like to delete another order"));
	}

	public void edit() {
		long orderNum = c.getsLong("Enter Order Number: ");
		String date = gui.convertDate();
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

		String tempName = gui.getUserCustName(" (" + toEdit.getCustomerName() + ")");
//			c.gets("\nCustomer Name (" + toEdit.getCustomerName() + "): ");
		if (!tempName.equals("")) {
			toEdit.setCustomerName(tempName);
		}

		state = c.gets("State (" + toEdit.getState() + "): ");
		if (!state.equals("")) {
			while (!(impl.getTaxKeys().contains(state))) {
				gui.print("\nError: Invalid entry.\n");
				state = c.gets("State (Ohio -> OH): ");
			}
			toEdit.setState(state);
		}

		matType = c.gets("Material Type (" + toEdit.getProductType() + "): ");
		if (!matType.equals("")) {
			while (!(impl.getProdKeys().contains(matType))) {
				gui.print("\nError: Invalid entry.\n");
				matType = c.gets("Material Type: ");
			}
			toEdit.setProductType(matType);
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
				gui.print("Error: Invalid Input\n");
			}
		} while (badInput);
		if (!tempArea.equals("")) {
			toEdit.setArea(area);
		}

		impl.completeOrder(toEdit);
		
		gui.print(gui.toString(toEdit));
	}

	public void save() {
		Set<String> keys = impl.getOrderKeys();
		if (gui.confirm("ATTENTION: Are you sure you want to save ")
			&& !impl.isTestMode()
			&& keys.size() > 0) {

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
			gui.print("Error: In test mode. Cannot save.\n");
		} else if (keys.isEmpty()) {
			gui.print("Error: there is nothing to save.\n");
		}
	}

	public void quit() {
		if (!gui.confirm("\nATTENTION: Quitting will discard any unsaved changes."
			+ "\nAre you sure you want to Quit?")) {
			menu();
		}
	}


}
