/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class AddressBookImplTest {

  AddressBookImpl impl = new AddressBookImpl();
  AddressBookImpl impl2 = new AddressBookImpl();
  AddressBookImpl impl3 = new AddressBookImpl();

  public AddressBookImplTest() {

  }

  @BeforeClass
  public static void setUpClass() {

  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
    impl.loadAddressBook("addressbook.txt");
    impl2.loadAddressBook("addressbook.txt");
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testLoadAddressBook() {
    impl3.loadAddressBook("test.txt");
    List<Address> bloomberg = impl3.getByLastName("Bloomberg");

    assertEquals("Michael", bloomberg.get(0).getFirstName());
    assertEquals("50 Central Park Ave", bloomberg.get(0).getStreet());
    assertEquals("10029", bloomberg.get(0).getZip());

  }

  @Test
  public void testWriteAddressBook() {
    impl3.loadAddressBook("test.txt");

    Address trump = new Address();
    trump.setFirstName("Donald");
    trump.setLastName("Trump");
    trump.setStreet("130 Trump Towers");
    trump.setCity("New York");
    trump.setState("NY");
    trump.setZip("10015");
    impl3.add(trump);

    impl3.writeAddressBook("test.txt");
    impl3.loadAddressBook("test.txt");
    List<Address> trumpList = impl3.getByLastName("Trump");

    assertEquals("Donald", trumpList.get(0).getFirstName());
    assertEquals("130 Trump Towers", trumpList.get(0).getStreet());
    assertEquals("10015", trumpList.get(0).getZip());
  }

  @Test
  public void testGetByLastName() {

    Address danteGeorge = impl.getByZipcode("28102").get(0);
    Address laurenGeorge = impl.getByZipcode("22902").get(0);

    assertThat(impl.getByLastName("George"), hasItems(danteGeorge, laurenGeorge));
  }

  @Test
  public void testGetByCity() {
    List<Address> city = impl.getByCity("Akron");
    assertThat(impl.getByCity("Akron"), hasItems(city.get(0)));

  }

  @Test
  public void testGetByState() {
    Map<String, List<Address>> state = impl.getByState("OH");
    assertThat(impl.getByState("OH").get("Akron"), hasItems(state.get("Akron").get(0)));
  }

  @Test
  public void testGetByZipcode() {
    List<Address> zipcode = impl.getByZipcode("78945");
    assertThat(impl.getByZipcode("78945"), hasItems(zipcode.get(0)));
  }

  @Test
  public void testGetAllAddresses() {
    Address danteGeorge = impl.getByZipcode("28102").get(0);
    Address danteGeorge2 = impl2.getByZipcode("28102").get(0);

    assertEquals(danteGeorge.getZip(), danteGeorge2.getZip());
    assertEquals(impl2.count(), impl.count());

  }

  @Test
  public void testCount() {
    assertEquals(impl.getAllAddresses().size(), impl.count());
  }

  @Test
  public void testAdd() {
    Address bloomberg = new Address();
    bloomberg.setFirstName("Michael");
    bloomberg.setLastName("Bloomberg");
    bloomberg.setStreet("50 Central Park Ave");
    bloomberg.setCity("New York");
    bloomberg.setState("NY");
    bloomberg.setZip("10029");

    Address trump = new Address();
    trump.setFirstName("Donald");
    trump.setLastName("Trump");
    trump.setStreet("130 Trump Towers");
    trump.setCity("New York");
    trump.setState("NY");
    trump.setZip("10015");

    impl3.add(bloomberg);
    impl3.add(trump);

    assertThat(impl3.getByLastName("Bloomberg"), hasItems(bloomberg));
    assertThat(impl3.getByLastName("Trump"), hasItems(trump));
  }

  @Test
  public void testRemove() {
    Address bloomberg = new Address();
    bloomberg.setFirstName("Michael");
    bloomberg.setLastName("Bloomberg");
    bloomberg.setStreet("50 Central Park Ave");
    bloomberg.setCity("New York");
    bloomberg.setState("NY");
    bloomberg.setZip("10029");

    Address trump = new Address();
    trump.setFirstName("Donald");
    trump.setLastName("Trump");
    trump.setStreet("130 Trump Towers");
    trump.setCity("New York");
    trump.setState("NY");
    trump.setZip("10015");

    impl3.add(bloomberg);
    impl3.add(trump);

    impl3.remove(bloomberg);
    assertFalse(impl3.getAllAddresses().contains(bloomberg));
    assertTrue(impl3.getAllAddresses().contains(trump));
  }

}
