import java.util.*;
/**
 *
 * @author krisw
 */
public class BMICalculator {
    public static void main(String[] args) {
        
        System.out.println("Your BIM Will Be: " + outputBMI());
    }
    
   public static int heightInInches()
   {
       int feet = 0;
       int inches = 13;
       
      Scanner kybd = new Scanner(System.in); 
      while (feet < 2 || feet > 7)
      {
        System.out.println("Enter height in feet: ");
        feet = kybd.nextInt();
      }
      
      while (inches > 12)
      {
        System.out.println("Enter height in inches: ");
        inches = kybd.nextInt();
      }
      
      int totalHeight = (feet * 12) + inches;
      return totalHeight;
   }
   
   public static int weightInPounds()
   {
       int stones = 0;
       int pounds = 14;
       
      Scanner kybd = new Scanner(System.in); 
      while (stones < 3 || stones > 30)
      {
        System.out.println("Enter stones: ");
        stones = kybd.nextInt();
      }
      
      while (pounds > 13)
      {
        System.out.println("Enter pounds: ");
        pounds = kybd.nextInt();
      }
      
      int totalWeight = (stones * 14) + pounds;
      return totalWeight;
   }
   
   public static int outputBMI()
   {
       int height = heightInInches();
       int bmi = (weightInPounds()* 703 ) / (height * height);
       return bmi;
   }
   
}