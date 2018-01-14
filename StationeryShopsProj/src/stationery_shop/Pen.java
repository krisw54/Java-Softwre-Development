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
    * @param name the name of the pen
    * @param costPrice the cost price of the pen
    * @param sellingPrice the selling price of the pen
    * @param inkColour the ink colour of the pen
    * @param pointType the point type of the pen
    */
    public Pen(String name, double costPrice, double sellingPrice, String inkColour, String pointType)
    {
        super(name, costPrice, sellingPrice);
        this.inkColour = inkColour;
        this.pointType = pointType;
    }
    
    /**
     * Returns the ink colour as a string
     * @return {@code inkColour} 
     */
    public String getInkColour()
    {
        return inkColour;
    }

    /**
    * Sets the ink colour of the pen
    * @param inkColour colour of the pen
    * @return {@code true} if the ink colour was set; 
    * {@code false} otherwise 
    */
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
    /**
     * Returns the point type as a string
     * @return {@code pointType} 
     */
    public String getPointType()
    {
        return pointType;
    }
    
     /**
    * Sets the ink colour of the pen
    * @param pointType point type of the pen passed in
    * @return {@code true} if the pen point type was set; 
    * {@code false} otherwise 
    */
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