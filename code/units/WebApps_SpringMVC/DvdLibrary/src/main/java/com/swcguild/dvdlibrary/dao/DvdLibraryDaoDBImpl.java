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
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DvdLibraryDaoDBImpl implements DvdLibraryDao {

	
	private List<Dvd> dvdLib = new ArrayList<>();
	

	private static final String SQL_INSERT_DVD
		= "insert into dvds (`title`, `director`, `release_date`, `mpaa_rating`, `studio`, `note`)"
		+ "values (?,?,?,?,?,?)";
	private static final String SQL_DELETE_DVD
		= "delete from dvds "
		+ "where dvdID = ?";
	private static final String SQL_UPDATE_DVD
		= "update dvds"
		+ "set title = ?,"
		+ "director = ?,"
		+ "release_date = ?,"
		+ "mpaa_rating = ?,"
		+ "studio = ?,"
		+ "note = ? "
		+ "where dvdID = ?";
	private static final String SQL_SELECT_DVD
		= "select * from dvds "
		+ "where dvdID = ?";
	private static final String SQL_SELECT_ALL_DVDS
		= "select * from dvds";

	private static final String SQL_SELECT_BY_TITLE
		= "select * from dvds"
		+ "where title rlike ?";

	private static final String SQL_SELECT_BY_STUDIO
		= "select * from dvds"
		+ "where studio rlike ?";

	private static final String SQL_SELECT_BY_RATING
		= "select * from dvds"
		+ "where mpaa_rating rlike ?";

	private static final String SQL_SELECT_BY_YEAR
		= "select * from dvds "
		+ "where extract(year from BirthDate) >= ?;";
	
	private static final String SQL_SELECT_YEARS
		= "select extract(year from BirthDate) from dvds";


	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Dvd> listAll() {
		return jdbcTemplate.query(SQL_SELECT_ALL_DVDS, new DvdMapper());
	}

	public Dvd getDvd(int dvdID) {

		try {
			return jdbcTemplate.queryForObject(SQL_SELECT_DVD, new DvdMapper(), dvdID);
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void add(Dvd dvd) {
		jdbcTemplate.update(SQL_INSERT_DVD,
			dvd.getTitle(),
			dvd.getDirector(),
			dvd.getReleaseDate(),
			dvd.getMpaaRating(),
			dvd.getStudio(),
			dvd.getStudio());
		dvd.setDvdID(
			jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
	}

	public void remove(int dvdID) {
		jdbcTemplate.update(SQL_DELETE_DVD, dvdID);
	}

	public void update(Dvd dvd) {
		jdbcTemplate.update(SQL_UPDATE_DVD,
			dvd.getTitle(),
			dvd.getDirector(),
			dvd.getReleaseDate(),
			dvd.getMpaaRating(),
			dvd.getStudio(),
			dvd.getNote(),
			dvd.getDvdID());
	}

	public List<Dvd> getByTitle(String title) {
		return jdbcTemplate.query(SQL_SELECT_BY_TITLE, new DvdMapper(), title);
	}

	@Override
	public List<Dvd> getByRating(String mpaaRating) {
		return jdbcTemplate.query(SQL_SELECT_BY_RATING, new DvdMapper(), mpaaRating);
	}

	@Override
	public List<Dvd> getByStudio(String studio) {
		return jdbcTemplate.query(SQL_SELECT_BY_STUDIO, new DvdMapper(), studio);
	}

	@Override
	public float getAverageAge() {
		List<Integer> years;
		years = jdbcTemplate.queryForList(SQL_SELECT_YEARS, Integer.class);
		float sum = 0;
		float age;
		
		for (Integer year : years) {
			sum += year;
		}
		
		age = sum/years.size();
		
		return age;
		
	}

	public List<Dvd> getReleasesInLastNYears(int year) {
		return jdbcTemplate.query(SQL_SELECT_BY_YEAR, new DvdMapper(), year);
	}

	private static final class DvdMapper implements ParameterizedRowMapper<Dvd> {

		@Override
		public Dvd mapRow(ResultSet rs, int i) throws SQLException {
			Dvd dvd = new Dvd();
			dvd.setTitle(rs.getString("title"));
			dvd.setReleaseDate(rs.getObject("release_date", LocalDate.class));
			dvd.setDirector(rs.getString("director"));
			dvd.setNote(rs.getString("note"));

			return dvd;
		}


	}

	public void loadFromFile() {
	}

	public void writeToFile() {
	}


}
