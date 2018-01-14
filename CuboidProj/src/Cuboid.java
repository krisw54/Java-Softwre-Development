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

public class Cuboid {
    public static void main(String[] args) {
        
    
     //create Scanner to read in data
	Scanner myKeyboard = new Scanner(System.in);

	//prompt user for input
	System.out.print("Enter width: ");
	int width = myKeyboard.nextInt();

	System.out.print("Enter length: ");
	int length = myKeyboard.nextInt();
        
        System.out.print("Enter height: ");
	int height = myKeyboard.nextInt();

	//calculate and output money taken
        int volume = width * length * height;
        System.out.println("The volume of the cube is: " + volume);
        int area = 6 * length * length;
        System.out.println("The area of the cube is: " + area);
    }
}
