/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

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
public class StoringReadingSortingDataInFile {

  private Car[] cars = new Car[5];
  private ConsoleIO cio = new ConsoleIO();
  private final String DELIMITER = "::";
  private String tempName = "temp.txt";

  public String writeMemory() {

    for (int i = 0; i < cars.length; i++) {
      cars[i] = new Car();
      cio.println("Car " + (i + 1));
      cars[i].make = cio.get("\tMake: ");

      cars[i].model = cio.get("\tModel: ");

      cars[i].year = cio.getNum("\tYear: ");

      cars[i].license = cio.get("\tLicense: ");
      cio.println();

    }
    String fileName = cio.get("Save as: ");
    writeFile(fileName);
    return fileName;
  }

  public void writeFile(String fileName) {

    try {
      PrintWriter temp = new PrintWriter(new FileWriter(fileName));

      for (int i = 0; i < cars.length; i++) {
        temp.print(cars[i].make + DELIMITER);

        temp.print(cars[i].model + DELIMITER);

        temp.print(cars[i].year + DELIMITER);

        temp.print(cars[i].license + "\n");

        temp.flush();
      }
      temp.close();
    } catch (IOException ex) {
      Logger.getLogger(StoringReadingSortingDataInFile.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NullPointerException ex) {
      cio.println("ERROR: " + ex.getMessage());
    }
  }

  public Scanner readFile(String fileName) {
    Scanner file = null;
    try {
      file = new Scanner(new BufferedReader(new FileReader(fileName)));
      cio.println("Reading data from " + fileName + "\n");
      //arrayFromFile(file);
      //printMemory(cars);
    } catch (FileNotFoundException ex) {
      cio.println(ex.getMessage());
    }
    return file;
  }

  public Car[] arrayFromFile(Scanner file) {

    while (file.hasNextLine()) {
      for (int i = 0; i < cars.length; i++) {
        String record = file.nextLine();
        String[] r = record.split(DELIMITER);
        cars[i] = new Car();
        cars[i].make = r[0];
        cars[i].model = r[1];
        cars[i].license = r[3];
        try {
          cars[i].year = Integer.parseInt(r[2]);
        } catch (NumberFormatException ex) {
          cio.println(ex.getMessage());
        }
      }

    }
    return cars;
  }

  public void printMemory(Car[] cars) {
    this.cars = cars;
    try {
      for (int i = 0; i < cars.length; i++) {
        cio.println("Car " + (i + 1) + ":");
        cio.println("\tMake: " + cars[i].make);
        cio.println("\tModel: " + cars[i].model);
        cio.println("\tYear: " + cars[i].year);
        cio.println("\tLicense: " + cars[i].license);

      }
    } catch (NullPointerException ex) {
      cio.println(ex.getMessage());
    }

  }

  public void selectionSort(Car[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        swap(a, i, j);
      }
    }
  }
  public void selectionSortMake(Car[] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length; j++) {
        swapMake(a, i, j);
      }
    }
  }

  public void swap(Car[] a, int i, int j) {
    Car old;
    if (a[i].year < a[j].year) {
      old = a[i];
      a[i] = a[j];
      a[j] = old;
    }
  }
  public void swapMake(Car[] a, int i, int j) {
    Car old;
    if (a[i].make.compareTo(a[j].make) < a[j].make.compareTo(a[i].make)) {
      old = a[i];
      a[i] = a[j];
      a[j] = old;
    }
  }

}
