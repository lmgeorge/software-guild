/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;



/**
 *
 * @author apprentice
 */
public class FindingPrimeNumbers {

  public static void main(String[] args) {
    for (int i = 2; i <= 100; i++) {
      if (isPrime(i) == true) {
        System.out.println(i);
      }
    }
    
  }
  public static boolean isPrime(int i){
    boolean prime = true;
    for (int j = 2; j < i; j++){
      if (i%j == 0){
        prime = false;
      }
    }
    return prime;
  }
}
