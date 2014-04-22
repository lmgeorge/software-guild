/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylists;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class BasicArrayLists {

  private final ConsoleIO cio = new ConsoleIO();
  private final Random rGen = new Random();
  private int r;

  public void simple() {
    ArrayList<Integer> al = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      al.add(-113);
    }

    for (int i = 0; i < al.size(); i++) {
      cio.println("Slot " + i + " contains a " + al.get(i));
    }
    cio.println();
  }

  public void random(int n) {
    ArrayList<Integer> al = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      r = rGen.nextInt(100) + 1;
      al.add(r);
    }

    cio.print("ArrayList: " + al + "\n\n");

  }

  public ArrayList<Integer> randomer(int n, int seed, int floor) {
    ArrayList<Integer> al = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      r = rGen.nextInt(100) + 1;
      al.add(r);
    }

    return al;
  }

  public void random1000() {
    ArrayList<Integer> al = new ArrayList<>();

    for (int i = 0; i < 1000; i++) {
      r = rGen.nextInt(90) + 10;
      al.add(r);
    }

    cio.print("ArrayList: " + al + "\n\n");
  }

  public void copyCat(int n) {
    ArrayList<Integer> al = new ArrayList<>();
    ArrayList<Integer> al2 = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      r = rGen.nextInt(100) + 1;
      al.add(r);
      al2.add(r);
    }
    al.set((n - 1), -7);
    cio.print("ArrayList 1: " + al + "\n");
    cio.print("ArrayList 2: " + al2 + "\n\n");
  }

  public void finder(int n) {
    ArrayList<Integer> al = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      r = rGen.nextInt(50) + 1;
      al.add(r);
    }
    cio.print("ArrayList: " + al + "\n");
    int x = cio.getNum("Value to find: ");

    if (al.contains(x)) {
      cio.println(x + " is in the ArrayList in slot " + al.lastIndexOf(x) + ".");
    } else {
      cio.println(x + " is not in the ArrayList.");
    }

  }

  public void largest() {
    ArrayList<Integer> al = new ArrayList<>();

    for (int i = 0; i < 10; i++) {
      r = rGen.nextInt(100) + 1;
      al.add(r);
    }
    cio.print("ArrayList: " + al + "\n");
    int max = al.get(0);
    for (Integer al1 : al) {
      if (al1 > max) {
        max = al1;
      }
    }
    cio.println("Largest value: " + max);
    cio.println("Slot number: " + al.lastIndexOf(max));

  }

  public void sortBigSmall() {

    ArrayList<Integer> al = randomer(10, 90, 10);

    cio.println("ArrayList before: " + al);

    int temp;
    for (int i = 0; i < al.size(); i++) {
      for (int j = 0; j < al.size(); j++) {
        if (al.get(i) > al.get(j)) {
          temp = al.get(j);
          al.set(j, al.get(i));
          al.set(i, temp);
        }
      }
    }

    cio.println("ArrayList after: " + al);

  }

  public void sortWords() {
    try {
      Scanner file = new Scanner(new BufferedReader(new FileReader("words.txt")));
      ArrayList<String> al = new ArrayList<>();
      ArrayList<String> words = new ArrayList<>();
      while (file.hasNextLine()) {
        String word = file.nextLine();
        words.add(word);
      }

      for (int i = 0; i < 10; i++) {
        r = rGen.nextInt(3000);
        al.add(words.get(r));
      }

      cio.println("ArrayList before: " + al);

      String temp;
      for (int i = 0; i < al.size(); i++) {
        for (int j = 0; j < al.size(); j++) {
          if (al.get(i).compareTo(al.get(j)) < al.get(j).compareTo(al.get(i))) {
            temp = al.get(j);
            al.set(j, al.get(i));
            al.set(i, temp);
          }
        }
      }

      cio.println("ArrayList after: " + al);
    } catch (FileNotFoundException | NullPointerException ex) {
      cio.println(ex.getMessage());
    }
  }

  public void sortSentence() {
    String sentence = cio.gets("Please enter a sentence: ");
    String[] jumble = sentence.toLowerCase().split(" ");
    ArrayList<String> words = new ArrayList<>();

    words.addAll(Arrays.asList(jumble));

    cio.println("Sentence: " + sentence);

    String temp;
    for (int i = 0; i < words.size(); i++) {
      for (int j = 0; j < words.size(); j++) {
        if (words.get(i).compareTo(words.get(j)) < words.get(j).compareTo(words.get(i))) {
          temp = words.get(j);
          words.set(j, words.get(i));
          words.set(i, temp);
        }
      }
    }

    cio.println("Sorted: " + words);
  }

  public void sortRecords() {
    try {
      Scanner file = new Scanner(new BufferedReader(new FileReader("cars.txt")));
      ArrayList<Car> al = new ArrayList<>();
      while (file.hasNextLine()) {
        String line = file.nextLine();
        String[] attrs = line.split("::");
        Car car = new Car();

        car.setMake(attrs[0]);
        car.setModel(attrs[1]);
        car.setYear(Integer.parseInt(attrs[2]));
        car.setLicense(attrs[3]);
        al.add(car);
      }

      Car temp;
      for (int i = 0; i < al.size(); i++) {
        for (int j = 0; j < al.size(); j++) {
          if (al.get(i).getYear() < al.get(j).getYear()) {
            temp = al.get(j);
            al.set(j, al.get(i));
            al.set(i, temp);
          }
        }
      }
      cio.println("ArrayList: "); 
      for (int i = 0; i < al.size(); i++){
        al.get(i).toStringer();
      }
      
      
      
      
      
    } catch (FileNotFoundException | NullPointerException ex) {
      cio.println(ex.getMessage());
    }

  }

}
