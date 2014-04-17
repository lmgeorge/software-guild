/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guessinggame;

import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ConsoleIO1 {

  private Scanner ui = new Scanner(System.in);
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
    println(line);
    str = get();
    return str;
  }

  public String setStr(String str) {
    this.str = str;
    return str;
  }

  //
  //integer methods
  public int getsNum(String str) {
    println(str);
    x = Integer.parseInt(ui.nextLine());
    return x;
  }
  public int getNum(String str) {
    print(str);
    x = Integer.parseInt(ui.next());
    return x;
  }

  public int getsNum() {
    x = setNum(Integer.parseInt(ui.nextLine()));
    return x;
  }
  public int getNum() {
    try{
    x = setNum(Integer.parseInt(ui.next()));
    }catch (NumberFormatException nfe){
      println("ERROR: " + nfe.getMessage());
    }
    return x;
  }

  public int setNum(int x) {
    this.x = x;
    return x;
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

  //
  //float methods
  public float getFlt() {
    flt = setNum(Float.parseFloat(gets()));
    return flt;
  }

  public float getFlt(String str) {
    print(str);
    flt = setNum(Float.parseFloat(gets()));
    return flt;
  }

  public float setNum(float flt) {
    this.flt = flt;
    return flt;
  }

  public float setValidNum(float x, float min, float max) {
    this.fMin = min;
    this.fMax = max;
    this.flt = x;

    while (x > max || x < min) {
      println("Please enter a number within " + min + " and " + max + ".");
      print("> ");
      x = getFlt();
    }
    return x;
  }
  /*
   Double methods
  
   */

  public double getDbl() {
    dbl = setNum(Double.parseDouble(gets()));
    return dbl;
  }

  public double getDbl(String str) {
    print(str);
    dbl = setNum(Double.parseDouble(gets()));
    return dbl;
  }

  public double setNum(double dbl) {
    this.dbl = dbl;
    return dbl;
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
