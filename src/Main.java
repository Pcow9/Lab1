import javax.swing.*;

/**
 * @author Mio Diaz,
 */
public class Main {
    /**
     * Main function
     * @param args not used
     */
    public static void main(String[] args) {
        // use GUI object to create GUI window
        GUI gui = new GUI();
        gui.createWindow();

        // Create utility object to call check methods
        Utility nc = new Utility();
        // booleans to determine if button should be enabled
        final boolean[] clickName = {false};
        final boolean[] clickAge = {false};

        // Name Input Verifier
        GUI.name.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input;
                try {
                    nc.checkName(jtf.getText());
                } catch (NameException e) {
                    System.out.println(e);
                    clickName[0] = false;
                    gui.clickableButton(false, clickAge[0]);
                    return false;
                }
                GUI.age.setEditable(true);
                clickName[0] = true;
                gui.clickableButton(true, clickAge[0]);
                return true;
            }
        });
        // Age Input Verifier
        InputVerifier ina = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input;
                try {
                    nc.checkAge(Integer.parseInt(jtf.getText()));
                } catch (AgeException e) {
                    System.out.println(e);
                    clickAge[0] = false;
                    gui.clickableButton(clickName[0], false);
                    return false;
                }
                clickAge[0] = true;
                gui.clickableButton(clickName[0], true);
                return true;
            }
        };

        GUI.age.setInputVerifier(ina);

    }
}
