package sports;

public class Player
{
    public final static String[] PLAYER_POSITION = {"", "Attack", "Defence"};
    
    private String name;
    private Team team;
    private String position;
    
    public Player(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Team getTeam()
    {
        return team;
    }

    public void setTeam(Team team)
    {
        this.team = team;
    }

    public String getPosition()
    {
        return position;
    }

    public boolean setPosition(String position)
    {
        boolean positionSet = false;
        
        if  (validPosition(position))
        {
            this.position = position;
            positionSet = true;
        }
        
        return positionSet;
    }
    
    protected boolean validPosition(String position)
    {
        boolean dataOK = false;
        
        for (String p : PLAYER_POSITION)
        {
            if (position.equalsIgnoreCase(p))
            {
                dataOK = true;
            }
        }
        
        return dataOK;
    }
}
