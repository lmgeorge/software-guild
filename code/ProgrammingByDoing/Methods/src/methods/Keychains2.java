package methods;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class Keychains2 {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int choice, keyTotal = 0;
    final int PRICE = 10;

    System.out.println("Ye Olde Keychain Shoppe\n");
    do {
      System.out.print(
        "1. Add Keychains to Order\n"
        + "2. Remove Keychains from Order\n"
        + "3. View Current Order\n"
        + "4. Checkout\n"
        + "\n"
        + "Please enter your choice: ");

      choice = Integer.parseInt(ui.nextLine());
      switch (choice) {
        case 1:
          keyTotal = add_keychains(keyTotal);
          break;
        case 2:
          keyTotal = remove_keychains(keyTotal);
          break;
        case 3:
          view_order(keyTotal, PRICE);
          break;
        case 4:
          checkout(keyTotal, PRICE);
          choice = 5;
          break;
        default:
          choice = 5;
          break;
      }
    } while (choice != 5);
  }

  public static int add_keychains(int quantity) {
    Scanner ui = new Scanner(System.in);
    int add;
    
    System.out.print("You have " + quantity + " keychains. How many to add? ");
    add = ui.nextInt();
    add += quantity;
    System.out.println("You now have " + add + " keychains.\n");
    return add;
  }

  public static int remove_keychains(int quantity) {
    Scanner ui = new Scanner(System.in);
    int subtract;
    
    System.out.print("You have " + quantity + " keychains. How many to remove? ");
    subtract = ui.nextInt();
    subtract = quantity - subtract;
    System.out. println("You now have " + subtract + " keychains.\n");
    return subtract;
  }

  public static void view_order(int subtotal, int price) {
    System.out.println("You have " + subtotal + " keychains.\n"
      + "Keychains cost $" + price + " each.\n"
      + "Total cost is $" + (subtotal * price) + ".\n");
  }

  public static void checkout(int subtotal, int price) {
    Scanner ui = new Scanner(System.in);
    String name;
    
    System.out.println("CHECKOUT\n\n");
    
    System.out.print("What is your name? ");
    name = ui.nextLine();

    System.out.println(
       "You have " + subtotal + " keychains.\n"
      + "Keychains cost $" + price + " each.\n"
      + "Total cost is $" + (subtotal * price) + ".\n"
      + "Thanks for your order, " + name + "!");
  }
}
