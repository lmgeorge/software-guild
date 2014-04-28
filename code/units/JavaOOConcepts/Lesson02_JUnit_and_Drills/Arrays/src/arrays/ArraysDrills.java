/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ArraysDrills {

  //1
  public boolean firstLast6(int[] numbers) {
    return numbers[0] == 6 || numbers[numbers.length - 1] == 6;
  }

  //2
  public boolean sameFirstLast(int[] numbers) {
    return numbers.length >= 1 && (numbers[0] == numbers[numbers.length - 1]);
  }

  //3
  public int[] makePi(int n) {
    int[] pi = new int[n];
    String word = "";
    word += Math.PI;
    word = word.replaceAll("\\.", "");

    for (int i = 0; i <= pi.length - 1; i++) {
      pi[i] = Integer.parseInt(word.substring(i, i + 1));
    }

    return pi;
  }

  //4
  public boolean commonEnd(int[] a, int[] b) {
    return a[0] == b[0] || a[a.length - 1] == b[b.length - 1];
  }

  //5
  public int sum(int[] numbers) {
    int sum = 0;

    for (int num : numbers) {
      sum += num;
    }
    return sum;
  }

  //6
  public int[] rotateLeft(int[] numbers) {
    int length = numbers.length;
    int[] rotated = new int[length];
    for (int i = 0; i < numbers.length - 1; i++) {
      rotated[i] = numbers[i + 1];
    }
    rotated[length - 1] = numbers[0];

    return rotated;
  }

  //7
  public int[] reverse(int[] numbers) {
    int[] reverse = new int[numbers.length];
    int j = 0;
    for (int i = numbers.length - 1; i > -1; i--) {
      reverse[j] = numbers[i];
      j++;
    }
    return reverse;
  }

  //8
  public int[] higherWins(int[] numbers) {
    int max = numbers[0];
    int[] high = numbers;

    for (int i = 0; i < numbers.length; i++) {
      if (max < numbers[i]) {
        max = numbers[i];
      }
    }

    for (int i = 0; i < numbers.length; i++) {
      high[i] = max;
    }

    return high;
  }

  //9
  public int[] getMiddle(int[] a, int[] b) {
    int[] middle = {a[1], b[1]};
    return middle;
  }

  //10
  public boolean hasEven(int[] numbers) {
    int counter = 0;
    for (int num : numbers) {
      if (num % 2 == 0) {
        counter++;
      }
    }
    return counter > 0;
  }

  //11
  public int[] keepLast(int[] numbers) {
    int[] keep = new int[numbers.length * 2];
    keep[keep.length - 1] = numbers[numbers.length - 1];
    return keep;
  }

  //12
  public boolean double23(int[] numbers) {
    int twos = 0;
    int threes = 0;

    for (int num : numbers) {
      if (num == 2) {
        twos++;
      } else if (num == 3) {
        threes++;
      }
    }
    return twos == 2 || threes == 2;
  }

  //13
  public int[] fix23(int[] numbers) {
    int[] fixed = numbers;
    
    for(int i = 0; i< numbers.length; i++){
      if(numbers[i] == 2 && numbers[i+1]){
        
      }
    }
    
  }
}
