import java.awt.Color;

public class AlienApplication
{
    public static void main(String args[])
    {
        Alien[] myAlienArray = new Alien[5];
        
        for (int i=0; i<myAlienArray.length; i++)
        {
            Color c = Alien.getColour();
            if (i % 2 == 0)
            {
                myAlienArray[i] = new Alien();
            }
            else
            {
                TriAlien tri = new TriAlien();
                tri.setLegColour(c);
                myAlienArray[i] = tri;
            }
            myAlienArray[i].setPosition(i*60, i%2*60);
            myAlienArray[i].setBodyColour(c);
        }
        
        new AlienJFrame(myAlienArray);
    }
}
