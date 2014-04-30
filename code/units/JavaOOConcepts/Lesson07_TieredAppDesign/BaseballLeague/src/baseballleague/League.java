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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class League {

	private HashMap<String, Team> teams = new HashMap<>();
	private Set<String> teamNames = teams.keySet();
	private final String LEAGUE = "league.txt";
	private List <Player> team =  new ArrayList<>();
	private final String DELIMITER = "::";


	public void loadLeague() throws FileNotFoundException {
		Scanner leagueFile = new Scanner(new BufferedReader(new FileReader(LEAGUE)));
		
		while(leagueFile.hasNextLine()){
			String teamFile = leagueFile.nextLine();
			loadTeam(teamFile);
		}
	}

	public void saveLeague() throws IOException {
		PrintWriter file = new PrintWriter(new FileWriter(LEAGUE));

		teamNames
			.stream()
			.forEach(teamName -> {
				file.println(fileNameGen(teamName) + DELIMITER
				+ teams.get(teamName).getCity() + DELIMITER
				+ teams.get(teamName).getState()
				);
				file.flush();
			});
		file.close();
	}

	public void loadTeam(String teamFile) throws FileNotFoundException {
		Scanner file = new Scanner(new BufferedReader(new FileReader(teamFile)));
		
		while(file.hasNextLine()){
			String[] playerStats = file.nextLine().split(DELIMITER);
			Player player = new Player();
			
		}
	}

	public void saveTeam(String teamName) throws IOException {
		String fileName = fileNameGen(teamName);
		PrintWriter file = new PrintWriter(new FileWriter(fileName));

	}
	public Team addTeam(String teamName, Team team) {
		team.setTeamName(teamName);
		return teams.put(keyGen(teamName), team);
	}

	public void removeTeam(String teamName) {
		teams.remove(keyGen(teamName));
	}
	
	public void addPlayer(Player player){
		team
			.stream()
			.filter(currPlayer -> currPlayer.getJerseyNumber().equals(player.getJerseyNumber()))
			.collect(Collectors.toList());
		
		team.add(player);
	}
	
	public  void removePlayer(String jerseyNumber){
	
	}
	
	public void tradePlayer(String teamNameOld, String teamNameNew ){
		
		
	}
	
	public String keyGen(String teamName){
		String temp;
		
		temp = teamName.replaceAll("[ \\t\\n\\x0B\\f\\r]", "");
		temp = temp.toLowerCase();
		
		return temp;
	}
	
	public String fileNameGen(String teamName){
		String temp;
		
		temp = keyGen(teamName) + ".txt";
		
		return temp;
	}
}

