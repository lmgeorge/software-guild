/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructuresandalgorithms.stack;

import java.util.Iterator;
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
public class StackTest {

	private Stack st = new ArrayStack();
	private String a;
	private String b;
	private String c;
	private String d;

	public StackTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		st = new ArrayStack();

		a = "a";
		b = "b";
		c = "c";
		d = "d";

	}

	@After
	public void tearDown() {
	}

	@org.junit.Test
	public void testSize_Push_Pop() {
		st.push(a);
		st.push(b);
		st.push(c);
		st.push(d);
		
		assertEquals(4, st.size());
		assertTrue(d.equals((String)st.pop()));
		assertTrue(c.equals((String)st.pop()));
		assertTrue(b.equals((String)st.pop()));
		assertTrue(a.equals((String)st.pop()));
		assertNull(st.pop());
		
	}



}
