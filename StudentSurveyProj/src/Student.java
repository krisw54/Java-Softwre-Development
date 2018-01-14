import java.util.ArrayList;

public class Student
{
    private String name;
    private String award;
    private ArrayList<String> likes;
    private char gender;
    
    public Student(String name, char gender)
    {
        this.name = name;
        award = "";
        likes = new ArrayList<String>();
        this.gender = gender;
    }

    public String getName()
    {
        return name;
    }

    public String getAward()
    {
        return award;
    }

    public void setAward(String award)
    {
        this.award = award;
    }

    public ArrayList<String> getLikes()
    {
        return likes;
    }

    public void addLike(String like)
    {
        likes.add(like);
    }

    public void removeLike(String like)
    {
        likes.remove(like);
    }

    public char getGender()
    {
        return gender;
    }
    
    @Override
    public String toString()
    {
        return getName();
    }
}
