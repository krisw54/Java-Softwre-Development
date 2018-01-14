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

public class Distance {
    
    public static void main(String[] args) {
        
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter initial velocity in ms: ");
        int velocity = kybd.nextInt();
        System.out.print("Enter initial acceleration in ms: ");
        int acceleration = kybd.nextInt();
        System.out.print("Enter initial time taken in s: ");
        int timeTaken = kybd.nextInt();
        
        double firstPart = (velocity * timeTaken);
        double secondPart = (acceleration) * ((timeTaken * timeTaken));
        double distance = firstPart + (secondPart * 0.5) ;
        
        System.out.println("The Distance Travelled is: " + distance);
    }
}
