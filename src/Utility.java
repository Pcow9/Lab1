import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class used to call check name and check age for exceptions
 *
 * @author Mio Diaz, Cody Walker
 * @version  1.0
 */
public class Utility {
    /**
     * Check Name uses temp string to determine if exception is thrown
     *
     * @param temp temp string pulled from user input for name
     * @throws NameException compare string to determine valid or invalid input
     */
    public void checkName(String temp) throws NameException {
        // Pattern and matcher used to compare to string to find special char
        Pattern special = Pattern.compile("[^\\w\\s,-]");
        Matcher m1 = special.matcher(temp);
        // Pattern and matcher used to compare to string and find digit
        Pattern digit = Pattern.compile("[0-9]");
        Matcher m2 = digit.matcher(temp);

        boolean hasSpecial = m1.find();  // does string have special char
        boolean hasDigit = m2.find();    // does string have digit
        int strLen = temp.length();      // string length used to determine valid or invalid length

        // If any of the values are true pass all values and
        // throw a name exception if once of the exception conditions are met
        if(hasSpecial || hasDigit || strLen > 15 || strLen < 1) throw new NameException(hasSpecial, hasDigit, strLen);
    }

    /**
     * Check age uses age val to determine if age exception is thrown
     *
     * @param val age value from user input in age text field
     * @throws AgeException compare age to determine valid or invalid input
     */
    public void checkAge(int val) throws AgeException {
        // check user input and throw exceptions if conditions are met
        if (val < 0 || val > 100){
            throw new AgeException(val);
        }

    }
}
