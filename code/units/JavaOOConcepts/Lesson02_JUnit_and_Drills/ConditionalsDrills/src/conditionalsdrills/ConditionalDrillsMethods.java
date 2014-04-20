/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conditionalsdrills;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ConditionalDrillsMethods {

  ConsoleIO9 cio = new ConsoleIO9();

// Drill 1: Mischievous Children  
  public boolean areWeInTrouble(boolean aSmile, boolean bSmile) {
    return aSmile == bSmile;
  }
//Drill 2:  Sleeping In 

  public boolean sleepIn(boolean isWeekday, boolean isVacation) {
    return isVacation || !isWeekday;
  }

  // Drill 3: SumDouble
  public int sumDouble(int a, int b) {
    int sum = a + b;
    if (a == b) {
      sum *= 2;
    }

    return sum;
  }

  //Drill 4: Diff21
  public int diff21(int n) {
    int diff = Math.abs(n - 21);

    if (n > 21) {
      diff *= 2;
    }

    return diff;
  }

  //Drill 5: Parrot Trouble
  public boolean parrotTrouble(boolean isTalking, int hour) {
    return isTalking && (hour > 20 || hour < 7);
  }

  //Drill 6: Makes10
  public boolean makes10(int a, int b) {
    return a == 10 || b == 10 || a + b == 10;
  }

  //Drill 7: NearHundred
  public boolean nearHundred(int n) {
    return Math.abs(100 - n) < 11 || Math.abs(200 - n) < 11;
  }
//Drill 8: PosNeg

  public boolean posNeg(int a, int b, boolean negative) {
    return a < 0 && b < 0 && negative || a < 0 && b > 0 || a > 0 && b < 0;
  }

  //Drill 9: NotString
  public String notString(String s) {
    String str = s;
    if (!s.contains("not")) {
      str = "not " + s;
    }
    return str;
  }

  //Drill 10: MissingCar
  public String missingChar(String str, int n) {
    ArrayList<String> lets = new ArrayList<>();
    lets.addAll(Arrays.asList(str.split("")));
    lets.remove(n);
    String s = toString(lets, "");

    return s;
  }

  //Drill 11: FrontBack
  public String frontBack(String str) {
    String[] lets = str.split("");
    String temp;

    temp = lets[0];
    lets[0] = lets[lets.length - 1];
    lets[lets.length - 1] = temp;

    temp = toString(lets, "");
    return temp;
  }

  //Drill 12
  public String front3(String str) {
    String s = str;
    if (s.length() > 2) {
      s = (s.substring(0, 3));
    }
    s = s + s + s;
    return s;
  }

  //Drill 13
  public String backAround(String str) {
    String s;
    s = str.charAt(str.length() - 1) + str + str.charAt(str.length() - 1);
    return s;
  }

  //Drill 14
  public boolean multiple3or5(int number) {
    return number % 3 == 0 || number % 5 == 0;
  }

  //Drill 15
  public boolean startHi(String str) {

    return str.contains("hi") && str.length() < 3 || str.contains("hi ") && str.length() >= 3;
  }

  //Drill 16
  public boolean icyHot(int temp1, int temp2) {
    return temp1 > 0 && temp2 < 0 || temp1 < 0 && temp2 > 0;
  }

  //Drill 17
  public boolean between10and20(int a, int b) {
    return a >= 10 && a <= 20 || b >= 10 && b <= 20;
  }

  //Drill 19
  public boolean soAlone(int a, int b) {
    return a >= 13 && a <= 19 && !(b >= 13 && b <= 19) || !(a >= 13 && a <= 19) && b >= 13 && b <= 19;
  }

  //Drill 20
  public String removeDel(String str) {
    String s = str;

    if (str.contains("del")) {
      s = str.replaceAll("del", "");
    }
    return s;
  }
//Drill 21

  public boolean ixStart(String str) {
    String[] words = str.split(" ");

    return words[0].startsWith("ix", 1);
  }

//Drill 22
  public String startOz(String str) {
    String s;
    s = str.substring(0, 2);
    s = s.replaceAll("[a-n&&p-y]", "");

    return s;
  }

  //Drill 23
  public int max(int a, int b, int c) {
    int max = a;

    if (a >= b && a >= c) {
      max = a;
    } else if (b >= a && b >= c) {
      max = b;
    } else if (c >= a && c >= b) {
      max = c;
    }

    return max;
  }

  //Drill 24
  public int closer(int a, int b) {
    int tie;

    if (Math.abs(10 - a) < Math.abs(10 - b)) {
      tie = a;
    } else if (Math.abs(10 - a) > Math.abs(10 - b)) {
      tie = b;
    } else {
      tie = 0;
    }

    return tie;
  }

  //Drill 25
  public boolean gotE(String str) {
    String s = str.replaceAll("[^eE]", "");

    return s.length() <= 3 && s.length() >= 1;
  }

  //Drill 26
  public String endUp(String str) {

    String s;
    if (str.length() < 3) {
      s = str.toUpperCase();
    } else {
      s = str.substring(0, str.length() - 3) + str.substring(str.length() - 3).toUpperCase();
    }
    return s;
  }

  //Drill 27
  public String everyNth(String str, int n) {
    ArrayList<String> s = new ArrayList<>();
    s.addAll(Arrays.asList(str.split("")));
    String s1 = "";
    int i = 0;
    while(i <= s.size()){
      s1 += s.get(i);
      i+=n;
    }
    return s1;  
  }

  
  
  
  
  public String toString(ArrayList<String> ary, String delimiter) {
    String word = "";
    for (String ary1 : ary) {
      word = word + ary1 + delimiter;
    }
    return word;
  }

  public String toString(String[] ary, String delimiter) {
    String word = "";
    for (String ary1 : ary) {
      word = word + ary1 + delimiter;
    }
    return word;
  }
}
