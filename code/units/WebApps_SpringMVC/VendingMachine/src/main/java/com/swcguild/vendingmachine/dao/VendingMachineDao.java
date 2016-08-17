/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.vendingmachine.dao;

import com.swcguild.vendingmachine.model.Item;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface VendingMachineDao {
	public void writeFile() throws IOException;

	public void loadFile() throws FileNotFoundException, IOException;
	public List<Item> getAll() ;

	public int getQty(String key);

	public void vendItem(String key);	

	public Item getItem(String key);

	public void addItem(Item item);
}
