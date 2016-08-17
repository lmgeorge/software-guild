/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringapp;

import com.swcguild.flooringapp.dao.FlooringAppDao;
import com.swcguild.flooringapp.model.Order;
import com.swcguild.flooringapp.model.Product;
import java.io.FileNotFoundException;
import java.util.Set;
import static org.hamcrest.CoreMatchers.hasItems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class FlooringAppImplTest {

	private FlooringAppDao impl;
	private FlooringAppDao implCopy;
	private FlooringAppDao implCopy2;
	private Order sass = new Order();
	private Order hunter = new Order();
	private Order hunterCopy = new Order();
	private Order george = new Order();
	private Order georgeComplete = new Order();

	public FlooringAppImplTest() {
	}

	public boolean compareOrder(Order order1, Order order2) {
		return order1.getCustomerName().equals(order2.getCustomerName())
			&& order1.getOrderNum() == order2.getOrderNum()
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

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("appContext.xml");
		impl = (FlooringAppDao) ctx.getBean("dao");
		
		ApplicationContext ctx2 = 
			new ClassPathXmlApplicationContext("appContext.xml");
		implCopy = (FlooringAppDao) ctx2.getBean("dao");

		ApplicationContext ctx3 = 
			new ClassPathXmlApplicationContext("appContext.xml");
		implCopy2 = (FlooringAppDao) ctx3.getBean("dao");
		
		sass.setOrderNum(203);
		sass.setCustomerName("Dan Sass");
		sass.setState("OH");
		sass.setTaxRate(5.0);
		sass.setProductType("tile");
		sass.setArea(500.0);
		sass.setCostPerSqft(5.50);
		sass.setLaborCostPerSqft(2.50);
		sass.setMaterialCost(6.0);
		sass.setLaborCost(30.0);
		sass.setTotalTax(500.0);
		sass.setTotalCost(100000.0);

		hunter.setOrderNum(201);
		hunter.setCustomerName("Hunter Gervelis");
		hunter.setState("PA");
		hunter.setTaxRate(5.0);
		hunter.setProductType("hardwood");
		hunter.setArea(800.0);
		hunter.setCostPerSqft(6.50);
		hunter.setLaborCostPerSqft(100);
		hunter.setMaterialCost(hunter.getArea() * 6.50);
		hunter.setLaborCost(hunter.getArea() * 100);
		hunter.setTotalTax((5 / 100)
			* (hunter.getMaterialCost() + hunter.getLaborCost()));
		hunter.setTotalCost(
			hunter.getTotalTax()
			+ hunter.getLaborCost()
			+ hunter.getMaterialCost());

		hunterCopy.setOrderNum(201);
		hunterCopy.setCustomerName("Hunter Gervelis");
		hunterCopy.setState("PA");
		hunterCopy.setTaxRate(5.0);
		hunterCopy.setProductType("hardwood");
		hunterCopy.setArea(800.0);
		hunterCopy.setMaterialCost(hunterCopy.getArea() * 6.50);
		hunterCopy.setLaborCost(hunterCopy.getArea() * 100);
		hunterCopy.setTotalTax((5 / 100)
			* (hunterCopy.getMaterialCost() + hunterCopy.getLaborCost()));
		hunterCopy.setTotalCost(
			hunterCopy.getTotalTax()
			+ hunterCopy.getLaborCost()
			+ hunterCopy.getMaterialCost());

		georgeComplete.setOrderNum(1000);
		georgeComplete.setCustomerName("Lauren George");
		georgeComplete.setState("MI");
		georgeComplete.setProductType("wood");
		georgeComplete.setArea(500);
		georgeComplete.setTaxRate(5.75);
		georgeComplete.setCostPerSqft(5.15);
		georgeComplete.setLaborCostPerSqft(4.75);
		georgeComplete.setMaterialCost(5.15 * 500);
		georgeComplete.setLaborCost(4.75 * 500);
		georgeComplete.setTotalTax((5.75/100)
			* (georgeComplete.getLaborCost() + georgeComplete.getMaterialCost()));
		georgeComplete.setTotalCost(
			georgeComplete.getTotalTax()
			+ georgeComplete.getLaborCost()
			+ georgeComplete.getMaterialCost());
	}

	@After
	public void tearDown() {
		sass = new Order();
		hunter = new Order();
		hunterCopy = new Order();
		george = new Order();
		georgeComplete = new Order();
	}

	@Test
	public void testAdd() {
		impl.add(sass, "04252014");
		Order sass2 = impl.getOrder("04252014", 203);
		assertTrue(compareOrder(sass, sass2));
	}

	@Test
	public void testGetByDate() {
		impl.add(hunter, "04282014");
		impl.add(sass, "04292014");

		assertThat(impl.getByDate("04282014"), hasItems(hunter));
		assertThat(impl.getByDate("04292014"), hasItems(sass));
	}

	@Test
	public void testGetOrder() {

		impl.add(hunter, "04282014");
		impl.add(sass, "04282014");

		Order hunterTest = impl.getOrder("04282014", 201);
		Order sassTest = impl.getOrder("04282014", 203);

		assertEquals(201, hunterTest.getOrderNum());
		assertTrue(compareOrder(hunter, hunterTest));
		assertTrue(compareOrder(sass, sassTest));
	}

	@Test
	public void testGetOrder_long() {
		impl.add(hunter, "04282014");
		impl.add(sass, "04282014");

		Order hunterTest = impl.getOrder(201);
		Order sassTest = impl.getOrder(203);

		assertEquals(201, hunterTest.getOrderNum());
		assertTrue(compareOrder(hunter, hunterTest));
		assertTrue(compareOrder(sass, sassTest));
	}

	//@Ignore
	@Test
	public void testLoad_WriteFile() throws FileNotFoundException {
		impl.add(hunter, "02121950");
		impl.add(sass, "02111850");

		impl.writeFile("02111850");
		impl.writeFile("02121950");

		implCopy.loadFile("02111850");
		implCopy.loadFile("02121950");

		assertTrue(compareOrder(implCopy.getOrder(201), impl.getOrder(201)));
		assertTrue(compareOrder(implCopy.getOrder(203), impl.getOrder(203)));

		assertTrue(compareOrder(implCopy.getOrder(201), hunter));
		assertTrue(compareOrder(implCopy.getOrder(203), sass));

		hunter.setArea(888);
		implCopy.getOrder(201).setArea(888);

		implCopy.writeFile("02111850");
		implCopy.writeFile("02121950");

		implCopy2.loadFile("02111850");
		implCopy2.loadFile("02121950");

		assertEquals(888, implCopy2.getOrder(201).getArea(), 0);

		assertTrue(compareOrder(implCopy2.getOrder(203), impl.getOrder(203)));

		assertTrue(compareOrder(implCopy2.getOrder(201), hunter));
		assertFalse(compareOrder(implCopy2.getOrder(201), hunterCopy));
		assertTrue(compareOrder(implCopy2.getOrder(203), sass));
	}

	@Test
	public void testLoad_GetProduct() throws FileNotFoundException {

		impl.loadProducts("Products.txt");

		Product tile = impl.getProduct("tile");
		Product carpet = impl.getProduct("carpet");
		Product laminate = impl.getProduct("laminate");
		Product wood = impl.getProduct("wood");

		assertFalse(tile.getCostPerSqft() == 2.25);
		assertTrue(carpet.getCostPerSqft() == 2.25);
		assertTrue(laminate.getCostPerSqft() == 1.75);
		assertTrue(wood.getCostPerSqft() == 5.15);

		assertTrue(tile.getLaborPerSqft() == 4.15);
		assertFalse(carpet.getLaborPerSqft() == 2.25);
		assertTrue(laminate.getLaborPerSqft() == 2.10);
		assertTrue(wood.getLaborPerSqft() == 4.75);
	}

	@Test
	public void testLoadTaxes() throws FileNotFoundException {
		FlooringAppImpl impl2 = new FlooringAppImpl();
		impl2.loadTaxes("Taxes.txt");

		assertEquals(6.25, impl2.getTax("OH"), 0);
		assertEquals(6.75, impl2.getTax("PA"), 0);
		assertEquals(5.75, impl2.getTax("MI"), 0);
		assertEquals(6, impl2.getTax("IN"), 0);
	}

	@Test
	public void testGetTaxKeys() throws FileNotFoundException {
		impl.loadTaxes("Taxes.txt");

		Set<String> keys = impl.getTaxKeys();

		assertTrue(keys.contains("OH"));
		assertTrue(keys.contains("PA"));
		assertTrue(keys.contains("MI"));
		assertTrue(keys.contains("IN"));
		assertEquals(4, keys.size());
	}

	@Test
	public void testLoad_WriteConfig_isTestMode() throws Exception {
		impl.loadConfig("configTest.txt");

		assertFalse(impl.isTestMode()); //configTest.txt set to "prod" mode
		assertEquals(1000, impl.getGlobalOrderNum());

		impl.setGlobalOrderNum();
		assertEquals(1001, impl.getGlobalOrderNum());

		impl.writeConfig("configTest2.txt");
		impl.loadConfig("configTest2.txt");

		assertFalse(impl.isTestMode());
		assertEquals(1001, impl.getGlobalOrderNum());
	}

	@Test
	public void testRemove() {
		impl.add(hunter, "04282014");
		impl.add(hunterCopy, "04282014");

		assertThat(impl.getByDate("04282014"), hasItems(hunter, hunterCopy));

		impl.remove("04282014", hunter);

		assertEquals(1, impl.getByDate("04282014").size());
		assertFalse(impl.getByDate("04282014").contains(hunter));
		assertThat(impl.getByDate("04282014"), hasItems(hunterCopy));
	}

	@Test
	public void testCompleteOrder() throws Exception {
		impl.loadTaxes("Taxes.txt");
		impl.loadProducts("Products.txt");
		impl.loadConfig("configTest.txt");

		george.setCustomerName("Lauren George");
		george.setState("MI");
		george.setProductType("wood");
		george.setArea(500);

		george.setOrderNum(impl.getGlobalOrderNum());

		george = impl.completeOrder(george);

		assertTrue(compareOrder(george, georgeComplete));

	}

	@Test
	public void testOrderExists() {
		impl.add(sass, "04252014");
		Order sass2 = impl.getOrder("04252014", 203);
		assertTrue(compareOrder(sass, sass2));

		//returns "true" if and only if there is only 1 order
		assertTrue(impl.orderExists(203));

		impl.add(sass, "04252014");
		assertFalse(impl.orderExists(203));
	}


}
