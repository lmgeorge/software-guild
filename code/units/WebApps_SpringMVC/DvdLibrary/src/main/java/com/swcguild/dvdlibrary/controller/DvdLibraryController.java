/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.dvdlibrary.controller;

import com.swcguild.dvdlibrary.dao.DvdLibraryDao;
import com.swcguild.dvdlibrary.model.Dvd;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
@Controller
public class DvdLibraryController {

	private List<Dvd> list = new ArrayList<>();
	private Dvd old;
	private DvdLibraryDao dao;

	@Inject
	public DvdLibraryController(DvdLibraryDao dao) {
		this.dao = dao;
	}

	//what the user will see in the url bar
	@RequestMapping(value = "/displayAddForm", method = RequestMethod.GET)
	public String displayAddForm() {
		return "add"; //return the desired jsp file
	}

	//should be called from add.jsp
	@RequestMapping(value = "/addDvd", method = RequestMethod.POST)
	public String addDvd(HttpServletRequest req, HttpServletResponse resp) {
		
		String title = req.getParameter("title");
		String studio = req.getParameter("studio");
		String director = req.getParameter("director");
		String mpaaRating = req.getParameter("mpaaRating");
		LocalDate releaseDate = LocalDate.parse(req.getParameter("releaseDate"));
		String note = req.getParameter("note");

		Dvd dvd = new Dvd();
		dvd.setTitle(title);
		dvd.setReleaseDate(releaseDate);
		dvd.setMpaaRating(mpaaRating);
		dvd.setDirector(director);
		dvd.setStudio(studio);
		dvd.setNote(note);

		dao.add(dvd);
		

		return "redirect:dvds";
	}

	@RequestMapping(value = "/dvds", method = RequestMethod.GET)
	public String displayDvds(Model model) {
		model.addAttribute("dvds", dao.listAll());
		
		return "displayDvds";
	}

	@RequestMapping(value = "/deleteDvd", method = RequestMethod.GET)
	public String deleteDvd(@RequestParam("id") int id) {
			dao.remove(id);
			
			return "redirect:dvds";
	}

	@RequestMapping(value = "/displayEditForm", method = RequestMethod.GET)
	public String displayEditForm(@RequestParam("id") int id, 
		Model model) {
			
		Dvd dvd = dao.getDvd(id);
		
		model.addAttribute("dvd", dvd);
		
		return "edit";
	}

	@RequestMapping(value = "/updateDvd", method = RequestMethod.POST)
	public String updateDvd(@ModelAttribute("dvd") Dvd dvd, Model model) {
		
		dao.update(dvd);

		return "redirect:dvds";

	}

	@RequestMapping(value = "/findDvd", method = RequestMethod.POST)
	public String findDvd(HttpServletRequest req, HttpServletResponse resp) {
		
		String keyword = req.getParameter("keyword");

		list = new ArrayList<>();
		list.addAll(dao.getByRating(keyword));
		list.addAll(dao.getByStudio(keyword));
		list.addAll(dao.getByTitle(keyword));

		try {
			int years = Integer.parseInt(keyword);
			list.addAll(dao.getReleasesInLastNYears(years));
			
		} catch (NumberFormatException ex) {
			
			return "redirect:results";
		}

		return "redirect:results";
	}
	
		@RequestMapping(value = "/results", method = RequestMethod.GET)
	public String displayResults(Model model) {
		model.addAttribute("results", list);
		return "displayResults";
	}

	@RequestMapping(value = "/stats", method = RequestMethod.GET)
	public String displayStats(Model model) {
		model.addAttribute("averageAge", dao.getAverageAge());
		model.addAttribute("size", dao.listAll().size());
		
		return "displayStats";
	}

	public boolean compareObject(Dvd dvd1, Dvd dvd2) {
		return dvd1.getTitle().equals(dvd2.getTitle())
			&& dvd1.getDirector().equals(dvd2.getDirector())
			&& dvd1.getMpaaRating().equals(dvd2.getMpaaRating())
			&& dvd1.getStudio().equals(dvd2.getStudio())
			&& (dvd1.getReleaseDate().compareTo(dvd2.getReleaseDate()) == 0);
	}


}
