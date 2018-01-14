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

public class Seconds {
    public static void main(String[] args) {
        
        //create Scanner to read in data
        Scanner myKeyboard = new Scanner(System.in);

        System.out.print("Enter total seconds: ");
        int totalSeconds = myKeyboard.nextInt();
        myKeyboard.nextLine(); //flush buffer
        
        int totalHours = totalSeconds / 3600;
        int totalMins = (totalSeconds / 60) - 60;
        int seconds = totalSeconds - (totalHours * 3600) - (totalMins * 60);
        System.out.printf("Input\tHours\tMinutes\tSeconds\n");
        System.out.printf("%d\t%d\t %d\t  %d\n", totalSeconds, totalHours, totalMins, seconds);
        
    }
}
