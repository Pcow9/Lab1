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
        InputVerifier inn = new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input;
                try {
                    nc.checkName(GUI.name.getText());
                } catch (NameException e) {
                    System.out.println(e);
                    return false;
                }
                GUI.age.setEditable(true);
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
                    return false;
                }
                GUI.button.setEnabled(true);
                return true;
            }
        };
        GUI.name.setInputVerifier(inn);
        GUI.age.setInputVerifier(ina);


     /*   try{
            nc.checkAge(40);
        } catch (AgeException e) {
            System.out.println(e);
        } */
    }
}
