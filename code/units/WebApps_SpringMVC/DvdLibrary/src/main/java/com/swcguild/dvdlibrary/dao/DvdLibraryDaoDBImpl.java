/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.dao;

import com.swcguild.dvdlibrary.model.Dvd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DvdLibraryDaoDBImpl implements DvdLibraryDao {

	private String notes;
	private List<Dvd> dvdLib = new ArrayList<>();
	private final String DELIMITER = "::";

	private static final String SQL_INSERT_DVD = 
		"insert into dvds (`title`, `release_date`, `mpaa_rating`, `studio`, `note`)"
		+ "values (?,?,?,?,?)";
	private static final String SQL_DELETE_DVD = 
		"delete from dvds "
		+ "where title = ? AND release_date = ?";
	private static final String SQL_UPDATE_DVD = 
		"update dvds"
		+ "set title = ?,"
		+ "release_date = ?,"
		+ "mpaa_rating = ?,"
		+ "studio = ?,"
		+ "note = ? "
		+ "where title = ? AND release_date = ?";
	private static final String SQL_SELECT_DVD = 
		"select * from dvds "
		+ "where title = ? AND release_date = ?";
	private static final String SQL_SELECT_ALL_DVDS =
		"select * from dvds";
	private static final String SQL_SELECT_BY_STUDIO =
		"select * from "
		+ "where studio = ?";

	private static final String SQL_SELECT_BY_RATING = 
		"select * from "
		+ "where mpaa_rating = ?";

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Dvd> listAll() {
		return dvdLib
			.stream()
			.collect(Collectors.toList());
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

	//Utility method for loadFromFile
	public LocalDate checkDate(String str) {
		LocalDate date = IsoChronology.INSTANCE.dateNow();
		try {
			date = LocalDate.parse(str);
		} catch (DateTimeParseException | NullPointerException ex) {
			Logger
				.getLogger(DvdLibraryDaoDBImpl.class.getName())
				.log(Level.OFF, ("Error: " + ex.getMessage()));
		}
		return date;
	}

	//Utility method for loadFromFile
	public String toString(ArrayList<String> al, String delimiter) {
		notes = "";
		al
			.stream()
			.forEach(str -> {
				notes += (delimiter + str);
			});
		return notes;
	}

	private static final class DvdMapper implements ParameterizedRowMapper<Dvd>{

		@Override
		public Dvd mapRow(ResultSet rs, int i) throws SQLException {
			Dvd dvd = new Dvd();
			dvd.setTitle(rs.getString("title"));
			dvd.setReleaseDate(rs.getDate("release_date").toLocalDate());
			dvd.setTitle(rs.getString("title"));
			dvd.setTitle(rs.getString("title"));
		}
		
	}
	
	public void loadFromFile() {
	}

	public void writeToFile() {
	}


}
