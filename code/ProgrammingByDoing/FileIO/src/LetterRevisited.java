
import java.io.FileWriter;
import java.io.PrintWriter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class LetterRevisited {

  public static void main(String[] args) throws Exception{

    PrintWriter out = new PrintWriter(new FileWriter("letter.txt"));
    out.println("+------------------------------+");
    out.println("|                          ####|");
    out.println("|                          ####|");
    out.println("|                          ####|");
    out.println("|                              |");
    out.println("|        Bill Gates            |");
    out.println("|        1 Microsoft Way       |");
    out.println("|        Redmond, WA 98104     |");
    out.println("|                              |");
    out.println("+------------------------------+");
    out.flush();
    out.close();
    
  }
}
