import java.util.ArrayList;

public class SurveyApplication
{
    public static void main(String args[])
    {
        ArrayList<Student> students = new ArrayList<Student>();
        String[] awards = {"Hopping", "Skipping", "Jumping", "Running"};
        String[] likes = {"Cats", "Dogs", "Budgies"};
        String[] genders = {"Male", "Female"};
        
        Student s1 = new Student("Graham", 'M');
        s1.setAward(awards[0]);
        s1.addLike(likes[0]);
        
        Student s2 = new Student("Janet", 'F');
        s2.setAward(awards[1]);
        s2.addLike(likes[0]);
        s2.addLike(likes[2]);
        
        Student s3 = new Student("Fred", 'M');
        s3.setAward(awards[0]);
        s3.addLike(likes[1]);
        
        Student s4 = new Student("Josephine", 'F');
        s4.setAward(awards[3]);
        s4.addLike(likes[0]);
        s4.addLike(likes[1]);
        s4.addLike(likes[2]);
        
        Student s5 = new Student("Jane", 'F');
        s5.setAward(awards[1]);
        
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        
        new SurveyJFrame(students, awards, likes, genders);
    }
}
