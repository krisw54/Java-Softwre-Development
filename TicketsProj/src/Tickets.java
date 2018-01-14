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

public class Tickets {
    
    public static void main(String[] args) {
        
        double adultPrice = 10.50;
        double kidsPrice = 7.30;
        double consPrice = 8.40;
        double pAndP = 2.34;
        double discount = 10.00;
        double totalCosts;
        
       Scanner myKeyboard = new Scanner(System.in);
        
       System.out.print("Plese input the number of adults: ");
       int adults = myKeyboard.nextInt();
       
       System.out.print("Plese input the number of children: ");
       int children = myKeyboard.nextInt();
       
       System.out.print("Plese input the number of Concessions: ");
       int concess = myKeyboard.nextInt();
       
       int freeTickets = children / 10;
       
       if (freeTickets > 1)
       {
           if (adults > freeTickets)
           {
               int adultsTotal = adults - freeTickets;
               totalCosts = (adultsTotal * adultPrice) + (concess * consPrice) + (children * kidsPrice);
               if (totalCosts > 100.00)
                {
                    double disCosts = (totalCosts * 0.10) + totalCosts;
                    System.out.println("Your Total Price is: £" + disCosts + " if you collect in person");
                    System.out.println("Your Total Price is: £" + (disCosts + pAndP) + " if you want to post the tickets");
                    System.out.printf("Adults Qrty %d \t Children Qrty %d \t Conessions %d \n",adults, children, concess );
                }
                else
                {
                    System.out.println("Your Total Price is: £" + totalCosts + " if you collect in person");
                    System.out.println("Your Total Price is: £" + (totalCosts + pAndP) + " if you want to post the tickets");
                }
           }
       
           else{
       
           totalCosts = (adults * adultPrice) + (concess * consPrice) + (children * kidsPrice);
           if (totalCosts > 100.00)
                {
                    double disCosts = (totalCosts * 0.10) + totalCosts;
                    System.out.println("Your Total Price is: £" + disCosts + " if you collect in person");
                    System.out.println("Your Total Price is: £" + (disCosts + pAndP) + " if you want to post the tickets");
                }
                else
                {
                    System.out.println("Your Total Price is: £" + totalCosts + " if you collect in person");
                    System.out.println("Your Total Price is: £" + (totalCosts + pAndP) + " if you want to post the tickets");
                }
        }
        System.out.println("Number of FREE! Adult Tickets are: " + freeTickets);
    }
   }
}


