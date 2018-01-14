/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w028006g
 */

import java.util.*;

public class Post {
    
    public static void main(String[] args) {
        
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter Letter Type: ");
        String letter = kybd.nextLine();

        //check title
        if (letter.equalsIgnoreCase("Bill"))
        {
            System.out.println("bills must be paid");
        }
        else if (letter.equalsIgnoreCase("Circular"))
        {
            System.out.println("circulars are thrown away");
        }
        else if (letter.equalsIgnoreCase("Postcard"))
        {
            System.out.println("postcards are put on the wall");
        }
        else if (letter.equalsIgnoreCase("Letter"))
        {
            System.out.println("personal letters are read and have replies written for them");
        }
        else
        {
            System.out.println("This letter type is not recognised");  
        }
    }
    
}
