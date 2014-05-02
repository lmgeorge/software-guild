/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3;

import com.swcguild.consoleio.ConsoleIO;
import com.swcguild.consoleio.ConsoleIOImpl;
import com.swcguild.dvdlibrary.model.Dvd;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DVDGooeyImpl implements DvdGUI{

	private final ConsoleIO c = new ConsoleIOImpl();
	private String note;
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private DecimalFormat d = new DecimalFormat("#.##");

	public void print(String str) {
		c.print(str);
	}
	
	public int printMenu(String str, int min, int max){
		return c.getsNum(str, min, max);
	}


	public void printMenuTitle(int choice) {
		switch (choice) {
			case 1:
				c.println("\nADD DVD:\n");
				break;
			case 2:
				c.println("\nDELETE DVD:");
				break;
			case 3:
				c.println("\nEDIT DVD:");
				break;
			case 4:
				c.println("\nFIND DVD:");
				break;
			case 5:
				c.println("\nLIST ALL DVDs:\n");
				break;
			case 0:
				c.println("\nEXIT:");
				c.println("Saving....Thank you!\n");
				break;
		}
	}


	public Dvd createDvd() {
		Dvd dvd = new Dvd();
		dvd.setTitle(c.gets("\tTitle: "));
		dvd.setReleaseDate(checkDate("\tRelease Date (MM/DD/YYYY): "));
		dvd.setMpaaRating(c.gets("\tMPAA Rating: "));
		dvd.setDirector(c.gets("\tDirector: "));
		dvd.setStudio(c.gets("\tStudio: "));
		dvd.setNote(c.gets("\tNote: "));
		return dvd;
	}
	
	public boolean confirm(String prompt){
		return c.getsNum(prompt + " (1 = Yes /  0 = No)?:  ", 0, 1) == 1;
	}

	public String getSearchParam(int choice) {
		String search = "";
		switch (choice) {
			case 1:
				search = c.gets("\n\nSEARCH BY TITLE"
					+ "\n\nPlease enter your choice: ");
				break;
			case 2:
				search = c.gets("\n\nSEARCH BY MPAA RATING"
					+ "\n\nPlease enter your choice: ");
				break;
			case 3:
				search = c.gets("\n\nSEARCH BY STUDIO"
					+ "\n\nPlease enter your choice: ");
				break;
			case 4:
				search = "" + c.getsNum("\n\nSEARCH SINCE YEAR"
					+ "\n\nPlease enter your choice: ",
					1850, (LocalDate.now().getYear() + 1));
				break;
		}
		return search;
	}

	public Dvd getObj(List<Dvd> dvdList) {
		Dvd dvd = new Dvd();
		try {
			if (dvdList.size() > 1) {
				int choice = c.getsNum("Please select a record: ");
				dvd = dvdList.get(choice - 1);
			} else {
				dvd = dvdList.get(0);
			}
		} catch (IndexOutOfBoundsException | NullPointerException ex) {
			c.println("\nError: No record exists.\n");
		}
		return dvd;
	}

	public void printStats(float average) {
		c.println(
			"\n\tAverage age: " + d.format(average) + " years\n");
	}

	public String toStringWithIndex(Dvd dvd, int index) {
		return "\n================================================================\n\n"
			+ "Film " + (index + 1)
			+ "\n\tTitle: " + dvd.getTitle()
			+ "\n\ttRelease Date: " + dvd.getReleaseDate().format(format)
			+ "\n\tMPAA Rating: " + dvd.getMpaaRating()
			+ "\n\tDirector: " + dvd.getDirector()
			+ "\n\tStudio: " + dvd.getStudio()
			+ "\n\tNote: " + dvd.getNote()
			+ "\n\n================================================================\n";
	}

	public String toString(Dvd dvd) {

		return "\n================================================================\n\n"
			+ "\n\tTitle: " + dvd.getTitle()
			+ "\n\tRelease Date: " + dvd.getReleaseDate().format(format)
			+ "\n\tMPAA Rating: " + dvd.getMpaaRating()
			+ "\n\tDirector: " + dvd.getDirector()
			+ "\n\tStudio: " + dvd.getStudio()
			+ "\n\tNote: " + dvd.getNote()
			+ "\n\n================================================================\n";
	}

	public LocalDate checkDate(String prompt) {
		LocalDate date = LocalDate.of(1850, 1, 1);
		boolean badInput = true;
		do {
			try {
				date = LocalDate.parse(c.gets(prompt), format);
				badInput = false;
			} catch (DateTimeParseException ex) {
				c.println("ERROR: Invalid entry. " + ex.getMessage()+"\n");
			}
		} while (badInput);
		return date;
	}

	
	public Dvd editor(Dvd dvd, int ui) {
		String tempVal;
		switch (ui) {
			case 1:
				c.println("Old title: " + dvd.getTitle());
				tempVal = c.gets("Enter new title: ");
				
				if (confirm("\nConfirm change "))  {
					dvd.setTitle(tempVal);
				} else {
					c.println("No changes made.\n");
				}

				break;
			case 2:
				c.println("Old release date: " + dvd.getReleaseDate().format(format));
				LocalDate date = checkDate("Enter new release date: ");
				if (confirm("\nConfirm change ")) {
					dvd.setReleaseDate(date);
				} else {
					c.println("No changes made.\n");
				}

				break;
			case 3:
				c.println("Old rating: " + dvd.getMpaaRating());
				tempVal = c.gets("Enter new rating: ");

				if (confirm("\nConfirm change ")){
					dvd.setMpaaRating(tempVal);
				} else {
					c.println("\nNo changes made.\n");
				}
				break;
			case 4:
				c.println("Old director: " + dvd.getDirector());
				tempVal = c.gets("Enter new director: ");

			if (confirm("\nConfirm change ")) {
					dvd.setDirector(tempVal);
				} else {
					c.println("\nNo changes made.\n");
				}
				break;
			case 5:
				c.println("Old studio: " + dvd.getStudio());
				tempVal = c.gets("Enter new studio: ");

				if (confirm("\nConfirm change ")){
					dvd.setStudio(tempVal);
				} else {
					c.println("\nNo changes made.\n");
				}
				break;
			case 6:
				c.println("Old note: " + dvd.getNote());
				tempVal = c.gets("Enter new note: ");

				if (confirm("\nConfirm change ")){
					dvd.setNote(tempVal);
				} else {
					c.println("\nNo changes made.\n");
				}
				break;
			case 0:
				c.println("\nCancelled.");
				break;
			default:
				break;
		}

		c.print("\nUpdated record:\n");
		c.println(toString(dvd));
		
		return dvd;
	}

}
