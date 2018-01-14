public class AlienApplication
{
    public static void main(String args[])
    {
        Alien[] myAlienArray = new Alien[5];
        
        for (int i=0; i<myAlienArray.length; i++)
        {
            myAlienArray[i] = new Alien();
            myAlienArray[i].setPosition(i*60+40, i%2*60+40);
        }
        
        PaintAliensInAJFrame frame = new PaintAliensInAJFrame(myAlienArray);
    }
}
