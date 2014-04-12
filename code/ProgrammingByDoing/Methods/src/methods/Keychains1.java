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
public class Keychains1 {

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        int choice;
        
        System.out.println("Ye Olde Keychain Shoppe\n");
        System.out.println(
          "1. Add Keychains to Order\n"
          + "2. Remove Keychains from Order\n"
          + "3. View Current Order\n"
          + "4. Checkout\n"
          + "\n"
          + "Please enter your choice:");
        
        choice = Integer.parseInt(ui.nextLine());
        
        switch(choice){
          case 1:
            add_keychains();
            break;
          case 2:
            remove_keychains();
            break;
          case 3:
            view_order();
            break;
          case 4:
            checkout();
            break;
          default:
            System.out.print("Error.");
            break;
        }
        
    }
    
    public static void add_keychains (){
       System.out.println("ADD KEYCHAINS");
    }
    public static void remove_keychains (){
       System.out.println("REMOVE KEYCHAINS");
    }
    public static void view_order (){
       System.out.println("VIEW ORDER");
    }
    public static void checkout(){
       System.out.println("CHECKOUT");
    }
}
