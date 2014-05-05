/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class FlooringMain {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		
		
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext("appContext.xml");

		Controller controller = (Controller) ctx.getBean("controller");
		controller.run();
		
	}


}
