import java.util.*;

public class BlockOfFlats
{
    public static void main(String[] args)
    {
        //outer loop counts floors
        for (int floor = 4; floor >= 1; floor--)
        {
            //inner loop counts flats
            for (int flat = 1; flat <= 3; flat++)
            {
                System.out.printf("Floor: %d, Flat: %d\t", floor, flat);
            }
            System.out.println();
        }
    }
}
