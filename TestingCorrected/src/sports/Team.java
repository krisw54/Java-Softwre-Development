package sports;

import java.util.ArrayList;

public class Team
{
    private String name;
    private int requiredNumberOfPlayers;
    private ArrayList<Player> players;
    
    public Team(String name, int requiredNumberOfPlayers) throws SportsException
    {
        if (name.equals(""))
        {
            throw new SportsException("Team name must have a value");
        }
        if (requiredNumberOfPlayers < 1)
        {
            throw new SportsException("required number of players must be greater than zero");
        }
        this.name = name;
        this.requiredNumberOfPlayers = requiredNumberOfPlayers;
        players = new ArrayList<Player>(requiredNumberOfPlayers);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getRequiredNumberOfPlayers()
    {
        return requiredNumberOfPlayers;
    }

    public boolean addPlayer(Player p, String position)
    {
        boolean playerAdded = false;
        
        if (players.size() < requiredNumberOfPlayers &&
            !players.contains(p) &&
            p.setPosition(position))
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
            p.setPosition("");
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
