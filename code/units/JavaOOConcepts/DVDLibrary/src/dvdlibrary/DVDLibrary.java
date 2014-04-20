/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary;

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
import java.util.Set;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DVDLibrary {
  
  HashMap<String, Dvd> dvdLib = new HashMap<>();
  String DELIMITER = "::";
  String fileName = "";
  ConsoleIO10 cio = new ConsoleIO10();
  
  public void loadDvds() throws FileNotFoundException {
    Scanner file = new Scanner(new BufferedReader(new FileReader(fileName)));
    
    while (file.hasNextLine()) {
      String[] dvdInfo = file.nextLine().split(DELIMITER);
      Dvd dvd = new Dvd();
      dvd.setTitle(dvdInfo[0]);
      dvd.setYear(Integer.parseInt(dvdInfo[1]));
      dvd.setMpaaRating(dvdInfo[2]);
      dvd.setDirector(dvdInfo[3]);
      dvd.setStudio(dvdInfo[4]);
      for (int i = 5; i < dvdInfo.length; i++) {
        dvd.setNote(dvdInfo[i]);
      }
      dvdLib.put(dvdInfo[0], dvd);
    }
    
  }
  
  public void writeDvdLib() throws IOException {
    PrintWriter file = new PrintWriter(new FileWriter(fileName));
    Collection<Dvd> vals = dvdLib.values();
    Iterator<Dvd> iter = vals.iterator();
    
    while (iter.hasNext()) {
      Dvd dvd = new Dvd();
      file.println(
        dvd.getTitle() + DELIMITER
        + dvd.getYear() + DELIMITER
        + dvd.getMpaaRating() + DELIMITER
        + dvd.getDirector() + DELIMITER
        + dvd.getStudio()
        + cio.toString(dvd.getNotes(), DELIMITER));
      file.flush();
    }
    file.close();
  }
  
  public void addDvd(Dvd dvd) {
    dvdLib.put(dvd.getTitle(), dvd);
  }

  public void remove(String dvdTitle) {
    dvdLib.remove(dvdTitle);
  }

  public Dvd getDvd(String dvdTitle) {
    return dvdLib.get(dvdTitle);
  }
  
  public int numDvds(){
    return dvdLib.size();
  }
  
  public String[] getKeys(){
    return dvdLib.keySet().toArray(new String[0]);
    
  }
}
