/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class VMController {

  private final ConsoleIO c = new ConsoleIO();
  private VendingMachine vender = new VendingMachine();
  private final NumberFormat n = NumberFormat.getCurrencyInstance(Locale.US);
  private ArrayList<Item> al = new ArrayList<>();
  private Change change = new Change();
  String more;
  int choice;
  public void vend() throws Exception {
    vender.loadFile();
    c.println("VENDING MACHINE\n");
    do {
      stockedItems();

      choice = c.getsNum("Please enter your choice: ", 0, al.size());
        if (choice == 0){
          c.println("Goodbye!\n");
          return;
        }
      buyItem(choice);
      
      more = c.gets("Would you like to buy something else (y/n)? ");
    } while (more.contains("y"));
    c.println("Enjoy!\n");
    
  }

  public void stockedItems() {
    String[] keys = vender.getKeys();

    for (int i = 0; i < keys.length; i++) {
      Item item = vender.getItem(keys[i]);
      if (item.getQuantity() > 0) {
        al.add(item);
      }
    }

    for (int i = 0; i < al.size(); i++) {
      c.println((i + 1) + ". " + al.get(i).getName() + "......." + n.format(al.get(i).getCost()));
    }
    c.println("0. Cancel\n");
  }

  public void buyItem(int choice) throws Exception {
    float money = c.getsFloat("\nEnter your money: ");
    Item item = al.get(choice - 1);

    while (money < item.getCost()) {
      c.println(n.format(money));
      money += c.getsFloat("\nInsufficient funds. Please enter money: ");
    }
    vender.vendItem(item.getName());
    vender.writeFile();
    int userChange = (int) ((money - item.getCost()) * 100);

    change.getChange(userChange);

    c.println("\nYour change: " + change.getQuarters() + " quarters, "
      + change.getDimes() + " dimes, "
      + change.getNickels() + " nickels, and "
      + change.getPennies() + " pennies.\n");
    
    al.clear();
  }
}
