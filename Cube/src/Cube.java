import java.util.*;
public class Cube
{
    public static void main (String[] args)
    {
        Scanner kybd = new Scanner(System.in);

        for (int i = 1; i <= 3; i++)
        {
            //read input
            System.out.print("Enter height: " ); 
            int height = kybd.nextInt();
            System.out.print("Enter length: " ); 
            int length = kybd.nextInt();
            System.out.print("Enter width: " ); 
            int width = kybd.nextInt();
        
            //perform calculations
            int area = 2 * ((height * width) + (width * length)
                    + (length * height));
            int volume = width * height * length;

            //output results
            System.out.println("The surface area is " + area); 
            System.out.println("The volume is " + volume);
            if (height == width && height == length)
            {
                System.out.println("cube");
            }
            else
            {
                System.out.println("Not a cube");
            } //end if
        }//end for
    }
}
