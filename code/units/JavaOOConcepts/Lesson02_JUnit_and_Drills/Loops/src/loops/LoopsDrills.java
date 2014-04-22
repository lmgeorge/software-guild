/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class LoopsDrills {

  //1
  public String stringTimes(String str, int n) {
    String word = "";
    for (int i = 0; i < n; i++) {
      word += str;
    }
    return word;
  }

  //2
  public String frontTimes(String str, int n) {
    String word = "";
    for (int i = 0; i < n; i++) {
      word += str.substring(0, 3);
    }
    return word;
  }

  //3
  public int countXX(String str) {
    String word = str.replaceAll("[^x]", "");

    return word.length() - 1;
  }

  //4
  public boolean doubleX(String str) {
    int first = str.indexOf("x");

    return str.charAt(first) == str.charAt(first + 1);
  }

  //5
  public String everyOther(String str) {
    String[] lets = str.split("");
    String word = "";
    for (int i = 0; i < lets.length; i += 2) {
      word += lets[i];
    }

    return word;
  }

  public String stringSplosion(String str) {
    String word = "";

    for (int i = 0; i < str.length(); i++) {
      word += str.substring(0, i + 1);
    }

    return word;
  }

  public int countLast2(String str) {
    String first = str.substring(0, str.length() - 2);
    String end = str.substring(str.length() - 2, str.length());
    int i = 0;
    while (first.contains(end)) {
      i++;
      first = first.replaceFirst(end, "");
    }
    return i;
  }
  
  public int count9(int[] numbers){
    int nines = 0;
    for (int num = 0; num < numbers.length; num++){
      if (numbers[num] == 9) { nines++; }
    }
    return nines;
  }
  
public boolean arrayFront9(int[] numbers) {
  int nines = 0;
  for (int i = 0; i < 4; i++){
    if (numbers[i] == 9){
      nines++;
    }
  }
  
  return nines > 0;
}
  
}
