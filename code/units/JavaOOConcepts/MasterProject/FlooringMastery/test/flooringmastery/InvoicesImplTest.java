/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class InvoicesImplTest {

  InvoicesInterface impl = new InvoicesImpl();
  InvoicesInterface impl2 = new InvoicesImpl();

  public boolean compareOrder(Order order1, Order order2) {
    return order1.getCustomerName().equals(order2.getCustomerName())
      && order1.getState().equals(order2.getState())
      && order1.getTaxRate() == order2.getTaxRate()
      && order1.getProductType().equals(order2.getProductType())
      && order1.getArea() == order2.getArea()
      && order1.getCostPerSqft() == order2.getCostPerSqft()
      && order1.getLaborCostPerSqft() == order2.getLaborCostPerSqft()
      && order1.getMaterialCost() == order2.getMaterialCost()
      && order1.getLaborCost() == order2.getLaborCost()
      && order1.getTotalTax() == order2.getTotalTax()
      && order1.getTotalCost() == order2.getTotalCost();

  }

  public InvoicesImplTest() {

  }

  @BeforeClass
  public static void setUpClass() {

  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {

  }

  @After
  public void tearDown() {
  }

  @Test
  public void testWriteFile() throws Exception {
    Order order1 = new Order();
    order1.setOrderNum(201);
    order1.setCustomerName("Hunter Gervelis");
    order1.setState("OH");
    order1.setTaxRate(5.0);
    order1.setProductType("hardwood");
    order1.setArea(10000.0);
    order1.setCostPerSqft(5.50);
    order1.setLaborCostPerSqft(2.50);
    order1.setMaterialCost(6.0);
    order1.setLaborCost(30.0);
    order1.setTotalTax(500.0);
    order1.setTotalCost(1000.0);

    Order order2 = new Order();

    order2.setOrderNum(202);
    order2.setCustomerName("Hunter Gervelis");
    order2.setState("OH");
    order2.setTaxRate(5.0);
    order2.setProductType("hardwood");
    order2.setArea(10000.0);
    order2.setCostPerSqft(5.50);
    order2.setLaborCostPerSqft(2.50);
    order2.setMaterialCost(6.0);
    order2.setLaborCost(30.0);
    order2.setTotalTax(500.0);
    order2.setTotalCost(1000.0);

    impl.add(order1, "04282014");
    impl.add(order2, "04282014");

    impl.writeFile("04282014");
    assertTrue(compareOrder(order1, order2));

  }

  @Test
  public void testGetByDate() throws Exception {
    impl.loadFile("04282014");
    assertTrue(compareOrder(
      impl.getByDate("04282014").get(0),
      impl.getByDate("04282014").get(1)));

  }

//  @Test
//  public void testLoadFile() throws Exception {
//    impl2.loadFile("04282014");
//
//    assertTrue(compareOrder(
//      impl2.getByDate("04282014").get(0),
//      impl2.getByDate("04282014").get(1)));
//  }
  @Test
  public void testAdd() {
  }

  @Test
  public void testRemove() {
  }

  @Test
  public void testGetByDate() {
  }

  @Test
  public void testGetOrderNum() {
  }

  @Test
  public void testGetOrder() {
  }

  @Test
  public void testToString() {
  }

  @Test
  public void testGetTax() {
  }

  @Test
  public void testLoadProducts() {
  }

  @Test
  public void testGetProduct() {
  }

  @Test
  public void testLoadTaxes() {
  }

  @Test
  public void testIsTestMode() {
  }

}
