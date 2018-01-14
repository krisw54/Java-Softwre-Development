import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author krisw
 */
public class SpaceshipInaJFrame extends JFrame implements ActionListener
{
    private JButton moveShips;
    private SpaceshipCanvas canvas;
    private JTextField txtN,txtY,txtX;
    private JButton but, but1;
    
    public SpaceshipInaJFrame(Spaceship[] ships)
    {
        super("Spaceship Program");
        
        setSize(600, 600);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        canvas = new SpaceshipCanvas(ships);
        getContentPane().setBackground(new Color(0xabcdef));

        getContentPane().add(canvas, BorderLayout.CENTER);
        
        createButton();
        
        setVisible(true);
    }
    
    private void createButton()
    {
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel southPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel southPanel3 = new JPanel();
        southPanel3.setLayout(new BoxLayout(southPanel3, BoxLayout.Y_AXIS));
       
        but = new JButton("Move all ships to random locations");
        but1 = new JButton("Move");
        southPanel.add(but);
        southPanel3.add(southPanel);
        JLabel l1 = new JLabel("Name: ");
        JLabel l2 = new JLabel("X: ");
        JLabel l3 = new JLabel("Y: ");
        txtN = new JTextField(10); 
        txtX = new JTextField(5); 
        txtY = new JTextField(5);
        southPanel1.add(l1);
        southPanel1.add(txtN);
        southPanel1.add(l2);
        southPanel1.add(txtX);
        southPanel1.add(l3);
        southPanel1.add(txtY);
        southPanel1.add(but1);
        southPanel3.add(southPanel1);
        getContentPane().add(southPanel3, BorderLayout.SOUTH);
        

        but.addActionListener(this);
        but1.addActionListener(this);
      
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String name = txtN.getText();
        String x = txtY.getText();
        String y = txtX.getText();
        
        if (e.getSource() == but)
        {
            canvas.moveAllSpaceships();
        }
        else if (e.getSource() == but1)
        {
            if (name.length() == 0)
            {
                System.out.println("Enter Ship To Move");
                txtN.requestFocus();
            }
            else if (x.length()== 0)
            {
                System.out.println("Enter X");
                txtX.requestFocus();
            }
            else if (y.length()== 0)
            {
                System.out.println("Enter Y");
                txtY.requestFocus();
            }
            else
            {
                try
                {
                    int xx = Integer.parseInt(x);
                    if (xx < 1)
                    {
                        System.out.println("Cant be less than 0");
                        txtX.requestFocus();
                    }
                    int yy = Integer.parseInt(y);
                    if (yy < 1)
                    {
                        System.out.println("Cant be less than 0");
                        txtY.requestFocus();
                    }
                    canvas.moveOneSpaceship(name, xx, yy);
                }
            catch (NumberFormatException nfe)
            {
                System.out.println("Must use integers please");
                txtY.requestFocus();
            }
         }       
       }
    }
}
