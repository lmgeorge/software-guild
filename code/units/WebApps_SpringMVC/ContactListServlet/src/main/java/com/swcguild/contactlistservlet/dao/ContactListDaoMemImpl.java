/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.contactlistservlet.dao;

import com.swcguild.contactlistservlet.model.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ContactListDaoMemImpl implements ContactListDao{
	private Map<Integer,Contact> contacts = new HashMap<>();
	private static int idCounter = 0;
	
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
		Set<Integer> ids = contacts.keySet();
		
		List<Contact> all = new ArrayList<>();
		
		ids
			.stream()
			.forEach(id -> {
				all.add(contacts.get(id));
			});
		
		return all;
	}

	@Override
	public Contact getById(int contactId) {
		return contacts.get(contactId);
	}

	@Override
	public List<Contact> getByLastName(String lastName) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public List<Contact> getByCompany(String company) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
