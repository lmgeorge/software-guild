/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.contactlistmvc.client;

import com.swcguild.contactlistmvc.model.Contact;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ContactListRESTClient {
	
	
	public static void main(String[] args){
		ContactListRESTClient client = new ContactListRESTClient();
		List<Contact> contacts = client.getAll();
		
		contacts.stream().
			forEach((c) -> {
				System.out.println(c.getFirstName());
		});
	}
	
	public @ResponseBody List<Contact> getAll(){
		RestTemplate rt = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJacksonHttpMessageConverter());
		rt.setMessageConverters(converters);
		
		List<Contact> contacts = (ArrayList<Contact>) rt.getForObject("http://localhost:8080/ContactList/spring/rest/contacts", ArrayList.class);
		return contacts;
	}
	
}
