/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamebot;

import java.util.ArrayList;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Menu {

  ConsoleIO10 c = new ConsoleIO10();

  public void run() {
    ArrayList<Game> games = new ArrayList<>();

    games.add(new Lucky());
    games.add(new HangmanEngine());
    while (true) {
      c.println("\tWelcome to GameBot!\n");
      for (int i = 0; i < games.size(); i++) {
        c.println((i + 1) + ". " + games.get(i));
      }
      int choice = c.getsNum("0. Exit\n"
        + "\nEnter your selection: ", 0, games.size());
      c.println("\n");
      if (choice == 0) {
        c.println("\nThanks for playing!");
        return;
      }
      games.get(choice - 1).run();
      c.println("\n");
    }
  }
}
