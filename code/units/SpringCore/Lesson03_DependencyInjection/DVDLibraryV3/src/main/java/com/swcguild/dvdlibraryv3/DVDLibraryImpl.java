/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibraryv3;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.model.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DVDLibraryImpl implements DvdLibraryDao {

	private List<Dvd> dvdLib = new ArrayList<>();
	private final String DELIMITER = "::";
	private final String DVDS = "dvds.txt";
	private final DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");

	public void loadFromFile() {
		Scanner file;
		try {
			file = new Scanner(new BufferedReader(new FileReader(DVDS)));
			String[] dvdInfo;

			while (file.hasNextLine()) {
				String dvdrecord = file.nextLine();
				dvdInfo = dvdrecord.split(DELIMITER);

				Dvd dvd = new Dvd();
				dvd.setTitle(dvdInfo[0]);
				dvd.setReleaseDate(checkDate(dvdInfo[1]));
				dvd.setMpaaRating(dvdInfo[2]);
				dvd.setDirector(dvdInfo[3]);
				dvd.setStudio(dvdInfo[4]);
				if (dvdInfo.length > 5) {
					dvd.setNote(dvdInfo[5]);
				}
				dvdLib.add(dvd);
			}
			file.close();
		} catch (FileNotFoundException | NullPointerException ex) {
			Logger
				.getLogger(DVDLibraryImpl.class.getName())
				.log(Level.OFF, ("Error: " + ex.getMessage()));
		}
	}

	public List<Dvd> listAll() {
		return dvdLib
			.stream()
			.collect(Collectors.toList());
	}

	public void writeToFile() {
		PrintWriter file;
		try {
			file = new PrintWriter(new FileWriter(DVDS));

			dvdLib
				.stream()
				.forEach(dvd -> {
					file.println(
						dvd.getTitle() + DELIMITER
						+ dvd.getReleaseDate() + DELIMITER
						+ dvd.getMpaaRating() + DELIMITER
						+ dvd.getDirector() + DELIMITER
						+ dvd.getStudio() + DELIMITER
						+ dvd.getNote());
					file.flush();
				});
			file.close();
		} catch (IOException | NullPointerException ex) {
			Logger
				.getLogger(DVDLibraryImpl.class.getName())
				.log(Level.OFF, ("Error: " + ex.getMessage()));
		}
	}

	public void add(Dvd dvd) {
		dvdLib.add(dvd);
	}

	public void remove(Dvd dvd) {
		dvdLib.remove(dvd);
	}

	public List<Dvd> getByTitle(String dvdTitle) {
		return dvdLib
			.stream()
			.filter(d -> d.getTitle().equalsIgnoreCase(dvdTitle))
			.collect(Collectors.toList());
	}

	@Override
	public List<Dvd> getByRating(String mpaa) {
		return dvdLib
			.stream()
			.filter(d -> d.getMpaaRating().matches(mpaa))
			.collect(Collectors.toList());
	}

	@Override
	public List<Dvd> getByStudio(String studio) {
		return dvdLib
			.stream()
			.filter(d -> d.getStudio().equalsIgnoreCase(studio))
			.collect(Collectors.toList());
	}

	@Override
	public float getAverageAge() {
		return (float) dvdLib
			.stream()
			.mapToLong(Dvd::getAge)
			.average()
			.getAsDouble();
	}

	public List<Dvd> getReleasesInLastNYears(int year) {
		return dvdLib
			.stream()
			.filter(d -> d.getReleaseDate().getYear() >= year)
			.collect(Collectors.toList());
	}

	public LocalDate checkDate(String str) {
		LocalDate date = null;
		try {
			date = LocalDate.parse(str, format);
		} catch (DateTimeParseException | NullPointerException ex) {
			Logger
				.getLogger(DVDLibraryImpl.class.getName())
				.log(Level.OFF, ("Error: " + ex.getMessage()));
		}
		return date;
	}


}
