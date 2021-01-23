/**
 * @author Mio Diaz,
 */
public class AgeException extends Exception{
    String str;
    int minAge = 0;
    int maxAge = 100;

    /**
     *
     * @param age pass user input from age field
     */
    public AgeException(int age) {
        // Ages less than 0 or greater than 100 are invalid
        if(age < minAge || age > maxAge){
            str = "0 <= " + age + " <= 100 is invalid";
        }
    }

    // Returns string that will be displayed in console
    public String getLocalizedMessage(){ return str; }
}
