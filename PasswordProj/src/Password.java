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

public class Password {
    
    public static void main(String[] args) {
        
        //output personalised welcome message
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter Password: ");
        String pssWrd = kybd.nextLine();
        
        if (pssWrd.equals("pass11"))
        {
            System.out.println("Password Correct! Welcome...");
        }
        else
        {
            System.out.println("Password WRONG!");
        }
    }
}
