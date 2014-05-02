/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.model.Dvd;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DvdLibController {

	private final DvdGUI gui = new DVDGooeyImpl();
	private DvdLibraryDao dvds;
	
	
	public DvdLibController(DvdLibraryDao dvds){
		this.dvds = dvds;
	}

	public void run() {
		dvds.loadFromFile();
		gui.print("\tWelcome to DVD Library\n"
			+ "===========================================\n\n");
		menu();
	}

	public void menu() {
		int ui = gui.printMenu("\nMain Menu:\n"
			+ "\n\t1. Add a DVD"
			+ "\n\t2. Remove a DVD"
			+ "\n\t3. Edit a DVD record"
			+ "\n\t4. Find a DVD"
			+ "\n\t5. List all DVDs"
			+ "\n\t6. Library Stats"
			+ "\n\t0. Exit"
			+ "\n\nPlease enter your choice: ", 0, 6);
		gui.printMenuTitle(ui);
		switch (ui) {
			case 1:
				addDvd();
				menu();
				break;
			case 2:
				deleteDvd();
				menu();
				break;
			case 3:
				editMenu();
				menu();
				break;
			case 4:
				findBy(false);
				menu();
				break;
			case 5:
				listAll(dvds.listAll());
				menu();
				break;
			case 6:
				gui.printStats(dvds.getAverageAge());
				menu();
				break;
			case 0:
				break;
		}

	}

	public void addDvd() {

		do {
			Dvd dvd = gui.createDvd();
			dvds.add(dvd);
		} while (gui.confirm("Would you like to add another DVD"));

		allowSave();

	}

	public void deleteDvd() {
		do {
			Dvd dvd = findBy(true);

			if (gui.confirm("Delete \"" + dvd.getTitle() + "\"")) {
				dvds.remove(dvd);
				gui.print("\nDVD removed successfully.\n");
			} else {
				gui.print("\nOperation successfully stopped.\n");
			}
		} while (gui.confirm("Would you like to delete another DVD"));

		allowSave();

	}

	public Dvd findBy(boolean makeSelection) {
		int choice = gui.printMenu("\n\t1. Search by Title"
			+ "\n\t2. Search by MPAA Rating"
			+ "\n\t3. Search by Studio"
			+ "\n\t4. Search since Release Year"
			+ "\n\t0. Main menu"
			+ "\n\nPlease enter your choice: ", 0, 4);
		String search = gui.getSearchParam(choice);
		Dvd dvd = new Dvd();

		if (makeSelection) {
			switch (choice) {
				case 1:
					dvd = chooseOne(dvds.getByTitle(search));
					break;
				case 2:
					dvd = chooseOne(dvds.getByRating(search));
					break;
				case 3:
					dvd = chooseOne(dvds.getByStudio(search));
					break;
				case 4:
					int year = Integer.parseInt(search);
					dvd = chooseOne(dvds.getReleasesInLastNYears(year));
					break;
				case 0:
					menu();
					break;
			}
		} else {
			switch (choice) {
				case 1:
					listAll(dvds.getByTitle(search));
					break;
				case 2:
					listAll(dvds.getByRating(search));
					break;
				case 3:
					listAll(dvds.getByStudio(search));
					break;
				case 4:
					int year = Integer.parseInt(search);
					listAll(dvds.getReleasesInLastNYears(year));
					break;
				case 0:
					menu();
					break;
			}
		}
		return dvd;
	}

	public void listAll(List<Dvd> dvdList) {
		gui.print("\nResults:\n");
		dvdList
			.stream()
			.forEach(dvd -> {
				gui.print(gui.toString(dvd));
			});
	}

	public Dvd chooseOne(List<Dvd> dvdList) {
		Dvd returnObj;
		gui.print("\nResults:\n");
		dvdList
			.stream()
			.forEach(dvd -> {
				gui.print(gui.toStringWithIndex(dvd, dvdList.indexOf(dvd)));
			});
		returnObj = gui.getObj(dvdList);
		return returnObj;
	}

	public void editMenu() {
		Dvd dvd = findBy(true);
		try {
			do {
				int ui = gui.printMenu("\n\t1. Edit Title"
					+ "\n\t2. Edit Release Year"
					+ "\n\t3. Edit MPAA Rating"
					+ "\n\t4. Edit Director"
					+ "\n\t5. Edit Studio"
					+ "\n\t6. Edit Note"
					+ "\n\t0. Cancel"
					+ "\n\nPlease enter your choice: ", 0, 6);

				dvd = gui.editor(dvd, ui);

			} while (gui.confirm("\nWould you like to continue editing "));
		} catch (NullPointerException ex) {
			gui.print("\nError: no such record exists. Msg = " + ex.getMessage() + "\n");
		}
		allowSave();

	}

	public void allowSave() {
		int choice = gui.printMenu("\nSAVE"
			+ "\n\t1. Save changes"
			+ "\n\t2. Cancel"
			+ "\n\t0. Main Menu"
			+ "\n\nPlease enter your choice: ", 0, 2);

		switch (choice) {
			case 1:
				dvds.writeToFile();
				gui.print("\nSaved.\n");
				break;
			case 2:
				gui.print("\nOperation successfully stopped.\n");
				break;
			case 0:
				menu();
				break;
		}

	}


}
