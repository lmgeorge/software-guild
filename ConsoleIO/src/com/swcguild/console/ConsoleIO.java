/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.console;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface ConsoleIO {
  // get a string 
  public String gets(String prompt);
  

  // get number
  public int getsNum(String prompt, int min, int max);

  public float getsNum(String prompt, float min, float max);

  public double getsNum(String prompt, double min, double max);

  public long getsNum(String prompt, long min, long max);
  
  
  //get & parse a number
  public float getsFloat(String prompt);

  public int getsNum(String prompt);

  public double getsDouble(String prompt);

  public long getsLong(String prompt);
  

//print methods
  public void println(String msg);

  public void println();

  public void print(String msg);

  public void println(int x);

  public void println(float x);

  public void println(double x);

  public void println(boolean x);

  public void print(int x);

  public void print(float x);

  public void print(double x);

  public void print(boolean x);
}
