package com.swcguild.contactlistservlet.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.swcguild.contactlistservlet.model.Contact;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface ContactListDao {

	public void addContact(Contact contact);

	public void removeContact(int contactId);

	public void updateContact(Contact contact);

	public List<Contact> getAll();

	public Contact getById(int contactId);

	public List<Contact> getByLastName(String lastName);

	public List<Contact> getByCompany(String company);


}
