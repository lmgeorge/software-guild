/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class InvoicesImpl implements InvoicesInterface {

	private String[] config = new String[2];
	private Map<String, List<Order>> orderLists = new HashMap<>();
	private Map<String, Product> productMap = new HashMap<>();
	private Map<String, Double> taxMap = new HashMap<>();
	private final String DELIMITER = ",";
	private Order tempOrder = new Order();
	private String printed = "";
	private final String PRODUCTS = "Products.txt";
	private final String TAXES = "Taxes.txt";
	private final String CONFIG = "config.txt";
	private final NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
	private final DecimalFormat d = new DecimalFormat("#.##");

	public String toString(Order order) {
		return "\n\tOrder Number: " + order.getOrderNum()
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
			+ "\n================================================================\n\n";
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

	@Override
	public void writeFile(String date) throws IOException {
		String fileName = "Order_" + date + ".txt";
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

	}

	@Override
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
			tempList.add(nextOrder);

		}
		orderLists.put(date, tempList);
		sc.close();
	}

	@Override
	public void add(Order order, String date) {
		if (orderLists.get(date) == null) {
			List<Order> tempList = new ArrayList<>();
			tempList.add(order);
			orderLists.put(date, tempList);
		} else {
			orderLists.get(date).add(order);
		}
	}

	@Override
	public List<Order> getByDate(String date) throws NullPointerException {
		return orderLists.get(date);
	}

	@Override
	public Order getOrder(String date, long orderNum) throws NullPointerException {
		tempOrder = new Order();
		tempOrder = (orderLists.get(date)
			.stream()
			.filter(order -> order.getOrderNum() == orderNum)
			.collect(Collectors.toList())).get(0);

		return tempOrder;
	}

	@Override
	public Map<String, Product> loadProducts(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(PRODUCTS)));
		String record;
		String[] tempArray;

		while (sc.hasNextLine()) {
			record = sc.nextLine();
			tempArray = record.split(DELIMITER);
			Product tempProd = new Product();
			tempProd.setName(tempArray[0]);
			try {
			double cost= Double.parseDouble(tempArray[1]);
			tempProd.setCostPerSqft(cost);
			double labor = Double.parseDouble(tempArray[2]);
			tempProd.setLaborPerSqft(labor);
			} catch (NumberFormatException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			productMap.put(tempProd.getName(), tempProd);
		}
		sc.close();

		return productMap;
	}

	@Override
	public Product getProduct(String type) {

		return productMap.get(type.toLowerCase());

	}

	@Override
	public Map<String, Double> loadTaxes(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(TAXES)));
		String record;
		String[] tempArray;

		while (sc.hasNextLine()) {
			record = sc.nextLine();
			tempArray = record.split(DELIMITER);
			try {
			double tax = Double.parseDouble(tempArray[1]);
			taxMap.put(tempArray[0], tax);
			} catch(NumberFormatException ex) {
				System.out.println("Error: " + ex.getMessage());
			}
			
		}
		sc.close();

		return taxMap;
	}

	public Set<String> getTaxKeys()  throws NullPointerException{
		return taxMap.keySet();
	}

	@Override
	public double getTax(String state) throws NullPointerException {
		return taxMap.get(state.toUpperCase());
	}

	@Override
	public long getGlobalOrderNum() throws NullPointerException {
		return Long.parseLong(config[1]);
	}
	
	public void setGlobalOrderNum() {
		config[1] = (getGlobalOrderNum()+1) + "";
	}

	@Override
	public boolean isTestMode() throws NullPointerException {
		return config[0].equalsIgnoreCase("test");
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

	@Override
	public void remove(String date, Order order) {
		orderLists.get(date)
			.remove(order);
	}
	
}
