/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface InvoicesInterface {

	public void writeFile(String fileName) throws IOException;

	public void loadFile(String fileName) throws FileNotFoundException;

	public void add(Order order, String date);

	public void remove(String date, Order order);

	public List<Order> getByDate(String date);

	public long getGlobalOrderNum() throws NullPointerException;

	public void setGlobalOrderNum();

	public Order getOrder(String date, long orderNum) throws NullPointerException;

	public String toString(Order order);

	public String toString(List<Order> al, String delimiter);

	public double getTax(String state) throws NullPointerException;

	public Map<String, Product> loadProducts(String fileName) throws FileNotFoundException;

	public Product getProduct(String type) throws NullPointerException;

	public Map<String, Double> loadTaxes(String fileName) throws FileNotFoundException;

	public void loadConfig(String filename) throws FileNotFoundException;

	public void writeConfig(String filename) throws IOException;

	public boolean isTestMode() throws NullPointerException;

	public Set<String> getTaxKeys() throws NullPointerException;


}
