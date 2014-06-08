/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.digitialpurple.lab;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.consoleio.ConsoleIOImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Date {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ConsoleIO c = new ConsoleIOImpl();
		
		Scanner countries = new Scanner(
			new BufferedReader(new FileReader("list_of_countries.txt")));
		PrintWriter writer = new PrintWriter(new FileWriter("countries.sql"));
		
		
		while (countries.hasNextLine()){
			String country = countries.nextLine();
			String insertCountry = "INSERT INTO Countries(`name`) value (\"" + country + "\");";
			
			writer.println(insertCountry);
			writer.flush();
		}
		
		writer.close();
		
		
//		
//		LocalDate date = IsoChronology.INSTANCE.dateNow();
//		LocalDate bday = IsoChronology.INSTANCE.date(1988, 2, 11);
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd,yyyy");
//	c.println(date.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
//	c.println(bday.getMonth().getDisplayName(TextStyle.SHORT, Locale.US));
//	c.println(bday.format(format));
//		bday.getMonth();
//		bday.getMonthValue();
//		bday.getDayOfMonth();
//		bday.getYear();
//		bday.toEpochDay();
	}


}
