/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package records;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class GettingDataFromAFile {

  private ConsoleIO7 cio = new ConsoleIO7();

  private Scanner file;
  private Canine[] k9 = new Canine[5];

  public void run() {

    String fileName = "canine.txt"; //cio.get("Which file to open: ");

    readFile(fileName);

    arrayFromFile(fileName);

    cio.println();

  }

  public void readFile(String fileName) {

    try {
      file = new Scanner(new BufferedReader(new FileReader(fileName)));
      cio.println("Reading data from " + fileName + "\n");
//
//      while (file.hasNextLine()) {
//        String record = file.nextLine();
//        record = record.replaceAll("::", ", ");
//
//        cio.println((record) + "\n");
//      }

    } catch (FileNotFoundException ex) {
      cio.println(ex.getMessage());
    }

  }

  public void arrayFromFile(String filename) {
    while (file.hasNextLine()) {
      for (int i = 0; i < k9.length; i++) {
        String record = file.nextLine();
        String[] r = record.split("::");
        k9[i] = new Canine();
        k9[i].name = r[0];
        k9[i].breed = r[1];
        k9[i].sex = r[2];
        try {
          k9[i].age = Integer.parseInt(r[3]);
          k9[i].weight = Double.parseDouble(r[4]);
        } catch (NumberFormatException ex) {
          cio.println(ex.getMessage());
        }
      }

    }
   
    try {
      for (int i = 0; i < k9.length; i++) {
        cio.println("Dog " + (i + 1) + " name: " + k9[i].name);
        cio.println("Dog " + (i + 1) + " breed: " + k9[i].breed);
        cio.println("Dog " + (i + 1) + " sex: " + k9[i].sex);
        cio.println("Dog " + (i + 1) + " age: " + k9[i].age + " years");
        cio.println("Dog " + (i + 1) + " weight: " + k9[i].weight + " lbs\n");

      }
    } catch (NullPointerException ex) {
      cio.println(ex.getMessage());
    }

  }
}
