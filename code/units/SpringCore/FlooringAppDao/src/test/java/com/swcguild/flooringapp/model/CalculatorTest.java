/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringapp.model;

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
public class CalculatorTest {

	private Calculator calc = new Calculator();

	public CalculatorTest() {
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
		calc = new Calculator();
	}

	@Test
	public void testCalcMaterialCost() {

		assertEquals(2387.35, calc.calcMaterialCost(95, 25.13), 0);
		assertEquals(374.5, calc.calcMaterialCost(35, 10.7), 0);
	}

	@Test
	public void testCalcLaborCost() {
		assertEquals(10, calc.calcLaborCost(2, 5), 0);
		assertEquals(919.368, calc.calcLaborCost(13.56, 67.8), 0);

	}

	@Test
	public void testCalcTotalTax() {
		calc.setMaterialCost(5);
		calc.setLaborCost(3);
		assertEquals(8 * (1.5/100), calc.calcTotalTax(1.5), 0);

		calc.setMaterialCost(9);
		calc.setLaborCost(60);
		assertEquals(69 * (3.25 / 100), calc.calcTotalTax(3.25), 0);
	}

	@Test
	public void testCalcTotalCost() {
		calc.setMaterialCost(9);
		calc.setLaborCost(60);
		calc.calcTotalTax(2.13);
		double totalTax = calc.getTotalTax();
		assertEquals((60 + 9 + totalTax), calc.calcTotalCost(), 0);

		calc.setMaterialCost(50.75);
		calc.setLaborCost(100.60);
		calc.calcTotalTax(4.5);
		double totalTax2 = calc.getTotalTax();
		assertEquals((50.75 + 100.60 + totalTax2), calc.calcTotalCost(), 0);
	}


}
