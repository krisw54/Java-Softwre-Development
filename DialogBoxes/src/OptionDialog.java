import javax.swing.*;

public class OptionDialog extends JApplet
{
    String itemName = "";

    @Override
    public void init()
    {
        itemName = getItemName();
        String str = "You picked: " + itemName;
        JLabel output = new JLabel(str, JLabel.CENTER);
        getContentPane().add("Center", output);
    }

    private String inputItemName()
    {
        String msg = "Please pick an item";
        String title = "Item selection";
        String[] items = {"Apple", "Orange", "Pear"};
        int index = 
              JOptionPane.showOptionDialog(this,
                                           msg,
                                           title,
                                           JOptionPane.OK_CANCEL_OPTION, 
                                           JOptionPane.QUESTION_MESSAGE,
                                           null,
                                           items,
                                           items[1]);
        return index != JOptionPane.CLOSED_OPTION ? items[index] : "";
    }

    private String getItemName()
    {
        String item = inputItemName();
        while (item.equals(""))
        {
            String msg = "You have not picked an item";
            String title = "Selection error";
            JOptionPane.showMessageDialog(this,
                                          msg,
                                          title,
                                          JOptionPane.ERROR_MESSAGE);
            item = inputItemName();
        }
        return item;
    }
}