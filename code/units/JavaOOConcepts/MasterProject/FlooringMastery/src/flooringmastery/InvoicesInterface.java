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
public interface InvoicesInterface {
  public void writeFile();
  public void loadFile();
  public void add(Order order);
  public void remove(Order order);
  public List<Order> getByDate(String date);
  public long getOrderNum(String fileName);
  public Order getOrder(String date, long orderNum);
  public String toString(Order order);
  public float getTax(String state);
  public Map<String, Product> loadProducts(String fileName);
  public Product getProduct(String type);
  public Map<String, Float> loadTaxes(String fileName);
  public boolean isTestMode(String fileName);
}
