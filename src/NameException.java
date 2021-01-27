import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mio Diaz, Cody Walker
 * @version 1.0
 */
public class NameException extends Exception {
    String str; // Returned string

    /**
     * adds the error message to NameException
     * @param hasSpecial boolean used to determine if string contains unapproved char
     * @param hasDigit   boolean used to determine if string has digit
     * @param strLen     value used to determine if string meets length constraint
     */
    public NameException(boolean hasSpecial, boolean hasDigit, int strLen) {
        // if length of string is greater than 0 and less than or equal to 15
        if(strLen > 0 && strLen <= 15){
            // If the string has a unapproved special char and no digits
            if(hasSpecial && !hasDigit){
                str = "a special character exists.\n";
            }
            // if string has no special unapproved char but has a digit
            else if(hasDigit && !hasSpecial){
                str = "a digit exists.\n";
            }
            // if string has a special char and digit
            else if(hasDigit && hasSpecial) {
                str = "a special character exists, a digit exists.";
            }
        }
        // if length of string is invalid ( either less than 0 or greater than 15 )
        else {
            str = "0 <= " + strLen + " characters <= 15 is invalid.\n";
        }

    }
    // Returned string displayed in console output
   public String getLocalizedMessage(){ return str; }

}
