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

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SortingTwoFields {

  //private ReportCard rc = new ReportCard();
  private final ConsoleIO7 cio = new ConsoleIO7();
  private final String DELIMITER = " ";
  private final String RECORD_FILE = "gb.txt";
  private final ReportCard[] r = new ReportCard[30];

  public Scanner openFile(String prompt) {
    String fileName = "gb.txt";//cio.get(prompt);
    Scanner file = null;
    try {
      file = new Scanner(new BufferedReader(new FileReader(fileName)));
      cio.println("Reading data from " + fileName + "\n");
      
      loadReportCard(file);
     
      sort();
     
      printReportCard(fileName);

    } catch (FileNotFoundException ex) {
      cio.println(ex.getMessage());
    }
    return file;
  }

  public void loadReportCard(Scanner file) {

    String currentLine;
    String[] reportCards;

    while (file.hasNextLine()) {
      for (int i = 0; i < r.length; i++) {
        ReportCard reportCard = new ReportCard();
        currentLine = file.nextLine();
        reportCards = currentLine.split(DELIMITER);

        reportCard.setId(Integer.parseInt(reportCards[0]));

        reportCard.setRecordNum(Integer.parseInt(reportCards[1]));
        reportCard.setGrade(Float.parseFloat(reportCards[2]));
        reportCard.setLtrGrade(reportCards[3]);

        r[i] = reportCard;
      }

    }
    file.close();
  }

  public void printReportCard(String prompt) {
    cio.println(prompt);
    try {

      for (ReportCard rc : r) { 
        cio.println(rc.getId() + DELIMITER
          + rc.getRecordNum() + DELIMITER
          + rc.getGrade() + DELIMITER
          + rc.getLtrGrade() + DELIMITER
        );
      }
    } catch (NullPointerException ex) {
      cio.println("ERROR: " + ex.getMessage());
    }

  }

  public void writeFile(String filename) {
    PrintWriter out;
    try {
      out = new PrintWriter(new FileWriter(filename));
       for (ReportCard rc : r) { 
        out.println(rc.getId() + DELIMITER
          + rc.getRecordNum() + DELIMITER
          + rc.getGrade() + DELIMITER
          + rc.getLtrGrade() + DELIMITER
        );

        out.flush();
      }
      out.close();
    } catch (IOException ex) {
      cio.println("ERROR: Unable to complete request.");
    }

  }

  public void sort() {
    ReportCard obj3;

    for (int i = 0; i < r.length; i++) {
      for (int j = 0; j < r.length; j++) {
        if (r[i].getId() < r[j].getId()) {
          obj3 = r[j];
          r[j] = r[i];
          r[i] = obj3;

        } else if (r[i].getId() == r[j].getId()) {
          if (r[i].getRecordNum() < r[j].getRecordNum()) {
            obj3 = r[j];
            r[j] = r[i];
            r[i] = obj3;
          }
        }
      }
    }

  }

}
