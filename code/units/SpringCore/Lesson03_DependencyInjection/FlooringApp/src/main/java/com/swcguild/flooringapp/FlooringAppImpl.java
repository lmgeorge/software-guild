/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringapp;

import com.swcguild.flooringapp.dao.FlooringAppDao;
import com.swcguild.flooringapp.model.Calculator;
import com.swcguild.flooringapp.model.Order;
import com.swcguild.flooringapp.model.Product;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class FlooringAppImpl implements FlooringAppDao {

	private final String DELIMITER = ",";
	private final String PRODUCTS = "Products.txt";
	private final String TAXES = "Taxes.txt";
	private final String CONFIG = "config.txt";

	private String[] config = new String[2];
	private Map<String, List<Order>> orderLists = new HashMap<>();
	private Set<String> orderDates = orderLists.keySet();
	private Map<String, Product> productMap = new HashMap<>();
	private Map<String, Double> taxMap = new HashMap<>();

	private Calculator calc = new Calculator();
	private long count = 0;
	private Order tempOrder = new Order();
	private List<Order> list = new ArrayList<>();

	public void loadFile(String date) throws FileNotFoundException {
		String fileName = "Order_" + date + ".txt";
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
		String record;
		String[] tempArray;
		List<Order> tempList = new ArrayList<>();
		while (sc.hasNextLine()) {
			record = sc.nextLine();
			tempArray = record.split(DELIMITER);
			Order nextOrder = new Order();
			try {
				nextOrder.setOrderNum(Long.parseLong(tempArray[0]));
				nextOrder.setCustomerName(tempArray[1]);
				nextOrder.setState(tempArray[2]);
				nextOrder.setTaxRate(Double.parseDouble(tempArray[3]));
				nextOrder.setProductType(tempArray[4]);
				nextOrder.setArea(Double.parseDouble(tempArray[5]));
				nextOrder.setCostPerSqft(Double.parseDouble(tempArray[6]));
				nextOrder.setLaborCostPerSqft(Double.parseDouble(tempArray[7]));
				nextOrder.setMaterialCost(Double.parseDouble(tempArray[8]));
				nextOrder.setLaborCost(Double.parseDouble(tempArray[9]));
				nextOrder.setTotalTax(Double.parseDouble(tempArray[10]));
				nextOrder.setTotalCost(Double.parseDouble(tempArray[11]));
			} catch (NumberFormatException ex) {
				Logger.getLogger(FlooringAppImpl.class.getName())
					.log(Level.FINE, ex.getMessage());
			}
			tempList.add(nextOrder);
			
		}
		orderLists.put(date, tempList);
		sc.close();
	}

	public void writeFile(String date) {
		String fileName = "Order_" + date + ".txt";

		try {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

			orderLists.get(date)
				.stream()
				.forEach(order -> {
					out.println(
						order.getOrderNum() + DELIMITER
						+ order.getCustomerName() + DELIMITER
						+ order.getState() + DELIMITER
						+ order.getTaxRate() + DELIMITER
						+ order.getProductType() + DELIMITER
						+ order.getArea() + DELIMITER
						+ order.getCostPerSqft() + DELIMITER
						+ order.getLaborCostPerSqft() + DELIMITER
						+ order.getMaterialCost() + DELIMITER
						+ order.getLaborCost() + DELIMITER
						+ order.getTotalTax() + DELIMITER
						+ order.getTotalCost()
					);
					out.flush();
				});
			out.close();
		} catch (IOException | NullPointerException ex) {
			Logger.getLogger(FlooringAppImpl.class.getName())
				.log(Level.FINE, ex.getMessage());
		}
	}

	public void loadConfig(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));

		for (int i = 0; i < config.length; i++) {
			config[i] = sc.nextLine();
		}

		sc.close();
	}

	public void writeConfig(String fileName) throws IOException {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));

		out.println(config[0]);
		out.println(config[1]);
		out.flush();
		out.close();

	}

	public void loadProducts(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCTS)));
		String record;
		String[] tempArray;

		while (sc.hasNextLine()) {
			record = sc.nextLine();
			tempArray = record.split(DELIMITER);
			Product tempProd = new Product();
			tempProd.setName(tempArray[0]);
			try {
				double cost = Double.parseDouble(tempArray[1]);
				tempProd.setCostPerSqft(cost);
				double labor = Double.parseDouble(tempArray[2]);
				tempProd.setLaborPerSqft(labor);
			} catch (NumberFormatException ex) {
				Logger.getLogger(FlooringAppImpl.class.getName())
					.log(Level.FINE, ex.getMessage());
			}
			productMap.put(tempProd.getName(), tempProd);
		}
		sc.close();
	}

	public Set<String> getProdKeys() throws NullPointerException {
		return productMap.keySet();
	}

	public Product getProduct(String type) {

		return productMap.get(type.toLowerCase());

	}

	public void loadTaxes(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(TAXES)));
		String record;
		String[] tempArray;

		while (sc.hasNextLine()) {
			record = sc.nextLine();
			tempArray = record.split(DELIMITER);
			try {
				double tax = Double.parseDouble(tempArray[1]);
				taxMap.put(tempArray[0], tax);
			} catch (NumberFormatException ex) {
				Logger.getLogger(FlooringAppImpl.class.getName())
					.log(Level.FINE, ex.getMessage());
			}

		}
		sc.close();

	}

	public Set<String> getTaxKeys() throws NullPointerException {
		return taxMap.keySet();
	}

	public Set<String> getOrderKeys() throws NullPointerException {
		return orderLists.keySet();
	}

	public List<Order> getByDate(String date) throws NullPointerException {
		return orderLists.get(date);
	}

	public void add(Order order, String date) {
		if (orderLists.get(date) == null) {
			List<Order> tempList = new ArrayList<>();
			tempList.add(order);
			orderLists.put(date, tempList);
		} else {
			orderLists.get(date).add(order);
		}
	}


	public Order completeOrder(Order temp) {

		temp.setTaxRate(
			taxMap.get(temp.getState().toUpperCase()));

		temp.setCostPerSqft(
			getProduct(
				temp.getProductType()).getCostPerSqft());

		temp.setLaborCostPerSqft(
			getProduct(
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

		return temp;
	}

	public void remove(String date, Order order) {
		try {
			orderLists.get(date)
				.remove(order);
		} catch (NullPointerException ex) {
			System.out.println("Error: " + ex.getMessage());
		}
	}

	public Order getOrder(String date, long orderNum) throws NullPointerException {
		tempOrder = new Order();
		tempOrder = (orderLists.get(date)
			.stream()
			.filter(order -> order.getOrderNum() == orderNum)
			.collect(Collectors.toList())).get(0);

		return tempOrder;
	}

	public Order getOrder(long orderNum) throws NullPointerException {
		tempOrder = new Order();
		list = new ArrayList<>();
		orderDates
			.stream()
			.forEach(date -> {
				try {
					if (!orderDates.contains(date)) {
						loadFile(date);
					}
					orderLists.get(date)
					.stream()
					.filter(order -> order.getOrderNum() == orderNum)
					.forEach(match -> {
						list.add(match);
					});
				} catch (FileNotFoundException ex) {
					Logger.getLogger(FlooringAppImpl.class.getName())
					.log(Level.FINE, ex.getMessage());
				}
			});

		return list.get(0);
	}

	public boolean orderExists(long orderNum) {
		count = 0;
		orderDates
			.stream()
			.forEach(date -> {
				count += orderLists.get(date)
				.stream()
				.mapToLong(Order::getOrderNum)
				.filter(num -> num == orderNum)
				.count();
			});

		return count == 1;
	}

	public long getGlobalOrderNum() throws NullPointerException {
		return Long.parseLong(config[1]);
	}

	public void setGlobalOrderNum() {
		config[1] = (getGlobalOrderNum() + 1) + "";
	}

	public boolean isTestMode() throws NullPointerException {
		return config[0].equalsIgnoreCase("test");
	}

	//Unit Test only method
	public double getTax(String state) throws NullPointerException {
		return taxMap.get(state.toUpperCase());
	}
	
public void calledEdit(){
}
public void calledAdd(){
}
public void calledRemove(){
}

}
