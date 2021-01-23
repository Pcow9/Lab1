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
                    gui.clickableButton(clickName[0], clickAge[0]);
                    return false;
                }
                GUI.age.setEditable(true);
                clickName[0] = true;
                gui.clickableButton(clickName[0], clickAge[0]);
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
                    gui.clickableButton(clickName[0], clickAge[0]);
                    return false;
                }
                clickAge[0] = true;
                gui.clickableButton(clickName[0], clickAge[0]);
                return true;
            }
        };
        GUI.name.setInputVerifier(inn);
        GUI.age.setInputVerifier(ina);

    }
}
