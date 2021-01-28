import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Main class used to create window, verify input, catch exceptions for name and age
 * @author Mio Diaz, Cody Walker
 * @version 1.0
 */
public class Main {
    /**
     * Main function
     * @param args not used
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createWindow();
        Utility nc = new Utility();

        // Input Verifier for name text field
        InputVerifier ivn = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input; // user input into field
                try {
                    nc.checkName(jtf.getText());
                } catch (NameException e) {
                    System.out.println(e);
                    return false;
                }

                GUI.age.setEditable(true);  //  lets age text file be editable

                return true;
            }
        };

        // Input Verifier for age text field
        InputVerifier iva = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input;
                if(!jtf.getText().equals("")){
                    try {
                        nc.checkAge(Integer.parseInt(jtf.getText()));
                    } catch (AgeException e) {
                        System.out.println(e);

                        return false;
                    }
                }else { return false; }

                return true;
            }
        };
        // Set age and name field input verifiers
        GUI.age.setInputVerifier(iva);
        GUI.name.setInputVerifier(ivn);
        // Name key listener for button enable
        GUI.name.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
            @Override
            public void keyPressed(KeyEvent e) { }
            @Override
            public void keyReleased(KeyEvent e) {
                // if name and age are true enable button
                GUI.button.setEnabled(ivn.verify(GUI.name) && iva.verify(GUI.age));
                // Button console output when clicked

            }
        });
        // age key listener for button enable
        GUI.age.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) { }
            @Override
            public void keyPressed(KeyEvent e) {  }
            @Override
            public void keyReleased(KeyEvent e) {
                // if name and age are true enable button
                GUI.button.setEnabled(ivn.verify(GUI.name) && iva.verify(GUI.age));
            }
        });
        // button click dialog msg
        GUI.button.addActionListener(al ->  JOptionPane.showMessageDialog(null,
                "Your name is " + GUI.name.getText() + " and your age is " + GUI.age.getText() + ".", "About You", JOptionPane.INFORMATION_MESSAGE));

    }
}
