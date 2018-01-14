import java.util.*;

public class AlienApplication
{
    private static Scanner kybd = new Scanner(System.in);

    public static void main(String args[])
    {
        Alien[] myAlienArray = new Alien[5];
        
        for (int i=0; i<myAlienArray.length; i++)
        {
            myAlienArray[i] = new Alien();
            myAlienArray[i].setPosition(i*60+40, i%2*60+40);
        }
        
        PaintAliensInAJFrame frame = new PaintAliensInAJFrame(myAlienArray);
        
        String response = getResponse();
        
        while (response.toLowerCase().charAt(0) == 'y')
        {
            int alienIndex = getAlienNumber(1, myAlienArray.length) - 1;
            
            myAlienArray[alienIndex].setBodyColour(Alien.getRandomColour());
            frame.repaint();
            
            response = getResponse();
        }
    }
    
    private static String getResponse()
    {
        String prompt = "Do you want to change an alien's colour? > ";
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
    
    private static int getAlienNumber(int min, int max)
    {
        System.out.print("Which alien's colour do you want to change? " + 
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
                                   "Please enter an integer: > ");
            }
        }
        return num;
    }
}
