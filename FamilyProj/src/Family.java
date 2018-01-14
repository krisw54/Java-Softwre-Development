
/**
 *
 * @author krisw
 */
public class Family {
    
    public static void main(String[] args) {
        Person mum  = new Person();
        Person dad  = new Person();
        Person son  = new Person();
        Person daughter =  new Person();
        
        mum.setName("Juliet", "Capulet");
        mum.setDOB(07, 11, 1987);
        mum.setHeight(68);
        
        dad.setName("Romeo", "Montague");
        dad.setDOB(21, 02, 1983);
        dad.setHeight(73);
        
        son.setName("Triolus", "Montague");
        son.setDOB(12, 04, 2009);
        son.setHeight(33);
        
        son.setName("Cressida", "Montague");
        son.setDOB(13, 10, 2007);
        son.setHeight(40);
        
        printPerson(mum);
        
        mum.setSurname("Montague");
        printPerson(mum);
    }
    
    public static void printPerson(Person person1)
    {
        System.out.println(person1.getName());
        System.out.println(person1.getDOB());
        System.out.println(person1.getAgeAt(07, 11, 2012));
        System.out.println(person1.getHeight());
        System.out.println("");
    }
}
