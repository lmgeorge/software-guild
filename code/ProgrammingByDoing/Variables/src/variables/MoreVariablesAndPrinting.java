/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package variables;

/**
 *
 * @author apprentice
 */
public class MoreVariablesAndPrinting {
    public static void main (String [] args){
        String myName, myEyes, myTeeth, myHair;
        int myAge, myHeight, myWeight;
        
        myName = "Lauren M. George";
        myAge = 26;
        myHeight = 62; //inches
        myWeight = 130; //pounds
        myEyes = "Brown";
        myTeeth = "White";
        myHair = "Brown";
        
        System.out.println(
                "Let's talk about " + myName + ".\n" +
                "She's " + myHeight + " inches tall.\n"+
                "She's " + myWeight + " punds heavy.\n" +
                "Actually, that's not too heavy.\n" +
                "She's got " + myEyes + " eyes and hair.\n"+
                "Her teeth are usually " + myTeeth + " depending on the coffee.\n" +
                "If I add " + myAge + ", " + myHeight + ", " + myWeight + " I get " + 
                        (myAge + myHeight + myWeight) + "."
        );
        
        //Remove "my" from all variable names
        //Convert Imperial to Metric and append to the end of each statement in parentheses
    }
}
