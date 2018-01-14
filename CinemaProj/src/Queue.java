import java.util.ArrayList;
/**
 *
 * @author krisw
 */
public class Queue {
    
    private ArrayList<Person> a;

    public Queue()
    {
       a = new ArrayList<>(10);  	//initial capacity of 10
    }

    public boolean isEmpty()
    {
         return a.isEmpty();
    }

    public Person remove()
    {
        return a.remove(0);
    }
    
    public void add(Person x)
    {
        a.add(x);
    }
    
}
