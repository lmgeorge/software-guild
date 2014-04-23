/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class VendingMachine {

  private HashMap<String, Item> vm = new HashMap<>();
  private final String fileName = "vendingMachine.txt";
  private String DELIMITER = "::";
  private ConsoleIO c = new ConsoleIO();

  public void writeFile() throws Exception {
    String[] keys = getKeys();
    PrintWriter file = new PrintWriter(new FileWriter(fileName));
    for (int i = 0; i < vm.size(); i++) {
      Item item = vm.get(keys[i]);
      file.println(
        item.getName() + DELIMITER
        + item.getCost() + DELIMITER
        + item.getQuantity()
      );
      file.flush();
    }
    file.close();
  }

  public void loadFile() throws Exception {

    Scanner file = new Scanner(new BufferedReader(new FileReader(fileName)));
    String entry;
    String[] entries;
    while (file.hasNextLine()) {
      entry = file.nextLine();
      entries = entry.split(DELIMITER);
      Item item = new Item();
      item.setName(entries[0]);
      item.setCost(Float.parseFloat(entries[1]));
      item.setQuantity(Integer.parseInt(entries[2]));

      vm.put(item.getName(), item);
    }
    file.close();
  }


  public int getQty(String key) {
    return vm.get(key).getQuantity();
  }

  public void vendItem(String key) {
    int newQty = vm.get(key).getQuantity() - 1;
    vm.get(key).setQuantity(newQty);
  }

  public String[] getKeys() {
    return vm.keySet().toArray(new String[0]);
  }

  public Item getItem(String key) {
    return vm.get(key);
  }

  public void addItem(Item item) {
    vm.put(item.getName(), item);
  }
}
