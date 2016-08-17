/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package addressbook;

import java.util.List;
import java.util.Map;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface AddressBook {
  public List<Address> getAllAddresses();
  public List<Address> getByLastName(String lastName);
  public List<Address> getByCity(String city);
  public Map<String, List<Address>> getByState(String state);
  public List<Address> getByZipcode(String zipcode);
  public void loadAddressBook(String fileName);
  public void writeAddressBook(String fileName);
  public int count();
  public void add(Address address);
  public void remove(Address address);
}
