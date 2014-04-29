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
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;
import static org.junit.internal.matchers.IsCollectionContaining.hasItems;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DVDLibraryImplTest extends DVDLibraryImpl {

	public boolean compareObject(Dvd dvd1, Dvd dvd2) {
		return dvd1.getTitle().equals(dvd2.getTitle())
			&& dvd1.getDirector().equals(dvd2.getDirector())
			&& dvd1.getMpaaRating().equals(dvd2.getMpaaRating())
			&& dvd1.getStudio().equals(dvd2.getStudio())
			&& dvd1.getYear() == dvd2.getYear()
			&& dvd1.getNotes().equals(dvd2.getNotes());
	}

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
	public void testAdd() {
		DVDLibrary impl = new DVDLibraryImpl();
		DVDLibrary impl2 = new DVDLibraryImpl();

		Dvd dvd = new Dvd();
		dvd.setTitle("The Return of the King, Part 2");
		dvd.setYear(2013);
		dvd.setMpaaRating("PG-13");
		dvd.setDirector("Peter Jackson");
		dvd.setStudio("Lions Gate");
		ArrayList<String> notes = new ArrayList<>();
		notes.add("stuff for testing");
		dvd.setNotes(notes);

		impl.add(dvd);

		Dvd dvd2 = new Dvd();
		dvd2.setTitle("The Return of the King, Part 2");
		dvd2.setYear(2013);
		dvd2.setMpaaRating("PG-13");
		dvd2.setDirector("Peter Jackson");
		dvd2.setStudio("Lions Gate");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("stuff for testing");
		dvd2.setNotes(notes2);

		impl2.add(dvd2);

		assertTrue(compareObject(dvd, dvd2));
		assertTrue(compareObject(impl.getAll().get(0), impl2.getAll().get(0)));

	}

	@Test
	public void testGetAll() {
		DVDLibrary impl = new DVDLibraryImpl();

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
		DVDLibrary impl = new DVDLibraryImpl();
		List<Dvd> dvds;

		impl.loadDvds("dvds.txt");
		dvds = impl.getAll();

		assertEquals(9, dvds.size());
		assertThat(dvds, hasItems(impl.getByStudio("Jim Henson Productions").get(0)));
		assertThat(dvds, hasItems(impl.getByTitle("The Hobbit").get(0)));
		assertThat(dvds, hasItems(impl.getByMpaa("R").get(0)));

	}

	@Test
	public void testWriteDvdLib() {
		DVDLibrary impl = new DVDLibraryImpl();
		List<Dvd> dvds;

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

		impl.add(dvd);

		impl.writeDvdLib("test.txt");
		impl.loadDvds("test.txt");

		dvds = impl.getAll();
		assertThat(dvds, hasItems(impl.getByTitle("The Return of the King, Part 2").get(0)));
		assertTrue(compareObject(dvd, impl.getAll().get(0)));
	}

	@Test
	public void testRemove() {
		DVDLibrary impl = new DVDLibraryImpl();
		List<Dvd> dvds;

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
		dvd2.setTitle("The Return of the King, Part 2");
		dvd2.setYear(2013);
		dvd2.setMpaaRating("PG-13");
		dvd2.setDirector("Peter Jackson");
		dvd2.setStudio("Lions Gate");

		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("stuff for testing");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);

		assertThat(impl.getAll(), hasItems(dvd, dvd2));
		assertTrue(compareObject(dvd, dvd2));
		
		Dvd dvd3 = dvd;
		
		impl.remove(dvd);
		dvd = dvd2;

		impl.add(dvd);
		Dvd testDvd = impl.getAll().get(impl.getAll().indexOf(dvd));
		Dvd testDvd2 = impl.getAll().get(impl.getAll().indexOf(dvd2));
		
		assertNotSame(dvd3, testDvd);
		assertSame(testDvd, testDvd2);

	}

	@Test
	public void testGetByTitle() {
		DVDLibrary impl = new DVDLibraryImpl();
		
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
		
		assertThat(impl.getByTitle("The Nightmare Before Christmas"), hasItems(dvd2));
		assertTrue(compareObject(dvd2, impl.getByTitle("The Nightmare Before Christmas").get(0)));
	}
	
	
	@Test
	public void testNumDvds() {
		DVDLibrary impl = new DVDLibraryImpl();
		
		impl.loadDvds("dvds.txt");
		
		assertEquals(impl.getAll().size(), impl.numDvds());
	}

	@Test
	public void testGetByMpaa() {
		DVDLibrary impl = new DVDLibraryImpl();
		impl.loadDvds("dvds.txt");
		
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


}
