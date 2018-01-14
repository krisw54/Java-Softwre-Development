//output weight loss given time spent on activities
import java.util.*;

public class WeightLoss
{
    public static void main (String[] args)
    {
        //create Scanner to read in data
        Scanner kybd = new Scanner(System.in);

        //declare constants
        final int CALS_CYCLING = 200;
        final int CALS_RUNNING = 475;
        final int CALS_SWIMMING = 275;
        final int CALS_FOR_POUND_LOSS = 3500;

        //prompt and input hours cycling, running and swimming
        System.out.print("Please enter hours cycling: ");
        double cycling = kybd.nextDouble();
        System.out.print("Please enter hours running: ");
        double running = kybd.nextDouble();
        System.out.print("Please enter hours swimming: ");
        double swimming = kybd.nextDouble();

        //calculate calories burnt
        double caloriesBurnt = cycling * CALS_CYCLING  +
                               running * CALS_RUNNING +
                               swimming * CALS_SWIMMING;

        //calculate weight loss
        double weightLoss = caloriesBurnt / CALS_FOR_POUND_LOSS;

        //output results
        System.out.printf("You have burnt %3.2f " +
                           "and lost %3.2f pounds\n",
                           caloriesBurnt, weightLoss);
    }
}
