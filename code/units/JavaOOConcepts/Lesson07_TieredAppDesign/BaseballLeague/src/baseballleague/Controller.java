/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Controller {

	ConsoleIO c = new ConsoleIOImpl();
	League league = new League();

	public void playBall() {
		//league.loadLeague();
		int choice = mainMenu();
		switch (choice) {
			case 1:
				listTeams();
				break;
			case 2:
				addTeam();
				break;
			case 3:
				removeTeam();
				break;
			case 4:
				listRoster();
				break;
			case 5:
				playerMenu();
				break;
			case 0:
				c.println("Thanks for coming!\n");
				break;
		}
	}

	public int mainMenu() {
		
		c.println("\tWelcome to the Baseball Trading Post"
			+ "\n====================================================");
		int choice = c.getsNum(
			"\nMAIN MENU"
			+ "\n\t1. List all teams"
			+ "\n\t2. Add a new team"
			+ "\n\t3. Remove a team"
			+ "\n\t4. See a team roster"
			+ "\n\t5. Player management"
			+ "\n\t0. Exit"
			+ "\n\nPlease enter your choice: ");
		c.println();
		return choice;
	}

	public int playerMenu() {
		int choice = c.getsNum(
			"\nPLAYER MENU"
			+ "\n\t1. See a team roster"
			+ "\n\t2. Add a new player"
			+ "\n\t3. Remove a player"
			+ "\n\t4. Trade a player"
			+ "\n\t5. Main menu"
			+ "\n\nPlease enter your choice: ");
		c.println();
		return choice;
	}

	public void listTeams() {

	}

	public void addTeam() {

	}

	public void removeTeam() {

	}

	public void listRoster() {

	}

	public void addPlayer() {
//		league.
//			.stream()
//			.filter(currPlayer -> currPlayer.getJerseyNumber().equals(player.getJerseyNumber()))
//			.collect(Collectors.toList());
	}

	public void removePlayer() {

	}


}
