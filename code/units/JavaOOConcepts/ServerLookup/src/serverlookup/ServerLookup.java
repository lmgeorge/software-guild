/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverlookup;

import java.io.IOException;

/**
 *
 * @author lmgeorge
 */
public class ServerLookup {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
//        Server server = new Server("server001", "192.168.01");
//        
//        Map<String, Server> hashServer = new HashMap<>();
////        HashMap<String, Person> hm= new HashMap<>();
////        hm.put(p1.getLastName(), p1);
////        System.out.println(hm.get(p1.getLastName()).getFirstName());
//        
//        hashServer.put(server.getName(), server);
//        System.out.println(hashServer.get(server.getName()).getIp() );
//        
try {
    ServerCabinet cab = new ServerCabinet();
    Server server = new Server();
    server.setName("web01");
    server.setIp("196.207.0.6");
    server.setMake("Dell");
    server.setRam("8 GB");
    server.setProcessors("8 cores");

    cab.add(server);
    
      cab.writeCabinet();
    } catch (IOException ioe) {
      System.out.println("ERROR: " + ioe.getMessage());
    }
  }

}
