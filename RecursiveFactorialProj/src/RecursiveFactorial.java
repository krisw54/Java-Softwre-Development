import java.util.*;

/**
 *
 * @author krisw
 */

//Ref: http://www.dummies.com/programming/java/what-is-recursion-in-java-programming/

public class RecursiveFactorial {
    
    public static void main(String[] args) {
        int num;
        Scanner kybd = new Scanner(System.in);
 
        System.out.println("Please enter a positive numnber: ");
        num = kybd.nextInt();
        
        System.out.println(factorial(num));
        
    }
    
    public static int factorial(int num)
    {
        if (num < 1)
        {
            return 1;
        }
        else
        {
            System.out.print(num);
            System.out.print(num==1 ? " = " : " x ");
            return num * factorial(num-1);
        }
    }
}
