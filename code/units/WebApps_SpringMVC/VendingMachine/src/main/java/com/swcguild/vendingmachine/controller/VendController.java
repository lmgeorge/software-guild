/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.vendingmachine.controller;

import com.swcguild.vendingmachine.dao.VendingMachineDao;
import com.swcguild.vendingmachine.model.Change;
import com.swcguild.vendingmachine.model.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
@Controller
public class VendController {

	private VendingMachineDao dao;
	private Item memItem;

	@Inject
	public VendController(VendingMachineDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "/menu", method = RequestMethod.GET)
	public String displayMenu(Model model) {
		try {
			try {
				dao.loadFile();
			} catch (IOException ex) {
				Logger.getLogger(VendController.class.getName()).log(Level.SEVERE, null, ex);
				return "index";
			}
			Item item = new Item();

			model.addAttribute("menuList", dao.getAll());
			model.addAttribute("choice", item);
			dao.writeFile();

			return "menu";
		} catch (IOException ex) {
			Logger.getLogger(VendController.class.getName()).log(Level.SEVERE, null, ex);
			return "index";
		}

	}

	@RequestMapping(value = "/returnSelection", method = RequestMethod.POST)
	public String returnSelection(@ModelAttribute("choice") Item item, Model model) throws IOException {
		dao.loadFile();
		memItem = new Item();
		memItem = dao.getItem(item.getName());
		model.addAttribute("choice", memItem);
		Change change = new Change();
		model.addAttribute("calc", change);
		dao.writeFile();
		return "pay";
	}

	@RequestMapping(value = "/vend", method = RequestMethod.GET)
	public String vend(@ModelAttribute("choice") Item item, Model model) throws IOException {

		try {
			dao.loadFile();

			model.addAttribute("menuList", dao.getAll());
			model.addAttribute("choice", item);

			dao.writeFile();
		} catch (IOException ex) {
			Logger.getLogger(VendController.class.getName()).log(Level.SEVERE, null, ex);
			dao.writeFile();
			return "pay";
		}

		return "pay";
	}

	@RequestMapping(value = "/buyItem", method = RequestMethod.POST)
	public String buyItem(@ModelAttribute("calc") Change change, Model model) {
		change.getChange(memItem.getCost());
		model.addAttribute("choice", memItem);
		model.addAttribute("calc", change);
		try {
			dao.loadFile();
			dao.vendItem(memItem.getName());
			dao.writeFile();
		} catch (IOException ex) {
			return "pay";
		} catch (NullPointerException ex) {
			return "menu";
		}
		return "enjoy";
	}


}
