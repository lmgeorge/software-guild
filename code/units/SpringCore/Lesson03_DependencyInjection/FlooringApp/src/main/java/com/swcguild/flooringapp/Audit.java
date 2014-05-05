/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.flooringapp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Audit {

	private File LOG;

	public void logAdd() {
		try {

			LOG = new File("FlooringAppAudit.txt");
			if (!LOG.exists()) {
				LOG.createNewFile();
			}

			FileWriter add = new FileWriter(LOG.getName(), true);
			BufferedWriter buff = new BufferedWriter(add);

			buff.write(getTime() + " : Order added.\n");
			buff.close();

		} catch (Throwable ex) {
			System.out.println("Error: Audit failed.");
		}
	}

	public void logEdit() {
		try {
			LOG = new File("FlooringAppAudit.txt");
			if (!LOG.exists()) {
				LOG.createNewFile();
			}

			FileWriter add = new FileWriter(LOG.getName(), true);
			BufferedWriter buff = new BufferedWriter(add);

			buff.write(getTime() + " : Order edited.\n");
			buff.close();
		} catch (Throwable ex) {
			System.out.println("Error: Audit failed.");
		}

	}

	public void logDelete() {
		try {
			LOG = new File("FlooringAppAudit.txt");
			if (!LOG.exists()) {
				LOG.createNewFile();
			}

			FileWriter add = new FileWriter(LOG.getName(), true);
			BufferedWriter buff = new BufferedWriter(add);

			buff.write(getTime() + " : Order removed.\n");
			buff.close();

		} catch (Throwable ex) {
			System.out.println("Error: Audit failed.");
		}

	}

	public String getTime() {
		String stringDate = "";

		try {
			DateTimeFormatter formatter = DateTimeFormatter.RFC_1123_DATE_TIME;
			ZonedDateTime dateTime = ZonedDateTime.now(ZoneOffset.UTC);
			stringDate = dateTime.format(formatter);

		} catch (Throwable ex) {
			System.out.println("Error: Cannot get date.");
		}
		return stringDate;
	}


}
