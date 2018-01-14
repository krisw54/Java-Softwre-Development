import java.awt.Color;

public class AlienApplication
{
    public static void main(String args[])
    {
        Alien[] myAlienArray = new Alien[5];
        
        for (int i=0; i<myAlienArray.length; i++)
        {
            Color c = Alien.getRandomColour();
            if (i % 2 == 0)
            {
                myAlienArray[i] = new Alien();
                myAlienArray[i].setName("A-"+(i+1));
            }
            else
            {
                TriAlien tri = new TriAlien();
                tri.setLegColour(c);
                tri.setName("T-"+(i+1));
                myAlienArray[i] = tri;
            }
            myAlienArray[i].setPosition(i*60, i%2*60);
        }
        
        new AlienJFrame(myAlienArray);
    }
}
