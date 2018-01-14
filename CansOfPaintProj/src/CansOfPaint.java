/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w028006g
 */
public class CansOfPaint
{
    public static void main(String[] args)
    {
        double paintCovers = 5.1; //m2
        double canOfPaintD = 15; //cm
        double canOfPaintH = 30; //cm
         
        double roomW = 30; //m
        double roomH = 3.4; //m
        double roomL = 40; //m
        
        int boxL = 60; //cm
        int boxW = 30; //cm
        int boxH = 35; //cm
        
        int canDiam = 15; //cm
        int canHeight = 30; //cm
        
        double surfaceAreaHall = ((roomL * roomH) * 2) + ((roomW * roomH) * 2);
        double cansNeeded = Math.ceil (surfaceAreaHall / 5.1);
        
        int canL = boxL / canDiam;
        int canW = boxW / canDiam;
        int canH = boxH / canHeight;
        int boxedCans = canH * canL * canW ;
        
        int boxesNeeded = (int)cansNeeded / boxedCans;
        int unBoxedCans = (int)cansNeeded % boxesNeeded;
        
        System.out.println("Area of the room: " + surfaceAreaHall);
        System.out.println("The amount of cans needed is: " + cansNeeded);
        System.out.println("Boxes of cans of paint: " + boxesNeeded);
        System.out.println("Number of cans that don't fit in the boxes are: " + unBoxedCans);
               
    }
    
}
