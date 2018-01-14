import java.util.ArrayList;

public class QueueWithArrayList
{
    private ArrayList<String> a;

    public QueueWithArrayList()
    {
       a = new ArrayList<String>(10);  		//initial capacity of 10
    }

    public boolean isEmpty()
    {
         return a.isEmpty();
    }

    public String remove()
    {
        return a.remove(0);
    }
    
    public void add(String x)
    {
        a.add(x);
    }
}
