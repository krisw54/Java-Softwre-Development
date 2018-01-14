import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class SurveyJFrame extends JFrame implements ActionListener, ListSelectionListener
{
    ArrayList<Student> students;
    String[] awards, likes, genders;
    JCheckBox[] likesBoxes;
    JRadioButton[] genderBoxes;
    ButtonGroup genderGroup;
    
    JList studentList;
    JComboBox award;
    
    public SurveyJFrame(ArrayList<Student> students, String[] awards, String[] likes, String[] genders)
    {
        super("Chris's student survey");
        setSize(400, 300);
        setLocation(200, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        this.students = students;
        this.awards = awards;
        this.likes = likes;
        this.genders = genders;
        
        setupGUI();
        
        setVisible(true);
    }
    
    private void setupGUI()
    {
        JPanel studentsPane = setupStudentPanel();
        JPanel awardPanel = setupAwardPanel();
        JPanel likesPanel = setupLikesPanel();
        JPanel genderPanel = setupGenderPanel();
        
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));
        getContentPane().add(studentsPane);
        getContentPane().add(awardPanel);
        getContentPane().add(likesPanel);
        getContentPane().add(genderPanel);
    }
    
    private JPanel setupStudentPanel()
    {
        studentList = new JList(students.toArray());
        JScrollPane jsp = new JScrollPane(studentList);
        
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Students"), BorderLayout.NORTH);
        p.add(jsp, BorderLayout.CENTER);
        studentList.addListSelectionListener(this);
        
        return p;
    }
    
    private JPanel setupAwardPanel()
    {
        award = new JComboBox(awards);
        award.setEditable(false);
        award.setSelectedIndex(-1);
        
        JPanel awardP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        awardP.add(award);
        
        JPanel p = new JPanel(new BorderLayout());
        p.add(new JLabel("Award"), BorderLayout.NORTH);
        p.add(awardP, BorderLayout.CENTER);
        
        return p;
    }
    
    private JPanel setupLikesPanel()
    {
        likesBoxes = new JCheckBox[likes.length];

        JPanel likesPanel = new JPanel();
        likesPanel.setLayout(new BoxLayout(likesPanel, BoxLayout.Y_AXIS));
        likesPanel.add(new JLabel("Likes"));
        
        int i = 0;
        for (String like : likes)
        {
            likesPanel.add(Box.createVerticalStrut(5));
            JCheckBox b = new JCheckBox(like);
            likesBoxes[i] = b;
            likesPanel.add(b);
            
            i++;
        }

        JPanel p = new JPanel(new BorderLayout());
        p.add(likesPanel, BorderLayout.NORTH);

        return p;
    }
    
    private JPanel setupGenderPanel()
    {
        genderBoxes = new JRadioButton[genders.length];
        genderGroup = new ButtonGroup();

        JPanel genderP = new JPanel();
        genderP.setLayout(new BoxLayout(genderP, BoxLayout.Y_AXIS));
        genderP.add(new JLabel("Gender"));

        int i = 0;
        for (String gender : genders)
        {
            JRadioButton b = new JRadioButton(gender);
            genderBoxes[i] = b;
            genderGroup.add(b);

            genderP.add(Box.createVerticalStrut(5));
            genderP.add(b);
            
            i++;
        }

        JPanel p = new JPanel(new BorderLayout());
        p.add(genderP, BorderLayout.NORTH);

        return p;
    }
    
    //NEW ************ Additions
    
     @Override
    public void actionPerformed(ActionEvent e)
    {
        //teamList.setListData(teams.toArray());
        //playerList.setListData(players.toArray());
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (!e.getValueIsAdjusting())
        {
            if (e.getSource() == studentList)
            {
                if (!studentList.isSelectionEmpty())
                {
                    displayStudents((Student)studentList.getSelectedValue());
                }
            }
        }
    }
    private void displayStudents(Student s)
    {
        for (int i = 0; i < likesBoxes.length; i++)
        {
            likesBoxes[i].setSelected(s.getLikes().contains(likesBoxes[i].getText()));
        }
        
        genderBoxes[s.getGender()=='M' ? 0:1].setSelected(true);
        
         for (int i = 0; i < awards.length; i++)
         {
             if (s.getAward().equalsIgnoreCase(awards[i]))
             {
                 award.setSelectedIndex(i);
             }
         }
    }
}       
