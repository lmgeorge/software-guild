/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package baseballleague;



/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Player {
  private String jerseyNumber;
  private String firstName;
  private String lastName;
  private String position;
  private float battingAvg;

  public String getJerseyNumber() {
    return jerseyNumber;
  }

  public void setJerseyNumber(String jerseyNumber) {
    this.jerseyNumber = jerseyNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public float getBattingAvg() {
    return battingAvg;
  }

  public void setBattingAvg(float battingAvg) {
    this.battingAvg = battingAvg;
  }
  
}
