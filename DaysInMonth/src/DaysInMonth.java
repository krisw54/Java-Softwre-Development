
import java.util.*;

public class DaysInMonth
{

    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        int[] monthDay =
        {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        String[] monthName =
        {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
        };

        System.out.print("Enter month: ");
        int monthNum = kybd.nextInt();
        if (monthNum < 1 || monthNum > 12)
        {
            System.out.println("Invalid month number");
        }
        else
        {
            monthNum--;
            System.out.println("There are " + monthDay[monthNum]
            + " days in " + monthName[monthNum]);
        }
    }
}
