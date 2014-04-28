/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class InvoicesImpl implements InvoicesInterface {

  private Map<String, List<Order>> orderLists = new HashMap<>();
  private final String DELIMITER = ",";
  private Order tempOrder = new Order();

  @Override
  public void writeFile(String date) throws Exception {
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
  public void loadFile(String date) throws Exception {
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
  public void remove(Order order) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Order> getByDate(String date) throws NullPointerException{
    return orderLists.get(date);
  }

  @Override
  public long getOrderNum(String fileName) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Order getOrder(String date, long orderNum) throws NullPointerException{
   tempOrder = null;
    orderLists.get(date)
      .stream()
      .forEach(order -> {
        if (order.getOrderNum() == orderNum){
          tempOrder = order;
        }
          });
    return tempOrder;
  }

  @Override
  public String toString(Order order) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public double getTax(String state) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Map<String, Product> loadProducts(String fileName) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Product getProduct(String type) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Map<String, Float> loadTaxes(String fileName) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean isTestMode(String fileName) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
