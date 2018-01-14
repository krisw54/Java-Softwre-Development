/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krisw
 */
//program to output the average of 3 integer values
import java.util.*;

public class Average 
{
    public static void main (String[] args)
    {
        Scanner kybd = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int num1 = kybd.nextInt();
        System.out.print("Enter second integer: ");
        int num2 = kybd.nextInt();
        System.out.print("Enter third integer: ");
        int num3 = kybd.nextInt();

        double ave = (num1 + num2 + num3) / 3;

        System.out.println("Average is: " + ave);
    }
}
