
public class DiceMatch {
           
    public static void main(String[] args)
    {
        int diceOne = (int) (Math.random() * 6) + 1;
        int diceTwo = (int) (Math.random() * 6) + 1;
        
        int count = 1;

        while (diceOne != diceTwo)
        {
            System.out.println("Throw Dice One: " + diceOne);
            System.out.println("Throw Dice Two: " + diceTwo);
            count = count + 1;
            diceOne = (int) (Math.random() * 6) + 1;
            diceTwo = (int) (Math.random() * 6) + 1;
        }
        System.out.println("Throw Dice One: " + diceOne);
        System.out.println("Throw Dice Two: " + diceTwo);
        System.out.println("It took " + count + " goes to match the dice!");

    }
}
