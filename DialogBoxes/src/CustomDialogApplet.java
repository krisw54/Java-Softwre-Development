import javax.swing.*;

public class CustomDialogApplet extends JApplet
{
    private String name;
    
    @Override
    public void init()
    {
        String greeting = "Hello";
        name = getUserName();
        if (name == null)
        {
            String msg = "Do you wish to withhold your name?\n(Click No to have one more opportunity to enter your name)";
            String title = "Confirm name withheld";
            int choice = JOptionPane.showConfirmDialog(this,
                                                       msg,
                                                       title,
                                                       JOptionPane.YES_NO_OPTION,
                                                       JOptionPane.QUESTION_MESSAGE);

            if (choice == JOptionPane.NO_OPTION)
            {
                name = getUserName();
            }
        }

        if (name != null)
        {
            greeting += ", " + name;
        }
        
        JLabel output = new JLabel(greeting, JLabel.CENTER);
        getContentPane().add("Center", output);
    }
    
    private String inputName()
    {
        String nameMsg = "Please enter your name";
        String nameTitle = "What is your name?";
        CustomDialog dialog = new CustomDialog(null, nameTitle, nameMsg);
        return dialog.getUsername();
    }

    private String getUserName()
    {
        String name = inputName();
        while (name != null && name.equals(""))
        {
            String msg = "You have not typed your name";
            String title = "Name error";
            JOptionPane.showMessageDialog(this,
                                          msg,
                                          title,
                                          JOptionPane.ERROR_MESSAGE);
            name = inputName();
        }
        return name;
    }
}