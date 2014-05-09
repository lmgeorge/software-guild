package com.swcguild.contactlistmvc.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.swcguild.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ContactListDaoMemImpl implements ContactListDao {

	private Map<Integer, Contact> contacts = new HashMap<>();
	private static int idCounter = 1;

	@Override
	public void addContact(Contact contact) {
		contact.setContactId(idCounter++);
		contacts.put(contact.getContactId(), contact);
	}

	@Override
	public void removeContact(int contactId) {
		contacts.remove(contactId);
	}

	@Override
	public void updateContact(Contact contact) {
		contacts.replace(contact.getContactId(), contact);
	}

	@Override
	public List<Contact> getAll() {
		Collection<Contact> c = contacts.values();
		return new ArrayList<Contact>(c);
	}

	@Override
	public Contact getById(int contactId) {
		return contacts.get(contactId);
	}

	@Override
	public List<Contact> getByLastName(String lastName) {
		Collection<Contact> coll = contacts.values();

		return coll.parallelStream()
			.filter(c -> c.getLastName().equals(lastName))
			.collect(Collectors.toList());

	}

	@Override
	public List<Contact> getByCompany(String company) {
		Collection<Contact> coll = contacts.values();

		return coll.parallelStream()
			.filter(c -> c.getCompany().equals(company))
			.collect(Collectors.toList());
	}


}
