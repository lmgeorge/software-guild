/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibraryv2;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.text.DecimalFormat;
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

  public void run(){
    dvds.loadDvds("dvds.txt");
    c.println("\tWelcome to DVD Library\n"
      + "===========================================\n");
    menu();
  }

  public void menu() {
    int ui = c.getsNum("\nMain Menu:\n"
      + "\n\t1. Add a DVD"
      + "\n\t2. Remove a DVD"
      + "\n\t3. Edit a DVD record"
      + "\n\t4. Find a DVD"
      + "\n\t5. List all DVDs"
      + "\n\t6. List Newest Films"
      + "\n\t7. List Oldest Films"
      + "\n\t8. Library Stats"
      + "\n\t0. Exit"
      + "\n\nPlease enter your choice: ", 0, 8);

    switch (ui) {
      case 1:
        c.println("\nADD DVD:\n");
        addDvd();
        menu();
        break;
      case 2:
        c.println("\nDELETE DVD:");
        deleteDvd();
        menu();
        break;
      case 3:
        c.println("\nEDIT DVD:");
        editMenu();
        menu();
        break;
      case 4:
        c.println("\nFIND DVD:");
        findBy(false);
        menu();
        break;
      case 5:
        c.println("\nLIST ALL DVDs:\n");
        listAll(dvds.getAll(), false);
        menu();
        break;
      
      case 6:
        c.println("\n\nLIST NEWEST FILMS");
        listAll(dvds.getNewest(), false);
        menu();
        break;
      case 7:
        c.println("\n\nLIST OLDEST FILMS");
        listAll(dvds.getOldest(), false);
        menu();
        break;
      case 8:
        c.println("\nLIBRARY STATS:");
        getStats();
        menu();
        break;
      case 0:
        c.println("\nEXIT:");
        c.println("Saving....Thank you!\n");
        break;
    }

  }

  public void addDvd() {
    String more;

    do {
      Dvd dvd = new Dvd();
      dvd.setTitle(c.gets("\tTitle: "));
      dvd.setYear(c.getsNum("\tRelease Year: "));
      dvd.setMpaaRating(c.gets("\tMPAA Rating: "));
      dvd.setDirector(c.gets("\tDirector: "));
      dvd.setStudio(c.gets("\tStudio: "));
      dvd.setNotes(addNotes());

      dvds.add(dvd);

      more = c.gets("Would you like to add another DVD (y/n)?: ");
      c.println();
    } while (more.equalsIgnoreCase("y"));

    allowSave();

  }

  public void deleteDvd() {
    String more;

    do {
      Dvd dvd = findBy(true);
      String confirm = c.gets("Delete \"" + dvd.getTitle() + "\" (y/n)? ");
      if (confirm.equalsIgnoreCase("y")) {
        dvds.remove(dvd);
        c.println("\nDVD removed successfully.");
      } else {
        c.println("\nOperation successfully stopped.");
      }
      more = c.gets("\nWould you like to delete another DVD? (y/n): ");
      c.println();
    } while (more.equalsIgnoreCase("y"));

    allowSave();

  }

  public Dvd findBy(boolean makeChoice) {
    int choice = c.getsNum("\n\t1. Keyword search"
      + "\n\t2. Search by Title"
      + "\n\t3. Search by MPAA Rating"
      + "\n\t4. Search by Director"
      + "\n\t5. Search by Studio"
      + "\n\t6. Search since Release Year"
      + "\n\t0. Main menu"
      + "\n\nPlease enter your choice: ", 1, 6);
    String search;
    Dvd retObj = new Dvd();
    switch (choice) {
      case 1:
        search = c.gets("\n\nKEYWORD SEARCH" + "\n\nPlease enter a keyword: ");
        retObj = listAll(searchByKeyword(search), makeChoice);
        break;
      case 2:
        search = c.gets("\n\nSEARCH BY TITLE"
          + "\n\nPlease enter your choice: ");
        retObj = listAll(dvds.getByTitle(search), makeChoice);
        break;
      case 3:
        search = c.gets("\n\nSEARCH BY MPAA RATING"
          + "\n\nPlease enter your choice: ");
        retObj = listAll(dvds.getByMpaa(search), makeChoice);
        break;
      case 4:
        search = c.gets("\n\nSEARCH BY DIRECTOR"
          + "\n\nPlease enter your choice: ");
        retObj = listAll(dvds.listByDirector(search), makeChoice);
        break;
      case 5:
        search = c.gets("\n\nSEARCH BY STUDIO"
          + "\n\nPlease enter your choice: ");
        retObj = listAll(dvds.getByStudio(search), makeChoice);
        break;
      case 6:
        choice = c.getsNum("\n\nSEARCH SINCE YEAR"
          + "\n\nPlease enter your choice: ", 1850, LocalDate.now().getYear());
        retObj = listAll(dvds.getSinceYear(choice), makeChoice);
        break;
      case 0:
        menu();
        break;
    }
    return retObj;
  }

  public List<Dvd> searchByKeyword(String keyword) {
    List<Dvd> allMatches = dvds.getByKeyword(keyword);

    return allMatches;
  }

  public Dvd listAll(List<Dvd> dvdList, boolean makeChoice) {
    Dvd returnObj = new Dvd(); 
    c.print("\nResults:\n");
    dvdList
      .stream()
      .forEach(dvd -> {
        c.print(
          "\nFilm " + (dvdList.indexOf(dvd) + 1)
          + "\n\tTitle: " + dvd.getTitle()
          + "\n\tRelease Year: " + dvd.getYear()
          + "\n\tMPAA Rating: " + dvd.getMpaaRating()
          + "\n\tDirector: " + dvd.getDirector()
          + "\n\tStudio: " + dvd.getStudio()
          + "\n\tNotes:"
          + dvds.toStringWithIndex(dvd.getNotes(), "\n\t  ", 1, ". ")
          + "\n\n================================================================\n\n"
        );
      });
    try {
      if (dvdList.size() > 1 && makeChoice) {
        int choice = c.getsNum("Please select a record: ");
        returnObj = dvdList.get(choice - 1);
      } else {
        returnObj = dvdList.get(0);
      }
    } catch (IndexOutOfBoundsException | NullPointerException ex) {
      c.println("\nError: No record exists.\n");
      menu();
    }
    return returnObj;
  }

  public void editMenu() {
    String confirm;
    Dvd dvd = findBy(true);
    try {
      do {
        int ui = c.getsNum(
          "\n\t1. Edit Title"
          + "\n\t2. Edit Release Year"
          + "\n\t3. Edit MPAA Rating"
          + "\n\t4. Edit Director"
          + "\n\t5. Edit Studio"
          + "\n\t6. Edit Notes"
          + "\n\t0. Cancel"
          + "\n\nPlease enter your choice: ", 0, 6);
        c.println();

        editor(dvd, ui);

        confirm = c.gets("Would you like to continue editing (y/n)? ");
      } while (confirm.equalsIgnoreCase("y"));
    } catch (NullPointerException ex) {
      c.println("Error: no such record exists. Msg = " + ex.getMessage() + "\n");
    }
    allowSave();

  }

  public void editor(Dvd dvd, int ui) {
    String tempVal;
    String confirm;
    int tempNum;
    switch (ui) {
      case 1:
        c.println("Old title: " + dvd.getTitle());
        tempVal = c.gets("Enter new title: ");
        confirm = c.gets("\nConfirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setTitle(tempVal);
        } else {
          c.println("No changes made.\n");
        }

        break;
      case 2:
        c.println("Old release year: " + dvd.getYear());
        tempNum = c.getsNum("Enter new release year: ");

        confirm = c.gets("\nConfirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setYear(tempNum);
        } else {
          c.println("No changes made.\n");
        }

        break;
      case 3:
        c.println("Old rating: " + dvd.getMpaaRating());
        tempVal = c.gets("Enter new rating: ");

        confirm = c.gets("\nConfirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setMpaaRating(tempVal);
        } else {
          c.println("\nNo changes made.\n");
        }
        break;
      case 4:
        c.println("Old director: " + dvd.getDirector());
        tempVal = c.gets("Enter new director: ");

        confirm = c.gets("\nConfirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setDirector(tempVal);
        } else {
          c.println("\nNo changes made.\n");
        }
        break;
      case 5:
        c.println("Old studio: " + dvd.getStudio());
        tempVal = c.gets("Enter new studio: ");

        confirm = c.gets("\nConfirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setStudio(tempVal);
        } else {
          c.println("\nNo changes made.\n");
        }
        break;
      case 6:
        notesEditor(dvd);
        break;
      case 7:
        c.println("\nCancelled.");
        break;
      default:
        break;
    }
    List<Dvd> temp = new ArrayList<>();
    temp.add(dvd);
    c.println("\nUpdated record:");
    c.print(dvds.toString(dvd));
  }

  public void notesEditor(Dvd dvd) {
    String confirm;
    ArrayList<String> notes = dvd.getNotes();
    do {
      int ui = c.getsNum("\n\t1. Add a note\n"
        + "\n\t2. Delete a note\n"
        + "\n\t3. Edit a note\n"
        + "\n\t4. Delete all\n"
        + "\n\t0. Cancel"
        + "\n\nEnter your choice: ", 0, 4);
      switch (ui) {
        case 1:
          notes.addAll(addNotes());
          break;
        case 2:
          notes = deleteNotes(dvd);
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
      confirm = c.gets("\nWould you like to continue editing (y/n)? ");
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

  public ArrayList<String> deleteNotes(Dvd dvd) {
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

  public void allowSave() {
    int choice = c.getsNum("\nSAVE"
      + "\n\t1. Save changes"
      + "\n\t2. Cancel"
      + "\n\t0. Main Menu"
      + "\n\nPlease enter your choice: ", 0, 2);
  
    switch (choice) {
      case 1:
        dvds.writeDvdLib("dvds.txt");
        c.println("\nSaved.\n");
        break;
      case 2:
        c.println("\nOperation successfully stopped.\n");
        break;
      case 0:
        menu();
        break;
    }

  }

  public void getStats() {
    c.println(
      "\n\tQuantity: " + dvds.numDvds() + " DVDs"
      + "\n\tAverage age: " + d.format(dvds.getAvgAge()) + " years"
      + "\n\tAverage Number of Notes: " + d.format(dvds.getAvgNumNotes())
      + "\n");
  }
}
