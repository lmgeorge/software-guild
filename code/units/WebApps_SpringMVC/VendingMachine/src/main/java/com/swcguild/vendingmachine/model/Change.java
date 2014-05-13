/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.model;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Change {

	private int quarters;
	private int dimes;
	private int nickels;
	private int pennies;
	private double money;
	public void getChange(double cost) {		
		pennies = (int) ((money-cost)*100) ;

		quarters = pennies / 25;
		pennies -= quarters * 25;

		dimes = pennies / 10;
		pennies -= dimes * 10;

		nickels = pennies / 5;
		pennies -= nickels * 5;
	}

	public int getQuarters() {
		return quarters;
	}

	public int getDimes() {
		return dimes;
	}

	public int getNickels() {
		return nickels;
	}

	public int getPennies() {
		return pennies;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}


}
