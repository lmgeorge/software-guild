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
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;


/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ContactListRESTClient {
	
	
	public static void main(String[] args){
		ContactListRESTClient client = new ContactListRESTClient();
		
		
//		Contact addition = new Contact();
//		addition.setFirstName("Anna");
//		addition.setLastName("Karenina");
//		addition.setCompany("Netbeans, Inc");
//		addition.setEmail("akarenina@netbeans.com");
//		addition.setPhone("0001112222");
//		client.createContact(addition);
		
		Contact[] contacts = client.getAll();
		
		for(Contact c : contacts){
				System.out.println(c.getContactId());
				System.out.println(c.getFirstName() );
		}
	}
	
	public @ResponseBody Contact[] getAll(){
		RestTemplate rt = new RestTemplate();
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJacksonHttpMessageConverter());
		//converters.add(new Jaxb2RootElementHttpMessageConverter());
		
		rt.setMessageConverters(converters);
		
		Contact[] contacts = rt.getForObject("http://localhost:8080/ContactList/spring/rest/contacts", Contact[].class);
		return contacts;
	}

	public @ResponseBody Contact createContact(Contact contact){
		RestTemplate rt = new RestTemplate();
		
		List<HttpMessageConverter<?>> converters = new ArrayList<>();
		converters.add(new MappingJacksonHttpMessageConverter());
		rt.setMessageConverters(converters);
	
		return rt.postForObject("http://localhost:8080/ContactList/spring/rest/contact", contact, Contact.class); // contact is the requested object
	}

}
