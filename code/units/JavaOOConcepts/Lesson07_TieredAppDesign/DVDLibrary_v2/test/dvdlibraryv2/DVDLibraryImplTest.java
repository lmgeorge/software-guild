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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);

		assertThat(impl.getByMpaa("PG"), hasItems(dvd2));
		assertTrue(compareObject(dvd2, impl.getByMpaa("PG").get(0)));
	}

	@Test
	public void testGetByDirectorSorted() {
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
		
		Dvd dvd3 = new Dvd();
		dvd3.setTitle("The Return of the King, Part 1");
		dvd3.setYear(2010);
		dvd3.setMpaaRating("R");
		dvd3.setDirector("Peter Jackson");
		dvd3.setStudio("Lions Gate");
		ArrayList<String> notes3 = new ArrayList<>();
		notes3.add("more testing");
		dvd3.setNotes(notes3);

		Dvd dvd2 = new Dvd();
		dvd2.setTitle("The Nightmare Before Christmas");
		dvd2.setYear(1993);
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);
		
		impl.add(dvd);
		impl.add(dvd3);
		impl.add(dvd2);
		
		assertThat(impl.getByDirectorSorted("Peter Jackson").get("PG-13"), hasItems(dvd));
		assertThat(impl.getByDirectorSorted("Peter Jackson").get("R"), hasItems(dvd3));
	}

	@Test
	public void testGetByStudio() {
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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);

		assertThat(impl.getByStudio("Skellington Productions"), hasItems(dvd2));
		assertTrue(compareObject(dvd, impl.getByStudio("Lions Gate").get(0)));
	}

	@Test
	public void testGetAvgAge() {
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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);

		double avgAge = impl.getAvgAge();
		double avgAgeHard = impl.getAll()
			.stream()
			.mapToDouble(Dvd::getAge)
			.average()
			.getAsDouble();

		assertEquals(avgAgeHard, avgAge, 0);
	}

	@Test
	public void testGetNewest() {
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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);

		Dvd test = impl.getNewest().get(0);

		assertTrue(compareObject(dvd, test));
		assertEquals(dvd.getYear(), test.getYear());
	}

	@Test
	public void testGetOldest() {
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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);

		Dvd test = impl.getOldest().get(0);

		assertTrue(compareObject(dvd2, test));
		assertEquals(dvd2.getYear(), test.getYear());
	}

	@Test
	public void testGetAvgNumNotes() {
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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);
		
		assertEquals(1.5, impl.getAvgNumNotes(),0);
		
		
	}

	@Test
	public void testGetSinceYear() {
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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);

		impl.add(dvd);
		impl.add(dvd2);
		
		assertEquals(1, impl.getSinceYear(1995).size());
		assertThat(impl.getSinceYear(1995), hasItems(dvd));
		
		assertEquals(2, impl.getSinceYear(1990).size());
		assertThat(impl.getSinceYear(1990), hasItems(dvd, dvd2));
	}

	@Test
	public void testGetByKeyword() {
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
		dvd2.setMpaaRating("PG");
		dvd2.setDirector("Henry Selick");
		dvd2.setStudio("Skellington Productions");
		ArrayList<String> notes2 = new ArrayList<>();
		notes2.add("Best movie of all time");
		notes2.add("Perfect musical");
		dvd2.setNotes(notes2);
		
		Dvd dvd3 = new Dvd();
		dvd3.setTitle("The Little Mermaid");
		dvd3.setYear(1989);
		dvd3.setMpaaRating("PG");
		dvd3.setDirector("Ron Clements");
		dvd3.setStudio("Walt Disney Pictures");
		ArrayList<String> notes3 = new ArrayList<>();
		dvd3.setNotes(notes3);

		impl.add(dvd);
		impl.add(dvd2);
		impl.add(dvd3);
		
		List<Dvd> test = impl.getByKeyword("PG");
		assertEquals(2, test.size());
		assertThat(test, hasItems(dvd2, dvd3));
		
		List<Dvd> test2 = impl.getByKeyword("Lions Gate");
		assertEquals(1, test2.size());
		assertThat(test2, hasItems(dvd));
	}


}
