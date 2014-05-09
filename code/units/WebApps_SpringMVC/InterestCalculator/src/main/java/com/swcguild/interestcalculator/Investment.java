/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.interestcalculator;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Investment {

	private float principal;
	private float newBalance;
	private int years;
	private float compoundRate;
	private float annualInterestRate;
	private float interestAccrued;
	private float grossInvestment;

	public float getInterestAccrued() {
		return interestAccrued;
	}

	public void setInterestAccrued(float interestAccrued) {
		this.interestAccrued = interestAccrued;
	}

	public float getGrossInvestment() {
		return grossInvestment;
	}

	public void setGrossInvestment(float grossInvestment) {
		this.grossInvestment = grossInvestment;
	}

	public void setYears(int years) {
		this.years = years;
	}

	public void setPrincipal(float principal) {
		this.principal = principal;
	}

	public void setCompoundRate(float compoundRate) {
		this.compoundRate = compoundRate;
	}

	public void setAnnualInterestRate(float annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public float getPrincipal() {
		return principal;
	}

	public float getNewBalance() {
		return newBalance;
	}

	public int getYears() {
		return years;
	}

	public float getCompoundRate() {
		return compoundRate;
	}

	public float getAnnualInterestRate() {
		return annualInterestRate;
	}


}
