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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DVDLibrary {

  private HashMap<String, Dvd> dvdLib = new HashMap<>();
  private final String DELIMITER = "::";
  private final ConsoleIO c = new ConsoleIO();

  public void loadDvds(String fileName) throws FileNotFoundException {
    Scanner file = new Scanner(new BufferedReader(new FileReader(fileName)));
    String[] dvdInfo;

    while (file.hasNextLine()) {
      String dvdrecord = file.nextLine();
      dvdInfo = dvdrecord.split(DELIMITER);

      Dvd dvd = new Dvd();
      dvd.setTitle(dvdInfo[0]);
      dvd.setYear(Integer.parseInt(dvdInfo[1]));
      dvd.setMpaaRating(dvdInfo[2]);
      dvd.setDirector(dvdInfo[3]);
      dvd.setStudio(dvdInfo[4]);
      ArrayList<String> notes = new ArrayList<>();
      for (int i = 5; i < dvdInfo.length; i++) {
        notes.add(dvdInfo[i]);

      }

      dvd.setNotes(notes);

      dvdLib.put(dvdInfo[0], dvd);
    }
    file.close();
  }

  public void writeDvdLib(String fileName) throws IOException {
    PrintWriter file = new PrintWriter(new FileWriter(fileName));

    String[] keys = getKeys();
    for (String key : keys) {
      Dvd dvd = new Dvd();
      file.print(dvdLib.get(key).getTitle() + DELIMITER 
        + dvdLib.get(key).getYear() + DELIMITER 
        + dvdLib.get(key).getMpaaRating() + DELIMITER 
        + dvdLib.get(key).getDirector() + DELIMITER 
        + dvdLib.get(key).getStudio());
      
      file.println(c.toString(dvdLib.get(key).getNotes(), DELIMITER, false));
      file.flush();
    }
    file.close();
  }

  public void add(Dvd dvd) {
    dvdLib.put(dvd.getTitle(), dvd);
  }

  public void remove(String dvdTitle) {
    dvdLib.remove(dvdTitle);
  }

  public Dvd getDvd(String dvdTitle) {
    return dvdLib.get(dvdTitle);
  }

  public int numDvds() {
    return dvdLib.size();
  }

  public String[] getKeys() {
    return dvdLib.keySet().toArray(new String[0]);
  }
}
