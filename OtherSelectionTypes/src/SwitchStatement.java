import java.util.Scanner;

public class SwitchStatement
{
    public static void main(String[] args)
    {
        Scanner kybd = new Scanner(System.in);
        System.out.print("Enter title: ");
        String title = kybd.nextLine();

//        if (title.equalsIgnoreCase("Mrs") || title.equalsIgnoreCase("Ms"))
//        {
//            System.out.println("Hello Madam");
//        }
//        else if (title.equalsIgnoreCase("Miss"))
//        {
//            System.out.println("Hello young lady");
//        }
//        else if (title.equalsIgnoreCase("Mr"))
//        {
//            System.out.println("Hello Sir");
//        }
//        else
//        {
//            System.out.println("Hello");
//        }

        switch (title)
        {
            case "Mrs":
            case "Ms":
                System.out.println("Hello Madam");
                break;
            case "Miss":
                System.out.println("Hello young lady");
                break;
            case "Mr":
                System.out.println("Hello Sir");
                break;
            default:
                System.out.println("Hello");
        }
    }
}