/**
 *
 * @author chriswood
 */
public class Cat extends Pet {
    
private int numberOfTeeth;
private int lengthOfTail;
    
public Cat(String name, String ownerName, int numberOfTeeth, int lengthOfTail) {
    super(name,ownerName);
    this.numberOfTeeth = numberOfTeeth;
    this.lengthOfTail = lengthOfTail;
}

public int getNumberOfTeeth() {
   
    return numberOfTeeth;
} 

public int getLengthOfTail() {
    
    return lengthOfTail;
}

    
}
