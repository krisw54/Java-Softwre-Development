import java.awt.Color;
import java.util.*;
/**
 *
 * @author chriswood
 */
public class MySpaceshipApplication {
    
    private static Scanner kybd = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        int x=0, y=0;
        
        Spaceship[] mySpaceshipsArray = new Spaceship[5];
        
        for (int i=0; i<mySpaceshipsArray.length; i++)
        {
            Color c = Spaceship.getRandomColour();
            if (i==0)
            {
                mySpaceshipsArray[i] = new Spaceship();
                mySpaceshipsArray[i].setName("Space: "+(i+1));
            }
            else if (i == 1 || i==2)
            {
                mySpaceshipsArray[i] = new Spaceship();
                mySpaceshipsArray[i].setPosition(i*60+40, i%2*60+40);
                mySpaceshipsArray[i].setName("Space: "+(i+1));
            }
            else
            {
                SpaceRocket rocket = new SpaceRocket();
                rocket.setRocketColour(c);
                mySpaceshipsArray[i] = rocket;
                mySpaceshipsArray[i].setPosition(i*60+40, i%2*60+40);
                mySpaceshipsArray[i].setName("Rock: "+(i+1));
            }
            mySpaceshipsArray[i].setBodyColour(c);
        }
        
        SpaceshipInaJFrame frame = new SpaceshipInaJFrame(mySpaceshipsArray);
        
        String response = getResponse();
        
        while (response.toLowerCase().charAt(0) == 'y')
        {
            int spaceshipIndex = getSpaceship(1, mySpaceshipsArray.length) - 1;
            
            mySpaceshipsArray[spaceshipIndex].setPosition(getSpaceshipX(), getSpaceshipY());
            frame.repaint();
            
            response = getResponse();
        }
        
    }
    
    private static String getResponse()
    {
        String prompt = "Do you want set the spaceships X & Y? ";
        System.out.print(prompt);
        String response = kybd.nextLine();
        
        while (!response.equalsIgnoreCase("yes") &&
               !response.equalsIgnoreCase("y") &&
               !response.equalsIgnoreCase("no") &&
               !response.equalsIgnoreCase("n"))
        {
            System.out.println("Response not recognised. Please enter one of: yes, y, no, n");
            System.out.print(prompt);
            response = kybd.nextLine();
        }
        
        return response;
    }
    
    private static int getSpaceship(int min, int max)
    {
        System.out.print("Which spaceship's X & Y do you want to change? " + 
                         "(enter " + min + "-" + max + ") > ");
        int num = getAnInteger();
        
        while (num < min || num > max)
        {
            System.out.print("Input out of range. " + 
                               "Please enter a number in the range " + 
                               min + "-" + max + ": > ");
            num = getAnInteger();
        }
        return num;
    }
    
    private static int getSpaceshipX()
    {
        System.out.println("Please input an X value: ");
        int x = getAnInteger();
       
        return x;
    }
    
    private static int getSpaceshipY()
    {
        System.out.println("Please input an Y value: ");
        int y = getAnInteger();
       
        return y;
    }     
    
    private static int getAnInteger()
    {
        boolean dataOK = false;
        int num=0;
        
        while (!dataOK)
        {
            try
            {
                num = kybd.nextInt();
                dataOK = true;
                kybd.nextLine();
            }
            catch (InputMismatchException ime)
            {
                kybd.nextLine();
                System.out.print("Input not an integer. " + 
                                   "Please enter an integer: ");
            }
        }
        return num;
    }   
    
}
