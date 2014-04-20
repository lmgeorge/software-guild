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
  
private String title;
private int year;
private String mpaaRating;
private String director;
private String studio;
private ArrayList<String> notes;
private String note;

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
    return notes;
  }

  public void setNotes(ArrayList<String> notes) {
    this.notes = notes;
  }

  public String getNote(int index) {
    note = notes.get(index);
    return note;
  }
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;  
    notes.add("Note " + notes.size() + ": " + note);
  }
  

}
