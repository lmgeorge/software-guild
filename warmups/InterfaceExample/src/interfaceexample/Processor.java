/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interfaceexample;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Processor {
  public void processCommand(Command c){
    c.execute();
  }
}
