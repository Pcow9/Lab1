import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {

    public void checkName(String temp) throws NameException {
        Pattern special = Pattern.compile("[^\\w\\s,-]");
        Matcher m1 = special.matcher(temp);

        Pattern digit = Pattern.compile("[0-9]");
        Matcher m2 = digit.matcher(temp);

        boolean hasSpecial = m1.find();
        boolean hasDigit = m2.find();
        int strLen = temp.length();

        if(hasSpecial || hasDigit || strLen > 15){
            throw new NameException(hasSpecial, hasDigit, strLen);
            //System.out.println(hasDigit + "\n" + hasSpecial + "\n" + strLen);
        }

    }

    public void checkAge(int val) throws AgeException {
        if (val < 0 || val > 100){
            throw new AgeException(val);
        }

    }
}
