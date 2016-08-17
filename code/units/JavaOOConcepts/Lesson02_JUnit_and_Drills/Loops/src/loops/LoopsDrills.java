/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loops;

import java.util.ArrayList;
import java.util.Collection;
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

  //6
  public String stringSplosion(String str) {
    String word = "";

    for (int i = 0; i < str.length(); i++) {
      word += str.substring(0, i + 1);
    }

    return word;
  }

  //7
  public int countLast2(String str) {
    String first = str.substring(0, str.length() - 2);
    String end = str.substring(str.length() - 2, str.length());
    int i = 0;
    while (first.contains(end)) {
      i++;
      if (end.charAt(0) == end.charAt(1) && first.contains(end.substring(1) + end)) {
        i++;
      }
      first = first.replaceFirst(end, "");
    }

    return i;
  }

  //8  
  public int count9(int[] numbers) {
    int nines = 0;
    for (int num = 0; num < numbers.length; num++) {
      if (numbers[num] == 9) {
        nines++;
      }
    }
    return nines;
  }

  //9
  public boolean arrayFront9(int[] numbers) {
    int nines = 0;
    for (int i = 0; i < 4; i++) {
      if (numbers[i] == 9) {
        nines++;
      }
    }

    return nines > 0;
  }

  //10
  public boolean Array123(int[] numbers) {
    List<Integer> list = new ArrayList<>();

    for (int i = 0; i < numbers.length; i++) {
      list.add(numbers[i]);
    }

    Collection<Integer> c = new ArrayList<>();
    c.add(1);
    c.add(2);
    c.add(3);

    return list.containsAll(c);

  }

  //11
  public int subStringMatch(String a, String b) {
    int length = a.length() <= b.length() ? a.length() : b.length();
    int c = 0;

    for (int i = 0; i < (length - 1); i++) {

      String aSub = a.substring(i, i + 2);
      String bSub = b.substring(i, i + 2);

      if (aSub.equals(bSub)) {
        c++;

      }
    }
    return c;
  }

  //12
  public String stringX(String str) {
    int sub = str.length() - 1;
    String word = str.substring(1, sub);

    return (str.charAt(0)
      + word.replaceAll("x", "")
      + str.charAt(sub));

  }

  //13
  public String altPairs(String str) {
    String word = "";
    for (int i = 0; i <= (str.length() - 2); i += 4) {
      word += str.substring(i, i + 2);
      if ((i * 2) > (str.length() - 2) && (str.length() % 2 != 0)) {
        word += str.substring(i * 2);
      }
    }
    return word;
  }

  //14
  public String doNotYak(String str) {
    return str.replaceAll("yak", "");
  }

  //15
  public int array667(int[] numbers) {
    int c = 0;
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] == 6 && (numbers[i] == numbers[i + 1] || numbers[i + 1] == 7)) {
        c++;
      }
    }
    return c;
  }

  //16
  public boolean noTriples(int[] numbers) {
    boolean triple = true;
    for(int i = 0; i < numbers.length - 2; i ++){
      if (numbers[i] == numbers[i+1] && numbers[i] == numbers[i+2]){
        triple = false;
      }
    }
    return triple;
  }
  
  //17
  public boolean pattern51(int[] nums){
    boolean bool = false;
    
    for (int i = 0; i < nums.length-2; i++){
      if (nums[i+1] == (nums[i] + 5) && nums[i+2] == (nums[i] - 1)){
        bool = true;
      }
    }
    
    return bool;
  }
}
