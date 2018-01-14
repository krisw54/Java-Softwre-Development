import java.util.ArrayList;

public class Stack
{
    private ArrayList<Integer> a;

    public Stack()
    {
        a = new ArrayList<Integer>(2);
    }

    public boolean isEmpty()
    {
        return a.isEmpty();
    }

    public int pop() throws Exception
    {
        try
        {
            return a.remove(a.size()-1);    //underflow will crash
        }
        catch (Exception e)
        {
            throw new Exception("Empty stack");
        }
    }

    public void push(int x)		//push integer element
    {
        a.add(x);
     }
}
