/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicdrills;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class LogicDrills6Thru17 {

  ConsoleIO9 cio = new ConsoleIO9();

  //Drill 6 
  public String alarmClock(int day, boolean vacation) {
    String alarm;

    if (vacation && day == 0 || day == 6) {
      alarm = "off";
    } else if ((vacation && day > 0 && day < 6) || (day == 0 || day == 6)) {
      alarm = "10:00";
    } else {
      alarm = "7:00";
    }

    return alarm;
  }

//Drill 7
  public boolean loveSix(int a, int b) {
    int sum = a + b;
    int difference = a - b;
    return a == 6 || b == 6 || sum == 6 || difference == 6;
  }

  //Drill 8 
  public boolean inRange(int n, boolean outsideMode) {

    return (n > 0 && n < 11) || (outsideMode && (n < 1 || n > 10));

  }

  //Drill 9
  public boolean specialEleven(int n) {

    return n % 11 == 0 || n % 11 == 1;

  }

  //Drill 10
  public boolean mod20(int n) {
    return n % 20 == 1 || n % 20 == 2;
  }

  //Drill 11
  public boolean mod35(int n) {
    return (n % 3 == 0 || n % 5 == 0) && n % 15 != 0;
  }

  // Drill 12
  public boolean answerCell(boolean isMorning, boolean isMom, boolean isAsleep) {
    return !isAsleep && (isMom || !isMorning);

  }

  // Drill 13
  public boolean twoIsOne(int a, int b, int c) {
    return a + b == c || a + c == b || b + c == a;
  }

  //Drill 14
  public boolean areInOrder(int a, int b, int c, boolean bOk) {
    return c > b && (b > a || bOk);
  }

  //Drill 15
  public boolean inOrderEqual(int a, int b, int c, boolean equalOk) {
    return (a < b && b < c) || (a <= b && b <= c && equalOk);
  }

  //Drill 16
  public boolean lastDigit(int a, int b, int c) {
    return a%10 == b%10 || c%10 == b%10 || a%10 == c%10 ;
  }
  
  //Roll Dice
  public int rollDice(int die1, int die2, boolean noDoubles) {
   int sum = die2 + die1; 
   if (noDoubles && sum%2 == 0 && sum < 12){
     sum++;
    }else if (sum == 12){
     sum = die1 + 1;
   }
    
  return sum;
}
}
