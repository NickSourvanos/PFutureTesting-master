package ExceptionUtils;

public class InvalidUserInputException extends Exception {

    private final static String msg = "Invalid User Input";

    public InvalidUserInputException(){
        super(msg);
    }

}
