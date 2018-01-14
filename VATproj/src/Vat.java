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

public class Vat
{
    public static void main(String[] args)
    {
        //create Scanner to read in data
        Scanner kybd = new Scanner(System.in);

        //declare constants
        final double vatIs = 20.00;
        
        //prompt user for item price
        System.out.print("Please enter item price: ");
        double itemPrice = kybd.nextDouble();
        
        double vatPrice = (vatIs / 100) * itemPrice;
        double totalPrice = (vatPrice + itemPrice);
        
        System.out.printf("VAT Amount is: £ %1.2f\n" , vatPrice);
        System.out.printf("Toal Cost of Item Plus The VAT is: £ %1.2f\n", totalPrice);
             
    }
    
}
