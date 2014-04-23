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
public int getsNum(String prompt);
public int getsNum(String prompt, int min, int max);
public String gets(String prompt);
public float getsFloat(String prompt);
public float getsNum(String prompt, float min, float max);
public double getsDouble(String prompt);
public double getsNum(String prompt, double min, double max);
public long getsLong(String prompt);
public long getsNum(String prompt, long min, long max);
public void println(String msg);
public void print(String msg);
}
