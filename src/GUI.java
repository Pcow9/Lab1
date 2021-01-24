import javax.swing.*;

/**
 * GUI class used to create window and elements
 * @author Mio Diaz, Cody Walker
 * @version 1.0
 */
public class GUI extends JFrame {
    public static JButton button;
    public static JTextField name;
    public static JTextField age;

    /**
     * creates window when called
     */
    public void createWindow() {
        JFrame gui = new JFrame("SWENG 431 Lab1");
        // Frame settings
        gui.setSize(400, 300);
        gui.setLocationRelativeTo(null);
        gui.setLayout(null);

        // Name Textfield
        name = new JTextField(20);
        name.setBounds(110, 50, 130, 30);
        // Name Label
        JLabel n = new JLabel("Name: ");
        n.setBounds(50, 50, 100, 30);
        // Age Textfiedl
        age = new JTextField(20);
        age.setBounds(110, 110, 130, 30);
        age.setEditable(false);  // makes age text box uneditable until changes inside main class
        // Age Label
        JLabel a = new JLabel("Age: ");
        a.setBounds(50, 110, 100, 30);
        // Button
        button = new JButton("Submit me");
        button.setBounds(200, 200, 140, 40);
        button.setEnabled(false); // makes button unclickable from the start, become clickable by function clickableButton
        // Adding GUI elements to frame
        gui.add(n);
        gui.add(name);
        gui.add(a);
        gui.add(age);
        gui.add(button);
        // close on exit behavior set for window
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gui.setVisible(true);
    }

    /**
     * makes button clickable or unclickable with correct values
     * @param clickName boolean for if name is correct
     * @param clickAge  boolean for if age is correct
     */
    public void clickableButton(boolean clickName, boolean clickAge){
        //check to see that both text are correct before button becomes clickable
        if(clickName == true && clickAge == true){
            button.setEnabled(true);
        }else
            button.setEnabled(false);
    }
}
