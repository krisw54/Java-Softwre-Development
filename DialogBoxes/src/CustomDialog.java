import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomDialog extends JDialog implements ActionListener
{
    private JTextField username;
    private String prompt;
    private JButton OK, cancel;
    private boolean cancelled;

    public CustomDialog(Frame owner, String title, String prompt)
    {
        super(owner, title, true);
        setSize(300, 100);
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
        this.prompt = prompt;
        cancelled = true;
        
        setupGUI();
        
        setVisible(true);
    }

    private void setupGUI()
    {
        JPanel centreP = setupCentrePanel();
        JPanel southP = setupSouthPanel();

        getContentPane().add(centreP, BorderLayout.CENTER);
        getContentPane().add(southP, BorderLayout.SOUTH);
    }

    private JPanel setupCentrePanel()
    {
        username = new JTextField(10);
        username.addActionListener(this);
        
        JPanel p1 = new JPanel();
        p1.add(new JLabel(prompt));
        p1.add(username);
        
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        p.add(p1);
        p.add(Box.createVerticalGlue());
        return p;
    }

    private JPanel setupSouthPanel()
    {
        OK = new JButton("OK");
        OK.addActionListener(this);
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);

        JPanel p = new JPanel();
        p.add(OK);
        p.add(cancel);
        return p;
    }

    public void actionPerformed(ActionEvent e)
    {
        cancelled = e.getSource() == cancel;
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
    
    public String getUsername()
    {
        return cancelled ? null : username.getText();
    }
    
    public boolean wasCancelled()
    {
        return cancelled;
    }
}
