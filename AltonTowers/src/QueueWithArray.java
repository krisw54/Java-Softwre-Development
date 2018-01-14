public class QueueWithArray
{
    private String[] a;			//declare String array
    private int rear;

    public QueueWithArray()
    {
       a = new String[10];  			//create String array
       rear = 0;                      
    }

    public boolean isEmpty()
    {
         return rear == 0;
    }

    public String remove()			//remove String element
    {
        String result = a[0];		//shuffle String elements
        rear--;
        for (int i = 0; i < rear ; i++)
        {
            a[i] = a[i + 1];
        }
        return result;
    }
    
    public void add(String x)		    //add String element
    {
        if (rear == a.length)
        {
            resize();
        }
        a[rear] = x;
        rear++;
    }  

    private void resize()
    {
        String[] temp = new String[a.length * 2];    //resize String array
        for (int i = 0; i < a.length; i++)
        {
            temp[i] = a[i];
	}
        a = temp;
    }
}
