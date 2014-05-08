/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.luckysevens;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class LuckySevensGameEngine {

	private int roll1, roll2, rollCounter = 0, betLimit, maxAmountBet = 0, maxAmountRoll = 0;
	private final Random rGen = new Random();

	public int rollDice() {
		roll1 = rGen.nextInt(6) + 1;
		roll2 = rGen.nextInt(6) + 1;
		int sum = roll1 + roll2;
		return sum;
	}

	public Game gamble(int bet) {
		this.betLimit = bet;
		while (betLimit > 0) {
			rollCounter++;
			if (rollDice() == 7) {
				betLimit += 4;
				if (betLimit > maxAmountBet) {
					maxAmountBet = betLimit;
					maxAmountRoll = rollCounter;
				}
			} else {
				betLimit -= 1;
			}
		}

		Game game = new Game();

		game.setMaxAmountBet(maxAmountBet);
		game.setMaxAmountRoll(maxAmountRoll);
		game.setRollCounter(rollCounter);

		return game;
	}


}
