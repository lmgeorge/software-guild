/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SkipSum {
  
  public int skipSum(int a, int b){
    int sum = a + b;
    
    if(sum >= 10 && sum <= 19){
      sum = 20;
    }
    return sum;
  }
  
}
