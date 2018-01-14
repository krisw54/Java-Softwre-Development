
import java.util.Scanner;

public class MakeMeBetter
{
    public static void main(String[] args)
    {
        int[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        Scanner b = new Scanner(System.in);
        
        System.out.println("Please input 10 numbers in the range 1-19 :> ");
        int c = b.nextInt();
        while (c < 1 || c > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            c = b.nextInt();
        }
        a[0] = c;
        
        int d = b.nextInt();
        while (d < 1 || d > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            d = b.nextInt();
        }
        a[1] = d;
        
        int e = b.nextInt();
        while (e < 1 || e > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            e = b.nextInt();
        }
        a[2] = e;
        
        int f = b.nextInt();
        while (f < 1 || f > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            f = b.nextInt();
        }
        a[3] = f;
        
        int g = b.nextInt();
        while (g < 1 || g > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            g = b.nextInt();
        }
        a[4] = g;
        
        int h = b.nextInt();
        while (h < 1 || h > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            h = b.nextInt();
        }
        a[5] = h;
        
        int i = b.nextInt();
        while (i < 1 || i > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            i = b.nextInt();
        }
        a[6] = i;
        
        int j = b.nextInt();
        while (j < 1 || j > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            j = b.nextInt();
        }
        a[7] = j;
        
        int k = b.nextInt();
        while (k < 1 || k > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            k = b.nextInt();
        }
        a[8] = k;
        
        int l = b.nextInt();
        while (l < 1 || l > 19)
        {
            System.out.println("Not in the range 1-19, please try again :> ");
            l = b.nextInt();
        }
        a[9] = l;

        System.out.println("\nArray contents");
        System.out.print((a[0] < 10 ? " " : "") + a[0] + "  ");
        System.out.print((a[1] < 10 ? " " : "") + a[1] + "  ");
        System.out.print((a[2] < 10 ? " " : "") + a[2] + "  ");
        System.out.print((a[3] < 10 ? " " : "") + a[3] + "  ");
        System.out.print((a[4] < 10 ? " " : "") + a[4] + "  ");
        System.out.print((a[5] < 10 ? " " : "") + a[5] + "  ");
        System.out.print((a[6] < 10 ? " " : "") + a[6] + "  ");
        System.out.print((a[7] < 10 ? " " : "") + a[7] + "  ");
        System.out.print((a[8] < 10 ? " " : "") + a[8] + "  ");
        System.out.print((a[9] < 10 ? " " : "") + a[9] + "  ");
        System.out.println();
        
        boolean noSwap = false;
        int startAt = 0;
        int stopAt = 9;
        while (startAt < stopAt && noSwap == false)
        {
            noSwap = true;
            for (int m=startAt; m<stopAt; m++)
            {
                if (a[m] > a[m+1])
                {
                    int t = a[m];
                    a[m] = a[m+1];
                    a[m+1] = t;
                    noSwap = false;
                }
            }
            stopAt = stopAt - 1;
        }
        
        System.out.println("\nArray contents");
        System.out.print((a[0] < 10 ? " " : "") + a[0] + "  ");
        System.out.print((a[1] < 10 ? " " : "") + a[1] + "  ");
        System.out.print((a[2] < 10 ? " " : "") + a[2] + "  ");
        System.out.print((a[3] < 10 ? " " : "") + a[3] + "  ");
        System.out.print((a[4] < 10 ? " " : "") + a[4] + "  ");
        System.out.print((a[5] < 10 ? " " : "") + a[5] + "  ");
        System.out.print((a[6] < 10 ? " " : "") + a[6] + "  ");
        System.out.print((a[7] < 10 ? " " : "") + a[7] + "  ");
        System.out.print((a[8] < 10 ? " " : "") + a[8] + "  ");
        System.out.print((a[9] < 10 ? " " : "") + a[9] + "  ");
        System.out.println();
        
        double n = (a[0] + a[1] + a[2] + a[3] +
                          a[4] + a[5] + a[6] + a[7] +
                          a[8] + a[9]) / 10;
        
        System.out.println("The minimum number is: " + a[0]);
        System.out.println("The maximum number is: " + a[9]);
        System.out.println("The average value is: " + n);
        System.out.println("The median is: " + a[4]);
    }
}