/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dvdlibrary;

import java.util.ArrayList;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Dvd {
private final ConsoleIO10 c = new ConsoleIO10();  
private String title;
private int year;
private String mpaaRating;
private String director;
private String studio;
private ArrayList<String> notes = new ArrayList<>();


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public String getMpaaRating() {
    return mpaaRating;
  }

  public void setMpaaRating(String mpaaRating) {
    this.mpaaRating = mpaaRating;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  public String getStudio() {
    return studio;
  }

  public void setStudio(String studio) {
    this.studio = studio;
  }

  public ArrayList<String> getNotes() {
    ArrayList<String> al;
     al = notes;
    return al;
  }

  public void setNotes(ArrayList<String> al) {
    this.notes = al;
  }

  public String getNote(int index) {
    String note = notes.get(index);
    return note;
  }

  public void setNote(String note, int counter) { 
    try{
    notes.add(note);
    } catch (NullPointerException ex){
      c.println("ERROR: " + ex.getMessage());
    }
  }
  public void setNote(String note) {
    try{
    notes.add(note);
    } catch (NullPointerException ex){
      c.println("ERROR: " + ex.getMessage());
    }
  }
  

}
