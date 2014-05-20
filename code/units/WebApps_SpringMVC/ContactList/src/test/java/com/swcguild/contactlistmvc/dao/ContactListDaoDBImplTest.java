/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.contactlistmvc.dao;

import com.swcguild.contactlistmvc.model.Contact;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ContactListDaoDBImplTest {
	private ContactListDao dao;
	private Contact sally;
	private Contact george;
	private Contact dante;
	private Contact danteCopy;
	
	public ContactListDaoDBImplTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
	}
	
	@AfterClass
	public static void tearDownClass() {
	}
	
	@Before
	public void setUp() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("test-applicationContext.xml");		
		dao = ctx.getBean("dao", ContactListDao.class);
		
		JdbcTemplate cleaner = ctx.getBean("jdbcTemplate", JdbcTemplate.class);
		cleaner.execute("DELETE FROM contacts");
		
		sally = new Contact();
		sally.setFirstName("Sally");
		sally.setLastName("Smith");
		sally.setCompany("Acme, Inc.");
		sally.setEmail("sally@email.com");
		sally.setPhone("5555555555");
		
		george = new Contact();
		george.setFirstName("George");
		george.setLastName("Adams");
		george.setCompany("Oracle");
		george.setEmail("george@email.com");
		george.setPhone("8885559988");
		
		dante = new Contact();
		dante.setFirstName("Dante");
		dante.setLastName("Sabacki");
		dante.setCompany("Canis Ops");
		dante.setEmail("dante@doge.com");
		dante.setPhone("8885559988");
		
		danteCopy = new Contact();
		danteCopy.setFirstName("Dante");
		danteCopy.setLastName("Sabacki");
		danteCopy.setCompany("Canis Ops");
		danteCopy.setEmail("dante@doge.com");
		danteCopy.setPhone("8885559988");
		
	}
	
	@After
	public void tearDown() {
		sally = new Contact();
		george = new Contact();
		dante = new Contact();
		danteCopy = new Contact();
	}
	
	private boolean compare(Contact contact1, Contact contact2){
		return contact1.getFirstName().equals(contact2.getFirstName())
			&& contact1.getLastName().equals(contact2.getLastName())
			&& contact1.getCompany().equals(contact2.getCompany())
			&& contact1.getEmail().equals(contact2.getEmail())
			&& contact1.getPhone().equals(contact2.getPhone());
	}

	@Test
	public void testAddGetDeleteContact() {
		dao.addContact(sally);
		
		Contact fromDao = dao.getById(sally.getContactId());
		
		assertTrue(compare(sally, fromDao));
		
		dao.removeContact(sally.getContactId());
		
		assertNull(dao.getById(sally.getContactId()));
	}

	@Test
	public void testRemoveContact() {
	}

	@Test
	public void testUpdateContact() {
	}

	@Test
	public void testGetAll() {
	}

	@Test
	public void testGetById() {
	}

	@Test
	public void testGetByLastName() {
	}

	@Test
	public void testGetByCompany() {
	}
	

}
