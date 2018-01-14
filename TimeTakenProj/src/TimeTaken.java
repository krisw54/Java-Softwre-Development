

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
    
public class TimeTaken {
    
    public static void main(String[] args) {
        
        final double accel = 9.8; //m/s2
        
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter distance in meters: ");
        int distance = kybd.nextInt();
        
        System.out.printf("Time Taken is: %.2f\n", Math.sqrt((2 * distance) / accel));
    }
}
    