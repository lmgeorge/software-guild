/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class League {

	private Map<String, List<Player>> league = new HashMap<>();
	private Set<String> teamNames = league.keySet();
	private final String LEAGUE = "league.txt";
	private Map<String, String> teams = new HashMap<>();
	private final String DELIMITER = "::";

	public void loadLeague() {
		try {

			Scanner leagueFile = new Scanner(new BufferedReader(new FileReader(LEAGUE)));

			while (leagueFile.hasNextLine()) {
				String[] line = leagueFile.nextLine().split(DELIMITER);
				String fileName = line[0];
				String teamName = line[1];

				teams.put(teamName, line[2]);
				league.put(teamName, loadTeam(fileName));
			}
			leagueFile.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(League.class.getName()).log(Level.OFF, ("ERROR: " + ex.getMessage()));
		}

	}

	public void saveLeague() throws IOException {
		PrintWriter file = new PrintWriter(new FileWriter(LEAGUE));
		teamNames
			.stream()
			.forEach(name -> {
				file.println(fileNameGen(name) + DELIMITER
					+ name + DELIMITER
					+ teams.get(name));
				file.flush();

				try {
					saveTeam(name);
				} catch (IOException ex) {

				}
			});
		file.close();

	}

	public Map<String, List<Player>> getLeague(){
		return league;
	}
	
	public List<Player> loadTeam(String fileName) throws FileNotFoundException {
		Scanner teamFile = new Scanner(new BufferedReader(new FileReader(fileName)));
		List<Player> team = new ArrayList<>();

		while (teamFile.hasNextLine()) {
			String[] line = teamFile.nextLine().split(DELIMITER);
			Player player = new Player();

			player.setJerseyNumber(line[0]);
			player.setFirstName(line[1]);
			player.setLastName(line[2]);
			player.setPosition(line[3]);
			try {
				player.setCareerBattingAvg(Double.parseDouble(line[4]));
				player.setCareerGames(Integer.parseInt(line[5]));
			} catch (NumberFormatException ex) {
				Logger.getLogger(League.class.getName()).log(Level.OFF, ("ERROR: " + ex.getMessage()));
			}
			player.setBirthday(line[6]);
			team.add(player);
		}
		teamFile.close();
		return team;
	}

	public void saveTeam(String teamName) throws IOException {
		String fileName = fileNameGen(teamName);
		PrintWriter file = new PrintWriter(new FileWriter(fileName));

		league.get(teamName)
			.stream()
			.forEach(player -> {
				file.println(player.toString());
				file.flush();
			});
		file.close();
	}

	public List<Player> getTeam(String teamName) throws NullPointerException {
		return league.get(teamName);
	}

	public void addTeam(String teamName, ArrayList<Player> team) {
		league.put(teamName, team);
	}

	public void removeTeam(String teamName) throws NullPointerException {
		league.remove(teamName);
	}

	public void addPlayer(Player player, String teamName) throws NullPointerException {
		league.get(teamName).add(player);
	}

	public void removePlayer(Player player) {
		teamNames
			.stream()
			.forEach(key -> {
				league.get(key)
				.remove(player);
			});
	}

	public Player getPlayer(String teamName, String jerseyNumber) throws NullPointerException {
		return league.get(teamName)
			.stream()
			.filter(player -> player.getJerseyNumber().equals(jerseyNumber))
			.collect(Collectors.toList()).get(0);
	}

	public String fileNameGen(String teamName) {
		String temp;
		temp = teamName.replaceAll("[ \\t\\n\\x0B\\f\\r]", "");
		temp = temp.toLowerCase();
		temp += ".txt";
		return temp;
	}


}
