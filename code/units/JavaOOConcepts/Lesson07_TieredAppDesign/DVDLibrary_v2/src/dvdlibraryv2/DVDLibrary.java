/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibraryv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface DVDLibrary {
  public List<Dvd> getByMpaa(String mpaa);
  public Map<String, List<Dvd>> getByDirectorSorted(String director);
  public List<Dvd> getByStudio(String studio);
  public double getAvgAge();
  public List<Dvd> getNewest();
  public List<Dvd> getOldest();
  public double getAvgNumNotes();
  public List<Dvd> getByDirector(String director); 
  public void loadDvds(String fileName);
  public void writeDvdLib(String fileName);
  public void add(Dvd dvd);
  public void remove(Dvd dvd);
  public List<Dvd> getByTitle(String dvdTitle) ;
  public int numDvds();
  public String toString(ArrayList<String> al, String delimiter);
  public String toStringWithIndex(ArrayList<String> al, String delimiter, int start, String del2);
  public List<Dvd> getAll();
  public List<Dvd> getSinceYear(int year);
}
