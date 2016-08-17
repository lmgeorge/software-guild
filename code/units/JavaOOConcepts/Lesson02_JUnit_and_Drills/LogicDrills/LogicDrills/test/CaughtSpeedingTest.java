/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static junit.framework.Assert.assertEquals;
import logicdrills.CaughtSpeeding;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class CaughtSpeedingTest {

  public CaughtSpeedingTest() {
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
  public void caughtSpeedingTEst() {
    CaughtSpeeding cs = new CaughtSpeeding();
    
    
    int ticket;
    
    ticket = cs.caughtSpeeding(60, false);
    assertEquals(0, ticket);
    ticket = cs.caughtSpeeding(65, false);
    assertEquals(1, ticket);
    ticket = cs.caughtSpeeding(65, true);
    assertEquals(0, ticket);
    ticket = cs.caughtSpeeding(85, true);
    assertEquals(0, ticket);
    ticket = cs.caughtSpeeding(81, false);
    assertEquals(2, ticket);
    ticket = cs.caughtSpeeding(86, true);
    assertEquals(0, ticket);

  }
}
