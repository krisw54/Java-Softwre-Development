public class ReferenceParamExample
{
    public static void main (String args[])
    {
        Person barbie = new Person();
        barbie.setName("Barbie", "Smith");
        
        System.out.println("Barbie is currently called " + barbie.getName());
        
        changeName(barbie, "Barbie", "Jones");
        
        System.out.println("Barbie is now called " + barbie.getName());
    }  
    
    public static void changeName(Person p, String s1, String s2)
    {
        p.setName(s1, s2);
    }
}
