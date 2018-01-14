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

public class PosNegTest {
    
    public static void main(String[] args) {
        
        Scanner myKeyboard = new Scanner(System.in);
        
        System.out.print("Please input number: ");
        int numberTest = myKeyboard.nextInt();
        
        if (numberTest == 0)
        {
            System.out.println("Zero is not Positive or Negitive");
        }
        else if (numberTest > 0)
        {
            System.out.println("Number is Positive");
        }
        else
        {
            System.out.println("Number is Negitive");
        }
    }
}
