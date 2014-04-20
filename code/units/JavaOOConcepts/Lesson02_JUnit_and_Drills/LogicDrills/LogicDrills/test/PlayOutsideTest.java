/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import logicdrills.PlayOutside;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class PlayOutsideTest {

  public PlayOutsideTest() {
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
  public void playOutside() {
//   playOutside(70, false) → true
//   playOutside(95, false) → false
//   playOutside(95, true) → true

    PlayOutside p = new PlayOutside();

    boolean answer = p.playOutside(70, false);
    assertTrue(answer);

    answer = p.playOutside(95, false);
    assertFalse(answer);

    answer = p.playOutside(95, true);
    assertTrue(answer);

  }
}
