package uk.ac.staffs.fcet.gdm1.sport;

import java.util.ArrayList;

/**
 * A class to implement the Team in this example application
 * 
 * @author gdm1 (version 1.1.1)
 * @author jel1 (version 1.1.2)
 * @version 1.1.2
 * @since 02-Mar-2012
 */
public class Team
{
    /**
     * A class-level property that is here only to show that JavaDoc
     * can be generated for this, too.
     */
    public static final String A_CLASS_LEVEL_PROPERTY = "Some value";
    
    /**
     * JavaDoc will be generated for any non-private property or method
     */
    protected int num;
    
    /**
     * This is the name property and is private, so it will not appear 
     * in the JavaDoc unless this feature is switched on in the NetBeans
     * project's properties
     */
    private String name;
    private int requiredNumberOfPlayers;
    private ArrayList<Player> players;
    
    /**
     * A constructor method for the {@link Team} class. 
     * It uses the parameters to initialise the properties for the newly 
     * created Team object
     * 
     * @param name the name of the team
     * @param requiredNumberOfPlayers the number of players required 
     * for the team to compete
     */
    public Team(String name, int requiredNumberOfPlayers)
    {
        this.name = name;
        this.requiredNumberOfPlayers = requiredNumberOfPlayers;
        players = new ArrayList<Player>(requiredNumberOfPlayers);
    }

    /**
     * Returns the name of this Team object
     * 
     * @return the current value of the {@link #name name} property
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the value of the {@link #name name} property to the value of the parameter
     * 
     * @param name the new value for this objects{@link #name name} property
     */
    public void setName(String name)
    {
        this.name = name;
    }

    public int getRequiredNumberOfPlayers()
    {
        return requiredNumberOfPlayers;
    }

    /**
     * Adds a {@link Player} object to this team's collection of 
     * {@link #players players} if:
     * <ul><li>the team has fewer than the 
     * {@link #requiredNumberOfPlayers requiredNumberOfPlayers}, and </li>
     * <li>the player is not already in the collection of {@link #players players}</li></ul>
     * @param p the {@link Player} object to add to this team
     * @return {@code true} if the player is added; {@code false} otherwise 
     */
    public boolean addPlayer(Player p)
    {
        boolean playerAdded = false;
        
        if (players.size() < requiredNumberOfPlayers &&
            !players.contains(p))
        {
            playerAdded = players.add(p);
            p.setTeam(this);
            
        }
        return playerAdded;
    }
    
    public void removePlayer(Player p)
    {
        if (players.remove(p))
        {
            p.setTeam(null);
        }
    }
    
    public ArrayList<Player> getPlayers()
    {
        return players;
    }
    
    public boolean canCompete()
    {
        return players.size() == requiredNumberOfPlayers;
    }
}
