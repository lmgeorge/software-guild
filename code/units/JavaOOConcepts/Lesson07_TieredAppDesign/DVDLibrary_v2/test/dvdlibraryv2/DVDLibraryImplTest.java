/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibraryv2;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DVDLibraryImplTest extends DVDLibraryImpl {

  DVDLibraryImpl impl = new DVDLibraryImpl();
  DVDLibraryImpl impl2 = new DVDLibraryImpl();
  DVDLibraryImpl impl3 = new DVDLibraryImpl();
  DVDLibraryImpl impl4 = new DVDLibraryImpl();
  DVDLibraryImpl impl5 = new DVDLibraryImpl();
  List<Dvd> dvds = new ArrayList<>();
  List<Dvd> dvds2 = new ArrayList<>();
  List<Dvd> dvds3 = new ArrayList<>();
  List<Dvd> dvds4 = new ArrayList<>();

  public DVDLibraryImplTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void testGetAll() {
    impl.getAll().clear();
    
    Dvd dvd = new Dvd();
    dvd.setTitle("The Return of the King, Part 2");
    dvd.setYear(2013);
    dvd.setMpaaRating("PG-13");
    dvd.setDirector("Peter Jackson");
    dvd.setStudio("Lions Gate");
    ArrayList<String> notes = new ArrayList<>();
    notes.add("stuff for testing");
    dvd.setNotes(notes);
    
    Dvd dvd2 = new Dvd();
    dvd2.setTitle("The Nightmare Before Christmas");
    dvd2.setYear(1993);
    dvd2.setMpaaRating("PG-13");
    dvd2.setDirector("Henry Selick");
    dvd2.setStudio("Skellington Productions");
    ArrayList<String> notes2 = new ArrayList<>();
    notes2.add("Best movie of all time");
    notes2.add("Perfect musical");
    dvd2.setNotes(notes2);
    
    impl.add(dvd);
    impl.add(dvd2);
    int index = impl.getAll().indexOf(dvd);
    assertEquals(2, impl.getAll().size());
    assertThat(impl.getAll(), hasItems(dvd, dvd2));
    assertEquals(dvd.getDirector(), impl.getAll().get(index).getDirector());
  }

  @Test
  public void testLoadDvds() {
    impl.loadDvds("dvds.txt");
    dvds = impl.getAll();

    assertEquals(9, dvds.size());
    assertThat(dvds, hasItems(impl.getByStudio("Jim Henson Productions").get(0)));
    assertThat(dvds, hasItems(impl.getByTitle("The Hobbit").get(0)));
    assertThat(dvds, hasItems(impl.getByMpaa("R").get(0)));

  }

  @Test
  public void testWriteDvdLib() {
    impl2.getAll().clear();
    Dvd dvd = new Dvd();
    dvd.setTitle("The Return of the King, Part 2");
    dvd.setYear(2013);
    dvd.setMpaaRating("PG-13");
    dvd.setDirector("Peter Jackson");
    dvd.setStudio("Lions Gate");

    ArrayList<String> notes = new ArrayList<>();
    notes.add("stuff for testing");
    dvd.setNotes(notes);

    impl2.add(dvd);

    impl2.writeDvdLib("test.txt");
    impl2.loadDvds("test.txt");

    dvds2 = impl2.getAll();
    assertThat(dvds2, hasItems(impl2.getByTitle("The Return of the King, Part 2").get(0)));
  }

  @Test
  public void testToStringWithIndex_Dvd() {
  }

  @Test
  public void testToString_Dvd() {
  }

  @Test
  public void testToString_ArrayList_String() {
  }

  @Test
  public void testToStringWithIndex_4args() {
  }

  @Test
  public void testAdd() {
  }

  @Test
  public void testRemove() {
  }

  @Test
  public void testGetByTitle() {
  }

  @Test
  public void testNumDvds() {
  }

  @Test
  public void testGetByMpaa() {
  }

  @Test
  public void testGetByDirectorSorted() {
  }

  @Test
  public void testListByDirector() {
  }

  @Test
  public void testGetByStudio() {
  }

  @Test
  public void testGetAvgAge() {
  }

  @Test
  public void testGetNewest() {
  }

  @Test
  public void testGetOldest() {
  }

  @Test
  public void testGetAvgNumNotes() {
  }

  @Test
  public void testGetSinceYear() {
  }

  @Test
  public void testGetByKeyword() {
  }

}
