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
public class Magic8Ball {

  public static void main(String[] args) {
    Random r = new Random();

    int choice = 1 + r.nextInt(20);
    String response;

    switch (choice){ 
      case 1:
        response = "It is certain";
        break;
      case 2:
        response = "It is decidedly so";
        break;
      case 3:
        response = "Without a doubt";
        break;
      case 4:
        response = "Yes - definitely";
        break;
      case 5:
        response = "You may rely on it";
        break;
      case 6:
        response = "As I see it, yes";
        break;
      case 7:
        response = "Most likely";
        break;
      case 8:
        response = "Outlook good";
        break;
      case 9:
        response = "Signs point to yes";
        break;
      case 10:
        response = "Yes";
        break;
      case 11:
        response = "Reply hazy, try again";
        break;
      case 12:
        response = "Ask again later";
        break;
      case 13:
        response = "Better not tell you now";
        break;
      case 14:
        response = "Cannot predict now";
        break;
      case 15:
        response = "Concentrate and ask again";
        break;
      case 16:
        response = "Don't count on it";
        break;
      case 17:
        response = "My reply is no";
        break;
      case 18:
        response = "My sources say no";
        break;
      case 19:
        response = "Outlook not so good";
        break;
      case 20:
        response = "Very doubtful";
        break;
      default:
        response = "8-BALL ERROR!";
        break;
    }
      //System.out.println(choice);  
      System.out.println("MAGIC 8-BALL SAYS: " + response);
    
  }
}
