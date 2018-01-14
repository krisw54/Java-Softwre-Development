
/**
 *
 * @author krisw
 */
public class TheBeatles {
    
    public static void main(String[] args) {
        
        Person john  = new Person();
        Person paul  = new Person(); 
        Person george  = new Person(); 
        Person ringo  = new Person(); 
        
        john.setName("John", "Lennon");
        john.setDOB(30, 10, 1940);
        
        paul.setName("Paul", "McCartney");
        paul.setDOB(18, 06, 1942);
        
        george.setName("George", "Harrison");
        george.setDOB(25, 02, 1943);
        
        ringo.setName("Ringo", "Star");
        ringo.setDOB(07, 07, 1940);
        
        System.out.println(john.getName());
        System.out.println(john.getDOB());
        System.out.println("");
        
        System.out.println(paul.getName());
        System.out.println(paul.getDOB());
        System.out.println("");
        
        System.out.println(george.getName());
        System.out.println(george.getDOB());
        System.out.println("");
        
        System.out.println(ringo.getName());
        System.out.println(ringo.getDOB());


    }
    
}
