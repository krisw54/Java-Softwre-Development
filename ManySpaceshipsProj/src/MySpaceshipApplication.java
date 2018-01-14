

/**
 *
 * @author chriswood
 */
public class MySpaceshipApplication {
    
    public static void main(String[] args) {
        
        Spaceship[] mySpaceshipsArray = new Spaceship[3];
        
        for (int i=0; i<mySpaceshipsArray.length; i++)
        {
            mySpaceshipsArray[i] = new Spaceship();
            mySpaceshipsArray[i].setPosition(i*60+40, i%2*60+40);
        }
        
        SpaceshipInaJFrame frame = new SpaceshipInaJFrame(mySpaceshipsArray);
        
    }
    
}
