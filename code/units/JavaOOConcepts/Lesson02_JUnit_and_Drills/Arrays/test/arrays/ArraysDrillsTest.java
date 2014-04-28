/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ArraysDrillsTest {

  ArraysDrills ad = new ArraysDrills();

  public ArraysDrillsTest() {
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
  public void testFirstLast6() {
    int[] i = {1, 2, 6};
    assertTrue(ad.firstLast6(i));
    int[] j = {6, 1, 2, 3};
    assertTrue(ad.firstLast6(j));
    int[] k = {13, 6, 1, 2, 3};
    assertFalse(ad.firstLast6(k));
  }

  @Test
  public void testSameFirstLast() {
    int[] i = {1, 2, 3};
    assertFalse(ad.sameFirstLast(i));

    int[] j = {1, 2, 3, 1};
    assertTrue(ad.sameFirstLast(j));

    int[] k = {1, 2, 1};
    assertTrue(ad.sameFirstLast(k));
  }

  @Test
  public void testMakePi() {
    int[] i = {3, 1, 4};
    Assert.assertArrayEquals(i, ad.makePi(3));

  }

  @Test
  public void testCommonEnd() {
    int[] a = {1, 2, 3};
    int[] b = {7, 3};

    assertTrue(ad.commonEnd(a, b));

    int[] c = {1, 2, 3};
    int[] d = {7, 3, 2};

    assertFalse(ad.commonEnd(c, d));

    int[] e = {1, 2, 3};
    int[] f = {1, 3};

    assertTrue(ad.commonEnd(e, f));

  }

  @Test
  public void testSum() {
    int[] i = {1, 2, 3};
    assertEquals(6, ad.sum(i));

    int[] j = {5, 11, 2};
    assertEquals(18, ad.sum(j));

    int[] k = {7, 0, 0};
    assertEquals(7, ad.sum(k));
  }

  @Test
  public void testRotateLeft() {
    int[] a = {1, 2, 3};
    int[] b = {2, 3, 1};

    assertArrayEquals(b, ad.rotateLeft(a));

    int[] c = {5, 11, 9};
    int[] d = {11, 9, 5};

    assertArrayEquals(d, ad.rotateLeft(c));

    int[] e = {7, 0, 0};
    int[] f = {0, 0, 7};

    assertArrayEquals(f, ad.rotateLeft(e));

  }

  @Test
  public void testReverse() {
    int[] a = {1, 2, 3};
    int[] b = {3, 2, 1};

    assertArrayEquals(b, ad.reverse(a));

    int[] c = {5, 11, 9};
    int[] d = {9, 11, 5};

    assertArrayEquals(d, ad.reverse(c));

    int[] e = {7, 0, 0};
    int[] f = {0, 0, 7};

    assertArrayEquals(f, ad.reverse(e));
  }

  @Test
  public void testHigherWins() {
    int[] a = {1, 2, 3};
    int[] b = {3, 3, 3};

    assertArrayEquals(b, ad.higherWins(a));

    int[] c = {5, 11, 9};
    int[] d = {11, 11, 11};

    assertArrayEquals(d, ad.higherWins(c));

    int[] e = {2, 11, 3};
    int[] f = {11, 11, 11};

    assertArrayEquals(f, ad.higherWins(e));
  }

  @Test
  public void testGetMiddle() {
    int[] a = {1, 2, 3};
    int[] b = {4, 5, 6};
    int[] g = {2, 5};

    assertArrayEquals(g, ad.getMiddle(a, b));

    int[] c = {3, 8, 9};
    int[] d = {11, 11, 11};
    int[] h = {8, 11};

    assertArrayEquals(h, ad.getMiddle(c, d));

    int[] e = {5, 2, 9};
    int[] f = {1, 4, 5};
    int[] i = {2, 4};

    assertArrayEquals(i, ad.getMiddle(e, f));

  }

  @Test
  public void testHasEven() {
    int[] i = {2, 3};
    assertTrue(ad.hasEven(i));

    int[] j = {4, 3};
    assertTrue(ad.hasEven(j));

    int[] k = {7, 5};
    assertFalse(ad.hasEven(k));

  }

  @Test
  public void testKeepLast() {
    int[] a = {4, 5, 6};
    int[] b = {0, 0, 0, 0, 0, 6};

    assertArrayEquals(b, ad.keepLast(a));

    int[] c = {1, 2};
    int[] d = {0, 0, 0, 2};

    assertArrayEquals(d, ad.keepLast(c));

    int[] e = {3};
    int[] f = {0, 3};

    assertArrayEquals(f, ad.keepLast(e));
  }

  @Test
  public void testDouble23() {
    int[] i = {2, 2, 3};
    assertTrue(ad.double23(i));

    int[] j = {3, 4,5, 3};
    assertTrue(ad.double23(j));

    int[] k = {2,3,2,2,};
    assertFalse(ad.double23(k));
  }

}
