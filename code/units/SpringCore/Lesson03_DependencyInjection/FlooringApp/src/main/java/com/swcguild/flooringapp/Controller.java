/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringapp;

import com.swcguild.flooringappgui.FlooringGUI;
import com.swcguild.flooringapp.dao.FlooringAppDao;
import com.swcguild.flooringapp.model.Order;
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

	private FlooringAppDao impl;
	private FlooringGUI gui;
	private Set<String> taxes;
	private Set<String> products;
	private Set<String> dates;

	public Controller(FlooringAppDao impl, FlooringGUI gui) {
		this.impl = impl;
		this.gui = gui;
	}

	public void run() {
		initProgram();
		taxes = impl.getTaxKeys();
		products = impl.getProdKeys();
		dates = impl.getOrderKeys();

		menu();
	}

	private void menu() {
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

	private void initProgram() {
		try {
			impl.loadProducts("Products.txt");
			impl.loadTaxes("Taxes.txt");
			impl.loadConfig("config.txt");
		} catch (NullPointerException | FileNotFoundException ex) {
			gui.print("Error: " + ex.getMessage() + "\n");
		}
	}

	private void displayByDate() {
		String date;
		date = gui.convertDate();
		try {
			if (!dates.contains(date)) {
				impl.loadFile(date);
			}

			gui.print(gui.toString(impl.getByDate(date), "") + "\n");

		} catch (NullPointerException | FileNotFoundException ex) {
			Logger.getLogger(Controller.class.getName())
				.log(Level.FINE, ex.getMessage());
			gui.print("Error: No record exists.\n");
		}

	}

	private void addOrder() {
		do {
			Order temp = new Order();
			String date;
			String state;
			String matType;
			double area;

			date = gui.convertDate();
			temp.setCustomerName(gui.getUserCustName(""));
			try {
				state = gui.getUserState("", taxes, false);
				temp.setState(state);

				matType = gui.getUserMatType("", products, false);
				temp.setProductType(matType);

				area = gui.getUserArea("", false);
				temp.setArea(area);

				temp.setOrderNum(impl.getGlobalOrderNum());

				impl.setGlobalOrderNum();

				temp = impl.completeOrder(temp);

				impl.add(temp, date);

				gui.print(gui.toString(temp) + "\n");
			} catch (NullPointerException ex) {
				Logger.getLogger(Controller.class.getName())
					.log(Level.FINE, ex.getMessage());
				gui.print("Error: Cannot process request.\n");
			}
		} while (gui.confirm("Would you like to add another order"));
	}//close addOrder

	private void deleteOrder() {

		Order tempOrder;
		String date;
		do {

			date = gui.convertDate();
			long orderNum = gui.getUserOrderNum();

			try {
				if (!dates.contains(date)) {
					impl.loadFile(date);
				}
				if (!impl.orderExists(orderNum)) {
					gui.print("No order found.\n");
					return;
				}

				tempOrder = impl.getOrder(date, orderNum);
				
				gui.print(gui.toString(tempOrder));
			
				if (gui.confirm("Are you sure that you want to delete this order")) {
					impl.remove(date, tempOrder);
				}
			} catch (FileNotFoundException | NullPointerException ex) {
				Logger.getLogger(Controller.class.getName())
					.log(Level.FINE, ex.getMessage());
				gui.print("Error: Cannot process request.\n" + ex.getMessage());
			}
		} while (gui.confirm("Would you like to delete another order"));
	}

	private void edit() {
		do {
			String date = gui.convertDate();
			long orderNum = gui.getUserOrderNum();

			//load the order file
			try {
				if (!dates.contains(date)) {
					impl.loadFile(date);
				}

				//grab the order from memory
				Order order = impl.getOrder(orderNum);
				double area;
				String state;
				String matType;

				String tempName = gui.getUserCustName(
					"(" + order.getCustomerName() + ")");
				if (!tempName.equals("")) {
					order.setCustomerName(tempName);
				}

				state = gui.getUserState(
					"State (" + order.getState() + "): ", taxes, true);
				if (!state.equals("")) {
					order.setState(state);
				}

				matType = gui.getUserMatType(
					"Material Type (" + order.getProductType() + "): ", 
					products, true);
				if (!matType.equals("")) {
					order.setProductType(matType);
				}

				area = gui.getUserArea(
					"Area (" + order.getArea() + "sqft.) : ", true);
				if (area != 0) {
					order.setArea(area);
				}

				//build the rest of the order
				impl.completeOrder(order);
				impl.calledEdit();
				//show the user the complete order
				gui.print(gui.toString(order));
			} catch (FileNotFoundException | NullPointerException ex) {
				Logger.getLogger(Controller.class.getName())
					.log(Level.FINE, ex.getMessage());
				gui.print("Error: Cannot process request.\n");
			}
		} while (gui.confirm("Would you like to edit another order"));
	}

	private void save() {
		if (gui.confirm("ATTENTION: Are you sure you want to save ")
			&& !impl.isTestMode()
			&& dates.size() > 0) {

			dates
				.stream()
				.forEach(date -> {
					impl.writeFile(date);
				});
			try {
				impl.writeConfig("config.txt");
			} catch (IOException ex) {
				Logger.getLogger(Controller.class.getName())
					.log(Level.FINE, ex.getMessage());
				gui.print("Error: Cannot process request.\n");
			}
		} else if (impl.isTestMode()) {
			gui.print("Error: In test mode. Cannot save.\n");
		} else if (dates.isEmpty()) {
			gui.print("Error: there is nothing to save.\n");
		}
	}

	private void quit() {
		if (!gui.confirm("\nATTENTION: Quitting will discard any unsaved changes."
			+ "\nAre you sure you want to Quit?")) {
			menu();
		}
	}


}
