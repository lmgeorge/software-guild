/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.dvdlibrary.gui;

import com.swcguild.dvdlibrary.model.Dvd;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface DvdGUI {
	public void print(String str);
	public int printMenu(String str, int min, int max);
	public void printMenuTitle(int choice);
	public Dvd createDvd();
	public boolean confirm(String prompt);
	public String getSearchParam(int choice) ;
	public Dvd getObj(List<Dvd> dvdList);
	public void printStats(float average);
	public String toStringWithIndex(Dvd dvd, int index);
	public String toString(Dvd dvd) ;
	public LocalDate checkDate(String prompt);
	public Dvd editor(Dvd dvd, int ui);
}
