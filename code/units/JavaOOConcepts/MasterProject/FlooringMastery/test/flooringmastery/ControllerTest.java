/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flooringmastery;

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
public class ControllerTest {
	
	public ControllerTest() {
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
	public void testAddOrder() {
	}

	@Test
	public void testConvertDate() {
		String test = "Jan 1, 1999";
		String test2 = "03142014";
		String test3 = "cat";
		String test4 = "3142014";
		String test5 = "03322015";
		InvoicesInterface impl = new InvoicesImpl();
		
		
	}
	

}
