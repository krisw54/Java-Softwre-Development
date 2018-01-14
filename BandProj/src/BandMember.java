/**
 *
 * @author krisw
 */
public class BandMember {
    
    //private variables – hidden data
    private String firstName;
    private String surname;
    private String instrument;
    
    //public methods
    public void setName(String theFirstName, String theSurname)
    {
        firstName = theFirstName;
        surname = theSurname;
    }
    
    public void setInstrument(String ins)
    {
        instrument = ins;
    }
    
    public String getName()
    {
        return firstName + " " + surname;
    }
    
    public String getInstrument()
    {
        return instrument;
    }
    
}
