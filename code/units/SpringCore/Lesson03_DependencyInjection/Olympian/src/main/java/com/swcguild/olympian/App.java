package com.swcguild.olympian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties. To change this template file, choose Tools | Templates and open the template in the editor.
 */
/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class App {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SkiJumper sj = ctx.getBean("superSkiJumper", SkiJumper.class);
		sj.competeInEvent();

		Event sje = new SkiJumpEvent();
		Olympian sjOlympian = new Olympian(sje);
		sjOlympian.setCountry("Guyana");
		sjOlympian.competeInEvent();
		
		Olympian usaSJ = ctx.getBean("usaSkiJumper", Olympian.class);
		usaSJ.competeInEvent();
		
		Olympian canadaSkiJumper = ctx.getBean("canadianSkiJumper", Olympian.class);
		canadaSkiJumper.competeInEvent();
		
	}


}
