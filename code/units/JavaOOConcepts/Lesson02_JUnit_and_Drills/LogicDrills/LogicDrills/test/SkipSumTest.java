/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SkipSumTest {
  
  public SkipSumTest() {
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

    // TODO add test methods here.
  // The methods must be annotated with annotation @Test. For example:
  
   @Test
   public void test() {
   SkipSum ss = new SkipSum();
   
   int sum;
   
   sum = ss.skipSum(3, 4);
   assertEquals(7, sum);
   
   sum = ss.skipSum(9, 4);
   assertEquals(20, sum);
   
   sum = ss.skipSum(10, 11);
   assertEquals(21, sum);
   
   }
}
