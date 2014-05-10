/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.dao.DvdLibraryDaoImpl;
import com.swcguild.dvdlibrary.model.Dvd;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static org.hamcrest.CoreMatchers.hasItems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DvdLibraryDaoImplTest {

	private DvdLibraryDao impl;
	private DvdLibraryDao impl2;

	private Dvd king1 = new Dvd();
	private Dvd king2 = new Dvd();
	private Dvd xmas = new Dvd();
	private Dvd mermaid = new Dvd();
	private Dvd mermaidCopy = new Dvd();

	private int counter;
	private boolean bool = false;

	public DvdLibraryDaoImplTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {

	}

	@Before
	public void setUp() {
		ApplicationContext ctx
			= new ClassPathXmlApplicationContext("test-applicationContext.xml");

		impl = (DvdLibraryDao) ctx.getBean("dao");

		ApplicationContext ctx2
			= new ClassPathXmlApplicationContext("test-applicationContext.xml");
		impl2 = (DvdLibraryDao) ctx2.getBean("dao");

		king1.setTitle("The Return of the King, Part 1");
		LocalDate date1 = IsoChronology.INSTANCE.date(2010, 5, 20);
		king1.setReleaseDate(date1);
		king1.setMpaaRating("R");
		king1.setDirector("Peter Jackson");
		king1.setStudio("Lions Gate");
		king1.setNote("more testing");

		king2.setTitle("The Return of the King, Part 2");
		LocalDate date2 = IsoChronology.INSTANCE.date(2013, 12, 25);
		king2.setReleaseDate(date2);
		king2.setMpaaRating("PG-13");
		king2.setDirector("Peter Jackson");
		king2.setStudio("Lions Gate");
		king2.setNote("stuff for testing");

		xmas.setTitle("The Nightmare Before Christmas");
		LocalDate date3 = IsoChronology.INSTANCE.date(1993, 10, 31);
		xmas.setReleaseDate(date3);
		xmas.setMpaaRating("PG");
		xmas.setDirector("Henry Selick");
		xmas.setStudio("Skellington Productions");
		xmas.setNote("Perfect musical");

		mermaid.setTitle("The Little Mermaid");
		LocalDate date4 = IsoChronology.INSTANCE.date(1989, 2, 11);
		mermaid.setReleaseDate(date4);
		mermaid.setMpaaRating("PG");
		mermaid.setDirector("Ron Clements");
		mermaid.setStudio("Walt Disney Pictures");
		mermaid.setNote("");

		mermaidCopy.setTitle("The Little Mermaid");
		LocalDate date5 = IsoChronology.INSTANCE.date(1989, 2, 11);
		mermaidCopy.setReleaseDate(date5);
		mermaidCopy.setMpaaRating("PG");
		mermaidCopy.setDirector("Ron Clements");
		mermaidCopy.setStudio("Walt Disney Pictures");
		mermaidCopy.setNote("");
	}

	@After
	public void tearDown() {
		king1 = new Dvd();
		king2 = new Dvd();
		xmas = new Dvd();
		mermaid = new Dvd();
		mermaidCopy = new Dvd();
		counter = 0;
	}

	public boolean compareObject(Dvd dvd1, Dvd dvd2) {
		return dvd1.getTitle().equals(dvd2.getTitle())
			&& dvd1.getDirector().equals(dvd2.getDirector())
			&& dvd1.getMpaaRating().equals(dvd2.getMpaaRating())
			&& dvd1.getStudio().equals(dvd2.getStudio())
			&& (dvd1.getReleaseDate().compareTo(dvd2.getReleaseDate()) == 0);
	}

	@Test
	public void testAdd_ListAll() {

		impl.add(king1);
		impl.add(xmas);
		int index = impl.listAll().indexOf(king1);
		int index2 = impl.listAll().indexOf(xmas);

		assertEquals(2, impl.listAll().size());
		assertEquals(king1.getDirector(), impl.listAll().get(index).getDirector());
		assertTrue(compareObject(xmas, impl.listAll().get(index2)));
	}

	@Test
	public void testCheckDate() {
		DvdLibraryDaoImpl testImpl = new DvdLibraryDaoImpl();
		assertEquals(IsoChronology.INSTANCE.date(1989, 2, 23), LocalDate.parse("1989-02-23"));
		assertEquals(IsoChronology.INSTANCE.date(1989, 2, 23), testImpl.checkDate("1989-02-23"));
	}

	@Test
	public void testLoad() {
		impl.loadFromFile();
		impl.add(mermaid);

		impl.writeToFile();

		impl2.loadFromFile();

		Dvd dvd = impl2.getByTitle("The Little Mermaid").get(0);
		assertTrue(compareObject(mermaidCopy, dvd));

		impl2.remove(impl2.getByTitle("The Little Mermaid").get(0));
		impl2.writeToFile();
	}

	@Test
	public void testWrite() {
		impl.add(xmas);
		impl.add(king1);
		impl.add(king2);
		impl.add(mermaid);
		impl.writeToFile();

		impl2.loadFromFile();
		impl.loadFromFile();
		List<Dvd> dvds = impl.listAll();
		List<Dvd> dvds2 = impl2.listAll();

		assertEquals(4, dvds.size());
		assertEquals(4, dvds2.size());

		dvds
			.stream()
			.forEach(dvd -> {
				if (compareObject(dvd, xmas)) {
					counter++;
				}
				if (compareObject(dvd, king1)) {
					counter++;
				}
				if (compareObject(dvd, king2)) {
					counter++;
				}
				if (compareObject(dvd, mermaid)) {
					counter++;
				}
			});
		assertEquals(4, counter);

		counter = 0;
		dvds2
			.stream()
			.forEach(dvd -> {
				if (compareObject(dvd, xmas)) {
					counter++;
				}
				if (compareObject(dvd, king1)) {
					counter++;
				}
				if (compareObject(dvd, king2)) {
					counter++;
				}
				if (compareObject(dvd, mermaid)) {
					counter++;
				}
			});
		assertEquals(4, counter);

	}

	@Test
	public void testRemove() {
		impl.add(mermaid);
		impl.add(mermaidCopy);

		assertThat(impl.listAll(), hasItems(mermaid, mermaidCopy));
		assertTrue(compareObject(mermaid, mermaidCopy));

		Dvd mermaid3 = mermaid;

		impl.remove(mermaid);
		mermaid = mermaidCopy;

		impl.add(mermaid);
		Dvd testDvd = impl.listAll().get(impl.listAll().indexOf(mermaid));
		Dvd testDvd2 = impl.listAll().get(impl.listAll().indexOf(mermaidCopy));

		assertNotSame(mermaid3, testDvd);
		assertSame(testDvd, testDvd2);

	}

	@Test
	public void testGetByTitle() {
		impl.add(mermaid);
		impl.add(mermaidCopy);

		assertThat(impl.getByTitle("The Little Mermaid"), hasItems(mermaidCopy));
		assertTrue(compareObject(mermaidCopy, impl.getByTitle("The Little Mermaid").get(0)));
	}

	@Test
	public void testGetByRating() {
		impl.add(king2);
		impl.add(xmas);
		impl.add(mermaid);

		assertThat(impl.getByRating("PG"), hasItems(xmas, mermaid));
		assertTrue(compareObject(xmas, impl.getByRating("PG").get(0)));
	}

	@Test
	public void testGetByStudio() {
		impl.add(king1);
		impl.add(xmas);

		assertThat(impl.getByStudio("Skellington Productions"), hasItems(xmas));
		assertTrue(compareObject(king1, impl.getByStudio("Lions Gate").get(0)));
	}

	@Test
	public void testGetAverageAge() {
		impl.add(king2);
		impl.add(xmas);

		double avgAge = impl.getAverageAge();
		double avgAgeHard = impl.listAll()
			.stream()
			.mapToDouble(Dvd::getAge)
			.average()
			.getAsDouble();

		assertEquals(avgAgeHard, avgAge, 0);
	}

	@Test
	public void testGetReleasesInLastNYears() {
		impl.add(king2);
		impl.add(xmas);

		assertEquals(1, impl.getReleasesInLastNYears(1995).size());
		assertThat(impl.getReleasesInLastNYears(1995), hasItems(king2));

		assertEquals(2, impl.getReleasesInLastNYears(1990).size());
		assertThat(impl.getReleasesInLastNYears(1990), hasItems(king2, xmas));
	}


}
