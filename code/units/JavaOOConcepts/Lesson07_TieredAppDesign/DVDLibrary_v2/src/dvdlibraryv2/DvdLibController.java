/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibraryv2;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DvdLibController {

  private final ConsoleIO c = new ConsoleIOImpl();
  private DVDLibrary dvds = new DVDLibraryImpl();
  private DecimalFormat d = new DecimalFormat("#.##");
  
  public void run() throws Exception {

    dvds.loadDvds("dvds.txt");

    c.println("\tWelcome to your DVD Library\n"
      + "===========================================\n");
    menu();

  }

  public void menu() {
    String key;
    int ui = c.getsNum("Main Menu:\n"
      + "\n\t1. Add a DVD"
      + "\n\t2. Remove a DVD"
      + "\n\t3. Edit a DVD record"
      + "\n\t4. Find a DVD"
      + "\n\t5. List all DVDs"
      + "\n\t6. Library Stats"
      + "\n\t7. Exit"
      + "\n\nPlease enter your choice: ", 1, 7);

    switch (ui) {
      case 1:
        c.println("\nADD DVD:\n");
        addDvd();
        menu();
        break;
      case 2:
        c.println("\nDELETE DVD:\n");
        key = c.gets("Please enter a dvd title: ");
        //deleteDvd(key);
        menu();
        break;
      case 3:
        c.println("\nEDIT DVD:\n");
        key = c.gets("Please enter a dvd title: ");
        //edit(key);
        menu();
        break;
      case 4:
        c.println("\nFIND DVD:\n");
        key = c.gets("Please enter a keyword: ");
        findBy(key);
        menu();
        break;
      case 5:
        c.println("\nLIST ALL DVDs:\n");
        listAll(dvds.getAll());
        menu();
        break;
      case 6:
        c.println("\nLIBRARY STATS:");
        getStats();
        menu();
        break;
      case 7:
        c.println("\nEXIT:");
        c.println("Saving....Thank you!\n");
        break;
    }

  }

  public void addDvd() {
    String more;

    do {
      Dvd dvd = new Dvd();
      dvd.setTitle(c.gets("Title: "));
      dvd.setYear(c.getsNum("Release Year: "));
      dvd.setMpaaRating(c.gets("MPAA Rating: "));
      dvd.setDirector(c.gets("Director: "));
      dvd.setStudio(c.gets("Studio: "));
      dvd.setNotes(addNotes());

      dvds.add(dvd);

      more = c.gets("Would you like to add another DVD? (y/n): ");
      c.println();
    } while (more.equalsIgnoreCase("y"));

    dvds.writeDvdLib("dvds.txt");

  }

  public void deleteDvd(Dvd dvd) {
    Dvd temp = find(dvd);
    String confirm = c.gets("Delete " + key + " (y/n)? ");
    if (confirm.equalsIgnoreCase("y")) {
      dvds.remove(key);
      c.println("DVD removed successfully.");
    } else {
      c.println("Operation successfully stopped.");
    }
    dvds.writeDvdLib("dvds.txt");

  }



  public void findBy(String keyword, boolean makeChoice) {
    int choice = c.getsNum("\n\t1. Keyword search"
      + "\n\t2. Search by Title"
      + "\n\t3. Search by MPAA Rating"
      + "\n\t4. Search by Director"
      + "\n\t5. Search by Studio"
      + "\n\t6. Search since Release Year"
      + "\n\t7. List Newest Films"
      + "\n\t8. List Oldest Films"
      + "\n\t9. Main menu"
      + "\n\nPlease enter your choice: ", 1, 9);
    String search;
    switch (choice) {
      case 1:
        c.println("\n\nKEYWORD SEARCH");
        searchByKeyword();
        break;
      case 2:
        search = c.gets("\n\nSEARCH BY TITLE"
          + "\n\tPlease enter your choice: ");
        listAll(dvds.getByTitle(search), makeChoice);
        break;
      case 3:
        search = c.gets("\n\nSEARCH BY MPAA RATING"
          + "\n\tPlease enter your choice: ");
        listAll(dvds.getByMpaa(search), makeChoice);
        break;
      case 4:
        search = c.gets("\n\nSEARCH BY DIRECTOR"
          + "\n\tPlease enter your choice: ");
        listByDirector(search);
        break;
      case 5:
        search = c.gets("\n\nSEARCH BY STUDIO"
          + "\n\tPlease enter your choice: ");
        listAll(dvds.getByStudio(search));
        break;
      case 6:
        choice = c.getsNum("\n\nSEARCH SINCE YEAR"
          + "\n\tPlease enter your choice: ", 1850, LocalDate.now().getYear());
        listAll(dvds.getSinceYear(choice));
        break;
      case 7:
        c.println("\n\nLIST NEWEST FILMS");
        listAll(dvds.getNewest());
        break;
      case 8:
        c.println("\n\nLIST NEWEST FILMS");
        listAll(dvds.getOldest());
        break;
      case 9:
        menu();
        break;
    }

  }

  public List<Dvd> searchByKeyword(String keyword) {
    List<Dvd> allMatches = dvds.getByKeyword(keyword);
    
    listAll(allMatches, false);
    return allMatches;
  }

  public void listByDirector(String keyword, boolean makeChoice) {
    dvds.getByDirectorSorted(keyword).values()
      .stream()
      .forEach(list -> {
        listAll(list, makeChoice);
      });
  }

  public Dvd listAll(List<Dvd> dvdList, boolean makeChoice) {
    Dvd returnObj = new Dvd();
    dvdList
      .stream()
      .forEach(dvd -> {
        c.print(
          "Film " + (dvdList.indexOf(dvd) + 1)
          + "\n\tTitle: " + dvd.getTitle()
          + "\n\ttRelease Year: " + dvd.getYear()
          + "\n\tMPAA Rating: " + dvd.getMpaaRating()
          + "\n\tDirector: " + dvd.getDirector()
          + "\n\tStudio: " + dvd.getStudio()
          + "\n\tNotes:"
          + dvds.toStringWithIndex(dvd.getNotes(), "\n\t  ", 1, ". ")
          + "\n================================================================\n\n"
        );
      });
    if (dvdList.size() > 1 && makeChoice){
      int choice = c.getsNum("Please select a record: ");
      returnObj = dvdList.get(choice-1);
    }
    return returnObj;
  }

  public void getStats() {
    c.println(
      "\n\tQuantity: " + dvds.numDvds() + " DVDs"
      + "\n\tAverage age: " + d.format(dvds.getAvgAge()) + " years"
      + "\n\tAverage Number of Notes: " + d.format(dvds.getAvgNumNotes())
      + "\n");
  }
  public void edit(String key) {
    String confirm;
    find(key);
    try {
      do {
        int ui = c.getsNum(
          "\n\t1. Edit Title"
          + "\n\t2. Edit Release Year"
          + "\n\t3. Edit MPAA Rating"
          + "\n\t4. Edit Director"
          + "\n\t5. Edit Studio"
          + "\n\t6. Edit Notes"
          + "\n\t7. Cancel"
          + "\n\nPlease enter your choice: ", 1, 7);

        editor(key, ui);

        confirm = c.gets("Would you like to continue editing (y/n)? ");
      } while (confirm.equalsIgnoreCase("y"));
    } catch (NullPointerException ex) {
      c.println("Error: no such record exists. Msg = " + ex.getMessage() + "\n");
    }
    dvds.writeDvdLib("dvds.txt");

  }
  public void notesEditor(String key) {
    String confirm;
    Dvd dvd = dvds.getDvd(key);
    ArrayList<String> notes = dvd.getNotes();
    do {
      int ui = c.getsNum("1. Add a note\n"
        + "2. Delete a note\n"
        + "3. Edit a note\n"
        + "4. Delete all\n"
        + "5. Cancel\n"
        + "Enter your choice: ", 1, 5);
      switch (ui) {
        case 1:
          notes.addAll(addNotes());
          break;
        case 2:
          deleteNotes(key);
          break;
        case 3:
          c.println("Coming soon!");
          break;
        case 4:
          notes.clear();
          break;
        case 5:
          c.println("Cancelled.");
          break;
      }
      dvd.setNotes(notes);
      confirm = c.gets("Would you like to continue editing (y/n)? ");
    } while (confirm.equalsIgnoreCase("y"));
  }

  public ArrayList<String> addNotes() {
    String answer;
    ArrayList<String> notes = new ArrayList<>();
    do {
      String note = c.gets("Note: ");
      notes.add(note);
      c.println();

      answer = c.gets("Would you like to add another note? (y/n):  ");
      c.println();

    } while (answer.equalsIgnoreCase("y"));
    return notes;
  }

  public ArrayList<String> deleteNotes(String key) {
    Dvd dvd = dvds.getDvd(key);
    int choice;
    String answer;
    ArrayList<String> notes = dvd.getNotes();
    do {
      c.println("Notes:" + dvds.toStringWithIndex(notes, "\n\t", 1, ". "));

      choice = c.getsNum("Enter the note number you want to delete:\n ");

      c.println(notes.get(choice - 1));

      String confirm = c.gets("\nAre you sure you want to delete this note (y/n?");

      if (confirm.contains("y")) {
        notes.remove(choice - 1);
      } else {
        c.println("Operation successfully cancelled.");
      }

      answer = c.gets("Would you like to delete another note? (y/n):  ");
      c.println();

    } while (answer.equalsIgnoreCase("y"));
    return notes;
  }

  public void editor(String key, int ui) {
    String currentKey = key;
    Dvd dvd = dvds.getDvd(currentKey);
    String tempVal;
    String confirm;
    int tempNum;
    switch (ui) {
      case 1:
        tempVal = c.gets("Enter new title: ");
        c.println("Old title: " + dvd.getTitle());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setTitle(tempVal);
          dvds.add(dvd);
          currentKey = tempVal;
        } else {
          c.println("No changes made.\n");
        }

        break;
      case 2:
        tempNum = c.getsNum("Enter new release year: ");
        c.println("Old release year: " + dvd.getYear());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setYear(tempNum);
        } else {
          c.println("No changes made.\n");
        }

        break;
      case 3:
        tempVal = c.gets("Enter new rating: ");
        c.println("Old rating: " + dvd.getMpaaRating());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setMpaaRating(tempVal);
        } else {
          c.println("No changes made.\n");
        }
        break;
      case 4:
        tempVal = c.gets("Enter new director: ");
        c.println("Old director: " + dvd.getDirector());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setDirector(tempVal);
        } else {
          c.println("No changes made.\n");
        }
        break;
      case 5:
        tempVal = c.gets("Enter new studio: ");
        c.println("Old studio: " + dvd.getStudio());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setStudio(tempVal);
        } else {
          c.println("No changes made.\n");
        }
        break;
      case 6:
        notesEditor(key);
        break;
      case 7:
        c.println("Cancelled.");
        break;
      default:
        break;
    }
    c.println("Updated record:");
    find(currentKey);
  }
}
