/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.dao;

import com.swcguild.vendingmachine.model.Item;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class VendingMachineImplTest {

	private VendingMachineImpl vm;
	private VendingMachineImpl vm2;
	private Item item;
	private Item item2;

	public VendingMachineImplTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		vm = new VendingMachineImpl();
		vm2 = new VendingMachineImpl();

		item = new Item();
		item.setName("Banana");
		item.setCost(2.25);
		item.setQuantity(5);

		item2 = new Item();
		item2.setName("Chips");
		item2.setCost(0.55);
		item2.setQuantity(25);
	}

	@After
	public void tearDown() {
	}

	public boolean compareObject(Item item1, Item item2) {
		return item1.getName().equals(item2.getName())
			&& item1.getCost() == item2.getCost()
			&& item1.getQuantity() == item2.getQuantity();
	}

	@Test
	public void testWriteFile() throws Exception {
		vm.addItem(item);
		vm.addItem(item2);

		vm.writeFile();

		vm2.loadFile();

		assertTrue(compareObject(vm2.getItem("Banana"), item));
		assertTrue(compareObject(vm2.getItem("Chips"), item2));
	}

	@Test
	public void testGetQtyVendItem() {
		vm.addItem(item);
		vm.addItem(item2);
		
		vm.vendItem("Banana");
		vm.vendItem("Chips");
		vm.vendItem("Chips");
		vm.vendItem("Chips");
		
		assertEquals(4, vm.getItem("Banana").getQuantity());
		assertEquals(22, vm.getItem("Chips").getQuantity());
	}

	@Test
	public void testGetKeys() {
		vm.addItem(item);
		vm.addItem(item2);
		String[] keys = {item2.getName(), item.getName()};

		assertArrayEquals(keys, vm.getKeys());
	}

	@Test
	public void testGetItem() {
	}

	@Test
	public void testAddItem() {
		vm.addItem(item);

		assertTrue(compareObject(item, vm.getItem("Banana")));
	}


}
