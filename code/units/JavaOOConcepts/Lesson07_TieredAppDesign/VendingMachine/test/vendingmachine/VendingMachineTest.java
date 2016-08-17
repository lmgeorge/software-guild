/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class VendingMachineTest {

	public boolean compareObject(Item item1, Item item2) {
		return item1.getName().equals(item2.getName())
			&& item1.getCost() == item2.getCost()
			&& item1.getQuantity() == item2.getQuantity();
	}

	public VendingMachineTest() {
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
	public void testAddItem() {
		VendingMachine vm = new VendingMachine();

		Item item = new Item();
		item.setName("Banana");
		item.setCost(2.25);
		item.setQuantity(5);

		vm.addItem(item);

		assertTrue(compareObject(item, vm.getItem("Banana")));
	}

	@Test
	public void testGetKeys() {
		VendingMachine vm = new VendingMachine();

		Item item = new Item();
		item.setName("Banana");
		item.setCost(2.25);
		item.setQuantity(5);

		Item item2 = new Item();
		item2.setName("Chips");
		item2.setCost(0.55);
		item2.setQuantity(25);

		vm.addItem(item);
		vm.addItem(item2);
		String[] keys = {item2.getName(), item.getName()};

		assertArrayEquals(keys, vm.getKeys());
	}

	@Test
	public void testWriteLoadFile() throws Exception {
		VendingMachine vm = new VendingMachine();
		VendingMachine vm2 = new VendingMachine();

		Item item = new Item();
		item.setName("Banana");
		item.setCost(2.25);
		item.setQuantity(5);

		Item item2 = new Item();
		item2.setName("Chips");
		item2.setCost(0.55);
		item2.setQuantity(25);

		vm.addItem(item);
		vm.addItem(item2);

		vm.writeFile("test.txt");

		vm2.loadFile("test.txt");

		assertTrue(compareObject(vm2.getItem("Banana"), item));
		assertTrue(compareObject(vm2.getItem("Chips"), item2));
	}

	@Test
	public void testVendItem() {
		VendingMachine vm = new VendingMachine();

		Item item = new Item();
		item.setName("Banana");
		item.setCost(2.25);
		item.setQuantity(5);

		Item item2 = new Item();
		item2.setName("Chips");
		item2.setCost(0.55);
		item2.setQuantity(25);

		vm.addItem(item);
		vm.addItem(item2);
		
		vm.vendItem("Banana");
		vm.vendItem("Chips");
		vm.vendItem("Chips");
		vm.vendItem("Chips");
		
		assertEquals(4, vm.getItem("Banana").getQuantity());
		assertEquals(22, vm.getItem("Chips").getQuantity());

	}


}
