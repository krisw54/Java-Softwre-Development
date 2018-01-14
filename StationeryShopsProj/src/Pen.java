package stationery_shop;
/**
* Describes a pen including Colour, Costs, Selling Price, Ink Colour and Point.
* @author GDM
* @see Item
* @since 14-Mar-20017
*/
public class Pen extends Item
{
    /**
    * The pen colours available in
    * an array called INK_COLOURS
    * @since 14-Mar-20017
    */
    public static final String[] INK_COLOURS = {"Blue", "Black", "Green", "Red"};
    /**
    * The pen points available in
    * an array called POINT_TYPES
    * @since 14-Mar-20017
    */
    public static final String[] POINT_TYPES = {"Ball", "Felt"};
    /**
    * Stores the Ink Colour
    * @since 14-Mar-20017
    */
    private String inkColour;

    private String pointType;
    /**
    * Adds a {@link Pen} object to this item's collection 
    * of {@link #pen pen} if:
    * @param name Pen name
    * 
    */
    public Pen(String name, double costPrice, double sellingPrice, String inkColour, String pointType)
    {
        super(name, costPrice, sellingPrice);
        this.inkColour = inkColour;
        this.pointType = pointType;
    }

    public String getInkColour()
    {
        return inkColour;
    }

    public boolean setInkColour(String inkColour)
    {
        boolean colourSet = false;
        
        if (valid(inkColour, INK_COLOURS))
        {
            this.inkColour = inkColour;
            colourSet = true;
        }
        
        return colourSet;
    }

    public String getPointType()
    {
        return pointType;
    }
    
    public boolean setPointType(String pointType)
    {
        boolean pointSet = false;
        
        if (valid(pointType, POINT_TYPES))
        {
            this.pointType = pointType;
            pointSet = true;
        }
        
        return pointSet;
    }

    private boolean valid(String value, String[] validValues)
    {
        boolean valueIsValid = false;
        
        for (int i=0;  !valueIsValid && i<validValues.length; i++)
        {
            if (validValues[i].equalsIgnoreCase(value))
            {
                valueIsValid = true;
            }
        }
        
        return valueIsValid;
    }
}