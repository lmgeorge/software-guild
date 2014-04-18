/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ConsoleIO7 {

  NumberFormatException ex = new NumberFormatException();
  private Scanner ui = new Scanner(System.in);
  private String str;
  private int min;
  private int max;
  private int x;
  private double dbl;
  private double dMin;
  private double dMax;
  private float flt;
  private float fMin;
  private float fMax;

  public boolean checkInt(String input) {
    boolean result;
    try {
      Integer.parseInt(input);
      result = true;
    } catch (NumberFormatException nfe) {
      print("Error: " + nfe.getMessage());
      result = false;
    }
    return result;
  }

  public boolean checkFloat(String input) {
    boolean result;
    try {
      Float.parseFloat(input);
      result = true;
    } catch (NumberFormatException nfe) {
      print("Error: " + nfe.getMessage());
      result = false;
    }
    return result;
  }

  public boolean checkDouble(String input) {
    boolean result;
    try {
      Double.parseDouble(input);
      result = true;
    } catch (NumberFormatException nfe) {
      print("Error: " + nfe.getMessage());
      result = false;
    }
    return result;
  }

  public String gets() {
    str = ui.nextLine();
    return str;
  }

  public String get() {
    str = ui.next();
    return str;
  }

  public String gets(String line) {
    println(line);
    str = gets();
    return str;
  }

  public String get(String line) {
    print(line);
    str = ui.nextLine();
    return str;
  }


  //
  //integer methods
  public int getsNum(String prompt) {
    println(prompt);
    str = gets();
    
    while (!checkInt(str)) {
      println("Error. Please enter a valid response");
      str = gets();
    }
    str = gets();
    x = Integer.parseInt(str);

    return x;
  }

  public boolean check(int x, String err) {

    return true;
  }

  public int getNum(String prompt) {
    print(prompt);
    do {
      str = gets();
      if (!checkInt(str)) {
        println("Error. Please enter a valid response");
      }
    } while (!checkInt(str));
    x = Integer.parseInt(str);

    return x;
  }

  public int getsNum() {
    try {
      x = (Integer.parseInt(ui.nextLine()));

    } catch (NumberFormatException nfe) {
      println("ERROR: " + nfe.getMessage());
      println();
    }
    return x;
  }

  public int getNum() {
    try {
      x = (Integer.parseInt(ui.next()));
    } catch (NumberFormatException nfe) {
      println("ERROR: " + nfe.getMessage());
    }
    return x;
  }

  public int setValidNum(int x, int min, int max, String err) {
    this.min = min;
    this.max = max;
    this.x = x;

    while (x > max || x < min) {
      println(err);
      try {
        x = getNum("> ");
      } catch (NumberFormatException nfe) {
        println("ERROR: " + nfe.getMessage());
      }
    }
    return x;
  }

  //
  //float methods
  public float getsFlt() {
    try {
      flt = Float.parseFloat(gets());
    } catch (NumberFormatException nfe) {
      println("ERROR: " + nfe.getMessage());
    }
    return flt;
  }

  public float getsFlt(String str) {
    println(str);
    flt = Float.parseFloat(gets());
    return flt;
  }
  public float getFlt() {
    try {
      flt = Float.parseFloat(get());
    } catch (NumberFormatException nfe) {
      println("ERROR: " + nfe.getMessage());
    }
    return flt;
  }

  public float getFlt(String str) {
    print(str);
    flt = Float.parseFloat(gets());
    return flt;
  }

  public float setsValidNum(float x, float min, float max) {
    this.fMin = min;
    this.fMax = max;
    this.flt = x;

    while (x > max || x < min) {
      println("Please enter a number within " + min + " and " + max + ".");
      x = getsFlt("> ");
    }
    return x;
  }
  /*
   Double methods
  
   */

  public double getsDbl() {
    dbl = Double.parseDouble(gets());
    return dbl;
  }

  public double getsDbl(String str) {
    print(str);
    dbl = Double.parseDouble(gets());
    return dbl;
  }

  public double setsValidNum(double x, double min, double max) {
    this.dMin = min;
    this.dMax = max;
    this.dbl = x;

    while (x > max || x < min) {
      println("Please enter a number within " + min + " and " + max + ".");
      print("> ");
      x = getsDbl();
    }
    return x;
  }
  //
  //printing methods

  public void println(String str) {
    System.out.println(str);
  }

  public void print(String str) {
    System.out.print(str);
  }

  public void println(int x) {
    System.out.println(x);
  }

  public void print(int x) {
    System.out.print(x);
  }

  public void println(float x) {
    System.out.println(x);
  }

  public void print(float x) {
    System.out.print(x);
  }

  public void println(double x) {
    System.out.println(x);
  }

  public void print(double x) {
    System.out.print(x);
  }

  public void println() {
    System.out.println();
  }
  public void print(boolean x) {
    System.out.print(x);
  }

  public void println(boolean x) {
    System.out.println(x);
  }

//  public int getValidNum(String str) {
//    println(str);
//
//    print("Min: ");
//    min = getNum();
//
//    print("Max: ");
//    max = getNum();
//
//    print("Your number: ");
//    x = getNum();
//
//    setValidNum(x, min, max);
//
//    return x;
//  }
}
