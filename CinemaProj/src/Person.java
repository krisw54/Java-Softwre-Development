/**
 *
 * @author krisw
 */
public class Person {
    
    //private variables – hidden data
    private String theName;
    private int theAge;

    
    //public methods
    public void setName(String name)
    {
        theName = name;

    }
    
    public void setAge(int age)
    {
        theAge = age;
    }
    
    public String getName()
    {
        return theName;
    }
    
    public int getAge()
    {
        return theAge;
    }
    
}
