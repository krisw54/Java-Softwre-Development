
public class Person
{
    private String firstName;
    private String surname;
    private int day;
    private int month;
    private int year;

    public void setName(String theFirstName, String theSurname)
    {
        firstName = theFirstName;
        surname = theSurname;
    }

    public String getName()
    {
        return firstName + " " + surname;
    }

    public void setDOB(int d, int m, int y)
    {
        if (dateValid(d, m, y))
        {
            day = d;
            month = m;
            year = y;
        }
    }

    public String getDOB()
    {
        return day + "-" + month + "-" + year;
    }

    public int getAgeAt(int d, int m, int y)
    {
        int age = -1;

        if (dateValid(d, m, y) && dateAfterDoB(d, m, y))
        {
            age = y - year;
            if (m < month || (m == month && d < day))
            {
                age--;
            }
        }
        return age;
    }

    private boolean dateValid(int d, int m, int y)
    {
        return (d >= 1 && d <= 31) && (m >= 1 && m <= 12);

    }

    private boolean dateAfterDoB(int d, int m, int y)
    {
        return (y > year) ||
               (y == year && m > month) ||
               (y == year && m == month && d > day);
    }
}
