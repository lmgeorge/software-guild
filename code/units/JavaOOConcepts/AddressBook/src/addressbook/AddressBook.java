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
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class AddressBook {

  public static final String BOOK_FILE = "addressbook.txt";
  public static final String DELIMITER = "::";

  private HashMap<String, Address> addressMap = new HashMap<>();

  public int count() {
    return addressMap.size();
  }

  public boolean checkKey(String lastName) {
    
    return getAddress(lastName) != null;
  }
  
  public Address getAddress(String lastName) {
    return addressMap.get(lastName);
  }

  public String[] getKeys() {
    return addressMap.keySet().toArray(new String[0]);
  }

  public void add(Address address) {
    addressMap.put(address.getLastName(), address);
  }

  public void remove(String key) {
    addressMap.remove(key);
  }

  public void writeAddressBook() throws IOException {
    PrintWriter out = new PrintWriter(new FileWriter(BOOK_FILE));

    Collection<Address> vals = addressMap.values();
    Iterator<Address> iter = vals.iterator();
    while (iter.hasNext()) {
      Address currentAddress = iter.next();
      out.println(currentAddress.getLastName() + DELIMITER
        + currentAddress.getFirstName() + DELIMITER
        + currentAddress.getStreet() + DELIMITER
        + currentAddress.getCity() + DELIMITER
        + currentAddress.getState() + DELIMITER
        + currentAddress.getZip());
      out.flush();
    }
    out.close();
  }

  public void loadAddressBook() throws FileNotFoundException {
    Scanner reader = new Scanner(new BufferedReader(new FileReader(BOOK_FILE)));
    String currentLine;
    String[] addressarray;

    while (reader.hasNextLine()) {
      currentLine = reader.nextLine();
      addressarray = currentLine.split(DELIMITER);

      Address currentAddress = new Address();
      currentAddress.setLastName(addressarray[0]);
      currentAddress.setFirstName(addressarray[1]);
      currentAddress.setStreet(addressarray[2]);
      currentAddress.setCity(addressarray[3]);
      currentAddress.setState(addressarray[4]);
      currentAddress.setZip(addressarray[5]);

      addressMap.put(currentAddress.getLastName(), currentAddress);
    }
    reader.close();
  }
}
