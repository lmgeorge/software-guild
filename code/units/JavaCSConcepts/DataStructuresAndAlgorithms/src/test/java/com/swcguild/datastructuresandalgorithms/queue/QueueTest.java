/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructuresandalgorithms.queue;

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
public class QueueTest {

	private Queue q = new ArrayQueue();
	private String a;
	private String b;
	private String c;
	private String d;

	public QueueTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
		q = new ArrayQueue();

		a = "a";
		b = "b";
		c = "c";
		d = "d";
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testAdd_Remove() {
		q.add(a);
		q.add(b);
		q.add(c);
		q.add(d);

		assertEquals(4, q.size());
		assertTrue(a.equals((String) q.remove()));
		assertTrue(b.equals((String) q.remove()));
		assertTrue(c.equals((String) q.remove()));
		assertTrue(d.equals((String) q.remove()));
		assertNull(q.remove());

		q.add(a);
		q.add(b);
		q.add(c);
		assertEquals(3, q.size());
		assertTrue(a.equals((String) q.remove()));
		assertTrue(b.equals((String) q.remove()));
		assertTrue(c.equals((String) q.remove()));
	}


}
