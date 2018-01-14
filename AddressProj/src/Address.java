
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krisw
 */
public class Address {
    public static void main(String[] args) {
        
        //create Scanner to read in data
        Scanner myKeyboard = new Scanner(System.in);

        //prompt user for input
        System.out.print("Enter surname: ");
        String name = myKeyboard.nextLine();

        System.out.print("Enter House Number: ");
        int houseNumber = myKeyboard.nextInt();
        myKeyboard.nextLine(); //flush buffer

        System.out.print("Enter Road Name: ");
        String roadName = myKeyboard.nextLine();
        
        System.out.print("Enter Town Name: ");
        String townName = myKeyboard.nextLine();
       
       System.out.printf("Mr and Mrs %s, \n%d, %s\n%s\n",name, houseNumber, roadName, townName);

    }
}
