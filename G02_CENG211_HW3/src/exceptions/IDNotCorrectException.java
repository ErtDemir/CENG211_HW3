package exceptions;

@SuppressWarnings("serial")
public class IDNotCorrectException extends Exception{
    public IDNotCorrectException(String message) {
        super(message);
    }
}
