
/**
 *
 * @author krisw
 */
import java.text.SimpleDateFormat;
import java.util.*;

public class Person
{
    //private variables – hidden data

    private String firstName;
    private String lastName;
    private int height;
    
    private Calendar dob;
   

    //public methods
    
    public void setHeight (int inches)
    {
        height = inches;
    }
    
    public String getHeight()
    {
        int feet = height / 12;
        double inches = height % 12;
        String h = feet + " Feet " + inches + " Inches";
        
        return String.valueOf(h);
    }
    
    public void setSurname(String surname)
    {
        lastName = surname;
    }
    
    public void setName(String forename, String surname)
    {
        firstName = forename;
        lastName = surname;
    }

    public String getName()
    {
        return firstName + " " + lastName;
    }

    public void setDOB(int d, int m, int y)
    {
        if (dateValid(d, m, y))
        {
           dob = Calendar.getInstance();
           dob.set(Calendar.YEAR, y);
           dob.set(Calendar.MONTH, m-1);
           dob.set(Calendar.DAY_OF_MONTH, d);
        }
    }

    public String getDOB()
    {
        String pattern = "EEE, d MMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formatted = simpleDateFormat.format(dob.getTime());
        return formatted;
    }

    public String getAgeAt(int d, int m, int y)
    {
        String ageAtS="";
        
        Calendar ageAt = Calendar.getInstance();
        if (dateValid(d, m, y))
        {
            ageAt.set(Calendar.YEAR, y);
            ageAt.set(Calendar.MONTH, m-1);
            ageAt.set(Calendar.DAY_OF_MONTH, d);
            int yearDiff = ageAt.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            int monthDiff = ageAt.get(Calendar.MONTH) - dob.get(Calendar.MONTH);
            int dayDiff = ageAt.get(Calendar.DAY_OF_MONTH) - dob.get(Calendar.DAY_OF_MONTH);
            ageAtS = "Years: " + yearDiff + " Months : " + monthDiff + " Days: " + dayDiff;
        }
        return ageAtS;
    }

    private boolean dateValid(int d, int m, int y)
    {
        return (d >= 1 && d <= 31) && (m >= 1 && m <= 12);

    }

}
