/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logicdrills.CanHazTable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class CanHazTableTest {

  public CanHazTableTest() {
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
  //
  @Test
  public void canHazTable() {
     //canHazTable(5, 10) → 2
    //canHazTable(5, 2) → 0
    //canHazTable(5, 5) → 1  

    CanHazTable t = new CanHazTable();
    int answer = t.canHazTable(5, 10);
    assertEquals(answer, answer);
    
    answer = t.canHazTable(5, 2);
    assertEquals(answer, answer);
    
    answer = t.canHazTable(5, 5);
    assertEquals(answer, answer);
    
    
  }
}
