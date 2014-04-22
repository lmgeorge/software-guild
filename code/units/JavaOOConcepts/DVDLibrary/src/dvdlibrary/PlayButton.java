/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dvdlibrary;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class PlayButton {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) throws Exception {
    ConsoleIO c = new ConsoleIO();
    DvdLibController control = new DvdLibController();

    control.run();
//    HashMap<String, Dvd> test = new HashMap<>();
//    Dvd testDvd = new Dvd();
//    ArrayList<String> notes = new ArrayList<>();
//
//    notes.add("note1");
//    notes.add("note2");
//    testDvd.setNotes(notes);
//
//    test.put("test1", testDvd);
//    c.println(c.toString(test.get("test1").getNotes(), "\n"));

//    c.println(c.toString(notes, "::"));
  }

}
