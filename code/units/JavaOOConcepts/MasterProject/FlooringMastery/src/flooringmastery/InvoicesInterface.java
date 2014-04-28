/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmastery;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface InvoicesInterface{
  public void writeFile(String fileName) throws Exception;
  public void loadFile(String fileName) throws Exception;
  public void add(Order order, String date);
  public void remove(Order order);
  public List<Order> getByDate(String date);
  public long getOrderNum(String fileName) throws Exception;
  public Order getOrder(String date, long orderNum) throws NullPointerException;
  public String toString(Order order);
  public double getTax(String state);
  public Map<String, Product> loadProducts(String fileName) throws Exception;
  public Product getProduct(String type);
  public Map<String, Float> loadTaxes(String fileName)  throws Exception;
  public boolean isTestMode(String fileName)  throws Exception;
}
