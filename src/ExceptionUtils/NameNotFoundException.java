package ExceptionUtils;

public class NameNotFoundException extends Exception{

    private static final String message = "Name does not exist!";
    public NameNotFoundException(){
        super(message);
    }
}
