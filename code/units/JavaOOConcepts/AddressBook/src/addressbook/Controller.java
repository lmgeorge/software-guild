
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Controller {

  private ConsoleIO2 cio = new ConsoleIO2();
  private AddressBook book = new AddressBook();

  public void runAddressBook() {
    try {
      book.loadAddressBook();
    } catch (FileNotFoundException ex) {
      cio.println("ERROR: " + ex.getMessage());
      //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
    }

    menu();

  }

  private void menu(){
    int selection = 0;
    cio.println("\nMain Menu:");
    cio.println("\n\t1.Add Address"
      + "\n\t2.Delete Address"
      + "\n\t3.Find Address"
      + "\n\t4.List Address Count"
      + "\n\t5.List All Addresses"
      + "\n\t6.Exit\n");
    while (selection < 1 || selection > 6) {
      cio.print("Please select an operation: ");
      selection = cio.getsNum();
      cio.println();
    }
    switch (selection) {
      case 1:
        addAddress();
        break;
      case 2:
        delete();
        break;
      case 3:
        find();
        break;
      case 4:
        cio.println("Total addresses: " + book.count() + " address records");
        menu();
        break;
      case 5:
        displayAll();
        break;
      case 6:
        break;
      default:
        break;
    }

  }  // close menu

  private void addAddress() {
    Address newAddress = new Address();
    String check;
    cio.print("ADD ADDRESS:\n");
    newAddress.setFirstName(cio.get("\tFirst Name: "));
    check = cio.get("\tLast Name: ");
    newAddress.setLastName(check);
    newAddress.setStreet(cio.get("\tStreet Address: "));
    newAddress.setCity(cio.get("\tCity: "));
    newAddress.setState(cio.get("\tState: "));
    newAddress.setZip(cio.get("\tZIP code: "));
    
    if (book.checkKey(check)){
      cio.println("Are you sure you want to change this address?");
      try {
      Address temp = book.getAddress(check);

      cio.println("First Name: " + temp.getFirstName());
      cio.println("Last Name: " + temp.getLastName());
      cio.println("Street: " + temp.getStreet());
      cio.println("City: " + temp.getCity());
      cio.println("State: " + temp.getState());
      cio.println("Zipcode: " + temp.getZip());
    } catch (NullPointerException np) {
      cio.println("ERROR: " + np.getMessage());
    }
      String answer = cio.get("y/n? ");
      if (answer.equalsIgnoreCase("n")){
        menu();
      }
    }
    
    book.add(newAddress);

    try {
      book.writeAddressBook();
    } catch (IOException ex) {
      cio.println("ERROR: " + ex.getMessage());
      //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      menu();
    } catch (Exception ex) {
      cio.println("ERROR: " + ex.getMessage());
    }
  }

  private void find() {
    cio.println("FIND ADDRESS:\n");
    String record = cio.get("Please enter a last name: ");
    Address temp;
    try {
      temp = book.getAddress(record);

      cio.println("First Name: " + temp.getFirstName());
      cio.println("Last Name: " + temp.getLastName());
      cio.println("Street: " + temp.getStreet());
      cio.println("City: " + temp.getCity());
      cio.println("State: " + temp.getState());
      cio.println("Zipcode: " + temp.getZip());
    } catch (NullPointerException np) {
      cio.println("ERROR: " + np.getMessage());
    }
    try {
      menu();
    } catch (Exception ex) {
      cio.println("ERROR: " + ex.getMessage());
      //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void displayAll() {
    String[] keys = book.getKeys();
    
    for (int i = 0; i < keys.length; i++) {
      String record = keys[i];
      Address temp = book.getAddress(record);
      cio.println("First Name: " + temp.getFirstName());
      cio.println("Last Name: " + temp.getLastName());
      cio.println("Street: " + temp.getStreet());
      cio.println("City: " + temp.getCity());
      cio.println("State: " + temp.getState());
      cio.println("Zipcode: " + temp.getZip());
      cio.println("==========================");
      cio.println();
    }

    menu();

  }

  private void delete() {
    Address delete = new Address();
    cio.print("DELETE ADDRESS:\n");
    String recordKey = cio.get("Please enter a last name: ");
    cio.println();

    Address temp;
    try {
      temp = book.getAddress(recordKey);
      cio.println("First Name: " + temp.getFirstName());
      cio.println("Last Name: " + temp.getLastName());
      cio.println("Street: " + temp.getStreet());
      cio.println("City: " + temp.getCity());
      cio.println("State: " + temp.getState());
      cio.println("Zipcode: " + temp.getZip());
      cio.println();
      String answer = cio.get("Are you sure? (y/n) ");
      if (answer.equalsIgnoreCase("y")) {
        book.remove(recordKey);
      }

      book.writeAddressBook();
    } catch (NullPointerException np) {
      cio.println("ERROR: " + np.getMessage());
    } catch (IOException ex) {
      cio.println("ERROR: " + ex.getMessage());
      //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
      menu();
    } catch (Exception ex) {
      cio.println("ERROR: " + ex.getMessage());
      //Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

}
