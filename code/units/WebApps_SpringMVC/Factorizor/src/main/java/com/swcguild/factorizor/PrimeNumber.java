/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.factorizor;

import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class PrimeNumber {
	private int value;
	private List<Integer> factors;
	private boolean perfect;
	private boolean prime;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public List<Integer> getFactors() {
		return factors;
	}

	public void setFactors(List<Integer> factors) {
		this.factors = factors;
	}

	public boolean isPerfect() {
		return perfect;
	}

	public void setIsPerfect(boolean isPerfect) {
		this.perfect = isPerfect;
	}

	public boolean isPrime() {
		return prime;
	}

	public void setIsPrime(boolean isPrime) {
		this.prime = isPrime;
	}
	
	
}
