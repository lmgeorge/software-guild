	/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.contactlistmvc.controller;

import com.swcguild.contactlistmvc.dao.ContactListDao;
import com.swcguild.contactlistmvc.model.Contact;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
@Controller
public class ContactController {

	private ContactListDao dao;

	@Inject
	public ContactController(ContactListDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/displayNewForm", method = RequestMethod.GET)
	public String displayNewForm() {
		return "addForm";
	}

	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(HttpServletRequest req, HttpServletResponse resp) {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String company = req.getParameter("company");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");

		Contact contact = new Contact();

		contact.setFirstName(firstName);
		contact.setLastName(lastName);
		contact.setCompany(company);
		contact.setEmail(email);
		contact.setPhone(phone);

		dao.addContact(contact);

		return "redirect:contacts";
	}

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String displayContacts(Model model) {
		
		model.addAttribute("contacts", dao.getAll());

		return "displayContacts";
	}

	@RequestMapping(value="/deleteContact", method= RequestMethod.GET)
	public String deleteContact(@RequestParam("id") int id){
		dao.removeContact(id);
		
		return "redirect:contacts";
	}
	
	@RequestMapping(value="/displayEditForm", method= RequestMethod.GET)
	public String displayEditForm(@RequestParam("id") int id, Model model){
		Contact contact = dao.getById(id);
		
		model.addAttribute("contact", contact);
		return "editForm";
	}
	
	@RequestMapping(value="/updateContact", method=RequestMethod.POST)
	public String updateContact(@ModelAttribute("contact") Contact contact, Model model){
		dao.updateContact(contact);
		
		return "redirect:contacts";
	}

}
