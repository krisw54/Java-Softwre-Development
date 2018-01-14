/**
 *
 * @author krisw
 */
import java.util.ArrayList;

public class Stack {
    
    private ArrayList<String> a;

    public Stack()
    {
       a = new ArrayList(10);       //initial capacity of 10
    }

    public boolean isEmpty()
    {
         return a.isEmpty();
    }

    public String pop()			 //pop integer element
    {
        return(a.remove(a.size()-1));      //underflow will crash
    }

    public void push(String x)		//push integer element
    {
        a.add(x);
    }
}