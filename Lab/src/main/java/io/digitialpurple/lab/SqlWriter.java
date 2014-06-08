/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.digitialpurple.lab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SqlWriter {
	
	public static void main (String[] args){
		SqlWriter sw = new SqlWriter();
		
	
	}
	
	public void countriesSQL(){
		try {
			Scanner countries = new Scanner(
				new BufferedReader(new FileReader("list_of_countries.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter("countries.sql"));
			
			
			while (countries.hasNextLine()){
				String country = countries.nextLine();
				String insertCountry = "INSERT INTO Countries.CountryName value (\"" + country + "\");";
				
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
	
	public void statesSQL(){
		try {
			Scanner states = new Scanner(
				new BufferedReader(new FileReader("list_of_states.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter("states.sql"));
			
			
			while (states.hasNextLine()){
				String state = states.nextLine();
				String insertState = "INSERT INTO States.StateName value (\"" + state + "\");";
				
				writer.println(insertState);
				writer.flush();
			}
			
			writer.close();
		} catch (FileNotFoundException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(SqlWriter.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
