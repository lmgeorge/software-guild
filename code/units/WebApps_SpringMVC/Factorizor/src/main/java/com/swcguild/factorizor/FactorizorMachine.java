/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.factorizor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class FactorizorMachine {

	private long sumFactors = 0, prime = 0, initial;

//  public void findPrimes() {
//
//    getUserNum();
//
//    checkPrimes();
//
//    returnPrimes();
//  }
//  public void isOne(long initial) {
//    if (initial == 1) {
//      System.out.println("One has no factors.  It's special.");
//      System.out.println();
//    } else {
//      System.out.println("The factors of " + initial + " are:");
//    }
//
//  }
	public PrimeNumber checkPrimes(int num) {
//    isOne(initial);
		PrimeNumber primeNum = new PrimeNumber();
		List<Integer> factors = new ArrayList<>();
		primeNum.setValue(num);
		initial = num;
		for (int i = 1; i < initial; i++) {
			if (initial % i == 0) {
				factors.add(i);
				sumFactors += i;
				prime++;
			}
		}
		primeNum.setFactors(factors);
		primeNum.setIsPrime(prime == 1);
		
		primeNum.setIsPerfect(sumFactors == initial);
		
		return primeNum;
	}

//  public void returnPrimes() {
//    if (sumFactors == initial) {
//      System.out.println(initial + " is a perfect number.");
//      System.out.println();
//    }
//    if (prime == 1) {
//
//      System.out.println(initial + " is a prime number.");
//      System.out.println();
//    } else {
//      System.out.println(initial + " is not a prime number.");
//      System.out.println();
//
//    }
//
//  }
//  public void getUserNum() {
//
//    do {
//      System.out.print("What number would you like to factor? ");
//      initial = sc.nextLong();
//
//      if (initial <= 0) {
//        System.out.println("Error: Enter a positive whole number.");
//        System.out.println();
//      }
//
//    } while (initial <= 0);
//  }
}
