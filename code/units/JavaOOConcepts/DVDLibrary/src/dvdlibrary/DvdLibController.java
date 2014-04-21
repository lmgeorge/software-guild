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
    String currentKey = key;
    Dvd dvd = dvds.getDvd(currentKey);

    String tempVal;
    String confirm;
    int tempYear;
    find(currentKey);
    do {
      int ui = c.getsNum(
        "\n\t1. Edit Title"
        + "\n\t2. Edit Release Year"
        + "\n\t3. Edit MPAA Rating"
        + "\n\t4. Edit Director"
        + "\n\t5. Edit Studio"
        + "\n\t6. Edit Notes"
        + "\n\t7. Cancel"
        + "\n\nPlease enter your choice: ");
      //what would you like to edit? (switch)
      switch (ui) {
        case 1:
          tempVal = c.gets("Enter new title: ");
          c.println("Old title: " + dvd.getTitle());
          confirm = c.gets("Confirm change (y/n): ");
          if (confirm.equalsIgnoreCase("y")) {
            dvd.setTitle(tempVal);
            currentKey = tempVal;
          } else {
            c.println("No changes made.\n");
          }

          break;
        case 2:
          tempYear = c.getsNum("Enter new release year: ");
          c.println("Old release year: " + dvd.getYear());
          confirm = c.gets("Confirm change (y/n): ");
          if (confirm.equalsIgnoreCase("y")) {
            dvd.setYear(tempYear);
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
          //coding
          break;
        case 7:
          c.println("Cancelled.");
          break;
        default:
          break;
      }
      //show changes
      c.println("Updated record:");
      find(currentKey);
      confirm = c.gets("Would you like to continue editing (y/n)? ");
    } while (confirm.equalsIgnoreCase("y"));

    //save? 
    try {
      dvds.writeDvdLib("dvds.txt");
    } catch (IOException ex) {
      Logger.getLogger(DvdLibController.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

  public void find(String key) {
    Dvd dvd = dvds.getDvd(key);
    c.println(
      "\nTitle: " + dvd.getTitle() + "\n"
      + "Release Year: " + dvd.getYear() + "\n"
      + "MPAA Rating: " + dvd.getMpaaRating() + "\n"
      + "Director: " + dvd.getDirector() + "\n"
      + "Studio: " + dvd.getStudio() + "\n"
      + "Notes:"
      + c.toString(dvd.getNotes(), "\n\t")
      + "\n\n"
    );

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
        + c.toString(dvd.getNotes(), "\n\t")
        + "\n================================================================\n\n"
      );
    }

  }

  public ArrayList<String> addNotes() {
    String answer;
    int counter = 1;
    ArrayList<String> notes = new ArrayList<>();
    do {
      String note = c.gets("Note: ");
      notes.add("Note " + counter + ": " + note);
      c.println();

      answer = c.gets("Would you like to add another note? (y/n):  ");
      c.println();
      counter++;

    } while (answer.equalsIgnoreCase("y"));
    return notes;
  }

  public void deleteNotes(String key) {
    Dvd dvd = dvds.getDvd(key);
    String choice;
    ArrayList<String> notes = dvd.getNotes();
    c.println("Old notes:" + c.toString(dvd.getNotes(), "\n\t"));
    choice = c.gets("Enter the note numbers you want to delete, separated by a comma, or 'all':\n ");
    if (choice.contains("all")) {
      if (c.gets("Are sure you want to permanently delete all notes (y/n)? ").equalsIgnoreCase("y")) {
        notes.clear();
      } else {
        c.println("Operation successfully quit.");
      }
    }

    String[] choices = choice.split(",");
  }
}
