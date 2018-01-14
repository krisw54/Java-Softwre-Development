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

public class Grade {
    
    public static void main(String[] args) {
        
        Scanner myKeyboard = new Scanner(System.in);
        
        System.out.print("Please percent: ");
        int percent = myKeyboard.nextInt();
        
        //output grade based on percent
        if (percent <=100 && percent > 0)
        {
            if (percent >= 70) 
            {
            System.out.println("A");
            }
            else if (percent >= 60) 
            {
            System.out.println("B");
            }
            else if (percent >= 50) 
            {
            System.out.println("C");
            }
            else if (percent >= 40) 
            {
            System.out.println("D");
            }
            else 
            {
            System.out.println("E");
            }
        }
        else
        {
            System.out.println("Please input a percent that is between 0-100, and try again!");
        }

    }
}
