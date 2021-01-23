public class AgeException extends Exception{
    String str;

    public AgeException(int age) {
        if(age < 0 || age > 100){
            str = "0 <= " + age + " <= 100 is invalid";
        }
    }

    public String getLocalizedMessage(){ return str; }
}
