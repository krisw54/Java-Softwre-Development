/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w028006g
 */
public class Savings {
    //calculate and output half of my savings
    
    //your share is 50% of my savings
    public static void main(String[] args) {
        int mySavings = 2000;
        int yourPercentage = 50;
        int yourShare = (mySavings * yourPercentage / 100);
        
        System.out.println("Your share: " + yourShare);
    }
}
