/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
@Controller
@RequestMapping("/rest")
public class ContactRESTController {

	private ContactListDao dao;

	@Inject
	public ContactRESTController(ContactListDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	@ResponseBody //the response body should contain the List<Contact> instead of attaching to a model bc there is no view
	public List<Contact> getAll() {
		return dao.getAll();
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.GET) //this is how we specify which contact we want using REST
	@ResponseBody
	public Contact getContact(@PathVariable("id") int id) { //we can leave the path variable out bc it is thte same as the parameter name, but it is best to be explicit in case the name of the method parameter changes
		return dao.getById(id);
	}

	@RequestMapping(value = "/contact", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Contact createContact(@RequestBody Contact contact) {  //returning Contact in case we want to do something else with it
		dao.addContact(contact);
		return contact;
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateContact(@PathVariable("id") int id, @RequestBody Contact contact) {
		contact.setContactId(id); //in case the contact id is not set invisibly in the view, we set it here to avoid accidentally updating contact 0
		dao.updateContact(contact);
	}

	@RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteContact(@PathVariable("id") int id){
		dao.removeContact(id);
	}
}
