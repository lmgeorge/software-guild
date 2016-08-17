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
public class Machine {
	private float principal;
	private float newBalance;
	private int years;
	private float compoundRate;
	private float annualInterestRate;
	private float interestAccrued;
	private float grossInvestment;

	public Investment caclulateInvestment(Investment investment) {
		principal = investment.getPrincipal();
		years = investment.getYears();
		compoundRate = investment.getCompoundRate();
		annualInterestRate = investment.getAnnualInterestRate();
		
		for (int i = 0; i < years; i++) {
			newBalance = principal;
			for (int j = 0; j < compoundRate; j++) {
				newBalance *= (1 + ((annualInterestRate / compoundRate) / 100));
			}
			principal = newBalance;
		}
		interestAccrued = newBalance - investment.getPrincipal();
		grossInvestment = newBalance;
		
		investment.setInterestAccrued(interestAccrued);
		investment.setGrossInvestment(grossInvestment);

		return investment;
	}


}
