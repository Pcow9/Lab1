import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
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
        final boolean[] clickName = {false};
        final boolean[] clickAge = {false};
        InputVerifier inn = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input;
                try {
                    nc.checkName(GUI.name.getText());
                } catch (NameException e) {
                    System.out.println(e);
                    clickName[0] = false;
                    gui.clickableButton(clickName[0], clickAge[0]);  //calls function form class GUI, will make button unclickable
                    return false;
                }
                GUI.age.setEditable(true);  //  lets age text file be editable
                clickName[0] = true;
                gui.clickableButton(clickName[0], clickAge[0]);  //calls function form class GUI, might make button clickable if clickAge is true
                return true;
            }
        };
        InputVerifier ina = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input;
                try {
                    nc.checkAge(Integer.parseInt(GUI.age.getText()));
                } catch (AgeException e) {
                    System.out.println(e);
                    clickAge[0] = false;
                    gui.clickableButton(clickName[0], clickAge[0]); //calls function form class GUI, will make button unclickable
                    return false;
                }
                clickAge[0] = true;
                gui.clickableButton(clickName[0], clickAge[0]); //calls function form class GUI, might make button clickable if clickName is true
                return true;
            }
        };
        GUI.name.setInputVerifier(inn);
        GUI.age.setInputVerifier(ina);
        GUI.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(" your name is " + GUI.name.getText() + " and your age is " + GUI.age.getText() + ".");
            }
        });

    }
}
