/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibraryv2;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Dvd {

  private final ConsoleIO c = new ConsoleIOImpl();
  private String title;
  private int year;
  private int age;
  private String mpaaRating;
  private String director;
  private String studio;
  private ArrayList<String> notes = new ArrayList<>();

  public enum mpaaRating {

    G { public String toString() {
          return "G";
        }
      },
    PG{ public String toString() {
          return "PG";
        }
      },
    PG_13{ public String toString() {
          return "PG-13";
        }
      },
    R{ public String toString() {
          return "R";
        }
      };
  }

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

  public int getNotesSize() {
    return notes.size();
  }

  public void setNotes(ArrayList<String> al) {
    this.notes = al;
  }

  public String getNote(int index) {
    String note = notes.get(index);
    return note;
  }

  public void setNote(String note, int counter) {
    try {
      notes.add(note);
    } catch (NullPointerException ex) {
      c.println("ERROR: " + ex.getMessage());
    }
  }

  public void setNote(String note) {
    try {
      notes.add(note);
    } catch (NullPointerException ex) {
      c.println("ERROR: " + ex.getMessage());
    }
  }

  public int getAge() {
   return IsoChronology.INSTANCE.date(year, 1, 1).until(IsoChronology.INSTANCE.dateNow()).getYears();
  }

}
