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
public class Keychains3 {

  public static void main(String[] args) {
    Scanner ui = new Scanner(System.in);
    int choice, keyTotal = 0;
    final double PRICE = 10,
      SALES_TAX = 0.0825,
      SHIPPING = 5,
      ADDL_SHIP = 1;

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
          view_order(keyTotal, PRICE, SALES_TAX, SHIPPING, ADDL_SHIP);
          break;
        case 4:
          checkout(keyTotal, PRICE, SALES_TAX, SHIPPING, ADDL_SHIP);
          choice = -1;
          break;
        default:
          System.out.print("\nError: Invalid choice.\n\n");
          break;
      }
    } while (choice != -1);
  }

  public static int add_keychains(int quantity) {
    Scanner ui = new Scanner(System.in);
    int add;
    do {
      System.out.print(
        "You have " + quantity + " keychains. How many to add? ");
      add = ui.nextInt();
      if (add < 0) {
        System.out.println("Error: Please enter a valid number!");
      }
    } while (add < 0);
    add += quantity;
    System.out.println("You now have " + add + " keychains.\n");
    return add;
  }

  public static int remove_keychains(int quantity) {
    Scanner ui = new Scanner(System.in);
    int subtract;
    do {
      System.out.print(
        "You have " + quantity + " keychains. How many to remove? ");
      subtract = ui.nextInt();
      if (quantity < subtract) {
        System.out.println("Error: Enter a valid number.");
      }
    } while (quantity < subtract);
    subtract = quantity - subtract;
    System.out.println("You now have " + subtract + " keychains.\n");
    return subtract;
  }

  public static void view_order(int subtotal, double price, double tax, double shipping, double addl_shipping) {
    double totalShip = shipping + (addl_shipping * (subtotal - 1)),
      taxes = tax * subtotal * price;

    System.out.println("You have " + subtotal + " keychains.\n"
      + "Keychains cost is $" + price + " each.\n"
      + "Subtotal: $" + subtotal * price + "\n"
      + "Sales tax: $" + taxes +"\n"
      + "Shipping: $" + totalShip + " \n"
      + "Total cost is $" + (taxes + totalShip + subtotal * price) + ".\n");
  }

  public static void checkout(int subtotal, double price, double tax, double shipping, double addl_shipping) {
    Scanner ui = new Scanner(System.in);
    String name;
    double totalShip = shipping + (addl_shipping * (subtotal - 1)),
      taxes = tax * subtotal * price;
    System.out.println("CHECKOUT\n");

    System.out.print("What is your name? ");
    name = ui.nextLine();

    System.out.println("\nYou have " + subtotal + " keychains.\n"
      + "Keychains cost is $" + price + " each.\n"
      + "Subtotal: $" + subtotal * price + "\n"
      + "Sales tax: $" + taxes +"\n"
      + "Shipping: $" + totalShip + "\n"
      + "Total cost: $" + (taxes + totalShip + subtotal * price) + "\n"
      + "Thanks for your order, " + name + "!");
  }

}
