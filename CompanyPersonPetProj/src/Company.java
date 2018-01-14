
import java.util.ArrayList;
/**
 *
 * @author chriswood
 */
public class Company {

    private String name;
    private String location;
    private ArrayList<Person> people;

    public Company(String name, String location)
    {
        this.name = name;
        this.location = location;
        people = new ArrayList<Person>();
    }
  
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public ArrayList<Person> getPeople()
    {
        return people;
    }
    
    public boolean addPerson(Person p)
    {
        boolean personAdded = false;
        if (!people.contains(p))
        {
        personAdded = people.add(p);
        }
    return personAdded; 
    }
    
    public int getNumberOfPeople()
    {
        return people.size();
    }
    
    public void removePet(Person p)
    {
        people.remove(p);
    }   
}
