
import java.util.Scanner;


/**
 *
 * @author krisw
 */
public class AboveAverage {
    
    public static void main(String[] args) {
        
        int numOfStudent = 0;
        int avGrade=0;
        
        Scanner kybd = new Scanner(System.in);
        
        while (numOfStudent <= 0)
        {
            System.out.print("Please Enter The Number Of Students: ");
            numOfStudent = kybd.nextInt();
        }
        int[] marks = new int[numOfStudent];
        String[] names = new String[numOfStudent];
        
        for (int i = 0; i < marks.length; i++)
        {
            System.out.println("Please Enter Student Name: ");
            kybd.nextLine(); 
            names[i] = kybd.nextLine();
            System.out.println("Please Enter Student Marks: ");
            marks[i] = kybd.nextInt();
        }
        
        for (int i = 0; i < marks.length; i++)
        {
            avGrade = avGrade + marks[i];
        }
        avGrade = avGrade / marks.length;
        System.out.println("Average Grade Is: " + avGrade);
        for (int i = 0; i < marks.length; i++)
        {
            if (marks[i] >= avGrade)
            {
                System.out.println("Student Name: " + names[i]);
                System.out.println("Grade: "+ marks[i]);
            }
        }
        
    }
    
}
