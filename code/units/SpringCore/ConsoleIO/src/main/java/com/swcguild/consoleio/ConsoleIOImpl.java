/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.consoleio;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ConsoleIOImpl implements ConsoleIO {

  private final Scanner ui = new Scanner(System.in);
  private String str;

  /**
   * Equivalent to Scanner.nextLine()
   *
   * @return the user's input as a string
   */
  public String gets() {
    str = ui.nextLine();
    return str;
  }


  /**
   * Equivalent to Scanner.nextLine()
   *
   * @param prompt prints the prompt to the user = System.out.print();
   * @return the user's input as a string
   */
  public String gets(String prompt) {
    print(prompt);
    str = gets();
    return str;
  }


  //integer methods

  /**
   * Equivalent to Scanner.nextLine() parsed using Integer.parseInt();
   *
   * Includes a prompt for to enter a number within a certain range print to the console
   *
   * @param prompt
   * @param min inclusive
   * @param max inclusive
   * @return a parsed integer if in range, inclusive, includes try-catch
   */
  public int getsNum(String prompt, int min, int max) {
    int x = max + 1;
    boolean badInput;

    do {
      badInput = false;
      print(prompt);
      str = gets();
      try {
        x = (Integer.parseInt(str));
      } catch (NumberFormatException ex) {
        badInput = true;
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput || x > max || x < min);
    return x;
  }

  /**
   * Equivalent to Scanner.nextLine() parsed using Integer.parseInt()
   *
   * @param prompt prints the prompt to the user = System.out.print();
   * @return a parsed integer, includes try-catch
   */
  public int getsNum(String prompt) {
    int x = 0;
    print(prompt);
    boolean badInput = true;
    do {
      try {
        str = gets();
        x = (Integer.parseInt(str));
        badInput = false;
      } catch (NumberFormatException ex) {
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput);
    return x;
  }

  /**
   * Equivalent to Scanner.nextLine() parsed using Integer.parseInt()
   *
   * @return a parsed integer, includes try-catch
   */
  public int getsNum() {
    int x = 0;
    boolean badInput = true;
    do {
      try {
        str = gets();
        x = (Integer.parseInt(str));
        badInput = false;
      } catch (NumberFormatException ex) {
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput);
    return x;
  }

  //Float methods
  /**
   * Equivalent to Scanner.nextLine() parsed using Float.parseFloat();
   *
   * Includes a prompt for to enter a number within a certain range print to the console
   *
   * @param prompt System.out.print(prompt) to user
   * @param min inclusive
   * @param max inclusive
   * @return a parsed float if in range, inclusive, includes try-catch
   */
  public float getsNum(String prompt, float min, float max) {
    float x = max + 1;
    boolean badInput;
    do {
      badInput = false;
      print(prompt);
      str = gets();
      try {
        x = (Float.parseFloat(str));
      } catch (NumberFormatException ex) {
        badInput = true;
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput || x > max || x < min);

    return x;
  }

  /**
   * Equivalent to Scanner.nextLine() parsed using Float.parseFloat()
   *
   * @param prompt prints the prompt to the user = System.out.print();
   * @return a parsed float, includes try-catch
   */
  public float getsFloat(String prompt) {
    float x = 0;
    print(prompt);
    boolean badInput = true;
    do {
      try {
        str = gets();
        x = (Float.parseFloat(str));
        badInput = false;
      } catch (NumberFormatException ex) {
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput);
    return x;
  }

  /**
   * Equivalent to Scanner.nextLine() parsed using Float.parseFloat()
   *
   * @return a parsed float, includes try-catch
   */
  public float getsFloat() {
    float x = 0;
    boolean badInput = true;
    do {
      try {
        str = gets();
        x = (Float.parseFloat(str));
        badInput = false;
      } catch (NumberFormatException ex) {
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput);
    return x;
  }

  //Double methods
  /**
   * Equivalent to Scanner.nextLine() parsed using Double.parseDouble();
   *
   * Includes a prompt for to enter a number within a certain range print to the console
   *
   * @param prompt
   * @param min inclusive
   * @param max inclusive
   * @return a parsed double if in range, inclusive, includes try-catch
   */
  public double getsNum(String prompt, double min, double max) {
    double x = max + 1;

    boolean badInput;
    do {
      badInput = false;
      print(prompt);
      str = gets();
      try {
        x = (Double.parseDouble(str));
      } catch (NumberFormatException ex) {
        badInput = true;
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput || x > max || x < min);

    return x;
  }

  /**
   * Equivalent to Scanner.nextLine() parsed using Double.parseDouble();
   *
   * @param prompt prints the prompt to the user = System.out.print();
   * @return a parsed double, includes try-catch
   */
  public double getsDouble(String prompt) {
    double x = 0;
    print(prompt);
    boolean badInput = true;
    do {
      try {
        str = gets();
        x = (Double.parseDouble(str));
        badInput = false;
      } catch (NumberFormatException ex) {
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput);
    return x;
  }

  /**
   * Equivalent to Scanner.nextLine() parsed using Double.parseDouble()
   *
   * @return a parsed double, includes try-catch
   */
  public double getsDouble() {
    double x = 0;
    boolean badInput = true;
    do {
      try {
        str = gets();
        x = (Double.parseDouble(str));
        badInput = false;
      } catch (NumberFormatException ex) {
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput);
    return x;
  }

    //Long methods
  /**
   * Equivalent to Scanner.nextLine() parsed using Long.parseLong();
   *
   * Includes a prompt for to enter a number within a certain range print to the console
   *
   * @param prompt A message to print to the user;
   * @param min inclusive
   * @param max inclusive
   * @return a parsed long if in range, inclusive, includes try-catch
   */
  public long getsNum(String prompt, long min, long max) {
    long x = max + 1;

    boolean badInput;
    do {
      badInput = false;
      print(prompt);
      str = gets();
      try {
        x = (Long.parseLong(str));
      } catch (NumberFormatException ex) {
        badInput = true;
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput || x > max || x < min);

    return x;
  }

  /**
   * Equivalent to Scanner.nextLine() parsed using Long.parseLong();
   *
   * @param prompt prints the prompt to the user = System.out.print();
   * @return a parsed long, includes try-catch
   */
  public long getsLong(String prompt) {
    long x = 0;
    print(prompt);
    boolean badInput = true;
    do {
      try {
        str = gets();
        x = (Long.parseLong(str));
        badInput = false;
      } catch (NumberFormatException ex) {
        println("ERROR: " + ex.getMessage() + "\n");
      }
    } while (badInput);
    return x;
  }
  
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

  /**
   * Takes an array list of strings and returns ONE string with a delimiter between each entry The delimiter is prepended to each entry
   *
   * @param aryL the array list to be converted to a string
   * @param delimiter is added BEFORE each entry in the array list
   * @param showIndex if true, prints the index + 1 in front of entry;
   * @return a string with the specified delimiter between each entry
   */
  public String toString(ArrayList<String> aryL, String delimiter, boolean showIndex) {
    String word = "";
    if (showIndex) {
      for (int i = 0; i < aryL.size(); i++) {
        word += delimiter + (1 + i) + ". " + aryL.get(i);
      }
    } else {
      word = aryL.stream()
        .map((aryL1) -> delimiter + aryL1)
        .reduce(word,
        String::concat);
    }
    return word;
  }

  /**
   * Takes an array of strings and returns ONE string with a delimiter between each entry The delimiter is prepended to each entry
   *
   * @param ary the array list to be converted to a string
   * @param delimiter is added BEFORE each entry in the array
   * @return a string with the specified delimiter between each entry
   */
  public String toString(String[] ary, String delimiter) {
    String word = "";
    for (String ary1 : ary) {
      word += delimiter + ary1;
    }
    return word;
  }

  /**
   * Takes an arraylist of integers and returns ONE string with a delimiter between each entry; The delimiter is prepended to each entry
   *
   * @param ary the array list to be converted to a string
   * @param delimiter is added BEFORE each entry in the arraylist
   * @return a string with the specified delimiter between each entry
   */
  public String intsToString(ArrayList<Integer> ary, String delimiter) {
    String word = "";
    for (Integer ary1 : ary) {
      word = word + ary1 + delimiter;
    }
    return word;
  }

  /**
   * Takes an array of integers and returns ONE string with a delimiter between each entry; The delimiter is prepended to each entry
   *
   * @param ary the array list to be converted to a string
   * @param delimiter is added BEFORE each entry in the array
   * @return a string with the specified delimiter between each entry
   */
  public String intsToString(Integer[] ary, String delimiter) {
    String word = "";
    for (Integer ary1 : ary) {
      word = word + ary1 + delimiter;
    }
    return word;
  }

}
