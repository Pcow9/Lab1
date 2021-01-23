import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.createWindow();
        Utility nc = new Utility();

        GUI.name.setInputVerifier(new InputVerifier() {

            @Override
            public boolean verify(JComponent input) {
                JTextField jtf = (JTextField) input;
                int val = Integer.parseInt(jtf.getText());

                if(val < 0 || val > 15){
                    return false;
                }else{
                    return true;
                }

            }
        });

        try {
            nc.checkName(GUI.name.getText());
        } catch (NameException e) {
            System.out.println(e);
        }

     /*   try{
            nc.checkAge(40);
        } catch (AgeException e) {
            System.out.println(e);
        } */
    }
}
