/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.digitalpurple.lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SqlWriter {
	private String industries = "`industries`";
	private String countries = "`countries`";
	private String states = "`states`";
	private String cities = "`cities`";
	
	private String countriesFile = 
		"/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/list_of_countries.txt";
	private String countriesSql = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/countries.sql";
	
	private String industriesFile = "";
	private String industriesSql = "";
	
	public static void main(String[] args) throws IOException {
		SqlWriter sw = new SqlWriter();

		sw.countriesSQL();
		Map<Integer, String> map = sw.statesSQL();
		sw.industriesSQL();

		sw.mapCityToStateId(sw.getStatesFromDB(map));
	}

	public void countriesSQL() {
		try {
			Scanner countries = new Scanner(
				new BufferedReader(new FileReader(countriesFile)));
			PrintWriter writer = new PrintWriter(new FileWriter(countriesSql));

			writer.println("USE STARSYSTEM_StudentsDB;");
			writer.println("USE STARSYSTEM_StudentsDB_Test;\n");
			writer.println("DELETE FROM `countries`;");
			writer.println("ALTER TABLE `countries` auto_increment = 1;\n");

			while (countries.hasNextLine()) {
				String country = countries.nextLine();
				String insertCountry = "INSERT INTO `countries`(`country`) value (\"" + country + "\");";

				writer.println(insertCountry);
				writer.flush();
			}

			writer.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Map<Integer, String> statesSQL() {
		Map<Integer, String> map = new HashMap<>();
		int ctr = 1;
		try {
			Scanner states = new Scanner(
				new BufferedReader(new FileReader("/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/list_of_state_abbrs.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter("/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/states.sql"));

			writer.println("USE STARSYSTEM_StudentsDB;");
			writer.println("USE STARSYSTEM_StudentsDB_Test;\n");

			writer.println("DELETE FROM `states`;");
			writer.println("ALTER TABLE `states` auto_increment = 1;\n");

			while (states.hasNextLine()) {
				String state = states.nextLine();
				String insertState = "INSERT INTO `states`(`state`) value (\"" + state + "\");";
				map.put(ctr, state);
				ctr++;
				writer.println(insertState);
				writer.flush();
			}

			writer.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		}

		return map;
	}

	public void industriesSQL() {
		try {
			Scanner industries = new Scanner(
				new BufferedReader(new FileReader("/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/list_of_industries.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter("/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/industries.sql"));

			writer.println("USE STARSYSTEM_StudentsDB;");
			writer.println("USE STARSYSTEM_StudentsDB_Test;\n");

			writer.println("DELETE FROM `industries`;");
			writer.println("ALTER TABLE `industries` auto_increment = 1;\n");

			while (industries.hasNextLine()) {
				String industry = industries.nextLine();
				String insertIndustry = "INSERT INTO `industries`(`industry`) value (\"" + industry + "\");";

				writer.println(insertIndustry);
				writer.flush();
			}

			writer.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private final String MSA_CITIES = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/msaCities.txt";
	private final String STATES_ABBR = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/statename_stateabbr.txt";
	private final String CITIES_SQL = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/cities.sql";

	public Map<String, Integer> getStatesFromDB(Map<Integer, String> allStates) throws FileNotFoundException, IOException {

			//Read in the State abbreviations file and map with an id from DB
		//<StateName, Order in File>
		Scanner sc1 = new Scanner(new BufferedReader(new FileReader(STATES_ABBR)));
		Map<String, Integer> stateNames = new HashMap<>();

		while (sc1.hasNextLine()) {
			String[] states = sc1.nextLine().split(",");
			String state = states[0].trim().toUpperCase();
			String abbr = states[1].trim().toUpperCase();
			int id = allStates.keySet()
				.stream()
				.filter(key -> allStates.get(key).equalsIgnoreCase(abbr))
				.findAny()
				.get();

			stateNames.put(state, id);
		}
		return stateNames;
	}

	//read in the msaCities file as a list
	//<CityName, StateName>
	public void mapCityToStateId(Map<String, Integer> mappedStates) throws FileNotFoundException {
		Scanner sc = new Scanner(new BufferedReader(new FileReader(MSA_CITIES)));
		PrintWriter writer = new PrintWriter(CITIES_SQL);
		
		writer.println("USE STARSYSTEM_StudentsDB;");
		writer.println("USE STARSYSTEM_StudentsDB_Test;\n");

		writer.println("DELETE FROM `cities`;");
		writer.println("ALTER TABLE `cities` auto_increment = 1;\n");

		while (sc.hasNextLine()) {
			String[] msaCity = sc.nextLine().split(",");
			String state = msaCity[1].trim().toUpperCase();
			String city = msaCity[0].trim().replaceAll("[']", "&lsquo;");
			//get out the CityName and map it with the mappedAbbrs id
			int id = mappedStates.get(state);

			writer.println("INSERT INTO cities(stateID, city) values (" + id + ", \"" + city + "\");");
			writer.flush();
		}
		writer.close();
	}


}
