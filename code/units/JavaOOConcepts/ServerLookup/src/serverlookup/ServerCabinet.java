/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverlookup;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ServerCabinet {
  private Scanner ui = new Scanner(System.in);
  public static final String CABINET_FILE = "servers.txt";
  public static final String DELIMITER = "::";
  private HashMap<String, Server> servers = new HashMap<>();
  
  
  public int count(){
    return servers.size();
  }
  
  public void add(Server server){
     servers.put(server.getName(), server);
  }
  public Server remove(String serverName){
     return servers.remove(serverName);
  }
  
  public Server get(String serverName){
    
    return servers.get(serverName);
  }
  
  public void showCabinet() throws FileNotFoundException {
    Scanner readFile = new Scanner(new BufferedReader(new FileReader(CABINET_FILE)));
    String record;
    String[] recordTokens;
    while(readFile.hasNextLine()){
       record = readFile.nextLine();
       recordTokens = record.split(DELIMITER);
       
       
      Server currentServer = new Server();
      currentServer.setName(recordTokens[0]);
      currentServer.setIp(recordTokens[1]);
      currentServer.setMake(recordTokens[2]);
      currentServer.setRam(recordTokens[3]);
      currentServer.setProcessors(recordTokens[4]);
      
      servers.put(currentServer.getName(), currentServer);
      
    }
    readFile.close();
    
  }
  
  public void writeCabinet() throws IOException{
    PrintWriter fileOut = new PrintWriter(new FileWriter(CABINET_FILE));
    
    Collection<Server> values = servers.values();
    
    Iterator<Server> iter = values.iterator();
    while (iter.hasNext()){
      Server currentServer = iter.next();
      fileOut.println(currentServer.getName()+DELIMITER
      + currentServer.getIp()+ DELIMITER
      + currentServer.getMake() + DELIMITER
      + currentServer.getRam() + DELIMITER
      + currentServer.getProcessors() + DELIMITER);
      
    }
    
  }
}
