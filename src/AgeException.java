/**
 * @author Mio Diaz, Cody Walker
 * @version 1.0
 */
public class AgeException extends Exception{
    String str;
    int minAge = 0; // adds minimal age here for quick change
    int maxAge = 100; // adds max agg here for quick change

    /**
     * add error message if age is to big or to small
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
