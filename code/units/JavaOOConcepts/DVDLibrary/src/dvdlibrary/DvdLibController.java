/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DvdLibController {

  private final ConsoleIO10 c = new ConsoleIO10();
  private DVDLibrary dvds = new DVDLibrary();

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
      + "\n\t6. Exit"
      + "\n\nPlease enter your choice: ");

    switch (ui) {
      case 1:
        c.println("\nADD DVD:\n");
        addDvd();
        menu();
        break;
      case 2:
        c.println("\nDELETE DVD:\n");
        key = c.gets("Please enter a dvd title: ");
        deleteDvd(key);
        menu();
        break;
      case 3:
        c.println("\nEDIT DVD:\n");
        key = c.gets("Please enter a dvd title: ");
        edit(key);
        menu();
        break;
      case 4:
        c.println("\nFIND DVD:\n");
        key = c.gets("Please enter a dvd title: ");
        find(key);
        menu();
        break;
      case 5:
        c.println("\nLIST ALL DVDs:\n");
        listAll();
        menu();
        break;
      case 6:
        c.println("\nEXIT:");
        c.println("Saving....Thank you!\n");
        break;
      default:
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

    try {
      dvds.writeDvdLib("dvds.txt");
    } catch (IOException ex) {
      Logger.getLogger(DvdLibController.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public void deleteDvd(String key) {
    try {
      find(key);

      String confirm = c.gets("Delete " + key + " (y/n)? ");
      if (confirm.equalsIgnoreCase("y")) {
        dvds.remove(key);
        c.println("DVD removed successfully.");
      } else {
        c.println("Operation successfully stopped.");
      }

      dvds.writeDvdLib("dvds.txt");
    } catch (IOException ex) {
      Logger.getLogger(DvdLibController.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public void edit(String key) {
    //what dvd would you like to edit
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
    //save? 
    try {
      dvds.writeDvdLib("dvds.txt");
    } catch (IOException ex) {
      Logger.getLogger(DvdLibController.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public void find(String key) {
    try {
      Dvd dvd = dvds.getDvd(key);
      c.println(
        "\nTitle: " + dvd.getTitle() + "\n"
        + "Release Year: " + dvd.getYear() + "\n"
        + "MPAA Rating: " + dvd.getMpaaRating() + "\n"
        + "Director: " + dvd.getDirector() + "\n"
        + "Studio: " + dvd.getStudio() + "\n"
        + "Notes:"
        + c.toString(dvd.getNotes(), "\n\t", true)
        + "\n\n"
      );
    } catch (NullPointerException ex) {
      c.println("Error: no such record exists. Msg = " + ex.getMessage() + "\n");
    }
  }

  public void listAll() {
    String[] keys = dvds.getKeys();

    for (String key : keys) {
      Dvd dvd = dvds.getDvd(key);
      c.print(
        "Title: " + dvd.getTitle() + "\n"
        + "Release Year: " + dvd.getYear() + "\n"
        + "MPAA Rating: " + dvd.getMpaaRating() + "\n"
        + "Director: " + dvd.getDirector() + "\n"
        + "Studio: " + dvd.getStudio() + "\n"
        + "Notes:\t"
        + c.toString(dvd.getNotes(), "\n\t", true)
        + "\n================================================================\n\n"
      );
    }

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
      c.println("Notes:" + c.toString(dvd.getNotes(), "\n\t", true));
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
