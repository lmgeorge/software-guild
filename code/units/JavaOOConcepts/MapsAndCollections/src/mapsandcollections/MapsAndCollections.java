/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mapsandcollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class MapsAndCollections {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
   ArrayList<Human> al = new ArrayList<>();
   
   
   Human p1 = new Human("John", "Doe", "123 Main St.");
   al.add(p1);
   //System.out.println(al.get(0).getFirstName());
   
   Human p2 = new Human("Anne", "White", "One Infinite Loop");
   al.add(p2);
   Human p3 = new Human("Dante", "George", "456 Broad Blvd");
   al.add(p3);
   
   //list all first names
   
   Iterator<Human> iter = al.iterator();
   
   while(iter.hasNext()){
     Human current = iter.next();
     
     System.out.println(current.getFirstName());
   }
   
   
   HashMap<String, Human> humans = new HashMap<>();
   
   humans.put(p3.getLastName(), p3);
   humans.put(p1.getLastName(), p1);
   humans.put(p2.getLastName(), p2);
   
   System.out.println(humans.keySet());
   System.out.println(humans.size());
   
  }
  
}
