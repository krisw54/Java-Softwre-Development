/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krisw
 */
import java.util.*;

public class OddOrEven {
    public static void main(String[] args) {
        
        //create Scanner to read in data
        Scanner myKeyboard = new Scanner(System.in);
        
        System.out.print("Please Enter Number: ");
        int numberTest = myKeyboard.nextInt();
        myKeyboard.nextLine(); //flush buffer
        if (numberTest == 0)
        {
            System.out.println("ZERO isn't either odd or even");
        }
        else if (numberTest % 2 == 0)
        {
            System.out.println("You entered an even number.");
        }
        else
        {
            System.out.println("You entered an odd number.");
        }
        
    }
}
