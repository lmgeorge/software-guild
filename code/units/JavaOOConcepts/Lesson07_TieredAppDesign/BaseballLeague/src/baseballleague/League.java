/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague;

import java.util.HashMap;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class League {
  HashMap<String,Team> teams = new HashMap<>();
  ConsoleIO c = new ConsoleIO();

  public Team addTeam(String teamName) {
    Team team = new Team();
    team.setTeamName(teamName);
    
    return teams.put(teamName, team);
  }

  public void removeTeam(String teamName) {
    teams.remove(teamName);
  }
  
  public void loadLeague(){
    
  }
  public void saveLeague(){
    
  }
}
