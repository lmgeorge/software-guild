/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logicdrills;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class CaughtSpeeding {
  
  public int caughtSpeeding(int speed, boolean isBirthday){
    int ticket = 0;
    if ((isBirthday && speed <= 86) || speed <= 60){
      ticket = 0;
    }else if (speed > 80){
      ticket = 2;
    }else if (speed >= 61){
      ticket = 1;
    }

    return ticket;
  }
  
  
}
