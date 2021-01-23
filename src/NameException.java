import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameException extends Exception {
    String str;

    public NameException(boolean hasSpecial, boolean hasDigit, int strLen) {
        if(strLen > 0 && strLen <= 15){
            if(hasSpecial && !hasDigit){
                str = "a special character exists.\n";
            } else if(hasDigit && !hasSpecial){
                str = "a digit exists.\n";
            } else if(hasDigit && hasSpecial) {
                str = "a special character exists, a digit exists.";
            }
        }
        else {
            str = "0 <= " + strLen + " characters <= 15 is invalid.\n";
        }

    }

   public String getLocalizedMessage(){ return str; }

}
