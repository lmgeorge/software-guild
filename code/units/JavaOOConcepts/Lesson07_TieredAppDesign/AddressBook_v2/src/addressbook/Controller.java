
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Controller {

  private final ConsoleIO cio = new ConsoleIOImpl();
  private final AddressBook book = new AddressBookImpl();

  public void runAddressBook() {
    book.loadAddressBook(cio.gets("Please enter a file to open: "));

    menu();

  }

  private void menu() {
    int selection;
    cio.println("\nMain Menu:");
    cio.println("\n\t1.Add Address"
      + "\n\t2.Delete Address"
      + "\n\t3.Find Address"
      + "\n\t4.List Address Count"
      + "\n\t5.List All Addresses"
      + "\n\t0.Exit\n");

    selection = cio.getsNum("Please select an operation: ", 0, 5);
    cio.println();

    switch (selection) {
      case 1:
        cio.print("ADD ADDRESS:\n");
        addAddress();
        menu();
        break;
      case 2:
        cio.print("DELETE ADDRESS:\n");
        delete();
        menu();
        break;
      case 3:
        cio.println("FIND ADDRESS:\n");
        findBy();
        menu();
        break;
      case 4:
        cio.println("Total addresses: " + book.count() + " address records");
        menu();
        break;
      case 5:
        displayAll(book.getAllAddresses());
        menu();
        break;
      case 0:
        cio.println("\nSaved. Thank you!");
        break;
    }
  }

  private void addAddress() {
    Address newAddress = new Address();

    newAddress.setFirstName(cio.gets("\tFirst Name: "));
    newAddress.setLastName(cio.gets("\tLast Name: "));
    newAddress.setStreet(cio.gets("\tStreet Address: "));
    newAddress.setCity(cio.gets("\tCity: "));
    newAddress.setState(cio.gets("\tState: "));
    newAddress.setZip(cio.gets("\tZIP code: "));
    book.add(newAddress);

    book.writeAddressBook(cio.gets("\nPlease enter file to save to: "));

  }

  private List<Address> findBy() {
    List<Address> list = new ArrayList<>();
    int choice = cio.getsNum(
      "\n\t1. Search by Last Name"
      + "\n\t2. Search by City"
      + "\n\t3. Search by State"
      + "\n\t4. Search by Zipcode"
      + "\n\t0. Main menu"
      + "\n\nPlease enter your choice: ", 0, 4);
    String search;
    switch (choice) {
      case 1:
        search = cio.gets("\n\tSEARCH BY LAST NAME"
          + "\n\nPlease enter your choice: ");
        list = book.getByLastName(search);
        displayAll(list);
        break;
      case 2:
        search = cio.gets("\n\nSEARCH BY CITY"
          + "\n\nPlease enter your choice: ");
        list = book.getByCity(search);
        displayAll(list);
        break;
      case 3:
        search = cio.gets("\n\nSEARCH BY STATE"
          + "\n\nPlease enter your choice (ex. New York -> NY): ");
        list = getByState(search);
        break;
      case 4:
        search = cio.gets("\n\nSEARCH BY ZIPCODE"
          + "\n\nPlease enter your choice: ");
        list = book.getByZipcode(search);
        displayAll(list);
        break;
      case 0:
        menu();
        break;
    }
    return list;
  }

  private List<Address> getByState(String state) {
    List<Address> allMatches = new ArrayList<>();
    book.getByState(state)
      .values()
      .stream()
      .forEach(list -> {
        list
        .stream()
        .forEach(a -> {
          allMatches.add(a);
        });
      });
    displayAll(allMatches);
    return allMatches;
  }

  private void displayAll(List<Address> list) {
    list
      .stream()
      .forEach(a -> {
        cio.println("\nAddress " + (list.indexOf(a) + 1));
        cio.println("\tFirst Name: " + a.getFirstName());
        cio.println("\tLast Name: " + a.getLastName());
        cio.println("\tStreet: " + a.getStreet());
        cio.println("\tCity: " + a.getCity());
        cio.println("\tState: " + a.getState());
        cio.println("\tZipcode: " + a.getZip());
        cio.println("==========================\n");
      });
  }

  private void delete() {
    Address delete;
    List<Address> temp;
    temp = findBy();
    try {
      if (temp.size() > 1) {
        int choice = cio.getsNum("Enter selection: ", 0, temp.size());
        delete = temp.get(choice - 1);
      } else {
        delete = temp.get(0);
      }

      String answer = cio.gets("Are you sure? (y/n) ");
      if (answer.equalsIgnoreCase("y")) {
        book.remove(delete);
      }

      book.writeAddressBook(cio.gets("\nPlease enter file to save to: "));
    } catch (NullPointerException np) {
      cio.println("ERROR: " + np.getMessage());
    }

  }

}
