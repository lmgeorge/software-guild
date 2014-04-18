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
public class StoringDataInFile {

  private Car[] cars = new Car[5];
  private ConsoleIO7 cio = new ConsoleIO7();
  private final String DELIMITER = "::";
  private Scanner file;
  //private PrintWriter temp = null;
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
    tempName = cio.get("Save as: ");
    writeFile(tempName);
    return tempName;
  }

  public void writeFile(String tempName) {
    this.tempName = tempName;
   
    try {
      PrintWriter temp = new PrintWriter(new FileWriter(tempName));

      for (int i = 0; i < cars.length; i++) {
        temp.print(cars[i].make + DELIMITER);

        temp.print(cars[i].model + DELIMITER);

        temp.print(cars[i].year + DELIMITER);

        temp.print(cars[i].license + "\n");

        temp.flush();
      }
      temp.close();
    } catch (IOException ex) {
      Logger.getLogger(StoringDataInFile.class.getName()).log(Level.SEVERE, null, ex);
    } catch (NullPointerException ex) {
      cio.println("ERROR: " + ex.getMessage());
    }
  }

  public void readFile(String fileName) {

    try {
      file = new Scanner(new BufferedReader(new FileReader(fileName)));
      cio.println("Reading data from " + fileName + "\n");
      arrayFromFile(fileName);
      printMemory();
    } catch (FileNotFoundException ex) {
      cio.println(ex.getMessage());
    }

  }

  public void arrayFromFile(String fileName) {
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
  }

  public void printMemory() {
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

}
