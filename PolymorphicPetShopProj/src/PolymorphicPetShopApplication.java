/**
 *
 * @author chriswood
 */
public class PolymorphicPetShopApplication {
    
    public static void main(String[] args) {
        
       Pet pets[] = {
           new Cat("Jack","Chris",30,10),
           new Cat("Jess","Sara",31,11),
           new Cat("Molly","Mary",20,7),
           new Cat("Chloe","Shannon",26,5),
           new Cat("Jay","Paul",25,4),
           new Cat("Sara","Kate",30,8),
           new Budgie("Lisa","Chris","Blue/Red"),
           new Budgie("Sarah","Jack","White/Red"),
           new Budgie("Summer","Rose","Red ONLY"),
           new Budgie("Birdy","Jannet","Blue/White/Gray")
                   };
       printPetDetails(pets);
}
    
    public static void printPetDetails(Pet pets[]){
        int count = 0;
        System.out.println("All Pets...");
        System.out.println("\tPet Name\tOwner Name\tTeeth\t\tTail Length\tFeather Colour");
        System.out.println("\t===============\t===============\t===============\t===============\t===============");
        for (Pet p : pets)
        {
            count++;
            System.out.print("\t" + p.getName() + "\t\t" + p.getOwnerName());
            
            if (p instanceof Cat)
            {
                System.out.print("\t\t" + ((Cat) p).getNumberOfTeeth() + "\t\t" + ((Cat) p).getLengthOfTail()+"\t\t---\n");
            }
            if (p instanceof Budgie)
            {
                System.out.print("\t\t---" + "\t\t---" +"\t\t" + ((Budgie) p).getColourOfFeathers() + "\n");
            }
               
    }
    
}
}
