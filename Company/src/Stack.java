import java.util.ArrayList;

public class Stack
{
    private ArrayList<Integer> a;

    public Stack()
    {
       a = new ArrayList(10);       //initial capacity of 10
    }

    public boolean isEmpty()
    {
         return a.isEmpty();
    }

    public int pop()			 //pop integer element
    {
        return(a.remove(a.size()-1));      //underflow will crash
    }

    public void push(int x)		//push integer element
    {
        a.add(x);
    }
}
