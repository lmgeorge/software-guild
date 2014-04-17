/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Controller {

  ConsoleIO cio = new ConsoleIO();
  AddressBook book = new AddressBook();

  public void runAddressBook() throws Exception {
    book.loadAddressBook();

    menu();

  }

  private void menu() throws Exception {
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

  private void addAddress() throws Exception {
    Address newAddress = new Address();
    cio.print("ADD ADDRESS:\n");
    newAddress.setFirstName(cio.get("\tFirst Name: "));
    newAddress.setLastName(cio.get("\tLast Name: "));
    newAddress.setStreet(cio.get("\tStreet Address: "));
    newAddress.setCity(cio.get("\tCity: "));
    newAddress.setState(cio.get("\tState: "));
    newAddress.setZip(cio.get("\tZIP code: "));

    book.add(newAddress);

    book.writeAddressBook();
    menu();
  }

  private void find() throws Exception {
    cio.println("FIND ADDRESS:\n");
    String record = cio.get("Please enter a last name: ");
    Address temp = book.getAddress(record);
    cio.println("First Name: " + temp.getFirstName());
    cio.println("Last Name: " + temp.getLastName());
    cio.println("Street: " + temp.getStreet());
    cio.println("City: " + temp.getCity());
    cio.println("State: " + temp.getState());
    cio.println("Zipcode: " + temp.getZip());
    menu();
  }

  private void displayAll() throws Exception {
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

  private void delete() throws Exception {
    Address delete = new Address();
    cio.print("DELETE ADDRESS:\n");
    String recordKey = cio.get("Please enter a last name: ");
    cio.println();
    
    Address temp = book.getAddress(recordKey);
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
    menu();
  }

}
