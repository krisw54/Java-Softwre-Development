import java.util.*;
/**
 *
 * @author krisw
 */
public class Band {
    
    private static Scanner kybd = new Scanner(System.in);
     
    public static void main(String[] args) {
           
        //Create the band members
        BandMember[] theBand = createBand();
        
        //Output details of array
        printDetails(theBand);
    }
    
    public static BandMember[] createBand()
    {
        BandMember[] theBand = new BandMember[5];

        for (int i = 0; i < theBand.length; i++)
        {
            System.out.println("Person" + (i + 1));
            theBand[i] = createPerson();
        }
        return theBand;
    }
    
    public static BandMember createPerson()
    {
        BandMember p = new BandMember();
        
        System.out.print("Enter full name stage name: ");
        String firstname = kybd.nextLine();
        String secondname = kybd.nextLine();
        p.setName(firstname, secondname);
        
        System.out.print("Enter the instrument that " + p.getName() + " plays: ");
        String instrumentS = kybd.nextLine();
        p.setInstrument(instrumentS);
        
        return p;
    }
    
    public static void printDetails(BandMember[] theBand)
    {
        for (int i = 0; i < theBand.length; i++)
        {
            System.out.println("Stage Name: " +theBand[i].getName() + " instrument they play: " + theBand[i].getInstrument());
        }
    }
}
