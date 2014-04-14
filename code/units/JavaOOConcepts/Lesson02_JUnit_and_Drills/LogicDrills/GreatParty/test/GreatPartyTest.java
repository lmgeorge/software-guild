/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import greatparty.GreatParty;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class GreatPartyTest {

  public GreatPartyTest() {
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
  public void greatPartyTest() {
    // greatParty(30, false) → false 
    // greatParty(50, false) → true 
    // greatParty(70, true) → true
    
    GreatParty gp = new GreatParty();
    
    boolean result = gp.greatParty(30, false);
    assertFalse(result);
    
    result = gp.greatParty(50, false);
    assertTrue(result);
    
    result = gp.greatParty(70, false);
    assertTrue(result);
    
    
  }
}
