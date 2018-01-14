/**
 *
 * @author krisw
 */
public class Candidate {
    //private variables – hidden data
    private String theName;
    private int theVotes=0;
    
    //public methods
    public void setName(String name)
    {
        theName = name;
    }
    
    public void setVotes(int votes)
    {
        theVotes = votes;
    }
    
    public String getName()
    {
        return theName;
    }
    
    public int getVotes()
    {
        return theVotes;
    }
    
}
