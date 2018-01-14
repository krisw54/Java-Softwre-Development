package uk.ac.staffs.fcet.gdm1.sport;

public class ExtendedPlayer extends Player
{
    private String extraProperty;
    
    public ExtendedPlayer(String name, String extraProperty)
    {
        super(name);
        this.extraProperty = extraProperty;
    }

    public String getExtraProperty()
    {
        return extraProperty;
    }

    public void setExtraProperty(String ep)
    {
        this.extraProperty = ep;
    }
}
