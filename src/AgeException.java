/**
 * Age Exception class determines exception to throw based on parameter
 *
 * @author Mio Diaz, Cody Walker
 * @version 1.0
 */
public class AgeException extends Exception{
    String str = null;
    /**
     * set error message if age is to0 big or small
     * @param val value of age
     */
    public AgeException(int val) {
        str = "0 <= " + val + " <= 100 is invalid";
    }

    // Returns string that will be displayed in console
    public String getLocalizedMessage(){ return str; }
}
