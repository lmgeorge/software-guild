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

	private static final String industriesTable = "`industries`";
	private static final String tableName = "`countries`";
	private static final String statesTable = "`states`";
	private static final String citiesTable = "`cities`";

	private static final String countriesFile
		= "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/list_of_countries.txt";
	private static final String countriesSql = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/countries.sql";

	private static final String industriesFile = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/list_of_industries.txt";
	private static final String industriesSql = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/industries.sql";

	private static final String statesFile = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/list_of_state_abbrs.txt";
	private static final String statesSql = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/states.sql";

	private final String MSA_CITIES = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/msaCities.txt";
	private final String STATES_ABBR = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataTxt/statename_stateabbr.txt";
	private final String CITIES_SQL = "/home/apprentice/Documents/GitHub/Java-April2014-Group-Capstone/DBFiles/refDataSql/cities.sql";
	private static final String usingStmts = "USE STARSYSTEM_StudentsDB;\n";
	private static final String usingStmtTest = "\nUSE STARSYSTEM_StudentsDB_Test;\n";
	private static final String deleteStmts = "DELETE FROM %s;\n\n";
	private static final String auto_increment = "ALTER TABLE %s auto_increment = 1;\n\n";

	public static void main(String[] args) throws IOException {
		SqlWriter sw = new SqlWriter();

		sw.singleValueInsertSQL("`country`", "`countries`", countriesFile, countriesSql);
//		Map<Integer, String> map = sw.statesSQL();
//		sw.industriesSQL();
//
//		sw.mapCityToStateId(sw.getStatesFromDB(map));
//		String cote = "Cote d' Ivoire".replaceAll("[']", "\\\\'");
//		System.out.println(cote);
	}

	public void singleValueInsertSQL(String colName, String tableName, String inFile, String outFile) {
		try {
			Scanner data = new Scanner(new BufferedReader(new FileReader(inFile)));
			Scanner dataTest = new Scanner(new BufferedReader(new FileReader(inFile)));
			PrintWriter writer = new PrintWriter(new FileWriter(outFile));

			//Inserts for production database
			writer.println(usingStmts);
			writer.printf(deleteStmts, tableName);
			writer.printf(auto_increment, tableName);

			while (data.hasNextLine()) {
				String datum = data.nextLine();

				writer.printf("INSERT INTO %s(%s) value (\"%s\");\n", tableName, colName, datum);
				writer.flush();
			}

			//Inserts for test database
			writer.println(usingStmtTest);
			writer.printf(deleteStmts, tableName);
			writer.printf(auto_increment, tableName);

			while (dataTest.hasNextLine()) {
				String datumTest = dataTest.nextLine();

				writer.printf("INSERT INTO %s(%s) value (\"%s\");\n", tableName, colName, datumTest);
				writer.flush();
			}

			writer.close();

		} catch (IOException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Map<Integer, String> singleValueInsertMapSQL(String colName, String tableName, String inFile, String outFile) {
		Map<Integer, String> map = new HashMap<>();
		int ctr = 1;
		try {
			Scanner data = new Scanner(new BufferedReader(new FileReader(inFile)));
			Scanner dataTest = new Scanner(new BufferedReader(new FileReader(inFile)));
			PrintWriter writer = new PrintWriter(new FileWriter(outFile));

			//Inserts for production database
			writer.println(usingStmts);
			writer.printf(deleteStmts, tableName);
			writer.printf(auto_increment, tableName);

			while (data.hasNextLine()) {
				String datum = data.nextLine();
				writer.printf("INSERT INTO %s(%s) value (\"%s\");\n", tableName, colName, datum);
				
				map.put(ctr, datum);
				ctr++;
				
				writer.flush();
			}

			//Inserts for test database
			writer.println(usingStmtTest);
			writer.printf(deleteStmts, tableName);
			writer.printf(auto_increment, tableName);

			while (dataTest.hasNextLine()) {
				String datumTest = dataTest.nextLine();

				writer.printf("INSERT INTO %s(%s) value (\"%s\");\n", tableName, colName, datumTest);
				writer.flush();
			}

			writer.close();
		} catch (IOException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		}

		return map;
	}

	public void industriesSQL() {
		try {
			Scanner industries = new Scanner(
				new BufferedReader(new FileReader(industriesFile)));
			PrintWriter writer = new PrintWriter(new FileWriter(industriesSql));

			writer.println("USE STARSYSTEM_StudentsDB;");
			writer.println("USE STARSYSTEM_StudentsDB_Test;\n\n");

			writer.println("DELETE FROM `industries`;");
			writer.println("ALTER TABLE `industries` auto_increment = 1;\n\n");

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
