/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalculator;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ConsoleIO {

  Scanner ui = new Scanner(System.in);
  private double dbl;
  private float flt;
  private String str;
  private int min;
  private int max;
  private double dMin;
  private double dMax;
  private float fMin;
  private float fMax;
  private int x;


  public String gets(String line) {
    println(line);
    str = ui.nextLine();
    return str;
  }

  public int getNum(String str) {
    println(str);
    x = Integer.parseInt(ui.nextLine());
    return x;
  }

  public int getNum() {
    x = setNum(Integer.parseInt(ui.nextLine()));
    return x;
  }
  public float getFlt() {
    flt = setNum(Float.parseFloat(ui.nextLine()));
    return flt;
  }
  public float getFlt(String str) {
    print(str);
    flt = setNum(Float.parseFloat(ui.nextLine()));
    return flt;
  }
  public double getDbl() {
    dbl = setNum(Double.parseDouble(ui.nextLine()));
    return dbl;
  }
  public double getDbl(String str) {
    print(str);
    dbl = setNum(Double.parseDouble(ui.nextLine()));
    return dbl;
  }

  public int getValidNum(String str) {
    println(str);

    print("Min: ");
    min = getNum();
    
    print("Max: ");
    max = getNum();
    
    print("Your number: ");
    x = getNum();
    
    setValidNum(x, min, max);

    return x;
  }
  public float getValidFlt(String str) {
    println(str);

    print("Min: ");
    fMin = getFlt();
    
    print("Max: ");
    fMax = getFlt();
    
    print("Your number: ");
    flt = getFlt();
    
    setValidNum(flt, min, max);

    return flt;
  }
  public double getValidDbl(String str) {
    println(str);

    print("Min: ");
    dMin = getDbl();
    
    print("Max: ");
    dMax = getDbl();
    
    print("Your number: ");
    dbl = getDbl();
    
    setValidNum(dbl, min, max);

    return dbl;
  }

  //printing methods
  public void println(String str) {
    this.str = str;
    System.out.println(str);
  }

  public void println(int x) {
    this.x = x;
    System.out.println(x);
  }

  public void println() {
    System.out.println();
  }

  public void print(String str) {
    this.str = str;
    System.out.print(str);
  }

  public void print(int x) {
    this.x = x;
    System.out.print(x);
  }

  //Setters
  public String setStr(String str) {
    this.str = str;
    return str;
  }

  public int setNum(int x) {
    this.x = x;
    return x;
  }
  public float setNum(float flt) {
    this.flt = flt;
    return flt;
  }
  public double setNum(double dbl) {
    this.dbl = dbl;
    return dbl;
  }

  public int setValidNum(int x, int min, int max) {
    this.min = min;
    this.max = max;
    this.x = x;
    
    while (x > max || x < min) {
      println("Please enter a number within " + min + " and " + max + ".");
      print("> ");
      x = getNum();
    }
    return x;
  }
  public float setValidNum(float x, float min, float max) {
    this.fMin = min;
    this.fMax = max;
    this.flt  = x;
    
    while (x > max || x < min) {
      println("Please enter a number within " + min + " and " + max + ".");
      print("> ");
      x = getFlt();
    }
    return x;
  }
  public double setValidNum(double x, double min, double max) {
    this.dMin = min;
    this.dMax = max;
    this.dbl = x;
    
    while (x > max || x < min) {
      println("Please enter a number within " + min + " and " + max + ".");
      print("> ");
      x = getDbl();
    }
    return x;
  }
}
