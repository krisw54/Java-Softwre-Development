//create 2 person objects
public class Couple
{
    public static void main (String args[])
    {
        Person barbie = new Person();
        Person ken = new Person();

        barbie.setName("Barbie", "Smith");
        barbie.setDOB(8, 3, 1959);
        ken.setName("Ken", "Jones");
        ken.setDOB(25, 12, 1961);

        System.out.println(barbie.getName() + " is " + 
                           barbie.getAgeAt(1, 1, 2012));
        System.out.println(ken.getName() + " is " + 
                           ken.getAgeAt(1, 1, 2012));

        barbie.setName("Barbie", "Jones");
        System.out.println("Barbie is now called " + barbie.getName());
    }  
}
