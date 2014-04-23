/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseballleague;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Team {
  private String teamName;
  private String city;
  private String state;
  private HashMap<String, Player> team = new HashMap<>();

  
  public void loadTeam(String teamName) throws Exception{
    String fileName = teamName.concat(".txt");
    Scanner file = new Scanner(new BufferedReader(new FileReader(fileName)));
  }
  
  public void saveTeam(String teamName) throws IOException{
    String fileName = teamName.concat(".txt");
    PrintWriter file = new PrintWriter(new FileWriter(fileName));
     
  }
  
  
  public void tradePlayer(){
    
  }
  
  public void addPlayer(){
    Player player = new Player();
    
  }
  
  public String[] getKeys(){
    return team.keySet().toArray(new String[0]);
  }

  public String getTeamName() {
    return teamName;
  }

  public void setTeamName(String teamName) {
    this.teamName = teamName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  
}
