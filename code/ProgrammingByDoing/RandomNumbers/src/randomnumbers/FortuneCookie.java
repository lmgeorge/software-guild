/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package randomnumbers;

import java.util.Random;

/**
 *
 * @author apprentice
 */
public class FortuneCookie {
  public static void main(String[] args){
    Random r = new Random();
    int rGen = 1 + r.nextInt(54);
    System.out.println("Fortune cookie says: "
      + "\"You will find happiness with a new love.\"\n"
      + rGen + " - " + rGen + " - " + rGen + " - " 
      + rGen + " - " + rGen + " - " + rGen + "\n"
    );
    System.out.println("Fortune cookie says: "
      + "\"Stick with your wife.\"\n"
      + rGen + " - " + rGen + " - " + rGen + " - " 
      + rGen + " - " + rGen + " - " + rGen + "\n"
    );
    System.out.println("Fortune cookie says: "
      + "\"Listen to the Force.\"\n"
      + rGen + " - " + rGen + " - " + rGen + " - " 
      + rGen + " - " + rGen + " - " + rGen + "\n"
    );
    System.out.println("Fortune cookie says: "
      + "\"Fear is the little death.\"\n"
      + rGen + " - " + rGen + " - " + rGen + " - " 
      + rGen + " - " + rGen + " - " + rGen + "\n"
    );
    System.out.println("Fortune cookie says: "
      + "\"All that glitters is not gold.\"\n"
      + rGen + " - " + rGen + " - " + rGen + " - " 
      + rGen + " - " + rGen + " - " + rGen + "\n"
    );
    System.out.println("Fortune cookie says: "
      + "\"Escape while you can, THX 1138.\"\n"
      + rGen + " - " + rGen + " - " + rGen + " - " 
      + rGen + " - " + rGen + " - " + rGen + "\n"
    );
  }
}
