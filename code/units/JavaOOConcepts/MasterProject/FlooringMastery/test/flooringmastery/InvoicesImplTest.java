/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flooringmastery;

import java.io.FileNotFoundException;
import java.util.Set;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class InvoicesImplTest {

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
	public void testAdd() {
		InvoicesInterface impl = new InvoicesImpl();
		Order test = new Order();
		test.setOrderNum(203);
		test.setCustomerName("Dan Sass");
		test.setState("OH");
		test.setTaxRate(5.0);
		test.setProductType("Tile");
		test.setArea(500.0);
		test.setCostPerSqft(5.50);
		test.setLaborCostPerSqft(2.50);
		test.setMaterialCost(6.0);
		test.setLaborCost(30.0);
		test.setTotalTax(500.0);
		test.setTotalCost(100000.0);

		impl.add(test, "04252014");
		Order test2 = impl.getOrder("04252014", 203);
		assertTrue(compareOrder(test, test2));

	}

	@Test
	public void testWriteFile() throws Exception {
		InvoicesInterface impl = new InvoicesImpl();

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
	public void testGetOrder() {
		InvoicesInterface impl2 = new InvoicesImpl();

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

		impl2.add(order1, "04282014");
		impl2.add(order2, "04282014");

		impl2.getOrder("04282014", 201);
		impl2.getOrder("04282014", 202);

		assertEquals(201, order1.getOrderNum());
		assertTrue(compareOrder(order1, order2));
	}

	@Test
	public void testLoadFile() throws Exception {
		InvoicesInterface impl3 = new InvoicesImpl();
		impl3.loadFile("04282014");

		assertTrue(compareOrder(
			impl3.getOrder("04282014", 201),
			impl3.getOrder("04282014", 202)));
	}

	@Test
	public void testGetByDate() throws Exception {
		InvoicesInterface impl = new InvoicesImpl();

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
		impl.add(order2, "04292014");

		assertThat(impl.getByDate("04282014"), hasItems(order1));
		assertThat(impl.getByDate("04292014"), hasItems(order2));

	}

	@Test
	public void testRemove() {
		InvoicesInterface impl = new InvoicesImpl();

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

		assertThat(impl.getByDate("04282014"), hasItems(order1, order2));

		impl.remove("04282014", order1);

		assertEquals(1, impl.getByDate("04282014").size());
		assertFalse(impl.getByDate("04282014").contains(order1));
		assertThat(impl.getByDate("04282014"), hasItems(order2));

	}

	@Test
	public void testLoadGetProducts() throws FileNotFoundException {
		InvoicesInterface impl = new InvoicesImpl();

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
	public void testLoadGetTaxes() throws FileNotFoundException {
		InvoicesInterface impl = new InvoicesImpl();

		impl.loadTaxes("Taxes.txt");

		assertEquals(6.25, impl.getTax("OH"), 0);
		assertEquals(6.75, impl.getTax("PA"), 0);
		assertEquals(5.75, impl.getTax("MI"), 0);
		assertEquals(6, impl.getTax("IN"), 0);
	}

	@Test
	public void testGetTaxKeys() throws FileNotFoundException {
		InvoicesInterface impl = new InvoicesImpl();
		impl.loadTaxes("Taxes.txt");

		Set<String> keys = impl.getTaxKeys();

		assertTrue(keys.contains("OH"));
		assertTrue(keys.contains("PA"));
		assertTrue(keys.contains("MI"));
		assertTrue(keys.contains("IN"));
		assertEquals(4, keys.size());
	}

	@Test
	public void testLoadWriteConfig() throws Exception {
		InvoicesInterface impl = new InvoicesImpl();
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

}
