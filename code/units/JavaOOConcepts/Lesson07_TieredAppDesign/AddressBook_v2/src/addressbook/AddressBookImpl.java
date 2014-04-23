/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class AddressBookImpl implements AddressBook {

  public static final String BOOK_FILE = "addressbook.txt";
  public static final String DELIMITER = "::";
  private List<Address> list = new ArrayList<>();

  @Override
  public List<Address> getByLastName(String lastName) {
    return list
      .stream()
      .filter(a -> a.getLastName().equalsIgnoreCase(lastName))
      .collect(Collectors.toList());

  }

  @Override
  public List<Address> getByCity(String city) {
    return list
      .stream()
      .filter(a -> a.getCity().equalsIgnoreCase(city))
      .collect(Collectors.toList());
  }

  @Override
  public Map<String, List<Address>> getByState(String state) {
    return list
      .stream()
      .filter(a -> a.getState().equalsIgnoreCase(state))
      .collect(Collectors.groupingBy(Address::getCity));
  }

  @Override
  public List<Address> getByZipcode(String zipcode) {
    return list
      .stream()
      .filter(a -> a.getZip().equalsIgnoreCase(zipcode))
      .collect(Collectors.toList());
  }

  public List<Address> getAllAddresses() {
    return list
      .stream()
      .collect(Collectors.toList());
  }

  public int count() {
    return list.size();
  }

  public void add(Address address) {
    list.add(address);

  }

  public void remove(int index) {
    list.remove(index);
  }

  public void writeAddressBook() {

    PrintWriter out;
    try {
      out = new PrintWriter(new FileWriter(BOOK_FILE));

      list
        .stream()
        .forEach(a
          -> {
          out.println(
            a.getFirstName() + DELIMITER
            + a.getLastName() + DELIMITER
            + a.getStreet() + DELIMITER
            + a.getCity() + DELIMITER
            + a.getState() + DELIMITER
            + a.getZip());
          out.flush();
        });
      out.close();
    } catch (IOException ex) {
      Logger.getLogger(AddressBookImpl.class.getName()).log(Level.FINER, null, ex);
    } catch (NullPointerException ex) {
      Logger.getLogger(AddressBookImpl.class.getName()).log(Level.FINEST, null, ex);
    }

  }

  public void loadAddressBook() {
    try {
      Scanner reader = new Scanner(new BufferedReader(new FileReader(BOOK_FILE)));
      String currentLine;
      String[] addressarray;

      while (reader.hasNextLine()) {
        currentLine = reader.nextLine();
        addressarray = currentLine.split(DELIMITER);

        Address currentAddress = new Address();
        currentAddress.setFirstName(addressarray[0]);
        currentAddress.setLastName(addressarray[1]);
        currentAddress.setStreet(addressarray[2]);
        currentAddress.setCity(addressarray[3]);
        currentAddress.setState(addressarray[4]);
        currentAddress.setZip(addressarray[5]);

        list.add(currentAddress);
      }

      reader.close();
    } catch (FileNotFoundException ex) {
      Logger.getLogger(AddressBookImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
