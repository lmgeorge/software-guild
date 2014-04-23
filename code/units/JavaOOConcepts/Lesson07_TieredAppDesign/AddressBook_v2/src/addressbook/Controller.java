
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Controller {

  private ConsoleIO cio = new ConsoleIOImpl();
  private AddressBook book = new AddressBookImpl();

  public void runAddressBook() {
    book.loadAddressBook();

    menu();

  }

  private void menu() {
    int selection = 0;
    cio.println("\nMain Menu:");
    cio.println("\n\t1.Add Address"
      + "\n\t2.Delete Address"
      + "\n\t3.Find Address"
      + "\n\t4.List Address Count"
      + "\n\t5.List All Addresses"
      + "\n\t6.Exit\n");
    selection = cio.getsNum("Please select an operation: ", 1, 6);
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
        find();
        menu();
        break;
      case 4:
        cio.println("Total addresses: " + book.count() + " address records");
        menu();
        break;
      case 5:
        displayAll();
        menu();
        break;
      case 6:
        break;
      default:
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

    book.writeAddressBook();

  }

  private void find() {
    
    String record = cio.gets("Please enter a last name: ");
    List<Address> temp;
    try {
      temp = book.getByLastName(record);

      temp
        .stream()
        .forEach(a -> {
          cio.println("\nFirst Name: " + a.getFirstName());
          cio.println("Last Name: " + a.getLastName());
          cio.println("Street: " + a.getStreet());
          cio.println("City: " + a.getCity());
          cio.println("State: " + a.getState());
          cio.println("Zipcode: " + a.getZip());
          cio.println();
        });

    } catch (NullPointerException np) {
      cio.println("ERROR: " + np.getMessage());
    }
  }

  private void displayAll() {
    book.getAllAddresses()
      .stream()
      .forEach(a -> {
        cio.println("First Name: " + a.getFirstName());
        cio.println("Last Name: " + a.getLastName());
        cio.println("Street: " + a.getStreet());
        cio.println("City: " + a.getCity());
        cio.println("State: " + a.getState());
        cio.println("Zipcode: " + a.getZip());
        cio.println("==========================\n");
      });

  }

  private void delete() {
    Address delete;
    
    String recordKey = cio.gets("Please enter a last name: ");
    cio.println();
    List<Address> temp;

    temp = book.getByLastName(recordKey);
    try {
      temp
        .stream()
        .forEach(a -> {
          cio.println("Address " + (temp.indexOf(a) + 1) + ":");
          cio.println("\tFirst Name: " + a.getFirstName());
          cio.println("\tLast Name: " + a.getLastName());
          cio.println("\tStreet: " + a.getStreet());
          cio.println("\tCity: " + a.getCity());
          cio.println("\tState: " + a.getState());
          cio.println("\tZipcode: " + a.getZip());
          cio.println();
        });
      int choice = cio.getsNum("Enter selection: ", 0, temp.size());
      delete = temp.get(choice-1);

      String answer = cio.gets("Are you sure? (y/n) ");
      if (answer.equalsIgnoreCase("y")) {
        int index = book.getAllAddresses().indexOf(delete);
        book.remove(index);
      }

      book.writeAddressBook();
    } catch (NullPointerException np) {
      cio.println("ERROR: " + np.getMessage());
    }

  }

}
