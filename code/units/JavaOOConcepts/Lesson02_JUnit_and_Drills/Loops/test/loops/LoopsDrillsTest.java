/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

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
public class LoopsDrillsTest {

  LoopsDrills l = new LoopsDrills();

  public LoopsDrillsTest() {
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
  public void testStringTimes() {
    assertEquals("HiHi", l.stringTimes("Hi", 2));
    assertEquals("HiHiHi", l.stringTimes("Hi", 3));
    assertEquals("Hi", l.stringTimes("Hi", 1));

  }

  @Test
  public void testFrontTimes() {
    assertEquals("AbcAbcAbc", l.frontTimes("Abc", 3));
    assertEquals("ChoChoCho", l.frontTimes("Chocolate", 3));
    assertEquals("ChoCho", l.frontTimes("Chocolate", 2));
    
  }

  @Test
  public void testCountXX() {
    assertEquals(1, l.countXX("abcxx"));
    assertEquals(2, l.countXX("xxx"));
    assertEquals(3, l.countXX("xxxx"));
  }

  @Test
  public void testDoubleX() {
    assertTrue(l.doubleX("axxbb"));
    assertFalse(l.doubleX("axaxxax"));
    assertTrue(l.doubleX("xxxx"));
  }

  @Test
  public void testEveryOther() {
    assertEquals("Hlo", l.everyOther("Hello"));
    assertEquals("H", l.everyOther("Hi"));
    assertEquals("Hello", l.everyOther("Heeololeo"));
  }

  @Test
  public void testStringSplosion() {
    assertEquals("CCoCodCode", l.stringSplosion("Code") );
    assertEquals("aababc", l.stringSplosion("abc") );
    assertEquals("aab", l.stringSplosion("ab") );
    
  }

  @Test
  public void testCountLast2() {
    assertEquals(1, l.countLast2("hixxhi") );
    assertEquals(1, l.countLast2("xaxxaxaxx") );
    //assertEquals(2, l.countLast2("axxxaaxx") );
  }

  @Test
  public void testCount9() {
    int[] i = {1,2,9};
    assertEquals(1, l.count9(i));
    
    int[] j = {1,9,9};
    assertEquals(2, l.count9(j));
    
    int[] k = {1, 9, 9, 3, 9};
    assertEquals(3, l.count9(k));
    
    
    
  }
  @Test
  public void testArrayFront9() {
    int[] i = {1,2,9,3,4};
    assertTrue(l.arrayFront9(i));
    
    int[] j = {1,2,3,4,9};
    assertFalse(l.arrayFront9(j));
    
    int[] k = {1,2,5,3,4};
    assertFalse(l.arrayFront9(k));
    

    
    
    
  }
}
