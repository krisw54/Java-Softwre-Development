/**
 *
 * @author chriswood
 */
public class PetShopApplication {
    
    public static void main(String[] args) {
        Cat cat1 = new Cat("Jack","Chris",30,10);
        Cat cat2  = new Cat("Jess","Sara",31,11);
        Cat cat3 = new Cat("Molly","Mary",20,7);
        
        Budgie bud1 = new Budgie("Lisa","Chris","Blue/Red");
        Budgie bud2 = new Budgie("Sarah","Jack","White/Red");
       
        System.out.println("All Pets...");
        System.out.println("\tPet Name\tOwner Name\tTeeth\t\tTail Length\tFeather Colour");
        System.out.println("\t===============\t===============\t===============\t===============\t===============››");
        System.out.println("\t"+ cat1.getName() + "\t\t"+ cat1.getOwnerName() + "\t\t" + cat1.getNumberOfTeeth() + "\t\t" + cat1.getLengthOfTail() + "\t\t---");
        System.out.println("\t"+ cat2.getName() + "\t\t"+ cat2.getOwnerName() + "\t\t" + cat2.getNumberOfTeeth() + "\t\t" + cat2.getLengthOfTail() + "\t\t---");
        System.out.println("\t"+ cat3.getName() + "\t\t"+ cat3.getOwnerName() + "\t\t" + cat3.getNumberOfTeeth() + "\t\t" + cat3.getLengthOfTail() + "\t\t---");
        
        System.out.println("\t"+ bud1.getName() + "\t\t"+ bud1.getOwnerName() + "\t\t---" + "\t\t---" + "\t\t"+ bud1.getColourOfFeathers());
        System.out.println("\t"+ bud2.getName() + "\t\t"+ bud2.getOwnerName() + "\t\t---" + "\t\t---" + "\t\t"+ bud2.getColourOfFeathers());
    }
    
}
