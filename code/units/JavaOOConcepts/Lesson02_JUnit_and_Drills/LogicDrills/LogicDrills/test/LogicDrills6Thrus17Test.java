/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import logicdrills.LogicDrills6Thru17;
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
public class LogicDrills6Thrus17Test {

  private final LogicDrills6Thru17 l = new LogicDrills6Thru17();

  public LogicDrills6Thrus17Test() {
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
  public void alarmClock6() {

    String alarm;

    alarm = l.alarmClock(1, false);
    assertEquals("7:00", alarm);

    alarm = l.alarmClock(5, false);
    assertEquals("7:00", alarm);

    alarm = l.alarmClock(0, false);
    assertEquals("10:00", alarm);

  }

  @Test
  public void loveSix7(){
    boolean  isSix;
    
    isSix = l.loveSix(6, 4);
    assertTrue(isSix);
    
    isSix = l.loveSix(4, 5);
    assertFalse(isSix);
    
    isSix = l.loveSix(1, 5);
    assertTrue(isSix);
    
  }
  @Test
  public void inRange8(){
    
    assertTrue(l.inRange(5, false));
    assertFalse(l.inRange(11, false));
    assertTrue(l.inRange(11, true));
    
    
  }
  @Test
  public void specialEleven9(){
    assertTrue(l.specialEleven(22));
    assertTrue(l.specialEleven(23));
    assertFalse(l.specialEleven(24));
    
  }
  @Test
  public void mod20_10() {
    assertFalse(l.mod20(20));
    assertTrue(l.mod20(21));
    assertTrue(l.mod20(22));
  }
@Test
  public void mod35_11() {
    assertFalse(l.mod35(15));
    assertTrue(l.mod35(3));
    assertTrue(l.mod35(10));
  }
 
  @Test
  public void answerCell12(){
    assertTrue(l.answerCell(false, false, false));
    assertFalse(l.answerCell(false, false, true));
    assertFalse(l.answerCell(true, false, false));
    
    
  }
  
  @Test
  public void TwoIsOne(){
    assertTrue(l.twoIsOne(1, 2, 3));
    assertTrue(l.twoIsOne(3, 1, 2));
    assertFalse(l.twoIsOne(3, 2, 2));
    
  }
  @Test
  public void areInOrder14(){
    assertTrue(l.areInOrder(1, 2, 4, false));
    assertFalse(l.areInOrder(1, 2, 1, false));
    assertTrue(l.areInOrder(1, 1, 2, true));
  }
  @Test
  public void InOrderEqual15(){
     assertTrue(l.inOrderEqual(2, 5, 11, false));
     assertFalse(l.inOrderEqual(5, 7, 6, false));
     assertFalse(l.inOrderEqual(5, 7, 5, true));
     assertFalse(l.inOrderEqual(7, 7, 5, true));
     assertFalse(l.inOrderEqual(8, 7, 7, true));
     assertTrue(l.inOrderEqual(7, 7, 7, true));
     assertTrue(l.inOrderEqual(5, 5, 7, true));
    
  }
  @Test
  public void lastDigit16(){
    assertTrue(l.lastDigit(23, 19, 13));
    assertTrue(l.lastDigit(23, 19, 3));
    assertFalse(l.lastDigit(23, 19, 12));
    
  }
  @Test
  public void rollDice17(){
    assertEquals(5, l.rollDice(2, 3, true));
    assertEquals(7, l.rollDice(3, 3, true));
    assertEquals(6, l.rollDice(3, 3, false));
  }
}
