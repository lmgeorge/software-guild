/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import simplecalculator.SimpleCalcEngine;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SimpleCalcTest {

  public SimpleCalcTest() {
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
  public void simpleCalcTest() {
    SimpleCalcEngine calc = new SimpleCalcEngine();
    double c;

    c = calc.add(3, 4);
    assertEquals(7, c, 0);

    c = calc.subtract(-9, 15);
    assertEquals(-24, c, 0);

    c = calc.multiply(5, 4);
    assertEquals(20, c, 0);

    c = calc.divide(5, 1);
    assertEquals(5, c, 0);

  }
}
