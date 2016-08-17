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
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DvdLibraryDaoDBTest {

	private DvdLibraryDao dao;
//	private DvdLibraryDao impl2;

	private Dvd king1 = new Dvd();
	private Dvd king2 = new Dvd();
	private Dvd xmas = new Dvd();
	private Dvd mermaid = new Dvd();
	private Dvd mermaidCopy = new Dvd();

//	private int counter;
//	private boolean bool = false;

	public DvdLibraryDaoDBTest() {
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

		dao = (DvdLibraryDao) ctx.getBean("dao");

		JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		cleaner.execute("DELETE FROM dvds");
		
//		ApplicationContext ctx2
//			= new ClassPathXmlApplicationContext("test-applicationContext.xml");
//		impl2 = (DvdLibraryDao) ctx2.getBean("dao");

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
//		counter = 0;
	}

	public boolean compareObject(Dvd dvd1, Dvd dvd2) {
		return dvd1.getTitle().equals(dvd2.getTitle())
			&& dvd1.getDirector().equals(dvd2.getDirector())
			&& dvd1.getMpaaRating().equals(dvd2.getMpaaRating())
			&& dvd1.getStudio().equals(dvd2.getStudio())
			&& (dvd1.getReleaseDate().compareTo(dvd2.getReleaseDate()) == 0);
	}

@Test
	public void testAddGetDeleteContact() {
		dao.add(mermaid);
		
		Dvd fromDao = dao.getDvd(mermaid.getDvdID());
		
		assertTrue(compareObject(mermaid, fromDao));
		
		dao.remove(mermaid.getDvdID());
		
		assertNull(dao.getDvd(mermaid.getDvdID()));
	}
	
	
	
	
//	
//	@Test
//	public void testAdd_ListAll() {
//
//		dao.add(king1);
//		dao.add(xmas);
//		int index = dao.listAll().indexOf(king1);
//		int index2 = dao.listAll().indexOf(xmas);
//
//		assertEquals(2, dao.listAll().size());
//		assertEquals(king1.getDirector(), dao.listAll().get(index).getDirector());
//		assertTrue(compareObject(xmas, dao.listAll().get(index2)));
//	}
//
//	@Test
//	public void testCheckDate() {
//		DvdLibraryDaoImpl testImpl = new DvdLibraryDaoImpl();
//		assertEquals(IsoChronology.INSTANCE.date(1989, 2, 23), LocalDate.parse("1989-02-23"));
//		assertEquals(IsoChronology.INSTANCE.date(1989, 2, 23), testImpl.checkDate("1989-02-23"));
//	}
//
//	@Test
//	public void testLoad() {
//		dao.loadFromFile();
//		dao.add(mermaid);
//
//		dao.writeToFile();
//
//		impl2.loadFromFile();
//
//		Dvd dvd = impl2.getByTitle("The Little Mermaid").get(0);
//		assertTrue(compareObject(mermaidCopy, dvd));
//
//		impl2.remove(impl2.getByTitle("The Little Mermaid").get(0));
//		impl2.writeToFile();
//	}
//
//	@Test
//	public void testWrite() {
//		dao.add(xmas);
//		dao.add(king1);
//		dao.add(king2);
//		dao.add(mermaid);
//		dao.writeToFile();
//
//		impl2.loadFromFile();
//		dao.loadFromFile();
//		List<Dvd> dvds = dao.listAll();
//		List<Dvd> dvds2 = impl2.listAll();
//
//		assertEquals(4, dvds.size());
//		assertEquals(4, dvds2.size());
//
//		dvds
//			.stream()
//			.forEach(dvd -> {
//				if (compareObject(dvd, xmas)) {
//					counter++;
//				}
//				if (compareObject(dvd, king1)) {
//					counter++;
//				}
//				if (compareObject(dvd, king2)) {
//					counter++;
//				}
//				if (compareObject(dvd, mermaid)) {
//					counter++;
//				}
//			});
//		assertEquals(4, counter);
//
//		counter = 0;
//		dvds2
//			.stream()
//			.forEach(dvd -> {
//				if (compareObject(dvd, xmas)) {
//					counter++;
//				}
//				if (compareObject(dvd, king1)) {
//					counter++;
//				}
//				if (compareObject(dvd, king2)) {
//					counter++;
//				}
//				if (compareObject(dvd, mermaid)) {
//					counter++;
//				}
//			});
//		assertEquals(4, counter);
//
//	}
//
//	@Test
//	public void testRemove() {
//		dao.add(mermaid);
//		dao.add(mermaidCopy);
//
//		assertThat(dao.listAll(), hasItems(mermaid, mermaidCopy));
//		assertTrue(compareObject(mermaid, mermaidCopy));
//
//		Dvd mermaid3 = mermaid;
//
//		dao.remove(mermaid);
//		mermaid = mermaidCopy;
//
//		dao.add(mermaid);
//		Dvd testDvd = dao.listAll().get(dao.listAll().indexOf(mermaid));
//		Dvd testDvd2 = dao.listAll().get(dao.listAll().indexOf(mermaidCopy));
//
//		assertNotSame(mermaid3, testDvd);
//		assertSame(testDvd, testDvd2);
//
//	}
//
//	@Test
//	public void testGetByTitle() {
//		dao.add(mermaid);
//		dao.add(mermaidCopy);
//
//		assertThat(dao.getByTitle("The Little Mermaid"), hasItems(mermaidCopy));
//		assertTrue(compareObject(mermaidCopy, dao.getByTitle("The Little Mermaid").get(0)));
//	}
//
//	@Test
//	public void testGetByRating() {
//		dao.add(king2);
//		dao.add(xmas);
//		dao.add(mermaid);
//
//		assertThat(dao.getByRating("PG"), hasItems(xmas, mermaid));
//		assertTrue(compareObject(xmas, dao.getByRating("PG").get(0)));
//	}
//
//	@Test
//	public void testGetByStudio() {
//		dao.add(king1);
//		dao.add(xmas);
//
//		assertThat(dao.getByStudio("Skellington Productions"), hasItems(xmas));
//		assertTrue(compareObject(king1, dao.getByStudio("Lions Gate").get(0)));
//	}
//
//	@Test
//	public void testGetAverageAge() {
//		dao.add(king2);
//		dao.add(xmas);
//
//		double avgAge = dao.getAverageAge();
//		double avgAgeHard = dao.listAll()
//			.stream()
//			.mapToDouble(Dvd::getAge)
//			.average()
//			.getAsDouble();
//
//		assertEquals(avgAgeHard, avgAge, 0);
//	}
//
//	@Test
//	public void testGetReleasesInLastNYears() {
//		dao.add(king2);
//		dao.add(xmas);
//
//		assertEquals(1, dao.getReleasesInLastNYears(1995).size());
//		assertThat(dao.getReleasesInLastNYears(1995), hasItems(king2));
//
//		assertEquals(2, dao.getReleasesInLastNYears(1990).size());
//		assertThat(dao.getReleasesInLastNYears(1990), hasItems(king2, xmas));
//	}


}
