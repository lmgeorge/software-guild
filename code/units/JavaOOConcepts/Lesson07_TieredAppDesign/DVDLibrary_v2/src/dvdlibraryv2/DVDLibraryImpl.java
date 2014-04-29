/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibraryv2;

import com.swcguild.console.ConsoleIO;
import com.swcguild.console.ConsoleIOImpl;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DVDLibraryImpl implements DVDLibrary {

	private List<Dvd> dvdLib = new ArrayList<>();
	private final String DELIMITER = "::";
	private final ConsoleIO c = new ConsoleIOImpl();
	private String notes;

  public void loadDvds(String fileName) {
		Scanner file;
		try {
			file = new Scanner(new BufferedReader(new FileReader(fileName)));
			String[] dvdInfo;

			while (file.hasNextLine()) {
				String dvdrecord = file.nextLine();
				dvdInfo = dvdrecord.split(DELIMITER);

				Dvd dvd = new Dvd();
				dvd.setTitle(dvdInfo[0]);
				dvd.setYear(Integer.parseInt(dvdInfo[1]));
				dvd.setMpaaRating(dvdInfo[2]);
				dvd.setDirector(dvdInfo[3]);
				dvd.setStudio(dvdInfo[4]);

				ArrayList<String> notesList = new ArrayList<>();
				for (int i = 5; i < dvdInfo.length; i++) {
					notesList.add(dvdInfo[i]);
				}

				dvd.setNotes(notesList);

				dvdLib.add(dvd);
			}
			file.close();
		} catch (FileNotFoundException | NullPointerException ex) {
			c.println("ERROR: " + ex.getMessage());
		}
	}

  public List<Dvd> getAll() {
		return dvdLib
			.stream()
			.collect(Collectors.toList());
	}

  public void writeDvdLib(String fileName) {
		PrintWriter file;
		try {
			file = new PrintWriter(new FileWriter(fileName));

			dvdLib
				.stream()
				.forEach(dvd -> {
					file.println(
						dvd.getTitle() + DELIMITER
						+ dvd.getYear() + DELIMITER
						+ dvd.getMpaaRating() + DELIMITER
						+ dvd.getDirector() + DELIMITER
						+ dvd.getStudio()
						+ toString(dvd.getNotes(), DELIMITER));
					file.flush();
				});
			file.close();
		} catch (IOException | NullPointerException ex) {
			c.println("Error: " + ex.getMessage());
		}
	}

  public String toStringWithIndex(Dvd dvd) {
		return "Film " + (dvdLib.indexOf(dvd) + 1)
			+ "\n\tTitle: " + dvd.getTitle()
			+ "\n\ttRelease Year: " + dvd.getYear()
			+ "\n\tMPAA Rating: " + dvd.getMpaaRating()
			+ "\n\tDirector: " + dvd.getDirector()
			+ "\n\tStudio: " + dvd.getStudio()
			+ "\n\tNotes:"
			+ toStringWithIndex(dvd.getNotes(), "\n\t  ", 1, ". ")
			+ "\n================================================================\n\n";
	}

  public String toString(Dvd dvd) {
		return "\n\tTitle: " + dvd.getTitle()
			+ "\n\ttRelease Year: " + dvd.getYear()
			+ "\n\tMPAA Rating: " + dvd.getMpaaRating()
			+ "\n\tDirector: " + dvd.getDirector()
			+ "\n\tStudio: " + dvd.getStudio()
			+ "\n\tNotes:"
			+ toStringWithIndex(dvd.getNotes(), "\n\t  ", 1, ". ")
			+ "\n================================================================\n\n";
	}

  public String toString(ArrayList<String> al, String delimiter) {
		notes = "";
		al
			.stream()
			.forEach(str -> {
				notes += (delimiter + str);
			});
		return notes;
	}

  public String toStringWithIndex(ArrayList<String> al, String delimiter, int start, String del2) {
		notes = "";
		al.stream()
			.forEach(str -> {
				notes += (delimiter + (al.indexOf(str) + start) + del2 + str);
			});
		return notes;
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

	public int numDvds() {
		return dvdLib.size();
	}

	@Override
  public List<Dvd> getByMpaa(String mpaa) {
		return dvdLib
			.stream()
			.filter(d -> d.getMpaaRating().matches(mpaa))
			.collect(Collectors.toList());
	}

	@Override
  public Map<String, List<Dvd>> getByDirectorSorted(String director) {
		return dvdLib
			.stream()
			.filter(d -> d.getDirector().equalsIgnoreCase(director))
			.collect(Collectors.groupingBy(Dvd::getMpaaRating));

	}

  public List<Dvd> listByDirector(String keyword) {

		List<Dvd> allMatches = new ArrayList<>();
		getByDirectorSorted(keyword).values()
			.stream()
			.forEach(list -> {
				list
				.stream()
				.forEach(a -> {
					allMatches.add(a);
				});
			});

		return allMatches;
	}

	@Override
  public List<Dvd> getByStudio(String studio) {
		return dvdLib
			.stream()
			.filter(d -> d.getStudio().equalsIgnoreCase(studio))
			.collect(Collectors.toList());
	}

	@Override
  public double getAvgAge() {
		return dvdLib
			.stream()
			.mapToInt(Dvd::getAge)
			.average()
			.getAsDouble();
	}

	@Override
  public List<Dvd> getNewest() {
		int young = dvdLib
			.stream()
			.mapToInt(Dvd::getAge)
			.min()
			.getAsInt();

		return dvdLib
			.stream()
			.filter(d -> d.getAge() == young)
			.collect(Collectors.toList());
	}

	@Override
  public List<Dvd> getOldest() {
		int old = dvdLib
			.stream()
			.mapToInt(Dvd::getAge)
			.max().getAsInt();

		return dvdLib
			.stream()
			.filter(d -> d.getAge() == old)
			.collect(Collectors.toList());
	}

	@Override
  public double getAvgNumNotes() {
		return dvdLib
			.stream()
			.mapToInt(Dvd::getNotesSize)
			.average().getAsDouble();
	}

  public List<Dvd> getSinceYear(int year) {
		return dvdLib
			.stream()
			.filter(d -> d.getYear() >= year)
			.collect(Collectors.toList());
	}

  public List<Dvd> getByKeyword(String keyword) {
		List<Dvd> allMatches = new ArrayList<>();
		allMatches.addAll(getByTitle(keyword));
		allMatches.addAll(getByMpaa(keyword));
		allMatches.addAll(getByStudio(keyword));
		allMatches.addAll(listByDirector(keyword));
		return allMatches;
	}
}
